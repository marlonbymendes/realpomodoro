package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import pomodoro.PomodoroTimer;

public class Home {
	
	JFrame home;

	JPanel startButtonPanel;
	TimePad timePad;
	StartButton startButton;
	JPanel settingsButtonPanel;
	
	PomodoroTimer pomodoroTimer;
	
	private final String HOME_TITLE = "RealPomodoro";

	private PomodoroCounting pomodoroCounting;
	public static final int HOME_X_SIZE = 350;
	public static final int HOME_Y_SIZE = 550;
	
	public Home() {
		
		setSettingsButtonPanel();
		
		setTimePad();
		setPomodoroTimer();
		setStartButton(pomodoroTimer);
		setStartButtonPanel();
		setPomodoroCounting();
		setHome();
	}
	
	private void setTimePad() {
		timePad = new TimePad();
	}
	
	private void setStartButton(final PomodoroTimer pomodoroTime) {
		startButton = new StartButton(pomodoroTime);
	}
	
	private void setHome() {
		setHomeFrame();
		addAllComponentsToHome();
	}
	
	private void setHomeFrame() {
		home = new JFrame(HOME_TITLE);
		//home.setSize(HOME_X_SIZE, HOME_Y_SIZE);
		home.setLayout(new BoxLayout(home.getContentPane(), BoxLayout.PAGE_AXIS));
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		home.getRootPane().setDefaultButton(startButton);
		
		home.getContentPane().setBackground(AppColors.HOME_BACKGROUND);
		setHomeBorder();
	}
	
	private void addAllComponentsToHome() {
		home.add(settingsButtonPanel);
		home.add(timePad);
		addPad(1, 125);
		home.add(startButtonPanel);
		addPad(1, 10);
		home.add(pomodoroCounting);
	}
	
	private void addPad(final int width, final int height) {
		home.add(Box.createRigidArea(new Dimension(width, height)));
	}
	

	private void setStartButtonPanel() {
		startButtonPanel = new JPanel();
		startButtonPanel.setLayout(new BoxLayout(startButtonPanel, BoxLayout.LINE_AXIS));
		startButtonPanel.add(startButton);
		startButtonPanel.setBackground(AppColors.HOME_BACKGROUND);
		startButtonPanel.setOpaque(true);
	}
	
	public void show() {
		home.pack();
		home.setVisible(true);
	}
	
	private void setPomodoroTimer() {
		pomodoroTimer = new PomodoroTimer(timePad, this);
	}
	
	public void pomodoroIsOver() {
		home.toFront();
		startButton.setStartButtonStyle();
		pomodoroCounting.update();
		JOptionPane.showMessageDialog(null, "Pomodoro is over.");
	}
	
	private void setSettingsButtonPanel() {
		settingsButtonPanel = new JPanel();
		settingsButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		settingsButtonPanel.setBackground(AppColors.HOME_BACKGROUND);
		
		SettingsButton settingsButton = new SettingsButton();
		settingsButtonPanel.add(settingsButton);
	}
	
	private void setPomodoroCounting() {
		pomodoroCounting = new PomodoroCounting();
	}
	
	private void setHomeBorder() {
		Border border = BorderFactory.createLineBorder(AppColors.HOME_BACKGROUND, 10);
		home.getRootPane().setBorder(border);
	}
}
