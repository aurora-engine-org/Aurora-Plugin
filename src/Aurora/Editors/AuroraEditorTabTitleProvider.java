package Aurora.Editors;

import com.intellij.openapi.fileEditor.impl.EditorTabTitleProvider;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class AuroraEditorTabTitleProvider implements EditorTabTitleProvider {
    @Override
    public @NlsContexts.TabTitle
    @Nullable String getEditorTabTitle(@NotNull Project project, @NotNull VirtualFile virtualFile) {

        return null;
    }

    @Override
    public @NlsContexts.Tooltip
    @Nullable String getEditorTabTooltipText(@NotNull Project project, @NotNull VirtualFile virtualFile) {
        return EditorTabTitleProvider.super.getEditorTabTooltipText(project, virtualFile);
    }
}
