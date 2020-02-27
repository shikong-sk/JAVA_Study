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
	
	Date startTime= new Date(); // ��Ϸ��ʼʱ��
	Date endTime;
	int period; // ���ʱ��

	/*
	 * ˫�����ֹ������˸
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

	Plane plane = new Plane(planeImg, 250, 250); // �ɻ���

	// Shell Shell = new Shell();

	Shell shell[] = new Shell[10]; // �ڵ���

	Explode explode; // ��ը��

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);

		Color color = g.getColor();
		Font font = getFont();
		
		g.drawImage(bg, 0, 0, null);

		plane.draw(g); // ���ɻ�
//		Shell.draw(g);

		/*
		 * ���ڵ�
		 */
		for (int i = 0; i < shell.length; i++) {
			shell[i].draw(g);

			/*
			 * ��ײ���
			 */
			if (shell[i].getRect().intersects(plane.getRect())) {
				plane.live = false;

				if (explode == null) {
					explode = new Explode(plane.x, plane.y);
				}
			}
			
			// ����ʱ��
			if (!plane.live) {
				explode.draw(g);
				if(endTime == null)
				{
					endTime = new Date();
					
					period = (int)((endTime.getTime() - startTime.getTime()) / 1000);
				}
				
				g.setColor(Color.WHITE);
//				g.setFont(new Font("����", 1200, 16)); // �������� �������������ٶȵ��¿���
				g.drawString("����ʱ�䣺" + period + "��", 200, 100);
				
				g.setColor(color);
				g.setFont(font);
			}
		}

	}

	// �ػ�����
	class PaintThread extends Thread {
		@Override
		public void run() {
			while (true) {
//				System.out.println("�����ػ�");
				repaint();
				try {
					Thread.sleep(17); // 1000 / 40 = 25 FPS �� 1000 / 17 �� 60 FPS
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// ���̼�����
	class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyPressed(e);
//			System.out.println("���£�" + e.getKeyCode());
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
	 * ��ʼ������
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
		 * ��ʼ���ڵ�
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
