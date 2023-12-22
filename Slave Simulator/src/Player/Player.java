package Player;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Helper.ImageResizer;
import Super.Entity;

public class Player extends Entity{
	
	//prob atlater date we have a sprite sheet
	PlayerData PlayerData;
	
	
	
	
	
	
	AnimationPlayer animP;
	
	///middle is neutral
	///back
	///front 
	///left

	public Player(PlayerData PD) {
		
		super(10,10,10,10,10);
		PlayerData = PD;
		
		animP = new AnimationPlayer("/PlayerSprite.png",62, 82,12,31);
		
		
		
	

	
	}
	
	public void playAnim(int num1, int num2) {
		
		
	}
	
	
	public void renderSelf(Graphics g) {
		
		
		
		g.drawImage(animP.getFrame(), XPos, YPos, null);
	
		
	}
	

}
