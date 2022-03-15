package Aurora.Listeners;

import Aurora.AuroraInstance;
import Aurora.Framework.AuroraConfigurable;
import com.intellij.ide.util.RunOnceUtil;
import com.intellij.notification.NotificationGroupManager;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.vfs.newvfs.BulkFileListener;
import com.intellij.openapi.vfs.newvfs.events.VFileEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

/*
*   通过监听主模块的内容创建 点来执行我们需要生成的项目结构
* */
public class AuroraBulkFileListener implements BulkFileListener {

    @Override
    public void before(@NotNull List<? extends VFileEvent> events) {

    }

    @Override
    public void after(@NotNull List<? extends VFileEvent> events) {
        for (VFileEvent event:events){

            //监听到go.mod文件创建之前，开始生成 aurora 项目文件结构，已完成
            if(Objects.requireNonNull(event.getFile()).getName().equals("go.mod")){
                //保证在整个项目中只运行一次
                if (AuroraInstance.project!=null){
                    RunOnceUtil.runOnceForProject(AuroraInstance.project, "create aurora template", () -> {
                        NotificationGroupManager.getInstance().getNotificationGroup("INFO_Notification").createNotification("Start building the project!", NotificationType.INFORMATION).notify(AuroraInstance.project);
                        //此处后期修改 虚拟文件系统方式创建结构
                        AuroraConfigurable.CreateAuroraWebProjectStructure(AuroraInstance.path);
                    });
                }
            }

        }
    }

}
