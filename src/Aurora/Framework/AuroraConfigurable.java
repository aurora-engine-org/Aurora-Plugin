package Aurora.Framework;

import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModifiableModelsProvider;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.OrderEnumerator;
import com.intellij.openapi.roots.impl.OrderEntryUtil;
import com.intellij.openapi.roots.libraries.Library;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.io.*;
import java.util.List;

public class AuroraConfigurable extends FrameworkSupportInModuleConfigurable {

    private static final AuroraConfigurable Config =new AuroraConfigurable();

    private String path;
    private boolean vue;

    public static AuroraConfigurable getInstance(){
        return Config;
    }

    /*
     *   Aurora Web 被选中 的配置选项
     * */
    @Override
    public JComponent createComponent() {
        /*
         *   框架被选中时候的 配置面板
         * */
        return null;
    }


    @Override
    public void addSupport(@NotNull Module module, @NotNull ModifiableRootModel rootModel, @NotNull ModifiableModelsProvider modifiableModelsProvider) {
        //初始化 project 对象
        Project project = rootModel.getProject();
        path= project.getBasePath();
        // 这是设置库、生成特定文件等的地方
        // 并实际为模块添加框架支持
        // 在点击下一步时候被执行
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                CreateAuroraWebProjectStructure(path);
            }
        }).start();

    }
    public void CreateAuroraWebProjectStructure(String root) {

        File main = new File(root, "app.go");
        File webStatic = new File(root, "webStatic");
        File config = new File(root, "application.yml");
        FileWriter writerGo=null;
        FileWriter writerHtml=null;
        FileWriter writerConfig=null;


        try {
            writerGo=new FileWriter(main);
            writerGo.write("package main\n" +
                    "\n" +
                    "import \"github.com/aurora-go/aurora\"\n" +
                    "\n" +
                    "func main() {\n" +
                    "\n" +
                    "\ta := aurora.New()\n" +
                    "\n" +
                    "\ta.GET(\"/\", func(request aurora.Request) interface{} {\n" +
                    "\t\treturn \"/index.html\"\n" +
                    "\t})\n" +
                    "\n" +
                    "\ta.Guide(\"\")\n" +
                    "}");
            if (!webStatic.exists()){
                if (webStatic.mkdir()){
                    File html = new File(webStatic, "index.html");
                    writerHtml=new FileWriter(html);
                    writerHtml.write("<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <title>Index</title>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "   <h2>Index Page</h2>\n" +
                            "</body>\n" +
                            "</html>");
                }
            }
            writerConfig=new FileWriter(config);
            writerConfig.write("aurora:\n" +
                    "  application:\n" +
                    "    name: \n" +
                    "  server:\n" +
                    "    port: 8080\n" +
                    "  resource:\n" +
                    "    static: webStatic");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writerGo!=null){
                try {
                    writerGo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writerHtml!=null){
                try {
                    writerHtml.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writerConfig!=null){
                try {
                    writerConfig.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}

