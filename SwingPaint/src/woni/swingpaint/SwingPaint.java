package woni.swingpaint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
 
public class SwingPaint extends JFrame {
	
	JButton clearBtn;
  JRadioButton blackBtn, greenBtn, redBtn, magentaBtn, yelloBtn, pinkBtn, cyanBtn, grayBtn, whiteBtn;
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
      } else if (e.getSource() == yelloBtn) {
  		drawArea.yellow();
  	} else if (e.getSource() == pinkBtn) {
  		drawArea.pink();
  	} else if (e.getSource() == cyanBtn) {
  		drawArea.cyan();
  	} else if (e.getSource() == grayBtn) {
  		drawArea.gray();
  	} else if (e.getSource() == whiteBtn) {
  		drawArea.white();
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
 
    clearBtn = new JButton("지우기");
   	clearBtn.setBackground(Color.BLACK);
   	clearBtn.setForeground(Color.white);
   	clearBtn.addActionListener(actionListener);
   	blackBtn = new JRadioButton("검정");
   	blackBtn.addActionListener(actionListener);
   	greenBtn = new JRadioButton("초록");
   	greenBtn.addActionListener(actionListener);
   	redBtn = new JRadioButton("빨강");
   	redBtn.addActionListener(actionListener);
   	magentaBtn = new JRadioButton("마젠타");
   	magentaBtn.addActionListener(actionListener);
   	yelloBtn = new JRadioButton("노랑");
   	yelloBtn.addActionListener(actionListener);
   	pinkBtn = new JRadioButton("분홍");
   	pinkBtn.addActionListener(actionListener);
   	cyanBtn = new JRadioButton("청록");
   	cyanBtn.addActionListener(actionListener);
   	grayBtn = new JRadioButton("회색");
   	grayBtn.addActionListener(actionListener);
   	whiteBtn = new JRadioButton("흰색");
   	whiteBtn.addActionListener(actionListener);
       
    blackBtn.setSelected(true);
    
    ButtonGroup groupRd = new ButtonGroup();
    
    groupRd.add(blackBtn);
	groupRd.add(greenBtn);
	groupRd.add(redBtn);
	groupRd.add(magentaBtn);
	groupRd.add(yelloBtn);
	groupRd.add(pinkBtn);
	groupRd.add(cyanBtn);
	groupRd.add(grayBtn);
	groupRd.add(whiteBtn);
	// add to panel
	controls.add(blackBtn);
	controls.add(redBtn);
	controls.add(magentaBtn);
	controls.add(greenBtn);
	controls.add(yelloBtn);
	controls.add(pinkBtn);
	controls.add(cyanBtn);
	controls.add(grayBtn);
	controls.add(whiteBtn);
	controls.add(clearBtn);

 
    // add to content pane
    content.add(controls, BorderLayout.NORTH);
 
    frame.setSize(600, 600);
    // can close frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // show the swing paint result
    frame.setVisible(true);
 
    // Now you can try our Swing Paint !!! Enjoy <img draggable="false" class="emoji" alt="�윑�" src="https://s.w.org/images/core/emoji/12.0.0-1/svg/1f600.svg">
  }
 
}