package Aurora.Services;

import com.intellij.openapi.components.Service;
import com.intellij.openapi.project.Project;

@Service
public final class AuroraProjectService {
    private final Project myProject;
    public AuroraProjectService(Project project) {
        myProject = project;
    }

}
