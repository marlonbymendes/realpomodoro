package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pomodoro.PomodoroTimer;

public class Home {
	
	JFrame home;

	JPanel startButtonPanel;
	TimePad timePad;
	StartButton startButton;
	JPanel settingsButtonPanel;
	
	PomodoroTimer pomodoroTimer;
	
	private final String HOME_TITLE = "RealPomodoro";
	public static final int HOME_X_SIZE = 350;
	public static final int HOME_Y_SIZE = 450;
	
	public Home() {
		
		setSettingsButtonPanel();
		
		setTimePad();
		setPomodoroTimer();
		setStartButton(pomodoroTimer);
		setStartButtonPanel();
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
		home.setSize(HOME_X_SIZE, HOME_Y_SIZE);
		home.setLayout(new BoxLayout(home.getContentPane(), BoxLayout.PAGE_AXIS));
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		home.getRootPane().setDefaultButton(startButton);
		
		home.getContentPane().setBackground(AppColors.HOME_BACKGROUND);
	}
	
	private void addAllComponentsToHome() {
		home.add(settingsButtonPanel);
		setTopPad();
		home.add(timePad);
		home.add(startButtonPanel);
	}
	
	private void setTopPad() {
		home.add(Box.createRigidArea(new Dimension(1, 15)));
	}
	

	private void setStartButtonPanel() {
		startButtonPanel = new JPanel();
		startButtonPanel.setLayout(new BoxLayout(startButtonPanel, BoxLayout.LINE_AXIS));
		
		final Dimension startButtonTopPadDimension = new Dimension(0, 400);
		final Component startButtonTopPad = Box.createRigidArea(startButtonTopPadDimension);
		
		startButtonPanel.add(startButtonTopPad);
		startButtonPanel.add(startButton);
		startButtonPanel.setBackground(AppColors.HOME_BACKGROUND);
		startButtonPanel.setOpaque(true);
	}
	
	public void show() {
		home.setVisible(true);
	}
	
	private void setPomodoroTimer() {
		pomodoroTimer = new PomodoroTimer(timePad, this);
	}
	
	public void pomodoroIsOver() {
		home.toFront();
		startButton.setStartButtonStyle();
		JOptionPane.showMessageDialog(null, "Pomodoro is over.");
	}
	
	private void setSettingsButtonPanel() {
		settingsButtonPanel = new JPanel();
		settingsButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		settingsButtonPanel.setBackground(AppColors.HOME_BACKGROUND);
		
		SettingsButton settingsButton = new SettingsButton();
		settingsButtonPanel.add(settingsButton);
	}
}
