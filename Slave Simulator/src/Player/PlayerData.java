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
		
		player.Xvelo = 0;
		player.Yvelo = 0;
		
		
		if(mRight == true) {
			//testa = "CHANGED";
			
			player.Xvelo = player.Xvelo + -5;
		}
		
		if(mLeft == true) {
			//testa = "CHANGED";
			
			player.Xvelo = player.Xvelo + 5;
		}
		
		if(mDown == true) {
			//testa = "CHANGED";
			
			player.Yvelo = player.Yvelo + 5;
		}
		
		if(mUp == true) {
			//testa = "CHANGED";
			
			player.Yvelo = player.Yvelo + -5;
		}
		
		if((mUp && mLeft) || (mUp && mRight) ||(mDown && mLeft) || (mDown && mRight)) {
			
			//has to be normalized but too lazy rn
			
			double xx = (player.Xvelo / 5);
			double yy  = (player.Yvelo / 5);
			
			player.Xvelo = (int) (player.Xvelo / 2 + xx*2);
			player.Yvelo = (int) (player.Yvelo / 2 + yy*2);
			
			
			
		}
		
	
	}
	
	

	
	//moves player on velocity
	public void movePlayer() {
		
		player.XPos = player.XPos + player.Xvelo;
		player.YPos = player.YPos + player.Yvelo;
		//animation for moving only
		animate();
	}
	
	
	public void animate() {
		
		//kinda bug if changes velo anim doesnt go neutral, but anim override so not bug, i think
		
		if(player.Xvelo > 0 && player.Yvelo == 0){
			
		}else if(player.Xvelo < 0  && player.Yvelo == 0){
			
		}
		
		if(player.Yvelo > 0  && player.Xvelo == 0){
			
		}else if(player.Yvelo < 0  && player.Xvelo == 0){
			player.animP.animUp();
		}
		
		if(player.Yvelo < 0 && player.Xvelo > 0){
			//up right
			
		}else if(player.Yvelo < 0 && player.Xvelo < 0){
			//up left
		}
		
		if(player.Yvelo > 0 && player.Xvelo > 0){
			//down right
			
		}else if(player.Yvelo > 0 && player.Xvelo < 0){
			//down left
		}
		
		if(player.Yvelo == 0 && player.Xvelo == 0) {
			player.animP.animIdle();
			//neutral
		}
		
		player.animP.animTickUp();
		
		
	}
	
	
	
	public void CheckNdoUpdate() {
		
		movePlayer();
		animate();
		
		
	//	System.out.println(testa);
		
		
		
	}
	
	
	
}
