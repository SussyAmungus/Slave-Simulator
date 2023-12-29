package Maps;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile {
	
	public int posx;
	public int posy;
	
	public int sizeX = 20;
	public int sizeY = 20;
	
	public BufferedImage spirte;
	
	

	public Tile(int x, int y) {
		
		posx = x;
		posy = y;
		
	
		spirte = SpriteTileEnum.deflutT.picture;

		
	}
	
	
	
	public void render(Graphics g) {
		
		g.drawImage(spirte, posx, posy, null);
		
	}
	
	public void screenRender(Graphics g, int x, int y) {
		
		g.drawImage(spirte, x, y, null);
		
	}
	
	
	
	
	
}
