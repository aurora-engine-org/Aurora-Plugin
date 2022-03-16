package Aurora.Editors;

import com.goide.psi.GoRecursiveVisitor;
import com.goide.psi.impl.GoStringLiteralImpl;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.editor.event.EditorMouseEvent;
import com.intellij.openapi.editor.event.EditorMouseEventArea;
import com.intellij.openapi.editor.event.EditorMouseMotionListener;

import com.intellij.openapi.fileEditor.FileDocumentManager;

import com.intellij.openapi.project.Project;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;

import com.intellij.psi.PsiFile;

import com.intellij.psi.util.PsiTreeUtil;
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
