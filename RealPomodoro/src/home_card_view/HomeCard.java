package home_card_view;

import java.awt.FlowLayout;
import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import home_view.AppColors;
import home_view.Home;
import home_view.StyledViewFactory;
import pomodoro.PomodoroTimer;

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
		playPomodoroIsOverSound();

		final boolean isAutoRunEnabled = home.isAutoRunEnabled();
		if (!isAutoRunEnabled) {
			startButton.setStartButtonStyle();
			home.toFront();
			showPomodoroIsOver();
			setPomodoroRunning(false);
		} else {
			pomodoroTimer.play();
		}
	}

	private void showPomodoroIsOver() {
		JOptionPane.showMessageDialog(null, "Pomodoro is over.");
	}

	private void playPomodoroIsOverSound() {
		final String FOLDER = "resources/sounds/";
		final String SOUND_FILE_NAME = "pomodoro_is_over.wav";
		final String FILE_PATH = FOLDER + SOUND_FILE_NAME;

		final ClassLoader classLoader = this.getClass().getClassLoader();
		final URL URLFile = classLoader.getResource(FILE_PATH);
		File yourFile = null;

		if (URLFile == null) {
			System.out.println("Can't create file " + SOUND_FILE_NAME);
		} else {
			yourFile = new File(URLFile.getFile());
		}

		try {
			AudioInputStream stream;
			AudioFormat format;
			DataLine.Info info;
			Clip clip;

			stream = AudioSystem.getAudioInputStream(yourFile);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
		} catch (Exception e) {
			System.out.println("Can't play sound with path " + FILE_PATH);
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
