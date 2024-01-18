package PlayState;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Structures.House1;
import Super.Structure;

public class ObjectMap {
	
	
	ArrayList<Structure> ObjList;
	
	BufferedImage ObjMapData;
	
	public ObjectMap(String source) {
		
		ObjList = new ArrayList<Structure>();
		
		try {
			ObjMapData = ImageIO.read(getClass().getResourceAsStream(source));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadMap();
		
		
	}
	
	
	//16777215 Transparency
	//-16777216 Solid black aka house
	
	
	
	private void loadMap() {
		// TODO Auto-generated method stub
		
		
		int currPosY =0;
		
		for(int i = 0; i < ObjMapData.getWidth(); i++) {
			
			int currPosX = 0;
			
			for(int j = 0; j < ObjMapData.getHeight(); j++) {
				
				
				
				
				if(ObjMapData.getRGB(j, i) == -16777216) {
					
					ObjList.add(new House1(currPosX, currPosY, 250, 550));
					
				}
				
				currPosX = currPosX + 50;
			}
	
			currPosY = currPosY + 50;
			
		}	
		
	}
}
