package Super;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Maps.SpriteTileEnum;

public abstract class Structure {
	
	
	public int posx;
	public int posy;
	
	
	public int sizex; 
	public int sizey;
	
	public BufferedImage spirte;
	
	public Structure(int px, int py, int sizex, int sizey) {
		
		posx = px;
		posy = py;
		
		this.sizex = sizex;
		this.sizey = sizey;
		
		spirte = SpriteTileEnum.deflutT.picture;
		
	}


	public void screenRender(Graphics g, int screenX, int screenY) {
		g.drawImage(spirte, screenX, screenY, null);
		
	}
	

	public void render(Graphics g) {
		
		g.drawImage(spirte, posx, posy, null);
		
	}

}
