package cn.skcks.game3;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.awt.Color;
import java.awt.Font;
//import javax.swing.JFrame;
import java.awt.Frame;

//public class GameFrame extends JFrame {

public class GameFrame extends Frame {

	private static final long serialVersionUID = 1L;
	
	Date startTime= new Date(); // 游戏起始时间
	Date endTime;
	int period; // 存活时间

	/*
	 * 双缓冲防止窗口闪烁
	 */
	private Image offScreenImage = null;

	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(Constant.window_Width, Constant.window_Height);
		}
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	Image planeImg = GameUtil.getImage("images/plane.png");
	Image bg = GameUtil.getImage("images/bg.jpg");

	Plane plane = new Plane(planeImg, 250, 250); // 飞机类

	// Shell Shell = new Shell();

	Shell shell[] = new Shell[10]; // 炮弹类

	Explode explode; // 爆炸类

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);

		Color color = g.getColor();
		Font font = getFont();
		
		g.drawImage(bg, 0, 0, null);

		plane.draw(g); // 画飞机
//		Shell.draw(g);

		/*
		 * 画炮弹
		 */
		for (int i = 0; i < shell.length; i++) {
			shell[i].draw(g);

			/*
			 * 碰撞检测
			 */
			if (shell[i].getRect().intersects(plane.getRect())) {
				plane.live = false;

				if (explode == null) {
					explode = new Explode(plane.x, plane.y);
				}
			}
			
			// 生存时间
			if (!plane.live) {
				explode.draw(g);
				if(endTime == null)
				{
					endTime = new Date();
					
					period = (int)((endTime.getTime() - startTime.getTime()) / 1000);
				}
				
				g.setColor(Color.WHITE);
//				g.setFont(new Font("黑体", 1200, 16)); // 设置字体 但会拖慢运行速度导致卡顿
				g.drawString("生存时间：" + period + "秒", 200, 100);
				
				g.setColor(color);
				g.setFont(font);
			}
		}

	}

	// 重画窗口
	class PaintThread extends Thread {
		@Override
		public void run() {
			while (true) {
//				System.out.println("窗口重画");
				repaint();
				try {
					Thread.sleep(17); // 1000 / 40 = 25 FPS ， 1000 / 17 ≈ 60 FPS
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 键盘监听类
	class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyPressed(e);
//			System.out.println("按下：" + e.getKeyCode());
			plane.addDirection(e);

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyReleased(e);
			plane.minusDirection(e);
		}

	}

	/*
	 * 初始化窗口
	 */

	public void launchFrame() {
		this.setTitle("MyGame");
		this.setVisible(true);
		this.setSize(Constant.window_Width, Constant.window_Height);
		this.setLocation(300, 300);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		new PaintThread().start();
		addKeyListener(new KeyMonitor());

		/*
		 * 初始化炮弹
		 */
		for (int i = 0; i < shell.length; i++) {
			shell[i] = new Shell();
		}
	}

	public static void main(String[] args) {
		GameFrame appFrame = new GameFrame();
		appFrame.launchFrame();
	}
}
