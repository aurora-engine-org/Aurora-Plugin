package Aurora.Listeners;

import com.intellij.workspaceModel.ide.WorkspaceModelChangeListener;
import com.intellij.workspaceModel.storage.EntityChange;
import com.intellij.workspaceModel.storage.VersionedStorageChange;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class AuroraProjectWorkspaceModelChangeListener implements WorkspaceModelChangeListener {
    @Override
    public void beforeChanged(@NotNull VersionedStorageChange versionedStorageChange) {
//        System.out.println("AuroraProjectWorkspaceModelChangeListener beforeChanged");


    }

    @Override
    public void changed(@NotNull VersionedStorageChange versionedStorageChange) {
//        System.out.println("AuroraProjectWorkspaceModelChangeListener changed");
    }
}
