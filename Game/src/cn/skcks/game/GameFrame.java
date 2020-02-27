package cn.skcks.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	Image ball = GameUtil.getImage("images/ball.png");
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		Color color = g.getColor();
		Font font = g.getFont();
		
		g.setColor(new Color(0,0,255));
		
		g.drawLine(100, 100, 400, 400);
		g.drawRect(100, 100, 300, 300);
		g.drawOval(100, 100, 300, 300);
		g.fillRect(100, 100, 40, 40);
		
		g.setColor(color);
		g.setFont(new Font("宋体",Font.BOLD,50));
		g.drawString("时空旅行者", 200, 200);
		g.setFont(font);
		
		g.drawImage(ball, 250,250, null);
	}

	
	/*
	 * 初始化窗口
	 */

	public void launchFrame() {
		this.setTitle("MyGame");
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocation(300, 300);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		GameFrame appFrame = new GameFrame();
		appFrame.launchFrame();

	}
}
