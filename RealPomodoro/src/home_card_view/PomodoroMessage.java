package home_card_view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import home_view.AppColors;
import home_view.StyledViewFactory;

public class PomodoroMessage extends JPanel {
	
	private JLabel pomodoroMessageLabel;
	
	public PomodoroMessage() {
		super();
		
		setPomodoroMessage();
		setLabel();
		add(pomodoroMessageLabel);
		
	}

	private void setPomodoroMessage() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBackground(AppColors.HOME_BACKGROUND);
		
		final Dimension POMODORO_MESSAGE_DIMENSION = StartButton.BUTTON_DIMENSION;
		StyledViewFactory.forceComponentSize(this, POMODORO_MESSAGE_DIMENSION);
	}
	
	private void setLabel() {
		final String POMODORO_MESSAGE = "Pomodoro time";
		final int fontSize = 17;
		pomodoroMessageLabel = StyledViewFactory.createStyledLabel(POMODORO_MESSAGE, fontSize);
	}
}
