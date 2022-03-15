package Aurora.Key;

import com.intellij.openapi.keymap.Keymap;
import com.intellij.openapi.keymap.KeymapManagerListener;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AuroraKeymapManagerListener implements KeymapManagerListener {
    @Override
    public void keymapAdded(@NotNull Keymap keymap) {
        KeymapManagerListener.super.keymapAdded(keymap);
    }

    @Override
    public void keymapRemoved(@NotNull Keymap keymap) {
        KeymapManagerListener.super.keymapRemoved(keymap);
    }

    @Override
    public void activeKeymapChanged(@Nullable Keymap keymap) {
        KeymapManagerListener.super.activeKeymapChanged(keymap);
    }

    @Override
    public void shortcutChanged(@NotNull Keymap keymap, @NonNls @NotNull String actionId) {
        KeymapManagerListener.super.shortcutChanged(keymap, actionId);
    }
}
