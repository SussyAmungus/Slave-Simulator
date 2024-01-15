package PlayState;

import java.awt.Graphics;
import java.util.ArrayList;

public class MapManager {
	
	

	ArrayList<Map> MapList;
	
	
	public Map curr;
	
	public MapManager() {
		
	
	

		MapList = new ArrayList<Map>();
		
		MapList.add(new Map("/TestMap1.png"));
		
		
		curr = MapList.get(0);
		
		
	}
	
	
	
	
		
		
}

	
	
	
	
	

