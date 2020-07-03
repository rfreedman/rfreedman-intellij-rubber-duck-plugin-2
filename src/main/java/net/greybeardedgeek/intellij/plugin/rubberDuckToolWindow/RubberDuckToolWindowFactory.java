// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package net.greybeardedgeek.intellij.plugin.rubberDuckToolWindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class RubberDuckToolWindowFactory implements ToolWindowFactory {
  // Create the tool window content.
  public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
    RubberDuckToolWindow myToolWindow = new RubberDuckToolWindow(toolWindow);
    ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
    Content content = contentFactory.createContent(myToolWindow.getContent(), "", false);
    toolWindow.getContentManager().addContent(content);
  }
}
