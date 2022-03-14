package Aurora.Listeners;

import com.intellij.ide.ApplicationLoadListener;
import com.intellij.openapi.application.Application;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

public class AuroraApplicationLoadListener implements ApplicationLoadListener {
    @Override
    public void beforeApplicationLoaded(@NotNull Application application, @NotNull Path configPath) {

        ApplicationLoadListener.super.beforeApplicationLoaded(application, configPath);
    }
}
