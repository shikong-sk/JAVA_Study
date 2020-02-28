package cn.skcks.game3;

import java.awt.Graphics;
import java.awt.Image;

import cn.skcks.game.GameUtil;

/*
 * 爆炸类
 */
public class Explode {
	double x, y;

	static Image imgs[] = new Image[16];

	static {
		for (int i = 0; i < imgs.length; i++) {
			imgs[i] = GameUtil.getImage("images/explode/e" + (i + 1) + ".gif");
			imgs[i].getWidth(null);
		}
	}

	int frame;

	public void draw(Graphics g) {
		if (frame < imgs.length * 10) {
			g.drawImage(imgs[frame/10], (int) x, (int) y, null);
			System.out.println(frame);
			frame++;
		}
	}

	public Explode(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

}
