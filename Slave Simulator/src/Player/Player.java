package Player;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Helper.ImageResizer;
import Super.Entity;

public class Player extends Entity{
	
	//prob atlater date we have a sprite sheet
	PlayerData PlayerData;
	
	//add animations later bc no animatons
	BufferedImage[][] PlayerSprite;
	
	//whole image import
	InputStream is;

	private BufferedImage buff;
	
	
	
	///middle is neutral
	///back
	///front 
	///left

	public Player(PlayerData PD) {
		
		super(10,10,10,10,10);
		PlayerData = PD;
		
		PlayerSprite = new BufferedImage[3][3];

		is = getClass().getResourceAsStream("/PlayerSprite.png");
		
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
	
	}
	
	
	
	

	
	//For now not use bc no sprite sheet
	//but will work asap
	public void loadSprites() throws IOException {
		
		//width = 216
		//height = 311
		
		int width = 62;
		int height = 85;
		
		int spacerY = 0;
		for(int i = 0; i < 3; i++) {
			
			
			int spacerX = 0;
			for(int j = 0; j < 3; j++) {
				
				
				int currX = j * 62 + spacerX;
				int currY = i * 82 + spacerY;
	
				
				BufferedImage temp = buff.getSubimage(currX, currY, width, height);
				
				
				
				temp = ImageResizer.resize(temp, 50, 60);
				
				PlayerSprite[i][j] = temp;
				
				spacerX = spacerX + 12;
				
				
				//Used to debug the pictures and shit
				//JOptionPane.showMessageDialog(null, "","Debug preview",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(PlayerSprite[i][j]));
				
			}
			
			
			spacerY = spacerY + 31;
		}
		
		
	
	}
	
	public void renderSelf(Graphics g) {
		
		g.drawImage(PlayerSprite[0][1], XPos, YPos, null);
	
		
	}
	

}
