package net.greybeardedgeek.intellij.plugin.rubberDuckToolWindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class RubberDuckToolWindowFactory implements ToolWindowFactory {
  public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
    RubberDuckToolWindow myToolWindow = new RubberDuckToolWindow(toolWindow);
    ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
    Content content = contentFactory.createContent(myToolWindow.getContent(), "", false);
    toolWindow.getContentManager().addContent(content);
  }
}
