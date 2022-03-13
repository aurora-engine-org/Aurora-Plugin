package Aurora.Framework;

import Aurora.Logo.PluginIco;
import com.intellij.framework.FrameworkTypeEx;
import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable;
import com.intellij.framework.addSupport.FrameworkSupportInModuleProvider;
import com.intellij.ide.util.frameworkSupport.FrameworkSupportModel;
import com.intellij.openapi.module.ModuleType;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class AuroraModuleProvider extends FrameworkSupportInModuleProvider {

    private static AuroraModuleProvider provider=new AuroraModuleProvider();
    private String Module="Java Module";
    private AuroraModuleProvider() {

    }

    public static AuroraModuleProvider getInstance(){
        return provider;
    }

    @NotNull
    @Override
    public FrameworkTypeEx getFrameworkType() {
        return AuroraFramework.getInstance();
    }

    @Override
    public @NotNull @Nls(capitalization = Nls.Capitalization.Title) String getPresentableName() {
        return "Aurora Web";
    }

    @Override
    public @NotNull
    Icon getIcon() {
        return PluginIco.Logo;
    }

    @NotNull
    @Override
    public FrameworkSupportInModuleConfigurable createConfigurable(@NotNull FrameworkSupportModel model) {
        return AuroraConfigurable.getInstance();
    }

    @Override
    public boolean isEnabledForModuleType(@NotNull ModuleType type) {
        /*
         *   把 框架类型 放到指定的向导模块下面
         * */
        if (type.getName().equals(Module)){
            return false;
        }
        return true;
    }
}
