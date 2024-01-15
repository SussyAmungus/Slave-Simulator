package Structures;

import Maps.SpriteStuctureEnum;
import Maps.SpriteTileEnum;
import Super.Structure;

public class House1 extends Structure{
	
	//LATER put doors and other componets within the house.
	
	//prob put implentation//interface for the logic and activation part for all child classes with Structure
	
	public House1(int px, int py, int sizex, int sizey) {
		
		super(px, py, sizex, sizey);
		spirte = SpriteStuctureEnum.house1.picture;
		
	}

}
