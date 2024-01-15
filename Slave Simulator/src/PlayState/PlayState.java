package PlayState;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import Player.Player;
import Player.PlayerData;

public class PlayState {
	
	
	PlayerData PlayerData;
	
	MapManager MapManager;
	
	StructureManager StructureManager;
	
	Camera Camera;
	
	
	

	public PlayState(PlayerData PD) {
		
		PlayerData = PD;
		
		MapManager = new MapManager();
		
		StructureManager = new StructureManager();
		
		Camera = new Camera(MapManager,PlayerData,StructureManager);
	
	}
	
	public void KeyActionPressed(KeyEvent e) {
		
		PlayerData.KeyActionPressed(e);
		
	}
	
	public void KeyActionReleased(KeyEvent e) {
		
		PlayerData.KeyActionReleased(e);
		
	}
	
	
	public void render(Graphics g) {
		
		//Map n stuff
		
		Camera.renderAll(g);
		
		PlayerData.selfRender(g,Camera);
		
	

		
		
	}
	
	
	public void update() {
		
	
		Camera.checkIfEdge();
		

		PlayerData.CheckNdoUpdate();
		
		
		
	}
	
	
	
	
	
	
	
	
}
