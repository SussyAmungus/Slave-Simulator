package PlayState;

import java.awt.Graphics;
import java.util.ArrayList;

public class MapManager {
	
	

	ArrayList<Map> MapList;
	
	
	public Map curr;
	
	public MapManager() {
		
	
	

		MapList = new ArrayList<Map>();
		
		MapList.add(new Map("/TestMap1.png"));
		System.out.println("ASDAS");
		
		curr = MapList.get(0);
		
		
	}
	
	
	
	//never gets called, all map renders are on camera
	public void renderMap(Graphics g) {
		
		for(int i = 0; i < curr.mTiles.length; i++) {
			
			for(int j = 0; j < curr.mTiles[i].length; j++) {
				
				
				curr.mTiles[i][j].render(g);
				
		}
	}
		
		
	}

	
	
	
	
	
}
