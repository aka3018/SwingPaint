package woni.swingpaint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class SwingPaint extends JFrame {
	
	JButton clearBtn;
  JRadioButton blackBtn, greenBtn, redBtn, magentaBtn;
  DrawArea drawArea;
  ActionListener actionListener = new ActionListener() {
 
  public void actionPerformed(ActionEvent e) {
      if (e.getSource() == clearBtn) {
        drawArea.clear();
      } else if (e.getSource() == blackBtn) {
        drawArea.black();
      } else if (e.getSource() == greenBtn) {
        drawArea.green();
      } else if (e.getSource() == redBtn) {
        drawArea.red();
      } else if (e.getSource() == magentaBtn) {
        drawArea.magenta();
      }
    }
  };
 
  public static void main(String[] args) {
    new SwingPaint().show();
  }
 
  public void show() {
    // create main frame
    JFrame frame = new JFrame("Swing Paint");
    Container content = frame.getContentPane();
    // set layout on content pane
    content.setLayout(new BorderLayout());
    // create draw area
    drawArea = new DrawArea();
 
    // add to content pane
    content.add(drawArea, BorderLayout.CENTER);
 
    // create controls to apply colors and call clear feature
    JPanel controls = new JPanel();
 
    clearBtn = new JButton("초기화");
    clearBtn.addActionListener(actionListener);
    blackBtn = new JRadioButton("검정색");
    blackBtn.addActionListener(actionListener);
    greenBtn = new JRadioButton("녹색");
    greenBtn.addActionListener(actionListener);
    redBtn = new JRadioButton("빨강색");
    redBtn.addActionListener(actionListener);
    magentaBtn = new JRadioButton("보라색");
    magentaBtn.addActionListener(actionListener);
    
    blackBtn.setSelected(true);
    
    ButtonGroup groupRd = new ButtonGroup();
    
    groupRd.add(blackBtn);
    groupRd.add(greenBtn);
    groupRd.add(redBtn);
    groupRd.add(magentaBtn);
 
    // add to panel
    controls.add(blackBtn);
    controls.add(redBtn);
    controls.add(magentaBtn);
    controls.add(greenBtn);
    controls.add(clearBtn);
 
    // add to content pane
    content.add(controls, BorderLayout.NORTH);
 
    frame.setSize(600, 600);
    // can close frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // show the swing paint result
    frame.setVisible(true);
 
    // Now you can try our Swing Paint !!! Enjoy <img draggable="false" class="emoji" alt="😀" src="https://s.w.org/images/core/emoji/12.0.0-1/svg/1f600.svg">
  }
 
}