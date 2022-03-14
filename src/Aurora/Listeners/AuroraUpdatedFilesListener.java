package Aurora.Listeners;

import com.intellij.openapi.vcs.update.UpdatedFilesListener;

import java.util.Set;

public class AuroraUpdatedFilesListener implements UpdatedFilesListener {
    @Override
    public void consume(Set<String> strings) {
        System.out.println(strings.toString());
    }
}
