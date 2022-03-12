package Aurora.Listeners;

import com.intellij.openapi.roots.ModuleRootEvent;
import com.intellij.openapi.roots.ModuleRootListener;
import org.jetbrains.annotations.NotNull;

public class RootModuleListener implements ModuleRootListener {
    @Override
    public void beforeRootsChange(@NotNull ModuleRootEvent event) {
        ModuleRootListener.super.beforeRootsChange(event);
    }

    @Override
    public void rootsChanged(@NotNull ModuleRootEvent event) {
        ModuleRootListener.super.rootsChanged(event);
    }
}
