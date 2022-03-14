package Aurora.Framework;

import Aurora.AuroraInstance;
import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable;
import com.intellij.ide.util.RunOnceUtil;
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
    public static void CreateAuroraWebProjectStructure(String root) {

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
        } finally {
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

            //使用消息通知组 发送一个消息消息提示框表示模板创建完成
            NotificationGroupManager.getInstance().getNotificationGroup("INFO_Notification").createNotification("aurora web project template created successfully!!", NotificationType.INFORMATION).notify(AuroraInstance.project);
//            RunOnceUtil.runOnceForProject(AuroraInstance.project,"open application.go",()->{
//                VirtualFile virtualFile = LocalFileSystem.getInstance().findFileByPath(AuroraInstance.path);
//                assert virtualFile != null;
//                VirtualFile child = virtualFile.findChild("app.go");
//                assert child != null;
//                PsiFile file = PsiManager.getInstance(AuroraInstance.project).findFile(child);
//                assert file != null;
//                FileViewProvider viewProvider = file.getViewProvider();
//                viewProvider.getPsi();
//            });
        }


    }

}

