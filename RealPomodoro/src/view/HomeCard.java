package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pomodoro.PomodoroTimer;

public class HomeCard extends JPanel {
	
	JPanel settingsButtonPanel;
	
	private TimePad timePad;
	
	private JPanel startButtonPanel;
	private StartButton startButton;
	
	private PomodoroTimer pomodoroTimer;
	private Home home;
	
	private PomodoroCounting pomodoroCounting;
	
	public HomeCard(Home home) {
		super();
		sethome(home);
		
		setHomeCard();
		
		setSettingsButtonPanel();
		setTimePad();
		setPomodoroTimer();
		setStartButton(pomodoroTimer);
		setStartButtonPanel();
		setPomodoroCounting();
		
		addAllComponentsToHomeCard();
	}
	
	private void setHomeCard() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBackground(AppColors.HOME_BACKGROUND);
		home.getRootPane().setDefaultButton(startButton);
	}
	
	private void addAllComponentsToHomeCard() {
		add(settingsButtonPanel);
		StyledViewFactory.addPad(this, 1, 5);
		add(timePad);
		StyledViewFactory.addPad(this, 1, 200);
		add(startButtonPanel);
		StyledViewFactory.addPad(this, 1, 10);
		add(pomodoroCounting);
	}
	
	private void setSettingsButtonPanel() {
		settingsButtonPanel = new JPanel();
		settingsButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		settingsButtonPanel.setBackground(AppColors.HOME_BACKGROUND);
		
		SettingsButton settingsButton = new SettingsButton(home);
		settingsButtonPanel.add(settingsButton);
	}
	
	private void setStartButtonPanel() {
		startButtonPanel = new JPanel();
		startButtonPanel.setLayout(new BoxLayout(startButtonPanel, BoxLayout.LINE_AXIS));
		startButtonPanel.add(startButton);
		startButtonPanel.setBackground(AppColors.HOME_BACKGROUND);
		startButtonPanel.setOpaque(true);
		
		final int PANEL_X_SIZE = (int) (Home.HOME_X_SIZE * 0.83);
		final int PANEL_Y_SIZE = 35;
		final Dimension START_PANEL_DIMENSION = new Dimension(PANEL_X_SIZE, PANEL_Y_SIZE);
		
		StyledViewFactory.forcePanelSize(startButtonPanel,  START_PANEL_DIMENSION);
	}
	
	public void pomodoroIsOver() {
		pomodoroCounting.update();

		final boolean isAutoRunEnabled = false;
		/*
		final boolean isAutoRunEnabled = home.isAutoRunEnabled();
		*/
		if(!isAutoRunEnabled) {
			startButton.setStartButtonStyle();
			home.toFront();
			JOptionPane.showMessageDialog(null, "Pomodoro is over.");
		}
		else {
			pomodoroTimer.play();
		}
	}

	private void setPomodoroTimer() {
		pomodoroTimer = new PomodoroTimer(timePad, this);
	}
	
	public PomodoroTimer getPomodoroTimer() {
		return pomodoroTimer;
	}

	public void setPomodoroTimer(final int minutes, final int seconds) {
		
	}
	
	private void setStartButton(final PomodoroTimer pomodoroTime) {
		startButton = new StartButton(pomodoroTime);
	}

	private void setTimePad() {
		timePad = new TimePad();
	}
	
	private void sethome(final Home home) {
		this.home = home;
	}
	
	
	private void setPomodoroCounting() {
		pomodoroCounting = new PomodoroCounting();
	}
	
}
