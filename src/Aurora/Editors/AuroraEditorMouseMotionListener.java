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
        Editor editor = e.getEditor();
        MouseEvent mouseEvent = e.getMouseEvent();
        //获取鼠标覆盖的编辑区区域
        if (e.getArea().toString().equals("EDITING_AREA")){
            //检查是否覆盖文本
            boolean overText = e.isOverText();
            if (overText){
                LogicalPosition logicalPosition = e.getLogicalPosition();
                String s = logicalPosition.toString();
                System.out.println(s);
                //获取选择的文本内容
                SelectionModel selectionModel = editor.getSelectionModel();

                String selectedText = selectionModel.getSelectedText();
                if (selectedText!=null){
                    System.out.println(selectedText);
                }
                FoldRegion collapsedFoldRegion = e.getCollapsedFoldRegion();
                String s1 = collapsedFoldRegion.toString();
                System.out.println(s1);
            }
        }
        EditorMouseMotionListener.super.mouseMoved(e);
    }

    @Override
    public void mouseDragged(@NotNull EditorMouseEvent e) {
        EditorMouseMotionListener.super.mouseDragged(e);
    }
}
