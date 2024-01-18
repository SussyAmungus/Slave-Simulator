package Super;

import java.awt.Graphics;

public abstract class Crop extends Obj{
	
	public int growth = 0;
	
	
	public Crop(int px, int py, int sizex, int sizey) {
		super(px, py, sizex, sizey);
		
		
	}
	
	
public void screenRender(Graphics g, int screenX, int screenY) {
		
		g.drawImage(spirte, screenX, screenY, null);
		System.out.println("DASDASd");
	}







}
