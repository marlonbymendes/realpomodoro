package settings_card_view;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import home_card_view.PomodoroMessage;
import home_view.AppColors;
import home_view.Home;
import home_view.StyledViewFactory;
import pomodoro.PomodoroConstants;


public class SettingsCard extends JPanel {
	
	private	Home home;
	
	private PomodoroMessage pomodoroMessage;
	
	private IntegerInputPanel minutesInputPanel;
	private IntegerInputPanel secondsInputPanel;

	private AutoRunPanel autoRunPanel;
	
	private JPanel doneButtonPanel;

	public static final int INPUT_X_SIZE = 124;
	public static final int INPUT_Y_SIZE = 87;
	
	public static final Dimension TIME_PANEL_DIMENSION = new Dimension(Home.HOME_X_SIZE, INPUT_Y_SIZE + 10);
	
	public SettingsCard(final Home home) {
		super();
		setHome(home);
		
		setSettingsCard();
		
		setPomodoroMessage();
		setInputPanels();
		setAutoRunPanel();
		setDoneButtonPanel();
		
		addAllComponents();	
	}
	
	private void setSettingsCard() {
		setBackground(AppColors.HOME_BACKGROUND);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}
	
	private void setPomodoroMessage() {
		pomodoroMessage = new PomodoroMessage();
	}
	
	private void addAllComponents() {	
		add(pomodoroMessage);
		
		add(minutesInputPanel);
		add(secondsInputPanel);
		
		StyledViewFactory.addPad(this, 0, 40);
		add(autoRunPanel);
		
		StyledViewFactory.addPad(this, 0, 134);
		add(doneButtonPanel);
	}
	
	private void setDoneButtonPanel() {
	
		
		doneButtonPanel = new JPanel();
		doneButtonPanel.setLayout(new BoxLayout(doneButtonPanel, BoxLayout.LINE_AXIS));
		doneButtonPanel.setBackground(AppColors.HOME_BACKGROUND);
		
		SettingsDoneButton settingsDoneButton = new SettingsDoneButton(home, this);
		doneButtonPanel.add(settingsDoneButton);
	}
	
	public boolean isAutoRunEnabled() {
		return autoRunPanel.isAutoRunEnabled();
	}
	
	private void setAutoRunPanel() {
		autoRunPanel = new AutoRunPanel();
	}
	
	private void setHome(final Home home) {
		this.home = home;
	}
	
	private void setMinutesInputPanel() {
		final String MINUTES_MESSAGE = "Minutes: ";
		minutesInputPanel = new IntegerInputPanel(MINUTES_MESSAGE, PomodoroConstants.DEFAULT_MINUTES);
	}
	
	private void setSecondsInputPanel() {
		final String SECONDS_MESSAGE = "Seconds:";
		secondsInputPanel = new IntegerInputPanel(SECONDS_MESSAGE, PomodoroConstants.DEFAULT_SECONDS);
	}
	
	private void setInputPanels() {
		setMinutesInputPanel();
		setSecondsInputPanel();
	}
	
	public boolean wasPomodoroUpdated() {
		boolean updated = minutesInputPanel.wasUpdated() || secondsInputPanel.wasUpdated();
		return updated;
	}
	
	public int getMinutes() {
		return minutesInputPanel.getInteger();
	}
	
	public int getSeconds() {
		return secondsInputPanel.getInteger();
	}

	public void setPomodoroUpdated(final boolean status) {
		minutesInputPanel.setUpdated(false);
		secondsInputPanel.setUpdated(false);
	}
}
