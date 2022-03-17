package Aurora.Modules;

import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.WebModuleTypeBase;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleFileIndex;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.openapi.ui.JBPopupMenu;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.components.JBBox;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBOptionButton;
import com.intellij.ui.components.JBPanel;
import com.intellij.util.ui.JButtonAction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class AuroraModuleBuilder extends ModuleBuilder {
    private static final Logger LOG = Logger.getInstance(AuroraModuleBuilder.class);
    public static String GOROOT=null;
    public static String root=null;
    public static String No_SDK="<No SDK>";
    public static Project project;
    @Override
    public void setupRootModel(@NotNull ModifiableRootModel modifiableRootModel) throws ConfigurationException {
        //获取模块，这个模块是通过向导步骤最后一步进入项目的 模块
        Module module = modifiableRootModel.getModule();
        project = modifiableRootModel.getProject();
        root=project.getPresentableUrl();
        //对模块初始化
        ModuleRootManager instance = ModuleRootManager.getInstance(module);
        VirtualFile workspaceFile = modifiableRootModel.getProject().getWorkspaceFile();
        Sdk sdk = ModuleRootManager.getInstance(module).getSdk();
        if (sdk==null){

        }
    }

    @Override
    public ModuleType getModuleType() {
        return WebModuleTypeBase.getInstance();
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
                JBBox hbox=new JBBox(1);
                TitledBorder b=new TitledBorder("aurora framework");

                hbox.setBorder(b);

                JBBox box=new JBBox(0);
                JBLabel label=new JBLabel(" GOROOT: ");
                label.setMaximumSize(new Dimension(100,30));
                label.setMinimumSize(new Dimension(100,30));
                ComboBox<String> ComboBox = new ComboBox<>();
                JButton Button = new JButton("add");
                Button.setToolTipText("添加 SDK");
                //点击按钮打开文件选择器选择GOROOT进行配置SDK
                Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //文件选择器
                        FileChooserDescriptor descriptor = new FileChooserDescriptor(true, true, true, true, false, false);
                        VirtualFile virtualFile = FileChooser.chooseFile(descriptor, context.getProject(), null);
                        //校验goroot
                    }
                });
                ComboBox.setMaximumSize(new Dimension(10000,30));
                ComboBox.setMinimumSize(new Dimension(300,30));
                Map<String, String> Env = System.getenv();
                GOROOT= Env.get("GOROOT");
                if (GOROOT!=null){
                    ComboBox.addItem(GOROOT);
                }else {
                    ComboBox.addItem(No_SDK);
                }
                hbox.add(box);
                box.add(label);
                box.add(ComboBox);
                box.add(Button);
                return hbox;
            }

            @Override
            public void updateDataModel() {

            }
        };
    }

}