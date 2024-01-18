package Crops;

import Maps.SpriteResourceEnum;
import Super.Crop;

public class Cotton extends Crop{
	
	

	public Cotton(int px, int py, int sizex, int sizey) {
		super(px, py, sizex, sizey);
		spirte = SpriteCropEnum.Cotton3.picture;
	}
	
	
	public void Update() {
		
		if(growth < 5) {
			growth++;
		}

		
	}
	

}
