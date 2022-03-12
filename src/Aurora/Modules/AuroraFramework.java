package Aurora.Modules;

import Aurora.Logo.PluginIco;
import com.intellij.framework.FrameworkTypeEx;
import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable;
import com.intellij.framework.addSupport.FrameworkSupportInModuleProvider;
import com.intellij.ide.util.frameworkSupport.FrameworkSupportModel;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.roots.ModifiableModelsProvider;
import com.intellij.openapi.roots.ModifiableRootModel;
import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class AuroraFramework extends FrameworkTypeEx {

    public static final String ID="AuroraFramework";

    public static AuroraFramework framework =new AuroraFramework();

    protected AuroraFramework() {
        super(ID);
    }

    public static AuroraFramework getInstance(){
        return framework;
    }

    @NotNull
    @Override
    public FrameworkSupportInModuleProvider createProvider() {
        return AuroraModuleProvider.getInstance();
    }

    @Override
    public @NotNull
    @Nls(capitalization = Nls.Capitalization.Title) String getPresentableName() {
        return "Aurora Web";
    }

    @Override
    public @NotNull Icon getIcon() {
        return PluginIco.Aurora_Logo;
    }
}
