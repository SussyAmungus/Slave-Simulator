package PlayState;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Maps.Dirt;
import Super.Structure;

public class StructureManager {
	
	ArrayList<StructureMap> StMapList;
	
	public StructureMap curr;
	
	public StructureManager() {
		
		StMapList = new ArrayList<StructureMap>();
		
		StMapList.add(new StructureMap("/TestStructureMap1.png"));
		
		curr = StMapList.get(0);
	}

	
	
}
