package Aurora.Providers;

import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorPolicy;
import com.intellij.openapi.fileEditor.FileEditorProvider;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class AuroraFileEditorProvider implements FileEditorProvider {
    @Override
    public boolean accept(@NotNull Project project, @NotNull VirtualFile virtualFile) {
        return false;
    }

    @Override
    public @NotNull FileEditor createEditor(@NotNull Project project, @NotNull VirtualFile virtualFile) {
        return null;
    }

    @Override
    public @NotNull
    @NonNls String getEditorTypeId() {
        return null;
    }

    @Override
    public @NotNull FileEditorPolicy getPolicy() {
        return null;
    }
}
