package Aurora.Editors;

import com.intellij.openapi.editor.*;
import com.intellij.openapi.editor.event.EditorMouseEvent;
import com.intellij.openapi.editor.event.EditorMouseEventArea;
import com.intellij.openapi.editor.event.EditorMouseMotionListener;

import com.intellij.openapi.fileEditor.FileDocumentManager;

import com.intellij.openapi.project.Project;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;

import com.intellij.psi.PsiFile;

import org.jetbrains.annotations.NotNull;


/*
*   监听鼠标 移动操作
* */
public class AuroraEditorMouseMotionListener implements EditorMouseMotionListener {

    @Override
    public void mouseMoved(@NotNull EditorMouseEvent e) {
        //EditorMouseEventArea.EDITING_AREA 选择鼠标在编辑区内 && e.isOverText() 覆盖到文本
        System.out.println("1");
        if (e.getArea().toString().equals(EditorMouseEventArea.EDITING_AREA.toString()) && e.isOverText()){
            Editor editor = e.getEditor();
            Project project = editor.getProject();
            Document document = editor.getDocument();
            VirtualFile file = FileDocumentManager.getInstance().getFile(document);
            PsiFile psiFile = PsiDocumentManager.getInstance(project).getPsiFile(document);
//            GoStringLiteralImpl childOfAnyType = PsiTreeUtil.findChildOfAnyType(psiFile, true, GoStringLiteralImpl.class);

        }
    }

    public void select(){

    }

    @Override
    public void mouseDragged(@NotNull EditorMouseEvent e) {
        EditorMouseMotionListener.super.mouseDragged(e);
    }
}
