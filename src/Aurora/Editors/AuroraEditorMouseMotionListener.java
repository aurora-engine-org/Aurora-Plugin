package Aurora.Editors;

import com.intellij.openapi.editor.*;
import com.intellij.openapi.editor.event.EditorMouseEvent;
import com.intellij.openapi.editor.event.EditorMouseEventArea;
import com.intellij.openapi.editor.event.EditorMouseMotionListener;
import com.intellij.openapi.editor.markup.HighlighterTargetArea;
import com.intellij.openapi.editor.markup.MarkupModel;
import com.intellij.openapi.editor.markup.RangeHighlighter;
import org.jetbrains.annotations.NotNull;

import java.awt.event.MouseEvent;

/*
*   监听鼠标 移动操作
* */
public class AuroraEditorMouseMotionListener implements EditorMouseMotionListener {

    @Override
    public void mouseMoved(@NotNull EditorMouseEvent e) {
        EditorMouseMotionListener.super.mouseMoved(e);
    }

    @Override
    public void mouseDragged(@NotNull EditorMouseEvent e) {
        EditorMouseMotionListener.super.mouseDragged(e);
    }
}
