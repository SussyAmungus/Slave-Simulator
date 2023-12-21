package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Inputs.KeyActions;
import Inputs.MouseActions;

public class GamePanel extends JPanel {

	public Game game;
	
	public KeyActions KA;
	public MouseActions MA;
	
	
	public GamePanel(Game game) {
		
		KA = new KeyActions(this);
		MA = new MouseActions(this);
		
		
		
		this.game = game;
		this.setVisible(true);
		super.setPreferredSize(new Dimension(1000,1000));
		
		this.addKeyListener(KA);
		this.addMouseListener(MA);
		this.addMouseMotionListener(MA);
		
	
	}
	@Override
	public void paintComponent(Graphics g) {
		
		
		//same as resetting image
			super.paintComponent(g);
		
			game.render(g);
			
			
	
	}
	
	
	public Game getGame() {
		return game;
	}
	
	
	

}
