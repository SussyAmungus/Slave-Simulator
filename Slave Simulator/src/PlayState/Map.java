package PlayState;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Maps.Dirt;
import Maps.Grass;
import Maps.Tile;
import Maps.Water;

public class Map {
	
	public int width;
	public int height;
	
	private int TileSizeX = 50;
	private int TileSizeY = 50;
	
	//cahnge later
	public int XEdgeMark = 500;
	public int YEdgeMark = 500;
	
	public Tile[][] mTiles;
	
	
	
	BufferedImage mapPng;
	
	
	public Map(String source) {
		
		try {
			mapPng = ImageIO.read(getClass().getResourceAsStream(source));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		mTiles = new Tile[mapPng.getWidth()][mapPng.getHeight()];
		width = mapPng.getWidth() * TileSizeX;
		height = mapPng.getHeight() * TileSizeY;
		
	
		
		loadMap();
		
	}
	

	
	
	//BTW goes y, x
	
	//-14451456 green tree
	// -10214656 dirt
	// -16776961 water
	// -16711936 grass
	
	
	public void loadMap() {
		int currPosY = 0;
		
		
		
		
		for(int i = 0; i < mTiles.length; i++) {
			
		
			int currPosX = 0;
			for(int j = 0; j< mTiles[i].length; j++) {
				
				
				
				
				
				
				
				if(mapPng.getRGB(j, i) == -10214656) {
					
					mTiles[j][i] = new Dirt(currPosX,currPosY);
					
				}
				if(mapPng.getRGB(j, i) == -16776961) {
					
					mTiles[j][i] = new Water(currPosX,currPosY);
					
				}
				if(mapPng.getRGB(j, i) == -16711936) {
					
					mTiles[j][i] = new Grass(currPosX,currPosY);
					
				}
				
				
				
				
				 currPosX =  currPosX + TileSizeX;
				
				
			
				 
			}
	
			currPosY = currPosY +TileSizeY;
		}
		
		
		
		
	}
	

	
	
	
	


}
