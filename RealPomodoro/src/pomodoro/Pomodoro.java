package pomodoro;

public class Pomodoro {

	private Integer DEFAULT_MINUTES = 25;
	private Integer DEFAULT_SECONDS = 0;
	
	private Integer minutes;
	private Integer seconds;

	final int SECONDS_IN_A_MINUTE = 60;
	
	public Pomodoro() {
		setMinutes(DEFAULT_MINUTES);
		setSeconds(DEFAULT_SECONDS);
	}
	
	public Integer getMinutes() {
		return minutes;
	}

	private void setMinutes(final Integer minutes) {
		this.minutes = minutes;
	}

	public Integer getSeconds() {
		return seconds;
	}

	private void setSeconds(final Integer seconds) {
		this.seconds = seconds;
	}
	
	public int getTotalTime() {
		int totalTime = minutes * SECONDS_IN_A_MINUTE + seconds;
		
		return totalTime;
	}
	
	public void update() {
		updateSeconds();
	}
	
	private void updateSeconds() {
		if(seconds > 0) {
			--seconds;
		}
		else {
			updateMinutes();
			updateSeconds();
		}
	}
	
	private void updateMinutes() {
		assert(minutes > 0);
		minutes--;
		seconds += SECONDS_IN_A_MINUTE;
	}
}
