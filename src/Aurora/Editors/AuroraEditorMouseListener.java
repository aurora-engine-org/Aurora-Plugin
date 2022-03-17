package Aurora.Editors;

import com.goide.psi.impl.GoStringLiteralImpl;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.LogicalPosition;
import com.intellij.openapi.editor.event.EditorMouseEvent;
import com.intellij.openapi.editor.event.EditorMouseListener;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/*
*   编辑器鼠标监听
* */
public class AuroraEditorMouseListener implements EditorMouseListener {
    @Override
    public void mousePressed(@NotNull EditorMouseEvent event) {

        EditorMouseListener.super.mousePressed(event);
    }

    @Override
    public void mouseClicked(@NotNull EditorMouseEvent event) {

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
