package PlayState;

import java.util.ArrayList;

import Crops.Cotton;
import Super.Crop;

public class CropManager {
	
	
	ArrayList<Crop> CropList;
	

	public CropManager() {
		
		CropList = new ArrayList<Crop>();
		CropList.add(new Cotton(500, 500,50,50));
		
	}
	
	
	
	
	
	
	
}
