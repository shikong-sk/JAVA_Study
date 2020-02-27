package cn.skcks.game3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;


public class Plane extends GameObject {

	boolean up,left,down,right;
	int speed;
	boolean live = true;
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if (live) {
			g.drawImage(img, (int)x,(int)y,null);
			
			if(left) {
				if(x > 0)
				{
					x -= speed;
				}
			}
			if(right)
			{
				if(x <= Constant.window_Width - width)
				{					
					x += speed;
				}
			}
			if(up) {
				if(y > height)
				{
					y -= speed;
				}
					
			}
			if(down)
			{
				if(y < Constant.window_Height - height)
				{
					y += speed;
				}
					
			}
		}else {
//			Color color = g.getColor();
//			g.setColor(Color.RED);
//			Font font = g.getFont();
//			g.setFont(new Font("黑体", 200, 36));
//			g.drawString("飞机狗带", 200, 200);
//			g.setColor(color);
//			g.setFont(font);
		}

	}
	
	public Plane(Image img,double x,double y) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.height = img.getHeight(null);
		this.width = img.getWidth(null);
		this.speed = 10;
		
	}
	
	/*
	 * 方向处理
	 */
	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		default:
			break;
		}
	}
	
	public void minusDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		default:
			break;
		}
	}
}
