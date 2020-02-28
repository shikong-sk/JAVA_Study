import java.awt.*;
import javax.swing.*;

public class BallGame2 extends JFrame {
	private static final long serialVersionUID = 1L;
	
	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
	
	double x = 100;
	double y = 100;
	double time = 10000;
	
	final double PI = Math.PI;
	
	double degree = PI/3;
	
	public void paint(Graphics g) {
		System.out.println(x+","+y+" "+g);
		g.drawImage(desk, 0,0,null);
		g.drawImage(ball, (int)x,(int)y,null);

		x += 10*Math.cos(degree);
		y += 10*Math.sin(degree);
		
		if(y>=500-(40+30) || y<=40+30)
		{ 
			degree = -degree;
		}
		if(x <= 40 || x>=856-(40+30))
		{
			degree = PI - degree;
		}
		
	}
	
	//窗口
	void launch() {
		setSize(856,500);
		setLocation(50,50);
		setVisible(true);
		while(time>=0) {
			repaint();
			try {
				
				Thread.sleep(40);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			time -= 1;
		}

	}
	
	public static void main(String[] args) {
		BallGame2 game = new BallGame2();
		game.launch();
		
	}
	
}
