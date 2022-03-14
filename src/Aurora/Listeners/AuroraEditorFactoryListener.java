package Aurora.Listeners;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.event.EditorFactoryEvent;
import com.intellij.openapi.editor.event.EditorFactoryListener;
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
//        Editor editor = event.getEditor();
//        Document document = editor.getDocument();
//        String text = document.getText();
//        System.out.println(text);

    }
    /*
    *   关闭触发
    * */
    @Override
    public void editorReleased(@NotNull EditorFactoryEvent event) {
//        System.out.println("close");
    }
}
