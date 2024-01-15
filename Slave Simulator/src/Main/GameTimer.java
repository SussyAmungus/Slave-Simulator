package Main;

public class GameTimer {
	
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	int days = 0;
	
	int gameticker = 0;
	
	//time scale for every hour in game is 45 seconds IRL = 10 minutes ever 24 hours;
	
	int gameMin = 0;
	int gameHour = 0;
	int gameDay = 1;
	int gameMonth = 1;
	int gameYear = 1991;
	
	Boolean leapYear = false;
	
	String currentMonth = "January";
	
	public GameTimer() {
		
	}
	
	
	public int getMin() {
		
		return gameMin;
	}
	public int getHour() {
		
		return gameHour;
	}
	public int getDay() {
		
		return gameDay;
	}
	public int getMonth() {
		
		return gameMonth;
	}
	public int getYear() {
		
		return gameYear;
	}
	
	
	
	
	public void hoursPlayedUpdate() {
		
		seconds++;
		
		if(seconds >= 60) {
			
			seconds = 0;
			minutes++;
		}
		if(minutes >= 60) {
			minutes = 0;
			hours++;
			
		}
		if(hours >= 24) {
			hours = 0;
			days++;
			
		}
		
	}
	
	public void updateGameTicker() {
		
		gameticker++;
		
		//remeber that you dont show in 12s
		if(gameticker >= 5) {
			
			gameMin = gameMin + 12;
			
			if(gameMin == 60) {
				gameMin = 0;
				
			}
			
		}
		
		
		if(gameticker >= 50) {
			gameHour++;
			gameticker = 0;
			
		}
		if(gameHour >= 24) {
			gameDay++;
			gameHour = 0;
			
		}
		if(gameDay >= 28) {
			//resets gamDay and adds year
			monthSelector();
			
		}
		
		
	}
	
	//selects month and also adds year
	public void monthSelector() {
		
	if(currentMonth.equals("January") && gameDay == 31) {
			currentMonth = "Feburary";
			gameDay = 1;
		}
	if(currentMonth.equals("Febuary") && gameDay == 28 && leapYear == false) {
			currentMonth = "March";
			gameDay = 1;
		}else if(currentMonth.equals("Febuary") && gameDay == 29 && leapYear == true) {
			currentMonth = "March";
			gameDay = 1;
		}
	if(currentMonth.equals("March") && gameDay == 31) {
		currentMonth = "April";
		gameDay = 1;
	}
	if(currentMonth.equals("April") && gameDay == 30) {
		currentMonth = "May";
		gameDay = 1;
	}
	if(currentMonth.equals("May") && gameDay == 31) {
		currentMonth = "June";
		gameDay = 1;
	}
	if(currentMonth.equals("June") && gameDay == 30) {
		currentMonth = "July";
		gameDay = 1;
	}
	if(currentMonth.equals("July") && gameDay == 31) {
		currentMonth = "August";
		gameDay = 1;
	}	
	if(currentMonth.equals("August") && gameDay == 31) {
		currentMonth = "September";
		gameDay = 1;
	}	
	if(currentMonth.equals("September") && gameDay == 30) {
		currentMonth = "October";
		gameDay = 1;
	}
	if(currentMonth.equals("October") && gameDay == 31) {
		currentMonth = "November";
		gameDay = 1;
	}
	if(currentMonth.equals("November") && gameDay == 30) {
		currentMonth = "Decemeber";
		gameDay = 1;
	}
	if(currentMonth.equals("December") && gameDay == 31) {
		currentMonth = "January ";
		gameDay = 1;
		gameYear++;
	}
		
	}
	
	
	
	
	
}
