package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import input_validation.IntegerTextField;
import pomodoro.PomodoroConstants;

public class SettingsCard extends JPanel {
	
	IntegerTextField minutesText;
	IntegerTextField secondsText;
	JLabel minutesLabel;
	JLabel secondsLabel;
	
	JPanel minutesInputPanel;
	JPanel secondsInputPanel;
	
	JPanel pomodoroMessage;
	
	public SettingsCard() {
		super();
		
		setSettingsCard();
		
		setPomodoroMessage();
		setInputPanels();
		addAllComponents();
	}
	
	private void setSettingsCard() {
		setBackground(AppColors.HOME_BACKGROUND);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}
	
	private void setTimeInput() {
		minutesText = createStyledIntegerTextField(PomodoroConstants.DEFAULT_MINUTES);
		minutesText.setBackground(AppColors.APP_GREEN);
		
		secondsText = createStyledIntegerTextField(PomodoroConstants.DEFAULT_SECONDS);
		secondsText.setBackground(AppColors.APP_RED);
	}
	
	private void setTimeLabels() {
		final int timeLabelFontSize = 15;
		final String MINUTES_STRING = "Minutes:";
		final String SECONDS_STRING = "Seconds:";
		
		final int LEFT_PAD = 73;
		minutesLabel = StyledViewFactory.createStyledLabel(MINUTES_STRING, timeLabelFontSize);
		minutesLabel.setPreferredSize(new Dimension(LEFT_PAD, 0));
		
		secondsLabel = StyledViewFactory.createStyledLabel(SECONDS_STRING, timeLabelFontSize);
		secondsLabel.setPreferredSize(new Dimension(LEFT_PAD, 0));
	}
	
	private void setInputPanels() {
		setTimeLabels();
		setTimeInput();
		
		minutesInputPanel = createInputPanel(minutesLabel, minutesText);
		minutesInputPanel.setBackground(Color.PINK);
		minutesInputPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		secondsInputPanel = createInputPanel(secondsLabel, secondsText);
		secondsInputPanel.setBackground(Color.YELLOW);
		secondsInputPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
	}
	
	private IntegerTextField createStyledIntegerTextField(final Integer initialNumber) {
		IntegerTextField timeInput = new IntegerTextField();
		setTimeDigitStyle(timeInput);
		
		final String initialNumberString = String.format("%02d", initialNumber);
		timeInput.setText(initialNumberString);

		return timeInput;
	}
	
	private void setPomodoroMessage() {
		JLabel message = StyledViewFactory.createStyledLabel(15);
		
		final String POMODORO_MESSAGE = "Pomodoro time:";
		message.setText(POMODORO_MESSAGE);
		message.setAlignmentX(message.LEFT_ALIGNMENT);
		
		pomodoroMessage = new JPanel();
		pomodoroMessage.setLayout(new BoxLayout(pomodoroMessage, BoxLayout.X_AXIS));
		pomodoroMessage.setBackground(AppColors.HOME_BACKGROUND);
		
		pomodoroMessage.add(message);
		pomodoroMessage.setAlignmentX( Component.LEFT_ALIGNMENT );
		
		//pomodoroMessage.setPreferredSize(new Dimension(300, 30));
		//pomodoroMessage.setMaximumSize(pomodoroMessage.getPreferredSize()); 
		//pomodoroMessage.setMinimumSize(pomodoroMessage.getPreferredSize());
	}
	
	private void addAllComponents() {
		
		
		add(pomodoroMessage);
		add(minutesInputPanel);
		add(secondsInputPanel);
	}
	
	private void setTimeDigitStyle(JComponent component) {
		final int DIGIT_INPUT_SIZE = 20;
		final Font digitFont = new Font(FontConstants.APP_FONT_NAME,
				FontConstants.APP_FONT_STYLE, DIGIT_INPUT_SIZE);
		
		component.setFont(digitFont);
		component.setBackground(AppColors.HOME_BACKGROUND);
		component.setForeground(AppColors.TIME_PAD_DIGITS);
	}
	
	private JPanel createInputPanel(final JLabel label, final JTextField textField) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBackground(AppColors.HOME_BACKGROUND);
		
		panel.add(label);
		panel.add(textField);
		
		final int INPUT_PANEL_X_SIZE = 97;
		
		panel.setPreferredSize(new Dimension(INPUT_PANEL_X_SIZE, 30));
		panel.setMaximumSize(panel.getPreferredSize()); 
		panel.setMinimumSize(panel.getPreferredSize());
		return panel;
	}
}
