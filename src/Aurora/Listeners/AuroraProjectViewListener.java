package Aurora.Listeners;

import com.intellij.ide.projectView.impl.AbstractProjectViewPane;
import com.intellij.ide.projectView.impl.ProjectViewListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
*   project 工具窗口 标题类型切换监听
* */
public class AuroraProjectViewListener implements ProjectViewListener {
    @Override
    public void paneShown(@NotNull AbstractProjectViewPane current, @Nullable AbstractProjectViewPane previous) {
//        String title = current.getTitle();
//        System.out.println("title:"+title);
        ProjectViewListener.super.paneShown(current, previous);
    }
}
