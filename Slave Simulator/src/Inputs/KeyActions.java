package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;

public class KeyActions implements KeyListener{

	private GamePanel gp;
	
	
	
	public KeyActions(GamePanel gp) {
		
		this.gp = gp;
	
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		gp.getGame().KeyActionsPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		gp.getGame().KeyActionsReleased(e);
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
