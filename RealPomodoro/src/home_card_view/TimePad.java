package home_card_view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import home_view.AppColors;
import home_view.FontConstants;
import home_view.Home;
import home_view.StyledViewFactory;
import pomodoro.PomodoroConstants;
import settings_card_view.SettingsCard;
import utils.PomodoroHistoryFileUtilities;

public class TimePad extends JPanel {

	JLabel twoPoints;
	JLabel minutesLabel;
	JLabel secondsLabel;
	
	final int SECONDS_START = 2;
	final int MINUTES_START = 0;
	
	final int TIME_PAD_X_SIZE = Home.HOME_X_SIZE - 57;
	final int TIME_PAD_Y_SIZE = SettingsCard.INPUT_Y_SIZE + 10;
	
	public TimePad() {
		super();
		 
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		setAlignmentX(JPanel.CENTER_ALIGNMENT);
		
		setBackground(AppColors.HOME_BACKGROUND);
		setOpaque(true);
		
		StyledViewFactory.setWhiteBorder(this);
		
		Dimension TIME_PAD_DIMENSION = new Dimension(TIME_PAD_X_SIZE, TIME_PAD_Y_SIZE);
		StyledViewFactory.forceComponentSize(this, TIME_PAD_DIMENSION);
		
		addAllDigits();
	}
	
	private void updateSeconds(final int seconds) {
		updateTextNumber(secondsLabel, seconds);
	}
	
	private void updateMinutes(final int minutes) {
		updateTextNumber(minutesLabel, minutes);
	}
	
	public void update(final int minutes, final int seconds) {
		updateMinutes(minutes);
		updateSeconds(seconds);
	}
	
	private void updateTextNumber(JLabel label, final Integer newText) {
		final String newTextString = String.format("%02d", newText);
		label.setText(newTextString);
	}
	
	private void initTimeDigits() {
		final String ZERO_ZERO = "00";
		minutesLabel = createDigitLabel(ZERO_ZERO);
		secondsLabel = createDigitLabel(ZERO_ZERO);
	}
	
	private JLabel createDigitLabel(final String text) {
		JLabel digitLabel = new JLabel();
		
		final Font digitFont = new Font(FontConstants.APP_FONT_NAME,
				FontConstants.APP_FONT_STYLE, FontConstants.TIMEPAD_DIGIT_SIZE);
		digitLabel.setFont(digitFont);
		digitLabel.setForeground(AppColors.TIME_PAD_DIGITS);
		digitLabel.setText(text);
		digitLabel.setBackground(AppColors.HOME_BACKGROUND);
		digitLabel.setOpaque(true);
		digitLabel.setPreferredSize(new Dimension(0, SettingsCard.INPUT_Y_SIZE + 8));
		
		return digitLabel;
	}
	
	private void initDigits() {
		initTimeDigits();
		updateMinutes(PomodoroHistoryFileUtilities.getMinutesInLastPomodoro());
		updateSeconds(PomodoroHistoryFileUtilities.getSecondsInLastPomodoro());
		
		setTwoPointsLabel();
	}
	
	private void setTwoPointsLabel() {
		final String TWO_POINTS = ":";
		twoPoints = createDigitLabel(TWO_POINTS);
	}
	
	private void addAllDigits() {
		initDigits();
	
		add(minutesLabel);
		add(twoPoints);
		add(secondsLabel);
	}
}
