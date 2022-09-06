import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class KeyPressed {
  public static void main(String[] argv) throws Exception {
    JTextField component = new JTextField();
    component.addKeyListener(new MyKeyListener());

    JFrame f = new JFrame();

    f.add(component);
    f.setSize(300, 300);
    f.setVisible(true);

  }
}

class MyKeyListener extends KeyAdapter {
  public void keyPressed(KeyEvent evt) {
    System.out.println("Check for key characters: " + evt.getKeyChar());
    if (evt.getKeyChar() == 'a') {
      System.out.println("Check for key characters: " + evt.getKeyChar());
    }
    if (evt.getKeyCode() == KeyEvent.VK_HOME) {
      System.out.println("Check for key codes: " + evt.getKeyCode());
    }
  }
}
