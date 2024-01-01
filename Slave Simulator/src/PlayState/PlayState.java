package PlayState;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import Player.Player;
import Player.PlayerData;

public class PlayState {
	
	
	PlayerData PlayerData;
	
	MapManager MapManager;
	
	Camera Camera;
	
	
	

	public PlayState(PlayerData PD) {
		
		PlayerData = PD;
		
		MapManager = new MapManager();
		
		Camera = new Camera(MapManager,PlayerData);
	
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
		
		PlayerData.selfRender(g);
		
		System.out.println(PlayerData.onEdgeY);
		
		
	}
	
	
	public void update() {
		
		//calculate all player stuff
		Camera.checkIfEdge();
		
	//	System.out.println(PlayerData.onEdgeY);
		PlayerData.CheckNdoUpdate();
		
		
		
	}
	
	
	
	
	
	
	
	
}
