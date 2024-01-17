package PlayState;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Resources.Resource;
import Resources.Tree;
import Structures.House1;
import Super.Structure;

public class ResourceMap {
	
	
	ArrayList<Resource> ReList;
	
	BufferedImage ReMapData;
	
	public ResourceMap(String source) {
		
		ReList = new ArrayList<Resource>();
		
		try {
			ReMapData = ImageIO.read(getClass().getResourceAsStream(source));
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
		
		for(int i = 0; i < ReMapData.getWidth(); i++) {
			
			int currPosX = 0;
			
			for(int j = 0; j < ReMapData.getHeight(); j++) {
				
				
				//System.out.println(ReMapData.getRGB(j, i));
				
				//trees
				if(ReMapData.getRGB(j, i) == -15532288) {
					
					//Tree temp = new Tree(currPosX, currPosY, 250, 550);
					//Resource tt = (Resource) temp;
					
					
					ReList.add(new Tree(currPosX, currPosY, 250, 550));
					System.out.println("printed");
					
				}
				
				currPosX = currPosX + 50;
			}
	
			currPosY = currPosY + 50;
			
		}	
		
	}
}
