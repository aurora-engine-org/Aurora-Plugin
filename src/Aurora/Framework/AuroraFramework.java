package Aurora.Framework;

import Aurora.Logo.PluginIco;
import com.intellij.framework.FrameworkTypeEx;
import com.intellij.framework.addSupport.FrameworkSupportInModuleProvider;
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
        return PluginIco.Logo;
    }
}
