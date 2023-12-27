package Maps;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Water extends Tile{

public String source = "/Water1.png";
	
	public Water(int x, int y) {
		
		super(x, y);
		
		spirte = SpriteTileEnum.dirt.picture;
		
		
	}
	
	
}
