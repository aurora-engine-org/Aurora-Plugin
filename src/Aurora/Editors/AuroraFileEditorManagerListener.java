package Aurora.Editors;
import com.intellij.openapi.fileEditor.*;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.vfs.VirtualFile;

import org.jetbrains.annotations.NotNull;


public class AuroraFileEditorManagerListener implements FileEditorManagerListener {
    @Override
    public void fileOpenedSync(@NotNull FileEditorManager source, @NotNull VirtualFile file, @NotNull Pair<FileEditor[], FileEditorProvider[]> editors) {
        FileEditorManagerListener.super.fileOpenedSync(source, file, editors);
    }

    /*
    *  文件被打开时候加载
    * */
    @Override
    public void fileOpened(@NotNull FileEditorManager source, @NotNull VirtualFile file) {

    }

    @Override
    public void fileClosed(@NotNull FileEditorManager source, @NotNull VirtualFile file) {
        FileEditorManagerListener.super.fileClosed(source, file);
    }

    @Override
    public void selectionChanged(@NotNull FileEditorManagerEvent event) {
        FileEditorManagerListener.super.selectionChanged(event);
    }

}
