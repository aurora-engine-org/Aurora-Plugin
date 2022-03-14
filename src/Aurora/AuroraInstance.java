package Aurora;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModifiableModelsProvider;
import com.intellij.openapi.roots.ModifiableRootModel;

/*
*   插件全局变量
* */
public class AuroraInstance {
    public static Project project;
    public static String path;
    public static ModifiableModelsProvider modifiableModelsProvider;
    public static Module module;
}
