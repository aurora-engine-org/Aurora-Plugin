package Aurora.Editors;

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

    }
    /*
    *   关闭触发
    * */
    @Override
    public void editorReleased(@NotNull EditorFactoryEvent event) {

    }
}
