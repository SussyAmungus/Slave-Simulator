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
	
	public int CamX = 0;
	public int CamY = 0;
	
	public int renderBoundsX = 550;
	public int renderBoundsY = 550;
	
	public int screenSizeX = 1000;
	public int screenSizeY = 1000;
	
	//this is the total size from middle to the ends of the screen size
	public int BufferX = 500;
	public int BufferY = 500;
	
	
	public Camera(MapManager mm, PlayerData pd) {
		
		MapManager = mm;
		PlayerData = pd;
		
		
		
	}
	
	//pls fix put way to see how map bounds are
	public void checkIfEdge() {
		
		if(PlayerData.player.XPos <= MapManager.curr.XEdgeMark - PlayerData.player.XSize/2 || PlayerData.player.XPos >= MapManager.curr.width - MapManager.curr.XEdgeMark  - PlayerData.player.XSize/2 ) {
			PlayerData.onEdgeX = true;
			
		}else {
			
			PlayerData.onEdgeX = false;
			
		}
		
		if(PlayerData.player.YPos <= MapManager.curr.YEdgeMark - PlayerData.player.YSize/2  || PlayerData.player.YPos >= MapManager.curr.height - MapManager.curr.YEdgeMark - PlayerData.player.YSize/2 ) {
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
	
	//basicaly is also equipped with the center render stuff too
	public void renderEdge(Graphics g) {
		
		for(int i = 0; i < MapManager.curr.mTiles.length; i++) {
			
			
			
			for(int j = 0; j < MapManager.curr.mTiles[i].length; j++) {
				
				//litteraly just render bounds
				int spaceX = renderBoundsX;
				int spaceY = renderBoundsY;
				
					
				if(PlayerData.onEdgeX == true) {
					
					spaceX = Math.abs(screenSizeX - PlayerData.player.XPos);
				}
				if(PlayerData.onEdgeY == true) {
					
					spaceY = Math.abs(screenSizeY - PlayerData.player.YPos);
				}
					
							
							
	
				
				if( MapManager.curr.mTiles[j][i].posx <= PlayerData.player.XPos + spaceX && MapManager.curr.mTiles[j][i].posx >= PlayerData.player.XPos - spaceX &&
						MapManager.curr.mTiles[j][i].posy <= PlayerData.player.YPos + spaceY && MapManager.curr.mTiles[j][i].posy >= PlayerData.player.YPos - spaceY	) {
					
					
					int screenX = MapManager.curr.mTiles[j][i].posx - PlayerData.player.XPos + BufferX;
					int screenY = MapManager.curr.mTiles[j][i].posy - PlayerData.player.YPos + BufferY;
					
					
					double ratioX = (double)MapManager.curr.mTiles[j][i].posx / (double)screenSizeX;
					double ratioY = (double)MapManager.curr.mTiles[j][i].posy / (double)screenSizeY;
					
					double scaleX = (double)screenSizeX / ratioX;
					double scaleY = (double)screenSizeY / ratioY;
					
					if(PlayerData.onEdgeX == true) {
						
						screenX = (int) (ratioX * scaleX);
					}
					
					if(PlayerData.onEdgeY == true) {
						
						screenY = (int) (ratioY * scaleY);
					}
					
					
					MapManager.curr.mTiles[j][i].screenRender(g,screenX,screenY);
					 printdebug(g, MapManager.curr.mTiles[j][i] ,screenX, screenY);
				}
			}
			
		}
		
	}
	
	
	
	
	
	
	public void renderCenter(Graphics g) {
		
		
		for(int i = 0; i < MapManager.curr.mTiles.length; i++) {
			
			for(int j = 0; j < MapManager.curr.mTiles[i].length; j++) {
				
				if( MapManager.curr.mTiles[j][i].posx <= PlayerData.player.XPos + renderBoundsX &&MapManager.curr.mTiles[j][i].posx > PlayerData.player.XPos - renderBoundsX &&
						MapManager.curr.mTiles[j][i].posy < PlayerData.player.YPos + renderBoundsY && MapManager.curr.mTiles[j][i].posy > PlayerData.player.YPos - renderBoundsY	) {
					
					int screenX = MapManager.curr.mTiles[j][i].posx - PlayerData.player.XPos + BufferX;
					int screenY = MapManager.curr.mTiles[j][i].posy - PlayerData.player.YPos + BufferY;
					
					 MapManager.curr.mTiles[j][i].screenRender(g, screenX, screenY);
						 printdebug(g, MapManager.curr.mTiles[j][i] ,screenX, screenY);
				}
				
				
			}
			
		
		}
		
	}
	
	public void printdebug(Graphics g, Tile tt, int x, int y) {
		
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("serif", Font.ITALIC, 10));
		g.drawString("" + tt.posx, x, y+10);
		g.drawString("" + tt.posy, x, y+20);
	}
	
	

}
