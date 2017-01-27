package pomodoro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import view.Home;
import view.HomeCard;
import view.TimePad;

public class PomodoroTimer implements ActionListener {

	private int UPDATE_TIME = 1000; // 1000 ms = 1 s
	
	private boolean counting;
	Pomodoro pomodoro;
	Timer stopWatch;
	TimePad timePad;
	
	HomeCard homeCard;
	
	public PomodoroTimer(final TimePad timePad) {
		setCounting(false);
		setPomodoro();
		setTimePad(timePad);
		setStopWatch();
		setHome(null);
	}
	
	public PomodoroTimer(final TimePad timePad, final HomeCard homeCard) {
		setCounting(false);
		setPomodoro();
		setTimePad(timePad);
		setStopWatch();
		setHome(homeCard);
	}
	
	public void actionPerformed(ActionEvent event) {
		assert(pomodoro != null);
		
		if(counting && pomodoro.getTotalTime() > 0) {
			pomodoro.update();
			
			final int currentMinutes = pomodoro.getMinutes();
			final int currentSeconds = pomodoro.getSeconds();
			
			timePad.updateMinutes(currentMinutes);
			timePad.updateSeconds(currentSeconds);
		}
		else if(counting && pomodoro.isOver()) {
			stopWatch.stop();
			setCounting(false);
			if(homeCard != null) {
				homeCard.pomodoroIsOver();
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
		if(pomodoro.isOver()) {
			restart();
		}
		else {
			setCounting(true);
		}
	}
	
	public void stop() {
		setCounting(false);
		stopWatch.restart();
	}
	
	private void setCounting(final boolean counting) {
		this.counting = counting;
	}
	
	private void setHome(final HomeCard homeCard) {
		this.homeCard = homeCard;
	}
	
	public void restart() {
		setCounting(true);
		setPomodoro();
		stopWatch.restart();
		timePad.updateMinutes(pomodoro.getMinutes());
		timePad.updateSeconds(pomodoro.getSeconds());
	}
}
