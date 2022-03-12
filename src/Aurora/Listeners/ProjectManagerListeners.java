package Aurora.Listeners;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import org.jetbrains.annotations.NotNull;

/*
*   项目在打开关闭时候被调用
*
* */
public class ProjectManagerListeners implements ProjectManagerListener {
    @Override
    public void projectOpened(@NotNull Project project) {
        System.out.println("projectOpened");
        ProjectManagerListener.super.projectOpened(project);
    }

    @Override
    public void projectClosed(@NotNull Project project) {
        System.out.println("projectClosed");
        ProjectManagerListener.super.projectClosed(project);
    }

    @Override
    public void projectClosing(@NotNull Project project) {
        System.out.println("projectClosing");
        ProjectManagerListener.super.projectClosing(project);
    }

    @Override
    public void projectClosingBeforeSave(@NotNull Project project) {
        System.out.println("projectClosingBeforeSave");
        ProjectManagerListener.super.projectClosingBeforeSave(project);
    }
}
