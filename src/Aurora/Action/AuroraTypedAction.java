package Aurora.Action;

import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.ActionPlan;
import com.intellij.openapi.editor.actionSystem.TypedAction;
import com.intellij.openapi.editor.actionSystem.TypedActionHandler;
import org.jetbrains.annotations.NotNull;

public class AuroraTypedAction extends TypedAction {
    public AuroraTypedAction() {
        super();
    }

    @Override
    public @NotNull TypedActionHandler getHandler() {
        return super.getHandler();
    }


    @Override
    public @NotNull TypedActionHandler getRawHandler() {
        return super.getRawHandler();
    }

    @Override
    public TypedActionHandler setupRawHandler(@NotNull TypedActionHandler handler) {
        return super.setupRawHandler(handler);
    }

    @Override
    public void beforeActionPerformed(@NotNull Editor editor, char c, @NotNull DataContext context, @NotNull ActionPlan plan) {
        super.beforeActionPerformed(editor, c, context, plan);
    }
}
