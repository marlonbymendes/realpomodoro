package home_card_view;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.FlowLayout;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import home_view.AppColors;
import home_view.Home;
import home_view.StyledViewFactory;
import pomodoro.PomodoroTimer;

@SuppressWarnings("serial")
public class HomeCard extends JPanel {

	JPanel settingsButtonPanel;

	private TimePad timePad;

	private JPanel startButtonPanel;
	private StartButton startButton;

	private PomodoroTimer pomodoroTimer;
	private Home home;
	private boolean pomodoroRunning;

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
		setPomodoroRunning(false);

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

		StyledViewFactory.addPad(this, 1, 20);
		add(pomodoroCounting);

		StyledViewFactory.addPad(this, 1, 190);
		add(startButtonPanel);
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

		StyledViewFactory.forceComponentSize(startButtonPanel, StartButton.BUTTON_DIMENSION);
	}

	public void pomodoroIsOver() {
		pomodoroCounting.update();
		
		
		final boolean isAutoRunEnabled = home.isAutoRunEnabled();
		if (!isAutoRunEnabled) {
			startButton.setStartButtonStyle();
			placeHomeInFront();
			
			playPomodoroIsOverSound();
			
			showPomodoroIsOver();
			setPomodoroRunning(false);
		} else {
			playPomodoroIsOverSound();
			pomodoroTimer.play();
		}
		
	}
	
	public void placeHomeInFront() {
		home.setVisible(true);
		home.setAlwaysOnTop(true);
		home.toFront(); 
	}

	private void showPomodoroIsOver() {
		JOptionPane.showMessageDialog(home, "Pomodoro is over.");
	}

	private void playPomodoroIsOverSound() {
		final String FOLDER = "resources/sounds/";
		final String SOUND_FILE_NAME = "pomodoro_is_over.wav";
		final String FILE_PATH = FOLDER + SOUND_FILE_NAME;

		ClassLoader classLoader = getClass().getClassLoader();
		URL url = classLoader.getResource(FILE_PATH);
		AudioClip clip = Applet.newAudioClip(url);
		clip.play();
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
		startButton = new StartButton(pomodoroTime, this);
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

	public void setPomodoroRunning(final boolean status) {
		pomodoroRunning = status;
	}

	public boolean isPomodoroRunning() {
		return this.pomodoroRunning;
	}
}
