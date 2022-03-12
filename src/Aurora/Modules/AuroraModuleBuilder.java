package Aurora.Modules;

import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleFileIndex;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.openapi.ui.JBPopupMenu;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBOptionButton;
import com.intellij.ui.components.JBPanel;
import com.intellij.util.ui.JButtonAction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class AuroraModuleBuilder extends ModuleBuilder {

    @Override
    public void setupRootModel(@NotNull ModifiableRootModel modifiableRootModel) throws ConfigurationException {
        //获取模块，这个模块是通过向导步骤最后一步进入项目的 模块
        Module module = modifiableRootModel.getModule();
        //对模块初始化
        ModuleRootManager instance = ModuleRootManager.getInstance(module);
        Sdk sdk = instance.getSdk();
        ModuleFileIndex fileIndex = instance.getFileIndex();

        Module[] dependencies = instance.getDependencies();
        String[] dependencyModuleNames = instance.getDependencyModuleNames();
        VirtualFile[] contentRoots = instance.getContentRoots();


        super.setupRootModel(modifiableRootModel);
    }

    @Override
    public AuroraModule getModuleType() {
        return AuroraModule.getInstance();
    }

    /*
    *   此处可以设置向导UI
    *   IDE 仅支持 Swing 实在难玩，这里实现调用系统默认
    * */
    @Override
    public @Nullable ModuleWizardStep getCustomOptionsStep(WizardContext context, Disposable parentDisposable) {
        return new ModuleWizardStep() {
            @Override
            public JComponent getComponent() {
                GridBagLayout gridBagLayout = new GridBagLayout();
                JBPanel jbPanelJBPanel = new JBPanel<>(gridBagLayout);

                JBLabel label=new JBLabel("GOROOT:");
                ComboBox<String> jbLabelComboBox = new ComboBox<>();
                JButton jButton = new JButton("+");

                jbLabelComboBox.addItem("<No SDK>");
                jbLabelComboBox.setMaximumSize(new Dimension(600,50));
                jbLabelComboBox.setMinimumSize(new Dimension(200,50));
                Map<String, String> getenv = System.getenv();
                getenv.get("");



                jbPanelJBPanel.add(label);
                jbPanelJBPanel.add(jbLabelComboBox);
                jbPanelJBPanel.add(jButton);
                return jbPanelJBPanel;
            }

            @Override
            public void updateDataModel() {

            }
        };
    }
}
