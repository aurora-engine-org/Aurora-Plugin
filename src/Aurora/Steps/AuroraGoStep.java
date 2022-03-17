package Aurora.Steps;

import com.esotericsoftware.kryo.NotNull;
import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.ModuleTypeManager;
import com.intellij.openapi.module.WebModuleType;
import com.intellij.openapi.module.WebModuleTypeBase;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;

import javax.swing.*;

public class AuroraGoStep extends ModuleBuilder {

    @Override
    public ModuleType getModuleType() {

        return WebModuleTypeBase.getInstance();
    }

    @Override
    public ModuleWizardStep[] createWizardSteps(WizardContext wizardContext, ModulesProvider modulesProvider) {
        return new ModuleWizardStep[]{new ModuleWizardStep() {
            @Override
            public JComponent getComponent() {
                return new JLabel("Put your content here");
            }

            @Override
            public void updateDataModel() {

            }
        }};
    }
}
