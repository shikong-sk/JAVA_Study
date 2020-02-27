package cn.skcks.game2;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//import javax.swing.JFrame;
import java.awt.Frame;

//public class GameFrame extends JFrame {

public class GameFrame extends Frame {
	private Image offScreenImage = null;

	int windowX = 500;
	int windowY = 500;
	
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(windowX, windowY);
		}
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	private static final long serialVersionUID = 1L;

	Image plane = GameUtil.getImage("images/plane.png");
	Image bg = GameUtil.getImage("images/bg.jpg");

	int planeX = 250;
	int planeY = 250;

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);

		g.drawImage(bg, 0, 0, null);
		g.drawImage(plane, planeX, planeY, null);

		if (Math.random() < 0.5) {
			planeX -= Math.random() * 20;
		} else {
			planeX += Math.random() * 20;
		}
		
	}

	// 重画窗口
	class PaintThread extends Thread {
		@Override
		public void run() {
			while (true) {
				System.out.println("窗口重画");
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * 初始化窗口
	 */

	public void launchFrame() {
		this.setTitle("MyGame");
		this.setVisible(true);
		this.setSize(windowX, windowY);
		this.setLocation(300, 300);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		new PaintThread().start();
	}

	public static void main(String[] args) {
		GameFrame appFrame = new GameFrame();
		appFrame.launchFrame();
	}
}
