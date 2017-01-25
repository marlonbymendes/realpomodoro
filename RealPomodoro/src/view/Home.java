package view;

import java.awt.Component;
import java.awt.Dimension;

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
	
	PomodoroTimer pomodoroTimer;
	
	public Home() {
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
		home = new JFrame("Home");
		home.setSize(350, 450);
		home.setLayout(new BoxLayout(home.getContentPane(), BoxLayout.PAGE_AXIS));
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		home.getRootPane().setDefaultButton(startButton);
		
		home.getContentPane().setBackground(AppColors.HOME_BACKGROUND);
	}
	
	private void addAllComponentsToHome() {
		setTopPad();
		home.add(timePad);
		home.add(startButtonPanel);
	}
	
	private void setTopPad() {
		home.add(Box.createRigidArea(new Dimension(1, 50)));
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
}
