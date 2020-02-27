package cn.skcks.game2;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameUtil {
	private GameUtil() {
		
	}
	
	public static Image getImage(String path) {
		BufferedImage img = null;
		
		try {
			URL url = GameUtil.class.getClassLoader().getResource(path);
			img = ImageIO.read(url);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return img;
	}
}
