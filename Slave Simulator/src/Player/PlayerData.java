package Player;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class PlayerData {
	
	public volatile Player player;
	
	public boolean mRight = false;
	public boolean mLeft = false;
	public boolean mUp = false;
	public boolean mDown = false;
	
	

	public PlayerData() {
		
		player = new Player(this);
	
	}
	//fix later
	public void selfRender(Graphics g) {
		
		player.renderSelf(g);
		
	}
	
	
	public Player getPlayer() {
		
		return player;
	}
	
	
	
	int KeyA = KeyEvent.VK_A;
	int KeyD = KeyEvent.VK_D;
	int KeyW = KeyEvent.VK_W;
	int KeyS = KeyEvent.VK_S;
	
	
	
	
	
	
	public void KeyActionPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyA) {
			
			mRight = true;
			
		}
		if(e.getKeyCode() == KeyD) {
			
			mLeft = true;
		}
		if(e.getKeyCode() == KeyW) {
			
			mUp = true;
		}
		if(e.getKeyCode() == KeyS) {
			
			mDown = true;
		}
		
		
		UpdateVelocity();
	}
	
	public void KeyActionReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyA) {
			
			mRight = false;
			
		}
		if(e.getKeyCode() == KeyD) {
			
			mLeft = false;
		}
		if(e.getKeyCode() == KeyW) {
			
			mUp = false;
		}
		if(e.getKeyCode() == KeyS) {
			
			mDown = false;
		}
		
		UpdateVelocity();
	}
	
	
	public void UpdateVelocity() {
		
		
		if(mRight == true) {
			//testa = "CHANGED";
			
			player.Xvelo = -5;
		}else if(mRight == false && mLeft == false) {
			player.Xvelo = 0;
			
		}
		if(mLeft == true) {
			
			player.Xvelo = 5;
		}else if(mRight == false && mLeft == false) {
			player.Xvelo = 0;
			
		}
		if(mUp == true) {
			
			player.Yvelo = -5;
		}else if(mUp == false && mDown == false) {
			player.Yvelo = 0;
			
		}
		if(mDown == true) {
			
			player.Yvelo = 5;
		}else if(mUp == false && mDown == false) {
			player.Yvelo = 0;
			
		}
		
		
	
	}
	

	
	//moves player on velocity
	public void movePlayer() {
		
		
		
		player.XPos = player.XPos + player.Xvelo;
		player.YPos = player.YPos + player.Yvelo;

	}
	
	
	
	
	public void CheckNdoUpdate() {
		
		movePlayer();
		
	//	System.out.println(testa);
		
		
		
	}
	
	
	
}
