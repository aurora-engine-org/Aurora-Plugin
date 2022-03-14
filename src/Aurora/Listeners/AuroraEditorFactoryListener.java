package Aurora.Listeners;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.event.EditorFactoryEvent;
import com.intellij.openapi.editor.event.EditorFactoryListener;
import org.jetbrains.annotations.NotNull;

public class AuroraEditorFactoryListener implements EditorFactoryListener {
    @Override
    public void editorCreated(@NotNull EditorFactoryEvent event) {
        Editor editor = event.getEditor();
        Document document = editor.getDocument();
        String text = document.getText();
        System.out.println(text);
        EditorFactoryListener.super.editorCreated(event);
    }

    @Override
    public void editorReleased(@NotNull EditorFactoryEvent event) {
        System.out.println("close");
        EditorFactoryListener.super.editorReleased(event);
    }
}
