package Aurora.Listeners;

import com.intellij.ide.ui.VirtualFileAppearanceListener;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class AuroraVirtualFileAppearanceListener implements VirtualFileAppearanceListener {
    @Override
    public void virtualFileAppearanceChanged(@NotNull VirtualFile virtualFile) {
//        System.out.println("virtualFileAppearanceChanged");
//        System.out.println(virtualFile.getName());
    }
}
