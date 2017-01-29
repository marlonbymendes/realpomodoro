package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import input_validation.IntegerTextField;
import pomodoro.PomodoroConstants;

public class SettingsCard extends JPanel {
	
	private	Home home;
	
	IntegerTextField minutesText;
	IntegerTextField secondsText;
	
	JPanel minutesInputPanel;
	JPanel secondsInputPanel;
	
	JPanel pomodoroMessage;
	JLabel pomodoroMessageLabel;

	private JPanel timePanel;
	private Component bottonPad;
	
	public static final int INPUT_X_SIZE = 124;
	public static final int INPUT_Y_SIZE = 87;
	
	private JPanel doneButtonPanel;
	
	public static final Dimension TIME_PANEL_DIMENSION = new Dimension(Home.HOME_X_SIZE, INPUT_Y_SIZE + 10);
	
	public SettingsCard(final Home home) {
		super();
		setHome(home);
		
		setSettingsCard();
		
		setPomodoroMessage();
		setInputPanels();
		setTimePanel();
		setDoneButtonPanel();
		
		addAllComponents();	
	}
	
	public void setFocusInMinutesText() {
		minutesText.requestFocusInWindow();
		minutesText.setCaretPosition(IntegerTextField.MAXIMUM_NUMBER_OF_DIGITS);
	}
	
	private void setSettingsCard() {
		setBackground(AppColors.HOME_BACKGROUND);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		StyledViewFactory.forcePanelSize(this, new Dimension(Home.HOME_X_SIZE, Home.HOME_Y_SIZE));
	}
	
	private void setTimeInput() {
		minutesText = createStyledIntegerTextField(PomodoroConstants.DEFAULT_MINUTES);
		minutesText.setBackground(AppColors.DARK_GRAY);
		
		secondsText = createStyledIntegerTextField(PomodoroConstants.DEFAULT_SECONDS);
		secondsText.setBackground(AppColors.DARK_GRAY);
	}
	
	private void setInputPanels() {
		setTimeInput();
		
		minutesInputPanel = createInputPanel(minutesText);
		minutesInputPanel.setBackground(AppColors.DARK_GRAY);
		minutesInputPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		secondsInputPanel = createInputPanel(secondsText);
		secondsInputPanel.setBackground(AppColors.DARK_GRAY);
		secondsInputPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
	}
	
	private void setTimePanel() {
		timePanel = new JPanel();
		timePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		timePanel.setBackground(AppColors.DARK_GRAY);
		
		StyledViewFactory.forcePanelSize(timePanel, TIME_PANEL_DIMENSION);
		
		StyledViewFactory.setTimePadBorder(timePanel);
		
		timePanel.add(minutesInputPanel);
		JLabel twoPoints = StyledViewFactory.createStyledLabel(":", 100);
		twoPoints.setBackground(AppColors.DARK_GRAY);
		twoPoints.setPreferredSize(new Dimension(35, INPUT_Y_SIZE));
		timePanel.add(twoPoints);
		timePanel.add(secondsInputPanel);
	}
	
	private IntegerTextField createStyledIntegerTextField(final Integer initialNumber) {
		IntegerTextField timeInput = new IntegerTextField();
		setTimeDigitStyle(timeInput);
		
		final String initialNumberString = String.format("%02d", initialNumber);
		timeInput.setText(initialNumberString);

		return timeInput;
	}
	
	private void setPomodoroMessage() {
		pomodoroMessageLabel = StyledViewFactory.createStyledLabel(15);
		
		final String POMODORO_MESSAGE = "Pomodoro time:";
		pomodoroMessageLabel.setText(POMODORO_MESSAGE);
		pomodoroMessageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		pomodoroMessage = new JPanel();
		pomodoroMessage.setLayout(new BoxLayout(pomodoroMessage, BoxLayout.X_AXIS));
		pomodoroMessage.setBackground(AppColors.HOME_BACKGROUND);
		
		pomodoroMessage.add(pomodoroMessageLabel);
		
		final Dimension POMODORO_MESSAGE_DIMENSION = new Dimension(Home.HOME_X_SIZE, 35);
		StyledViewFactory.forcePanelSize(pomodoroMessage, POMODORO_MESSAGE_DIMENSION);
	}
	
	private void addAllComponents() {
		
		
		add(pomodoroMessage);
		add(timePanel);
		addBottonPad();
		add(doneButtonPanel);
	}
	
	private void setTimeDigitStyle(JComponent component) {
		final int DIGIT_INPUT_SIZE = 100;
		final Font digitFont = new Font(FontConstants.APP_FONT_NAME,
				FontConstants.APP_FONT_STYLE, DIGIT_INPUT_SIZE);
		
		component.setFont(digitFont);
		component.setBackground(AppColors.DARK_GRAY);
		component.setForeground(AppColors.TIME_PAD_DIGITS);
	}
	
	private JPanel createInputPanel(final JTextField textField) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBackground(AppColors.DARK_GRAY);

		panel.add(textField);
		panel.setPreferredSize(new Dimension(INPUT_X_SIZE, INPUT_Y_SIZE));
		return panel;
	}
	
	private void addBottonPad() {
		final Dimension BOTTON_PAD_SIZE = new Dimension(150, 201);
		bottonPad = Box.createRigidArea(BOTTON_PAD_SIZE);
		add(bottonPad);
		add(Box.createHorizontalGlue());
	}
	
	private void setDoneButtonPanel() {
	
		
		doneButtonPanel = new JPanel();
		doneButtonPanel.setLayout(new BoxLayout(doneButtonPanel, BoxLayout.LINE_AXIS));
		doneButtonPanel.setBackground(AppColors.HOME_BACKGROUND);
		
		SettingsDoneButton settingsDoneButton = new SettingsDoneButton(home);
		doneButtonPanel.add(settingsDoneButton);
	}
	
	private void setHome(final Home home) {
		this.home = home;
	}
}
