package Resources;

import Maps.SpriteResourceEnum;

public class Tree extends Resource{
	
	public int HitPoints = 100;
	
	

	public Tree(int px, int py, int sizex, int sizey) {
		super(px, py, sizex, sizey);
		// TODO Auto-generated constructor stub
		
		if(Math.random() > 0.5) {
			
			spirte = SpriteResourceEnum.tree1.picture;
		}else {
			
			spirte = SpriteResourceEnum.tree2.picture;
		}
		
		
	}
	
public void interact(int damage) {
		
		Hitpoints = Hitpoints - damage;
		
		if(Hitpoints <= 0) {
			
			
			
		}
	}
	

public void collectResources() {
	
	System.out.println("TIMBER");
	
}

	
	


}
