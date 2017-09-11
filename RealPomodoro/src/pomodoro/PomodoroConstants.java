package pomodoro;

public class PomodoroConstants {
	public static final Integer DEFAULT_MINUTES = 25;
	public static final Integer DEFAULT_SECONDS = 00;
	public static final Integer SECONDS_IN_A_MINUTE = 60;
	
	public static final Integer TOTAL_POMODORO_TIME_IN_SECONDS =
								DEFAULT_MINUTES * SECONDS_IN_A_MINUTE + DEFAULT_SECONDS;
}
