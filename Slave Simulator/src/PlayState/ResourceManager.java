package PlayState;

import java.util.ArrayList;

import Resources.Resource;

public class ResourceManager {
	
	
	ArrayList<ResourceMap> ResourceMap;
	
	ResourceMap curr;

	public ResourceManager() {
		
		ResourceMap = new ArrayList<ResourceMap>();
		ResourceMap.add(new ResourceMap("/TestResourceMap1.png"));
		curr = ResourceMap.get(0);
	}
	
	
	
}
