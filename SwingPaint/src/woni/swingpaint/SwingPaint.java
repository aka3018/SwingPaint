package woni.swingpaint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SwingPaint extends JFrame {
	private static final Logger logger = Logger.getLogger(SwingPaint.class.getName());
	JButton clearBtn;
	JRadioButton blackBtn, greenBtn, redBtn, magentaBtn, yelloBtn, pinkBtn, cyanBtn, grayBtn, whiteBtn;
	DrawArea drawArea;
	ActionListener actionListener = new ActionListener() {
		private JSlider slider;

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
	private JPanel controls;

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

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("파일");
		fileMenu.add(new JMenuItem("저장")).addActionListener(new ShowAction());
		fileMenu.addSeparator(); // 구분선 추가
		fileMenu.add(new JMenuItem("종료")).addActionListener(new ShowAction());

		
		//fileMenu.addActionListener(new ShowAction()); // actionPerformed() 메소드가 실행
		// 메뉴를 메뉴바에 등록
		menuBar.add(fileMenu);
		

		// 메뉴바 추가
		frame.setJMenuBar(menuBar);

		// add to content pane
		content.add(drawArea, BorderLayout.CENTER);

		// create controls to apply colors and call clear feature
		 controls = new JPanel();

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

		JSlider slider = new JSlider(0, 20, 1);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		// slider.setPaintTrack(true);
		slider.setMajorTickSpacing(5);
		slider.setMinorTickSpacing(1);
		// slider.addChangeListener(this);

		slider.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {

				drawArea.bold(slider.getValue());
				// l.setText( ""+s.getValue() );
			}

		});
		controls.add(slider);

		String[] colorList = { "white", "RED", "GREEN", "BLUE", "CYAN", "DARK GRAY", "MAGENTA", "ORANGE", "PINK" };
		final JComboBox cbColor = new JComboBox(colorList);
		cbColor.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String ItemSelected = cbColor.getSelectedItem().toString();

				if (ItemSelected.equals(colorList[0])) {
					drawArea.chg_color(Color.white);
				} else if (ItemSelected.equals(colorList[1])) {
					drawArea.chg_color(Color.red);
				} else if (ItemSelected.equals(colorList[2])) {
					drawArea.chg_color(Color.GREEN);
				} else if (ItemSelected.equals(colorList[3])) {
					drawArea.chg_color(Color.BLUE);
				} else if (ItemSelected.equals(colorList[4])) {
					drawArea.chg_color(Color.CYAN);
				} else if (ItemSelected.equals(colorList[5])) {
					drawArea.chg_color(Color.darkGray);
				} else if (ItemSelected.equals(colorList[6])) {
					drawArea.chg_color(Color.MAGENTA);
				} else if (ItemSelected.equals(colorList[7])) {
					drawArea.chg_color(Color.orange);
				} else if (ItemSelected.equals(colorList[8])) {
					drawArea.chg_color(Color.PINK);
				}

				// logger.info(ItemSelected);

			}
		});
		controls.add(cbColor);

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

		frame.setSize(900, 700);
		// can close frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// show the swing paint result
		frame.setVisible(true);
	}
	  class ShowAction implements ActionListener {
		   public void actionPerformed(ActionEvent e) {
		    String cmd = e.getActionCommand(); // 선택한 메뉴 아이템의 문자열 리턴
		    switch(cmd) {
		    case "저장" : 
		    	drawArea.save();
		    	 BufferedImage bImg = new BufferedImage(drawArea.getWidth(), drawArea.getHeight(), BufferedImage.TYPE_INT_RGB);
		    	    Graphics2D cg = bImg.createGraphics();
		    	    drawArea.paintAll(cg);
		    	    
		    	    Frame ms = null;
		    		FileDialog dialog = new FileDialog(ms, "저장", FileDialog.SAVE);

					dialog.setDirectory(".");   // .은 지금폴더

					dialog.setVisible(true);

					// 2. FileDialog가 비정상 종료되었을때

					if(dialog.getFile() == null) return; // 이걸빼면 취소를 해도 저장

					// 3. 경로명 파일명 설정

					String dfName = dialog.getDirectory() + dialog.getFile();
					// 4. 파일 저장	   
		    	    try {
		    	            if (ImageIO.write(bImg, "png", new File(dfName)))
		    	            {
		    	                System.out.println("-- saved");
		    	            }
		    	    } catch (IOException e1) {
		    	            // TODO Auto-generated catch block
		    	            e1.printStackTrace();
		    	    }


		    	 //logger.info(cmd);
		     break;
		  
		    case "종료" :
			     // JOptionPane.showConfirmDialog( null, "출력메세지", "타이틀", "버튼종료");
			     int result = JOptionPane.showConfirmDialog(null, "끝내시겠습니까?", "종료", JOptionPane.YES_NO_OPTION);
			     if(result==JOptionPane.CANCEL_OPTION) {
			      // [X] 버튼 누른 경우
			      break;
			     }
			     else if(result==JOptionPane.YES_OPTION) {
			      System.exit(0); // 예 버튼 누른 경우
			      break;
			     }
			     else {
			      break; // 아니오 버튼 누른 경우
			     }
			    }
			   }
		  }

	}