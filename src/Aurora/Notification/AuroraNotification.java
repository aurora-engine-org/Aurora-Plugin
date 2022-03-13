package Aurora.Notification;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationGroupManager;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AuroraNotification implements Notifications {

    @Override
    public void notify(@NotNull Notification notification) {
        String title = notification.getTitle();
        System.out.println("title:"+title);
        Notifications.super.notify(notification);
    }
}
