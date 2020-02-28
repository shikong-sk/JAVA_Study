import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
	
	double x = 100;
	double y = 100;
	
	boolean right = true;
	
	public void paint(Graphics g) {
		System.out.println(x+","+y+" "+g);
		g.drawImage(desk, 0,0,null);
		g.drawImage(ball, (int)x,(int)y,null);
		if(right) {
			x += 10;
		}
		else {
			x -= 10;
		}
		
		if(x >= 856 - 35*2)
		{
			right = false;
		}
		else if(x< 0+45) {
			right = true;
		}

		
	}
	
	//窗口
	void launch() {
		setSize(856,500);
		setLocation(50,50);
		setVisible(true);
		while(true) {
			repaint();
			try {
				
				Thread.sleep(40);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void main(String[] args) {
		BallGame game = new BallGame();
		game.launch();
	}
	
}
