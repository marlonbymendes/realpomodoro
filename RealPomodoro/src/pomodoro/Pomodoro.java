package pomodoro;

public class Pomodoro {

	private Integer minutes;
	private Integer seconds;
	
	public Pomodoro() {
		setMinutes(PomodoroConstants.DEFAULT_MINUTES);
		setSeconds(PomodoroConstants.DEFAULT_SECONDS);
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
		int totalTime = minutes * PomodoroConstants.SECONDS_IN_A_MINUTE + seconds;
		
		return totalTime;
	}
	
	public void update() {
		updateSeconds();
	
		System.out.printf("Current total time: %d\n", getTotalTime());
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
		seconds += PomodoroConstants.SECONDS_IN_A_MINUTE;
	}
}
