package Aurora;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModifiableModelsProvider;
import com.intellij.openapi.roots.ModifiableRootModel;

/*
*   插件全局变量
* */
public class Aurora {
    //项目实例
    public static Project project;
    //根路径
    public static String path;
    public static ModifiableModelsProvider modifiableModelsProvider;
    //模块
    public static Module module;

    //静态资源
    public static String staticRoot;
}
