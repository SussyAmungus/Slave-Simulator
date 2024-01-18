package Crops;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum SpriteCropEnum {
	
	Cotton3("/Cotton.png");

	public BufferedImage picture;
	
	
	SpriteCropEnum(String source) {
		try {
			this.picture = ImageIO.read(getClass().getResourceAsStream(source));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
