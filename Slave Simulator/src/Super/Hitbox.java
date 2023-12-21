package Super;

public class Hitbox {
	
	public int XSize;
	public int YSize;
	
	
	//X and Y
	public int XPos;
	public int YPos;
	
	public int MXPos;
	public int MYPos;

	public Hitbox(Entity e) {
		
		XPos = e.XPos;
		YPos = e.YPos;
		
		XSize = e.XSize;
		YSize = e.YSize;
		
	}
	
	
	
	
	
}
