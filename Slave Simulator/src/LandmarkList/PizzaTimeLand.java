package LandmarkList;


import Landmark.Landmark;

import Landmark.LandmarkFunctions;


public class PizzaTimeLand extends Landmark implements LandmarkFunctions{

	public PizzaTimeLand(int y, int mo, int d, int h, int m) {
		super(y, mo, d, h, m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void PlayEvent() {
		System.out.println("Pizza time");
	}

	public boolean trigger(int year,int month, int day, int hour, int minute) {
		
		
		
		return true;
		
	}
	
	
}
