package PlayState;

public class ObjectManager {
	
	//has multiple things that are objects
	//eg resources are objects, crops are objects, event triggers are objects, antything interactable by player or slaves
	
	ResourceManager RM;
	CropManager CM;
	
	
	public ObjectManager() {
		
		RM = new ResourceManager();
		CM = new CropManager();
		
	}
	
	
	public void update() {
		
		//do updating things here, not rendering
		
		
		
		
	}
	
	//public void render 
	

}
