package Super;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Maps.SpriteTileEnum;

public class Obj {
	
	public int posx;
	public int posy;
	
	
	public int sizex; 
	public int sizey;
	
	public BufferedImage spirte;
	
	
	public Obj(int px, int py, int sizex, int sizey) {
		
		posx = px;
		posy = py;
		
		this.sizex = sizex;
		this.sizey = sizey;
		
		spirte = SpriteTileEnum.deflutT.picture;
		
	}
	
	public void screenRender(Graphics g, int screenX, int screenY) {
		g.drawImage(spirte, screenX, screenY, null);
		System.out.println("DASDASd");
		
	}
	

	
	
	
	
}
