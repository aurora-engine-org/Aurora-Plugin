package Aurora.Listeners;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.util.messages.MessageBus;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/*
*   项目在打开关闭时候被调用
*
* */
public class ProjectManagerListeners implements ProjectManagerListener {
    @Override
    public void projectOpened(@NotNull Project project) {
//        System.out.println("project Opened");
        /*
        *   打开项目，或者创建项目执行一次
        *   此处可以用来执行初始化命令 比如 go mod tidy 等
        * */

        ProjectManagerListener.super.projectOpened(project);
    }

    @Override
    public void projectClosed(@NotNull Project project) {
//        System.out.println("project Closed");
        ProjectManagerListener.super.projectClosed(project);
    }

    @Override
    public void projectClosing(@NotNull Project project) {
//        System.out.println("project Closing");
        ProjectManagerListener.super.projectClosing(project);
    }

    @Override
    public void projectClosingBeforeSave(@NotNull Project project) {
//        System.out.println("projectClosing BeforeSave");
        ProjectManagerListener.super.projectClosingBeforeSave(project);
    }
}
