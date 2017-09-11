package settings_card_view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import home_view.Home;
import pomodoro.PomodoroTimer;

public class ResetTimerButton extends StyledButton {
	
	private final static String LABEL = "Timer";
	private final static float X_SIZE_PROPORTION = 0.35F;
	private final static int Y_SIZE = 25;
	
	private Home home;
	private PomodoroTimer pomodoroTimer;
	
	public ResetTimerButton(final Home home) {
		super(LABEL, X_SIZE_PROPORTION, Y_SIZE);
		
		setHome(home);
		setPomodoroTimer();
		
		this.addActionListener(new Listener());
	}
	
	private class Listener implements ActionListener {

		public void actionPerformed(final ActionEvent event) {
			System.out.println("Reset timer");
			pomodoroTimer.resetPomodoroTimerAndPad();
			getHome().getHomeCard().getStartButton().setStartButtonStyle();
		}
	}
	
	private void setHome(final Home home) {
		this.home = home;
	}
	
	private void setPomodoroTimer() {
		this.pomodoroTimer = getHome().getPomodoroTimer();
	}
	
	private Home getHome() {
		return this.home;
	}
}
