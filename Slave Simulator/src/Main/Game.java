package Main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import PlayState.PlayState;

import Player.PlayerData;

public class Game implements Runnable{

	public final double FPS_SET = 120;
	public final double UPS_SET = 120;
	
	public GamePanel Gpanel;
	public GameWindow Gwindow;
	
	public PlayerData PlayerData;
	public EventManager EventManger;
	
	public boolean paused = false;
	
	
	public GameTimer GameTimer;
	
	
	
	//MANY STATES DEFINED BY STRING
	
	public String State = "Playing";
	
	public PlayState PlayState;
	
	
	
	public Game() {
		
		Gpanel = new GamePanel(this);
		Gwindow = new GameWindow(Gpanel);
		Gpanel.requestFocus();
		
		
	
		
	
		
		
		
		PlayerData = new PlayerData();
		
		
		PlayState = new PlayState(PlayerData);
		
		
		GameTimer = new GameTimer();
		
		EventManger = new EventManager(GameTimer);
		
		//end of all thread1
		
		run();
		
		

		
		
		
	}
	
	
	@Override
	public void run() {
		
		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;
		
		//kinda doesnt matter but post initailization for the first frame
		long lastFrame = System.nanoTime();
		long now = System.nanoTime();
		
		long previousTime = System.nanoTime();
		
		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();
		
		double deltaU = 0;
		double deltaF = 0;
		
		while(true) {
			
			now = System.nanoTime();
			long currentTime = System.nanoTime();
			
			deltaU = deltaU + (currentTime - previousTime)/ timePerUpdate;
			deltaF = deltaF + (currentTime - previousTime)/ timePerFrame;
			previousTime = currentTime;
			
			
			if(deltaU >= 1) {
				
				update();
				updates++;
				deltaU--;
			}
			
			if(deltaF >= 1) {
				
				
				//repaint just calls to refresh screen (NO LOGIC) --> use Update ticks
				Gpanel.repaint();
				lastFrame++;
				deltaF--;
				frames++;
			}
			
			
			
			if(System.currentTimeMillis() - lastCheck >= 1000) {
				
				lastCheck = System.currentTimeMillis();
				System.out.println("Fps: " + frames + " Ups: " + updates);
				frames = 0;
				updates = 0;
				
			}
			
		}
		
		
	}


	void update() {
		
		if(paused == false) {
			
			GameTimer.updateGameTicker();
			EventManger.UpdateEvents();
			
			
		}
		
		
		
		
		if(PlayState == null) {
			return;
		}
		
		if(State.equals("Playing")) {
			
			PlayState.update();
		}
		
		
	}
	
	
	void render(Graphics g) {
		
		//not broken but weird
		if(PlayState == null) {
			return;
		}
		
		if(State.equals("Playing")) {
			
			PlayState.render(g);
		}
		
		
	}
	
	
	public void KeyActionsPressed(KeyEvent e) {
		
		if(State.equals("Playing")) PlayState.KeyActionPressed(e);
		
		
	}
	
	public void KeyActionsReleased(KeyEvent e) {
		
		if(State.equals("Playing")) PlayState.KeyActionReleased(e);
		
		
	}
	
	public void waita() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
}
