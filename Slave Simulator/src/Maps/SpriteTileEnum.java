package Maps;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum SpriteTileEnum {
	
	dirt("/Dirt1.png"),
	water("/Water1.png"),
	deflutT("/Defult_Sprite.png");
	
	BufferedImage picture;
	
	SpriteTileEnum(String source){
		
		try {
			this.picture = ImageIO.read(getClass().getResourceAsStream(source));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
