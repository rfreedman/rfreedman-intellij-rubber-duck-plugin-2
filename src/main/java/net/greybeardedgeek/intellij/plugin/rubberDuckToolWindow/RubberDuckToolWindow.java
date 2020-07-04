package net.greybeardedgeek.intellij.plugin.rubberDuckToolWindow;

import com.intellij.openapi.wm.ToolWindow;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import org.jdesktop.swingx.JXImageView;

import javax.swing.*;
import java.awt.*;
import java.net.URISyntaxException;

@SuppressWarnings("unused")
public class RubberDuckToolWindow {
  private JPanel toolWindowContent;
  private JButton quackButton;
  private JXImageView duckImageView;
  private JPanel basePanel;
  private JPanel scrollPanel;

  final JFXPanel fxPanel = new JFXPanel(); // to initialize JFX

  MediaPlayer mediaPlayer;

  @SuppressWarnings("unused")
  public RubberDuckToolWindow(ToolWindow toolWindow) {
    initializeSound();
    Color backgroundColor =  new Color(242, 0, 0);
    toolWindowContent.setBackground(backgroundColor);
    basePanel.setBackground(backgroundColor);
    duckImageView.setBackground(backgroundColor);
    quackButton.addActionListener(e -> quack());
    this.duck();
  }

  public void duck() {
    duckImageView.setImage(new ImageIcon(getClass().getResource("/rubberDuckToolWindow/duck.png")).getImage());
  }

  public JPanel getContent() {
    return toolWindowContent;
  }

  void initializeSound() {
    quackButton.setEnabled(false);
    Media quackSound = getQuackSound();
    if(quackSound != null) {
      mediaPlayer = new MediaPlayer(quackSound);
      quackButton.setEnabled(true);
    }
  }

  void quack() {
    System.out.println("quacking!");
    mediaPlayer.seek(Duration.ZERO);
    mediaPlayer.play();
  }

  Media getQuackSound() {
    try {
      Media media = new Media(getClass().getResource("/quack.mp3").toURI().toString());
      return media;
    } catch (URISyntaxException e) {
      e.printStackTrace();
      return null;
    }
  }
}
