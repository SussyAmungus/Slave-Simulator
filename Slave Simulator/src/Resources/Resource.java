package Resources;

import java.awt.Graphics;

import Super.Obj;

public class Resource extends Obj{
	
	public int Hitpoints;
	

	public Resource(int px, int py, int sizex, int sizey) {
		super(px, py, sizex, sizey);
		
		
	}
	
	
	
	public boolean isDestroyed() {
		
		if(Hitpoints <= 0) return true;
		
		return false;
		
	}
	
	
	
	public void screenRender(Graphics g, int screenX, int screenY) {
		
		g.drawImage(spirte, screenX, screenY, null);
		System.out.println("DASDASd");
	}
	
}
