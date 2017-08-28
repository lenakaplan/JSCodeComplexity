import com.intellij.icons.AllIcons
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import javax.swing.Icon
import com.intellij.lang.javascript.psi.JSFunction

class JSFunctionsAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is JSFunction) {
            val range = TextRange(element.textRange.startOffset, element.textRange.endOffset)
            val annotation = holder.createInfoAnnotation(range, null)

            annotation.gutterIconRenderer = object : GutterIconRenderer() {
                override fun equals(other: Any?) = false
                override fun hashCode() = 0
                override fun getIcon(): Icon = AllIcons.Xml.Browsers.Chrome16
            }
        }
    }
}
