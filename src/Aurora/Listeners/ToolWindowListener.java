package Aurora.Listeners;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.openapi.wm.ex.ToolWindowManagerListener;
import com.intellij.util.indexing.diagnostic.dump.paths.PortableFilePath;
import org.jetbrains.annotations.NotNull;

public class ToolWindowListener implements ToolWindowManagerListener {
    private final Project project;

    public ToolWindowListener(Project project) {
//        System.out.println("IDEToolWindowListener");
        this.project = project;

    }

    @Override
    public void stateChanged(@NotNull ToolWindowManager toolWindowManager) {
        // IDE 程序动 窗口动作 作监听，打开关闭都会触发
    }
}
