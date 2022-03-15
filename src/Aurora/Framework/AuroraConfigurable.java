package Aurora.Framework;

import Aurora.AuroraInstance;
import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable;
import com.intellij.ide.util.RunOnceUtil;
import com.intellij.lang.Language;
import com.intellij.notification.NotificationGroupManager;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ModifiableModelsProvider;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AuroraConfigurable extends FrameworkSupportInModuleConfigurable {

    private static final AuroraConfigurable Config =new AuroraConfigurable();

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
        //初始化 全局变量
        AuroraInstance.project = rootModel.getProject();
        AuroraInstance.path= rootModel.getProject().getBasePath();
        AuroraInstance.module=module;
        AuroraInstance.modifiableModelsProvider=modifiableModelsProvider;
    }
    public static void CreateAuroraWebProjectStructure(String root)  {
        //加载 根路径的虚拟文件
        VirtualFile rootVF = LocalFileSystem.getInstance().findFileByIoFile(new File(AuroraInstance.path));
        VirtualFile resources =null;
        VirtualFile controllers=null;
        VirtualFile services=null;
        VirtualFile controller=null;
        VirtualFile index_html =null;
        VirtualFile yml_config =null;
        VirtualFile application=null;
        try {

            //读取 mod文件 并拿到模块名称
            VirtualFile mod = rootVF.findChild("go.mod");
            if (mod==null){
                NotificationGroupManager.getInstance().getNotificationGroup("ERROR_Notification").createNotification("Aurora web project template create a failure", NotificationType.ERROR).notify(AuroraInstance.project);
                return;
            }

            //解析 mod 模块名称,默认解析项目名称
            String project_mod_name = rootVF.getName();

            //创建配置文件
            yml_config = rootVF.createChildData(null, "application.yml");
            String ymlTemplate="aurora:\n" +
                    "  application:\n" +
                    "    name: myapp\n" +
                    "  server:\n" +
                    "    port: 8080\n" +
                    "  resource:\n" +
                    "    static: static";
            yml_config.setBinaryContent(ymlTemplate.getBytes(StandardCharsets.UTF_8));

            //创建 controller 层
            controllers=rootVF.createChildDirectory(null,"controllers");
            controller= controllers.createChildData(null, "controller.go");
            String controllerTemplate="package controllers\n" +
                    "\n" +
                    "import (\n" +
                    "\t\"github.com/aurora-go/aurora\"\n" +
                    "\t\""+project_mod_name+"/services/views\"\n" +
                    ")\n" +
                    "\n" +
                    "func Control(router *aurora.Aurora) {\n" +

                    "\trouter.GET(\"/\", views.Index)\n" +
                    "}";
            controller.setBinaryContent(controllerTemplate.getBytes(StandardCharsets.UTF_8));

            //创建 model 层
            rootVF.createChildDirectory(null,"models");

            //创建 service 层
            services=rootVF.createChildDirectory(null,"services");
            VirtualFile views = services.createChildDirectory(null, "views");
            VirtualFile view_go = views.createChildData(null, "view.go");
            String viewTemplate="package views\n" +
                    "\n" +
                    "import \"github.com/aurora-go/aurora\"\n" +
                    "\n" +
                    "func Index(request aurora.Request) interface{} {\n" +
                    "\n" +
                    "\treturn \"/index.html\"\n" +
                    "}";
            view_go.setBinaryContent(viewTemplate.getBytes(StandardCharsets.UTF_8));

            //创建 静态资源目录
            resources=rootVF.createChildDirectory(null,"static");
            VirtualFile js = resources.createChildDirectory(null, "js");
            VirtualFile css = resources.createChildDirectory(null, "css");

            VirtualFile jsData = js.createChildData(null, "index.js");
            String jsTemplate="console.log(\"hello\")";
            jsData.setBinaryContent(jsTemplate.getBytes(StandardCharsets.UTF_8));

            VirtualFile cssDtaa = css.createChildData(null, "index.css");
            String cssTemplate="*{\n" +
                    "    margin: 0;\n" +
                    "    padding: 0;\n" +
                    "}\n" +
                    "\n" +
                    ".box{\n" +
                    "    width: 100vw;\n" +
                    "    height: 100vh;\n" +
                    "    display: flex;\n" +
                    "    flex-direction: row;\n" +
                    "    justify-content: center;\n" +
                    "}\n" +
                    "\n" +
                    ".main{\n" +
                    "    display: flex;\n" +
                    "    flex-direction: column;\n" +
                    "    justify-content: center;\n" +
                    "}\n" +
                    ".main>.title{\n" +
                    "    margin-top: 1vh;\n" +
                    "}\n" +
                    "\n" +
                    ".title{\n" +
                    "    display: flex;\n" +
                    "    flex-direction: row;\n" +
                    "    justify-content: center;\n" +
                    "}\n" +
                    "h1,h2,h3{\n" +
                    "    user-select: none;\n" +
                    "    font-family: Microsoft YaHei;\n" +
                    "}\n";
            cssDtaa.setBinaryContent(cssTemplate.getBytes(StandardCharsets.UTF_8));
            index_html = resources.createChildData(null, "index.html");
            String indexTemplate="<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <link rel=\"stylesheet\" href=\"./css/index.css\">\n" +
                    "    <title>Index</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class=\"box\">\n" +
                    "    <div class=\"main\">\n" +
                    "        <div class=\"title\">\n" +
                    "            <h1>Welcome to Aurora Web Framework</h1>\n" +
                    "        </div>\n" +
                    "       <div class=\"title\">\n" +
                    "           <h2>\n" +
                    "               <a href=\"http://www.go-aurora.cn\" target=\"_blank\">Usage Guide Reference</a>\n" +
                    "           </h2>\n" +
                    "       </div>\n" +
                    "\n" +
                    "        <div class=\"title\">\n" +
                    "            <h3>\n" +
                    "                <a href=\"https://www.github.com/aurora-go/aurora\" target=\"_blank\">the project address</a>\n" +
                    "            </h3>\n" +
                    "        </div>\n" +
                    "\n" +
                    "\n" +
                    "    </div>\n" +
                    "</div>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>";
            index_html.setBinaryContent(indexTemplate.getBytes(StandardCharsets.UTF_8));

            //创建 application 启动程序
            application = rootVF.createChildData(null,"application.go");
            String mainTemplate="package main\n" +
                    "\n" +
                    "import (\n" +
                    "\t\"github.com/aurora-go/aurora\"\n" +
                    "\t\""+project_mod_name+"/controllers\"\n" +
                    ")\n" +
                    "\n" +
                    "func main() {\n" +
                    "\tvar a = aurora.New()\n" +
                    "\tcontrollers.Control(a)\n" +
                    "\ta.Guide(\"8080\")\n" +
                    "}\n";
            application.setBinaryContent(mainTemplate.getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //使用消息通知组 发送一个消息消息提示框表示模板创建完成
            NotificationGroupManager.getInstance().getNotificationGroup("INFO_Notification").createNotification("Aurora web project template created successfully!!", NotificationType.INFORMATION).notify(AuroraInstance.project);
        }


    }

}

