package cn.skcks.game3;

import java.awt.Color;
import java.awt.Graphics;
import java.time.chrono.MinguoChronology;
import java.util.Random;

/*
 * 炮弹类
 */
public class Shell extends GameObject {
	double degree;
	
	public Shell() {
		width = 8;
		height = 8;
		
		x = (Math.random()*Constant.window_Width - width + 1) + width;
//		y = (Math.random()*Constant.window_Height - height + 1) + height;
		y = 100;
		
		int maxSpeed = 8;
		int minSpeed = 3;
		speed = (int)(Math.random() * (maxSpeed - minSpeed) + 1) + minSpeed; // 随机炮弹速度
//		System.out.println(speed);
		degree = Math.random() * Math.PI * 2;
	}
	
	public void draw(Graphics g) {
		Color color = g.getColor();
		g.setColor(Color.YELLOW);
		
		g.fillOval((int)x, (int)y, width, height);
		
		
		/*
		 * 炮弹任意角度飞行
		 */
		x += speed * Math.cos(degree);
		y += speed * Math.sin(degree);
		
		if(x < 0 || x > Constant.window_Width - width)
		{
			degree = Math.PI - degree;
		}
		if(y < 0 + 40 || y > Constant.window_Height - height)
		{
			degree = - degree;
		}
		
		g.setColor(color);
	}
}
