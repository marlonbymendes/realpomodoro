package settings_card_view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import home_view.AppColors;
import home_view.FontConstants;
import home_view.Home;
import home_view.StyledViewFactory;
import pomodoro.PomodoroTimer;

public class SettingsDoneButton extends JButton {
	
	private Home home;
	private SettingsCard settingsCard;
	PomodoroTimer pomodoroTimer;
	
	private static final String DONE_BUTTON_TEXT = "DONE";
	
	public SettingsDoneButton(final Home home, final SettingsCard settingsCard) {
		super(DONE_BUTTON_TEXT);
		
		setHome(home);
		setSettingsCard(settingsCard);
		
		setPomodoroTimer();
		
		setSettingsDoneButtonSyle();
		addActionListener(new ButtonListener());
	}
	
	private void setSettingsDoneButtonSyle() {
		StyledViewFactory.setButtonStyle(this);
		
		setFontStyle();
		setBackground(AppColors.APP_GREEN);
	}
	
	private void setFontStyle() {
		final int fontSize = 17;
		final Font font = new Font(FontConstants.APP_FONT_NAME, FontConstants.APP_FONT_STYLE, fontSize);
		setFont(font);
		setForeground(AppColors.TIME_PAD_DIGITS);
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(final ActionEvent event) {
			final boolean wasPomodoroUpdated = settingsCard.wasPomodoroUpdated();
			if(wasPomodoroUpdated) {
				final boolean isPomodoroRunning = home.isPomodoroRunning();
				
				if(!isPomodoroRunning) {
					updatePomodoroTimer();
				}
				else {
					showPomodoroIsRunningMessage();
				}
				
				settingsCard.setPomodoroUpdated(false);
			}
			
			home.showHomeCard();
		}
	}
	
	private void setHome(final Home home) {
		this.home = home;
	}
	
	private void setSettingsCard(final SettingsCard settingsCard) {
		this.settingsCard = settingsCard;
	}
	
	private void setPomodoroTimer() {
		this.pomodoroTimer = home.getPomodoroTimer();
	}
	
	private void updatePomodoroTimer() {
		int minutes = settingsCard.getMinutes();
		int seconds = settingsCard.getSeconds();
		
		pomodoroTimer.updatePomodoroTime(minutes, seconds);
	}
	
	private void showPomodoroIsRunningMessage() {
		
		System.out.println("POMODOO IS RUNNING");
		final String POMODORO_IS_RUNNING = "There is a pomodoro running.Do you want to update it's time anyways?";
		
		final int user_answer = JOptionPane.showConfirmDialog(null, POMODORO_IS_RUNNING, "Pomodoro is running", JOptionPane.YES_NO_OPTION);
	}
}
