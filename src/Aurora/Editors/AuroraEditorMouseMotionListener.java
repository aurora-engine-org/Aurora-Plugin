package Aurora.Editors;


import com.intellij.openapi.editor.event.EditorMouseEvent;
import com.intellij.openapi.editor.event.EditorMouseMotionListener;

import org.jetbrains.annotations.NotNull;


/*
*   监听鼠标 移动操作
* */
public class AuroraEditorMouseMotionListener implements EditorMouseMotionListener {

    @Override
    public void mouseMoved(@NotNull EditorMouseEvent e) {

    }

    public void select(){

    }

    @Override
    public void mouseDragged(@NotNull EditorMouseEvent e) {
        EditorMouseMotionListener.super.mouseDragged(e);
    }
}
