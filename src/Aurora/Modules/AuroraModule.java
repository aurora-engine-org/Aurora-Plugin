package Aurora.Modules;

import Aurora.Logo.PluginIco;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.ModuleTypeManager;
import com.intellij.openapi.roots.ModuleRootManager;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class AuroraModule extends ModuleType<AuroraModuleBuilder> {

    //设置aurora 在IDE中的模块标识
    private static final String ID="aurora_web_module_type";

    protected AuroraModule() {
        super(ID);
    }

    // 应用程序实例中找到模块实例
    public static AuroraModule getInstance(){
        return (AuroraModule) ModuleTypeManager.getInstance().findByID(ID);
    }

    @Override
    public @NotNull AuroraModuleBuilder createModuleBuilder() {
        // 通过 AuroraModuleBuilder 去构建 AuroraModule 类型
        return new AuroraModuleBuilder();
    }

    /*
    *   对外展示模块名称
    * */
    @Override
    public @NotNull
    @Nls(capitalization = Nls.Capitalization.Title) String getName() {
        return "Aurora";
    }

    /*
    *   模块功能描述
    * */
    @Override
    public @NotNull
    @Nls(capitalization = Nls.Capitalization.Sentence) String getDescription() {
        return "Aurora web template";
    }

    /*
    *   模块显示的小图标 logo
    * */
    @Override
    public @NotNull Icon getNodeIcon(boolean b) {
        return PluginIco.Logo;
    }



}
