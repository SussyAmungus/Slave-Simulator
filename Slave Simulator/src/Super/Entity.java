package Super;

public class Entity {

	public Hitbox HB;
	
	//X and Y
	public   int XPos;
	public  int YPos;
	
	public  int XSize;
	public  int YSize;
	
	public  int MXPos;
	public  int MYPos;
	
	public double speed;
	
	
	public int Xvelo;
	public  int Yvelo;
	
	public Entity(int XP, int YP, int XS, int YS, double speed) {
		
		HB = new Hitbox(this);
		
		XPos = XP;
		YPos = YP;
		
		XSize = XS;
		YSize = YS;
		
		MXPos = XPos + (XSize /2);
		MYPos = YPos + (YSize /2);
		
		this.speed = speed;
		
		
		Xvelo = 0;
		Yvelo = 0;
		
	
		
	}
	
	
	public int getMidXPos() {
		
		
		return XPos + (XSize /2);
	}
	public int getMidYPos() {
		
		
		return YPos + (YSize /2);
	}
	
	
	public void collision() {
		
		
	}
	
	
	
	
	
}
