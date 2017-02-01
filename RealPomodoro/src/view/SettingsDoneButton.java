package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
				updatePomodoroTimer();
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
}
