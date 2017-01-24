package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import pomodoro.Pomodoro;

public class PomodoroTimer implements ActionListener {

	private int SECOND = 1000; // 1 second = 1000 ms
	Pomodoro pomodoro;
	Timer stopWatch;
	TimePad timePad;
	
	public PomodoroTimer(final TimePad timePad) {
		setPomodoro();
		setTimePad(timePad);
		setStopWatch();
	}
	
	public void actionPerformed(ActionEvent event) {
		if(pomodoro.getTotalTime() > 0) {
			pomodoro.update();
			
			final int currentMinutes = pomodoro.getMinutes();
			final int currentSeconds = pomodoro.getSeconds();
			
			timePad.updateMinutes(currentMinutes);
			timePad.updateSeconds(currentSeconds);
		}
		else {
			stopWatch.stop();
		}
	}
	
	private void setPomodoro() {
		pomodoro = new Pomodoro();
	}
	
	private void setStopWatch() {
		stopWatch = new Timer(SECOND, this);
		stopWatch.setInitialDelay(SECOND);;
		stopWatch.start();
	}
	
	private void setTimePad(final TimePad timePad) {
		this.timePad = timePad;
	}
}
