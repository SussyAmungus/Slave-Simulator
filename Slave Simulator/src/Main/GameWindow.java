package Main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame{

	public GameWindow(JPanel GamePanel) {
		

		
		this.setPreferredSize(new Dimension(1000,1000));;
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(GamePanel);
		
		this.pack();
		
	}
	
	
	
}
