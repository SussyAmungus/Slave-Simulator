package PlayState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Maps.Tile;
import Player.PlayerData;


//Not a tanglibe object, but a translation method for antything rendering except player,  
public class Camera {
	
	MapManager MapManager;
	PlayerData PlayerData;
	
	
	
	public Camera(MapManager mm, PlayerData pd) {
		
		MapManager = mm;
		PlayerData = pd;
		
		
		
	}
	
	//pls fix put way to see how map bounds are
	public void checkIfEdge() {
		
		if(PlayerData.player.XPos <= 500 - PlayerData.player.XSize/2 || PlayerData.player.XPos >= 1500 - PlayerData.player.XSize/2 ) {
			PlayerData.onEdgeX = true;
			
		}else {
			
			PlayerData.onEdgeX = false;
			
		}
		
		if(PlayerData.player.YPos <= 500 - PlayerData.player.XSize/2  || PlayerData.player.YPos >= 1500 - PlayerData.player.XSize/2 ) {
			PlayerData.onEdgeY = true;
			
		}else {
			
			PlayerData.onEdgeY = false;
			
		}
		
		
	}
	
	
	
	//player allready renders if on edgde or nah
	public void renderAll(Graphics g) {
		
		if(PlayerData.onEdgeX || PlayerData.onEdgeY) {
			
			
			
			renderEdge(g);
			
		}else {//Other condition camera on person
			
			
			 renderCenter(g);
			
		}
		
		
	}
	
	
	public void renderEdge(Graphics g) {
		
		for(int i = 0; i < MapManager.curr.mTiles.length; i++) {
			
			for(int j = 0; j < MapManager.curr.mTiles[i].length; j++) {
				
				
				int spaceX = 550;
				int spaceY = 550;
				
					
				if(PlayerData.onEdgeX == true) {
					
					spaceX = Math.abs(1000 - PlayerData.player.XPos);
				}
				if(PlayerData.onEdgeY == true) {
					
					spaceY = Math.abs(1000 - PlayerData.player.YPos);
				}
					
							
							
							
				
				
				if( MapManager.curr.mTiles[j][i].posx <= PlayerData.player.XPos + spaceX && MapManager.curr.mTiles[j][i].posx >= PlayerData.player.XPos - spaceX &&
						MapManager.curr.mTiles[j][i].posy <= PlayerData.player.YPos + spaceY && MapManager.curr.mTiles[j][i].posy >= PlayerData.player.YPos - spaceY	) {
					
					
					
					int X = MapManager.curr.mTiles[j][i].posx;
					int Y = MapManager.curr.mTiles[j][i].posy;
					
				
					
					if(PlayerData.onEdgeX == false) {
						
						X = MapManager.curr.mTiles[j][i].posx - PlayerData.player.XPos + 500;
						
					}else if(PlayerData.onEdgeX == true && MapManager.curr.mTiles[j][i].posx >= 1000){
						
						
						X = MapManager.curr.mTiles[j][i].posx - 1000;
					}
					
					
					
					if(PlayerData.onEdgeY == false) {
						
						Y = MapManager.curr.mTiles[j][i].posy - PlayerData.player.YPos + 500;
						
					}else if(PlayerData.onEdgeY == true && MapManager.curr.mTiles[j][i].posy >= 1000){
						
						
						Y = MapManager.curr.mTiles[j][i].posy - 1000;
					}
					
					
					
					
					
					MapManager.curr.mTiles[j][i].screenRender(g,X,Y);
				//	 printdebug(g, MapManager.curr.mTiles[j][i] ,X, Y);
				}
			}
			
		}
		
	}
	
	
	public void renderCenter(Graphics g) {
		int amount = 0;
		
		for(int i = 0; i < MapManager.curr.mTiles.length; i++) {
			
			for(int j = 0; j < MapManager.curr.mTiles[i].length; j++) {
				
				if( MapManager.curr.mTiles[j][i].posx <= PlayerData.player.XPos + 550 &&MapManager.curr.mTiles[j][i].posx > PlayerData.player.XPos - 550 &&
						MapManager.curr.mTiles[j][i].posy < PlayerData.player.YPos + 550 && MapManager.curr.mTiles[j][i].posy > PlayerData.player.YPos - 550	) {
					
					int screenX = MapManager.curr.mTiles[j][i].posx - PlayerData.player.XPos + 500;
					int screenY = MapManager.curr.mTiles[j][i].posy - PlayerData.player.YPos + 500;
					
					 MapManager.curr.mTiles[j][i].screenRender(g, screenX, screenY);
					 amount++;
				//	 printdebug(g, MapManager.curr.mTiles[j][i] ,screenX, screenY);
				}
				
				
			}
			
		
		}
		
	//	System.out.println(amount);	
	}
	
	public void printdebug(Graphics g, Tile tt, int x, int y) {
		
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("serif", Font.ITALIC, 10));
		g.drawString("" + tt.posx, x, y+10);
		g.drawString("" + tt.posy, x, y+20);
	}
	
	

}
