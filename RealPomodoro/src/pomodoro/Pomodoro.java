package pomodoro;

public class Pomodoro {

	private Integer initialMinutes;
	private Integer initialSeconds;
	
	private Integer currentMinutes;
	private Integer currentSeconds;
	
	public Pomodoro() {
		setInitialMinutes(PomodoroConstants.DEFAULT_MINUTES);
		setInitialSeconds(PomodoroConstants.DEFAULT_SECONDS);
		
		setCurrentMinutes(PomodoroConstants.DEFAULT_MINUTES);
		setCurrentSeconds(PomodoroConstants.DEFAULT_SECONDS);
	}
	
	public Pomodoro(final int minutes, final int seconds) {
		setInitialMinutes(PomodoroConstants.DEFAULT_MINUTES);
		setInitialSeconds(PomodoroConstants.DEFAULT_SECONDS);
		
		setCurrentMinutes(minutes);
		setCurrentSeconds(seconds);
	}
		
	public int getTotalTime() {
		assert(currentMinutes != null);
		assert(currentSeconds != null);
		int totalTime = currentMinutes * PomodoroConstants.SECONDS_IN_A_MINUTE + currentSeconds;	
		return totalTime;
	}
	
	public void update() {
		updateSeconds();
	
		System.out.printf("Current total time: %d\n", getTotalTime());
	}
	
	private void updateSeconds() {
		if(currentSeconds > 0) {
			--currentSeconds;
		}
		else {
			updateMinutes();
			updateSeconds();
		}
	}
	
	private void updateMinutes() {
		assert(currentMinutes > 0);
		currentMinutes--;
		currentSeconds += PomodoroConstants.SECONDS_IN_A_MINUTE;
	}
	
	public void restart() {
		setCurrentMinutes(initialMinutes);
		setCurrentSeconds(initialSeconds);
	}
	
	public boolean isOver() {
		return getTotalTime() == 0;
	}
	
	private void setCurrentMinutes(final Integer currentMinutes) {
		this.currentMinutes = currentMinutes;
	}

	private void setCurrentSeconds(final Integer currentSeconds) {
		this.currentSeconds = currentSeconds;
	}
	
	public Integer getMinutes() {
		return currentMinutes;
	}

	private void setInitialMinutes(final Integer minutes) {
		this.initialMinutes = minutes;
	}

	public Integer getSeconds() {
		return currentSeconds;
	}

	private void setInitialSeconds(final Integer seconds) {
		this.initialSeconds = seconds;
	}

	public int getInitialMinutes() {
		return initialMinutes;
	}
	
	public int getInitialSeconds() {
		return initialSeconds;
	}
	
	
	public void setInitialTime(final int minutes, final int seconds) {
		setInitialMinutes(minutes);
		setInitialSeconds(seconds);
	}
}
