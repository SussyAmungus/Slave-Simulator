package PlayState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Maps.Tile;
import Player.PlayerData;


//Not a tanglibe object, but a translation method for antything rendering except player,  
public class Camera {
	
	MapManager MapManager;
	StructureManager StructureManager;
	PlayerData PlayerData;
	ObjectManager ObjectManager;
	
	//top right corner 
	public int CamX = 0;
	public int CamY = 0;
	
	public int focalX = 0;
	public int focalY = 0;
	
	public int focusMode = 1;
	
	
	public int renderBoundsX = 550;
	public int renderBoundsY = 550;
	
	public int screenSizeX = 1000;
	public int screenSizeY = 1000;
	
	//this is the total size from middle to the ends of the screen size
	public int BufferX = 500;
	public int BufferY = 500;
	
	
	public Camera(MapManager mm, PlayerData pd, StructureManager sm, ObjectManager om) {
		
		MapManager = mm;
		PlayerData = pd;
		StructureManager = sm;
		ObjectManager = om;
		
	}
	
	//pls fix put way to see how map bounds are
	public void checkIfEdge() {
		
		
		if(focusMode == 1) {
		
		if(PlayerData.player.getMidXPos() <= MapManager.curr.XEdgeMark || PlayerData.player.XPos>=  MapManager.curr.width - MapManager.curr.XEdgeMark) {
			PlayerData.onEdgeX = true;
			
			
		}else {
			focalX = PlayerData.player.XPos;
			
			PlayerData.onEdgeX = false;
			CamX = focalX - BufferX;
			
		}
		
		if(PlayerData.player.getMidYPos() <= MapManager.curr.YEdgeMark || PlayerData.player.getMidYPos() - 49 >= MapManager.curr.height - MapManager.curr.YEdgeMark) {
			PlayerData.onEdgeY = true;
			
		}else {
			
			PlayerData.onEdgeY = false;
			focalY = PlayerData.player.YPos;
			CamY = focalY - BufferY;
		}
		}
		
	}
	
	
	
	//player allready renders if on edgde or nah
	public void renderAll(Graphics g) {
		
		if(focusMode == 1) {
			
			renderPlayerFocus(g);
			
		}
		
		
	}
	
	public void renderPlayerFocus(Graphics g) {
		//System.out.println(CamX);
	for(int i = 0; i < MapManager.curr.mTiles.length; i++) {
		
		for(int j = 0; j < MapManager.curr.mTiles[i].length; j++) {
			//the minus 50 is a little but of buffer to render stuff allite out no now
			if(MapManager.curr.mTiles[j][i].posx >= CamX - 50 && MapManager.curr.mTiles[j][i].posx <= CamX +  screenSizeX&& 
					MapManager.curr.mTiles[j][i].posy >= CamY - 50 && MapManager.curr.mTiles[j][i].posy <= CamY +  screenSizeY){
				
				int Xrelative = MapManager.curr.mTiles[j][i].posx - CamX;
				int Yrelative = MapManager.curr.mTiles[j][i].posy - CamY;
				
				double screenXratio = ((double)Xrelative) / ((double)screenSizeX);
				double screenYratio = ((double)Yrelative) / ((double)screenSizeY);
				
				int screenX = (int) (screenXratio * screenSizeX);
				int screenY = (int) (screenYratio * screenSizeY);
				
				
				 MapManager.curr.mTiles[j][i].screenRender(g, screenX, screenY);
			//	printdebug(g, MapManager.curr.mTiles[j][i] ,screenX, screenY);
				
			}
		}
		}
	
	for(int i = 0; i < StructureManager.curr.StList.size(); i++){
		

		int Xrelative = StructureManager.curr.StList.get(i).posx - CamX;
		int Yrelative = StructureManager.curr.StList.get(i).posy - CamY;
		
		double screenXratio = ((double)Xrelative) / ((double)screenSizeX);
		double screenYratio = ((double)Yrelative) / ((double)screenSizeY);
		
		int screenX = (int) (screenXratio * screenSizeX);
		int screenY = (int) (screenYratio * screenSizeY);
		
		
		StructureManager.curr.StList.get(i).screenRender(g, screenX, screenY);
		
		
	}
	
	
	for(int i = 0 ; i < ObjectManager.RM.curr.ReList.size(); i++) {
		
		
		
		
		int Xrelative = ObjectManager.RM.curr.ReList.get(i).posx - CamX;
		int Yrelative = ObjectManager.RM.curr.ReList.get(i).posy - CamY;
		
		double screenXratio = ((double)Xrelative) / ((double)screenSizeX);
		double screenYratio = ((double)Yrelative) / ((double)screenSizeY);
		
		int screenX = (int) (screenXratio * screenSizeX);
		int screenY = (int) (screenYratio * screenSizeY);
		
		
		ObjectManager.RM.curr.ReList.get(i).screenRender(g, screenX, screenY);
		
	}
	
	
	
	
	

	}
	
	
	public void printdebug(Graphics g, Tile tt, int x, int y) {
		
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("serif", Font.ITALIC, 10));
		g.drawString("" + tt.posx, x, y+10);
		g.drawString("" + tt.posy, x, y+20);
	}
	
	

}
