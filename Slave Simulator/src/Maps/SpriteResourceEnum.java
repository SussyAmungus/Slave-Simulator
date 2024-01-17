package Maps;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum SpriteResourceEnum {

	tree1("/TestTree.png"),
	tree2("/Trees.png");
	
	
	
	
	public BufferedImage picture;
	

	SpriteResourceEnum(String source) {
			try {
				this.picture = ImageIO.read(getClass().getResourceAsStream(source));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
}
