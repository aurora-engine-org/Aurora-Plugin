package Aurora.Editors;

import com.intellij.openapi.editor.event.EditorMouseEvent;
import com.intellij.openapi.editor.event.EditorMouseListener;
import org.jetbrains.annotations.NotNull;
/*
*   编辑器鼠标监听
* */
public class AuroraEditorMouseListener implements EditorMouseListener {
    @Override
    public void mousePressed(@NotNull EditorMouseEvent event) {
        System.out.println("mousePressed");
        EditorMouseListener.super.mousePressed(event);
    }

    @Override
    public void mouseClicked(@NotNull EditorMouseEvent event) {
        EditorMouseListener.super.mouseClicked(event);
    }

    @Override
    public void mouseReleased(@NotNull EditorMouseEvent event) {
        EditorMouseListener.super.mouseReleased(event);
    }

    @Override
    public void mouseEntered(@NotNull EditorMouseEvent event) {
        EditorMouseListener.super.mouseEntered(event);
    }

    @Override
    public void mouseExited(@NotNull EditorMouseEvent event) {
        EditorMouseListener.super.mouseExited(event);
    }
}
