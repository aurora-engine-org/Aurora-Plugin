package Aurora.Listeners;

import Aurora.Framework.AuroraConfigurable;
import com.intellij.internal.psiView.PsiViewerAction;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.newvfs.BulkFileListener;
import com.intellij.openapi.vfs.newvfs.events.VFileEvent;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.List;

public class AuroraBulkFileListener implements BulkFileListener {

    @Override
    public void before(@NotNull List<? extends VFileEvent> events) {
        for (VFileEvent event:events){
            //监听到go.mod文件创建后，开始生成 aurora 项目文件结构
            if(event.getFile().getName().equals("go.mod")){
                AuroraConfigurable.CreateAuroraWebProjectStructure(AuroraConfigurable.path);
                //创建完成后执行一个打开的操作
                //加载虚拟文件操作
            }

        }
        BulkFileListener.super.before(events);
    }

    @Override
    public void after(@NotNull List<? extends VFileEvent> events) {
        BulkFileListener.super.after(events);
    }

}
