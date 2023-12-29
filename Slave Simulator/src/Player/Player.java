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
		
		super(500,500,10,10,10);
		PlayerData = PD;
		
		animP = new AnimationPlayer("/PlayerSprite.png",62, 82,12,31);
		
		
		
	

	
	}
	
	public void playAnim(int num1, int num2) {
		
		
	}
	
	public void renderSelfEdge(Graphics g, boolean XEdge, boolean YEdge) {
		
		int tempX = 0;
		int tempY = 0;
		
		if(XEdge == true&& XPos < 1000){
			
			tempX = XPos;
		}else if(XEdge == true && XPos >= 100) {
		
			tempX = XPos - 1000;
			
		
		}else {
			
			tempX = 500 - XSize/2;
			
		}
		
		
		if(YEdge == true&& YPos < 1000){
			
			tempY = YPos;
		}else if(YEdge == true && YPos >= 1000) {
		
			tempY = YPos - 1000;
		
		}else {
			
			tempY = 500 - YSize/2;
			
		}
		
	
		g.drawImage(animP.getFrame(), tempX, tempY, null);
		
		
	
	}
	

	public void renderSelfM(Graphics g) {
		
	
		//get middle gor now rough middle
		g.drawImage(animP.getFrame(), 500 - XSize/2, 500 - XSize/2, null);
	
		
	}
	

}
