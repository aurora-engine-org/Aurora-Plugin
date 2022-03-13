package Aurora.Listeners;

import com.intellij.ide.AppLifecycleListener;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/*
*   IDE 应用程序生命周期监听器
* */
public final class ApplicationListener implements AppLifecycleListener {

    @Override
    public void appFrameCreated(@NotNull List<String> commandLineArgs) {
//        System.out.println("appFrameCreated");
        for (String s:commandLineArgs){
            System.out.println(s);
        }
        AppLifecycleListener.super.appFrameCreated(commandLineArgs);
    }

    /*
    *   欢迎窗口 被执行
    * */
    @Override
    public void welcomeScreenDisplayed() {
//        System.out.println("welcomeScreenDisplayed");
        AppLifecycleListener.super.welcomeScreenDisplayed();
    }


    /*
    *   启动IDE 软件执行
    * */
    @Override
    public void appStarted() {
//        System.out.println("appStarted");
        AppLifecycleListener.super.appStarted();
    }


    /*
    *   关闭 IDE 时候被执行
    * */
    @Override
    public void appWillBeClosed(boolean isRestart) {
//        System.out.println("appWillBeClosed");
        AppLifecycleListener.super.appWillBeClosed(isRestart);
    }
    /*
     *   关闭 IDE 时候被执行 在 appWillBeClosed 之后
     * */
    @Override
    public void appClosing() {
//        System.out.println("appClosing");
        AppLifecycleListener.super.appClosing();
    }


}
