package Maps;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum SpriteStuctureEnum {

		
		house1("/HouseTest.png");
	
	
	
	
	public BufferedImage picture;
	

		SpriteStuctureEnum(String source) {
			try {
				this.picture = ImageIO.read(getClass().getResourceAsStream(source));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

}
