package Player;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Helper.ImageResizer;


//sit name but for right now its the animation for PLAYER
public class AnimationPlayer {
	
	BufferedImage[][] PlayerSprite;
	
	BufferedImage curr = null;
	

	
	InputStream is;
	
	private BufferedImage buff;
	
	private int width;
	private int height;
	
	private int buffx;
	private int buffy;
	
	double animTick = 0;
	
	
	String currentAnim = "Idle";
	
	
	
	
	//change name later
	public AnimationPlayer(String source, int width, int height, int buffx, int buffy) {
		
		this.width = width;
		this.height = height;
		this.buffx = buffx;
		this.buffy = buffy;
		
		is = getClass().getResourceAsStream(source);
		PlayerSprite = new BufferedImage[3][3];
		
		try {
			buff = ImageIO.read(is);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			loadSprites();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//defult
		curr = PlayerSprite[0][1];
	}
	
	public void loadSprites() throws IOException {
		
		//width = 216
		//height = 311
		
	
		
		int spacerY = 0;
		for(int i = 0; i < 3; i++) {
			
			
			int spacerX = 0;
			for(int j = 0; j < 3; j++) {
				
				
				int currX = j * 62 + spacerX;
				int currY = i * 82 + spacerY;
	
				
				BufferedImage temp = buff.getSubimage(currX, currY, width, height);
				
				
				
				temp = ImageResizer.resize(temp, 50, 60);
				
				PlayerSprite[i][j] = temp;
				
				spacerX = spacerX + buffx;
				
				
				//Used to debug the pictures and shit
			//	JOptionPane.showMessageDialog(null, "","Debug preview",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(PlayerSprite[i][j]));
				
			}
			
			
			spacerY = spacerY + buffy;
		}
		
		
	
	}

	//all animation stuff
	
	
	public BufferedImage getFrame() {
		return curr;
		
		
		
	}
	
	//eventualy a single array of individual animation
	
	public void animTickUp() {
		
		animTick++;
		
	}
	
	public void animTickRest() {
		
		animTick = 0;
	}

	public void checkAnimPlay(String testAnim) {
		
		
		//ACTIONS that can have compouding with movement or other logic will ahve it where animtick doesnt reset IF its in the subgroup, playerdata iwll controll what aimation player show have
		
		if(currentAnim.equals(testAnim)) {
			
			//do nothing
		}else {
			
			currentAnim = testAnim;
			animTickRest();
			
		}
		
	}
	
	
	
	public void animUp() {
		
		checkAnimPlay("Up");
		
		//every one second is 120 ups
		double timeEveryFrame = 0.5; //measred in seconds
		
		double timeBetween = 120 * timeEveryFrame;
		
		//three in
		if(animTick <= timeBetween) {
			curr = PlayerSprite[1][0];
		}else if(animTick <= timeBetween * 2) {
			curr = PlayerSprite[1][1];
		}else if(animTick <= timeBetween * 3) {
			curr = PlayerSprite[1][2];
			
		}else {
			
			animTick = 0;
			
		}
		
		
	}
	
	public void animIdle() {
		
		checkAnimPlay("Idle");
		
		//every one second is 120 ups
		double timeEveryFrame = 0.5; //measred in seconds
		
		double timeBetween = 120 * timeEveryFrame;
		
		//three in
		if(animTick <= timeBetween) {
			curr = PlayerSprite[0][1];
		}else {
			
			animTick = 0;
			
		}
		
		
	}
	
	
}
