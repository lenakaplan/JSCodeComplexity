import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.FileEditorManagerEvent
import com.intellij.openapi.fileEditor.FileEditorManagerListener
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.messages.MessageBus
import com.intellij.util.messages.MessageBusConnection

/**
 * This is our sample StartupActivity used to execute code on project open.
 */
class SampleStartupActivity : StartupActivity {

    override fun runActivity(project: Project) {
        // This code is executed after the project was opened.
        println("Loaded project: " + project.name)

        val bus = ApplicationManager.getApplication().messageBus
        val connection = bus.connect()
        connection.subscribe(FileEditorManagerListener.FILE_EDITOR_MANAGER, object : FileEditorManagerListener {
            override fun fileOpened(source: FileEditorManager, file: VirtualFile) {
                println("open")

            }

            override fun fileClosed(source: FileEditorManager, file: VirtualFile) {
                println("close")

            }

            override fun selectionChanged(event: FileEditorManagerEvent) {
                println("change")
            }
        })
    }
}