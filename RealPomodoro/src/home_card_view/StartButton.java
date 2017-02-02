package home_card_view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import home_view.AppColors;
import home_view.Home;
import home_view.StyledViewFactory;
import pomodoro.PomodoroTimer;

public class StartButton extends JButton {
	
	PomodoroTimer pomodoroTimer;
	
	private final static String START_BUTTON_NAME = "S";
	private final static String PAUSE_BUTTON_NAME = "P";
	
	public final static int X_SIZE = (int) (Home.HOME_X_SIZE * 0.83);
	public final static int Y_SIZE = 35;
	public final static Dimension BUTTON_DIMENSION = new Dimension(X_SIZE, Y_SIZE);
	
	public StartButton(final PomodoroTimer pomodoroTimer) {
		super();
		initButton();
		setPomodoroTimer(pomodoroTimer);
	}
	
	private class StartButtonListener implements ActionListener {
		public void actionPerformed(final ActionEvent event) {
			final String currentStatusText = getStatusText();
			boolean startStatus = currentStatusText.equals(START_BUTTON_NAME);
			
			if(startStatus) {
				setPauseButtonStyle();
				pomodoroTimer.play();
			}
			else {
				setStartButtonStyle();
				pomodoroTimer.stop();
			}
		}
	}
	
	public void setStartButtonStyle() {
		setText(START_BUTTON_NAME);
		setBackground(AppColors.APP_GREEN);
		setForeground(AppColors.APP_GREEN);

		final String playIconName = "play.png";
		setImageIcon(playIconName);
	}
	
	private void setPauseButtonStyle() {
		setText(PAUSE_BUTTON_NAME);
		setBackground(AppColors.APP_RED);
		setForeground(AppColors.APP_RED);
		
		final String playIconName = "pause.png";
		setImageIcon(playIconName);
		
		StyledViewFactory.forceComponentSize(this, BUTTON_DIMENSION);
	}
	
	private void setPomodoroTimer(final PomodoroTimer pomodoroTime) {
		this.pomodoroTimer = pomodoroTime;
	}
	
	private String getStatusText() {
		return getText();
	}
	
	private void setImageIcon(final String fileName) {
		try {
			ImageIcon imageIcon = (new AppColors()).createIconFromResources(fileName);
			setIcon(imageIcon);
			
		} catch (Exception ex) {
		    System.out.println("Can't load icon with name: " + fileName);
		}
		
	}
	
	private void initButton() {
		StyledViewFactory.setButtonStyle(this);
		addActionListener(new StartButtonListener());
		setStartButtonStyle();
	}
}
