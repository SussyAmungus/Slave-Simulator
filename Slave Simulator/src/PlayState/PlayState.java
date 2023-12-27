package PlayState;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import Player.Player;
import Player.PlayerData;

public class PlayState {
	
	
	PlayerData PlayerData;
	
	MapManager MapManager;
	
	
	

	public PlayState(PlayerData PD) {
		
		PlayerData = PD;
		
		MapManager = new MapManager();
		
		
	
	}
	
	public void KeyActionPressed(KeyEvent e) {
		
		PlayerData.KeyActionPressed(e);
		
	}
	
	public void KeyActionReleased(KeyEvent e) {
		
		PlayerData.KeyActionReleased(e);
		
	}
	
	
	public void render(Graphics g) {
		
		
		MapManager.renderMap(g);
		PlayerData.selfRender(g);
		
		
	}
	
	
	public void update() {
		
		//calculate all player stuff
		PlayerData.CheckNdoUpdate();
		
		
		
	}
	
	
	
	
	
	
	
	
}
