package pomodoro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import view.Home;
import view.TimePad;

public class PomodoroTimer implements ActionListener {

	private int UPDATE_TIME = 1000; // 1000 ms = 1 s
	
	private boolean counting;
	Pomodoro pomodoro;
	Timer stopWatch;
	TimePad timePad;
	
	Home home;
	
	public PomodoroTimer(final TimePad timePad) {
		setCounting(false);
		setPomodoro();
		setTimePad(timePad);
		setStopWatch();
		setHome(null);
	}
	
	public PomodoroTimer(final TimePad timePad, final Home home) {
		setCounting(false);
		setPomodoro();
		setTimePad(timePad);
		setStopWatch();
		setHome(home);
	}
	
	public void actionPerformed(ActionEvent event) {
		if(counting && pomodoro.getTotalTime() > 0) {
			pomodoro.update();
			
			final int currentMinutes = pomodoro.getMinutes();
			final int currentSeconds = pomodoro.getSeconds();
			
			timePad.updateMinutes(currentMinutes);
			timePad.updateSeconds(currentSeconds);
		}
		else if(counting && pomodoro.getTotalTime() == 0) {
			stopWatch.stop();
			setCounting(false);
			if(home != null) {
				home.pomodoroIsOver();
			}
		}
	}
	
	private void setPomodoro() {
		pomodoro = new Pomodoro();
	}
	
	private void setStopWatch() {
		stopWatch = new Timer(UPDATE_TIME, this);
		stopWatch.start();
	}
	
	private void setTimePad(final TimePad timePad) {
		this.timePad = timePad;
	}
	
	public void play() {
		setCounting(true);
	}
	
	public void stop() {
		setCounting(false);
		stopWatch.restart();
	}
	
	private void setCounting(final boolean counting) {
		this.counting = counting;
	}
	
	private void setHome(final Home home) {
		this.home = home;
	}
}
