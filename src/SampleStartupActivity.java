import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.FileEditorManagerAdapter;
import com.intellij.openapi.fileEditor.FileEditorManagerEvent;
import com.intellij.openapi.fileEditor.FileEditorManagerListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.messages.MessageBus;
import org.jetbrains.annotations.NotNull;

public class SampleStartupActivity implements StartupActivity {

    @Override
    public void runActivity(Project project) {
        // This code is executed after the project was opened.
        System.out.println("Hello World! Loaded project: " + project.getName());

        MessageBus messageBus = project.getMessageBus();
        messageBus.connect().subscribe(FileEditorManagerListener.FILE_EDITOR_MANAGER, new FileEditorManagerAdapter() {
            @Override
            public void fileOpened(@NotNull FileEditorManager source, @NotNull VirtualFile file) {
                super.fileOpened(source, file);
                System.out.println("File opend" + file.getName());
            }

            @Override
            public void fileClosed(@NotNull FileEditorManager source, @NotNull VirtualFile file) {
                super.fileClosed(source, file);
                System.out.println("File closed" + file.getName());
            }

            @Override
            public void selectionChanged(@NotNull FileEditorManagerEvent event) {
                System.out.println("File changed");
                super.selectionChanged(event);
            }
        });
    }



}

