package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pomodoro.PomodoroTimer;

public class StartButton extends JButton {
	
	PomodoroTimer pomodoroTimer;
	
	private final static String START_BUTTON_NAME = "START";
	private final static String PAUSE_BUTTON_NAME = "PAUSE";
	
	private static final long serialVersionUID = -6839276097281926270L;
	
	private boolean startStatus;
	
	public StartButton(final PomodoroTimer pomodoroTimer) {
		super();
		
		setStartStatus(true);
		setPomodoroTimer(pomodoroTimer);
		
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setOpaque(true);
		setMinimumSize(new Dimension(300, 25));
		setMaximumSize(new Dimension(300, 25));
		
		addActionListener(new StartButtonListener());
		setStartButtonStyle();
	}
	
	private class StartButtonListener implements ActionListener {
	

		public void actionPerformed(final ActionEvent event) {
			if(startStatus) {
				setPauseButtonStyle();
				setStartStatus(false);
				pomodoroTimer.play();
			}
			else {
				setStartButtonStyle();
				setStartStatus(true);
				pomodoroTimer.stop();
			}
		}
	}
	
	private void setStartStatus(final boolean status) {
		this.startStatus = status;
	}
	
	public void setStartButtonStyle() {
		setBackground(AppColors.APP_GREEN);
		setText(START_BUTTON_NAME);
	}
	
	private void setPauseButtonStyle() {
		setBackground(AppColors.APP_RED);
		setText(PAUSE_BUTTON_NAME);
	}
	
	private void setPomodoroTimer(final PomodoroTimer pomodoroTime) {
		this.pomodoroTimer = pomodoroTime;
	}
}
