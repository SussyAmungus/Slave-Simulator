package Maps;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum SpriteTileEnum {
	
	dirt("/Dirt2.png"),
	water("/Water2.png"),
	deflutT("/TestSprite.png"),
	grass("/Grass.png");
	
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
