package Aurora.Listeners;

import com.intellij.lang.Language;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.event.EditorFactoryEvent;
import com.intellij.openapi.editor.event.EditorFactoryListener;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import org.jetbrains.annotations.NotNull;
/*
*   监听打开的文件
* */
public class AuroraEditorFactoryListener implements EditorFactoryListener {

    /*
    *   打开文件编辑触发
    * */
    @Override
    public void editorCreated(@NotNull EditorFactoryEvent event) {

    }
    /*
    *   关闭触发
    * */
    @Override
    public void editorReleased(@NotNull EditorFactoryEvent event) {

    }
}
