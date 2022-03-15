package Aurora.Key;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.keymap.KeymapExtension;
import com.intellij.openapi.keymap.KeymapGroup;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Condition;
import org.jetbrains.annotations.Nullable;

public class AuroraKeymapExtension implements KeymapExtension {
    @Override
    public @Nullable KeymapGroup createGroup(Condition<? super AnAction> condition, @Nullable Project project) {

        return null;
    }
}
