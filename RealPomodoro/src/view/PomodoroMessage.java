package view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		setBackground(AppColors.APP_RED);
		
		final Dimension POMODORO_MESSAGE_DIMENSION = StartButton.BUTTON_DIMENSION;
		StyledViewFactory.forceComponentSize(this, POMODORO_MESSAGE_DIMENSION);
	}
	
	private void setLabel() {
		pomodoroMessageLabel = StyledViewFactory.createStyledLabel(15);
		final String POMODORO_MESSAGE = "Pomodoro time:";
		pomodoroMessageLabel.setText(POMODORO_MESSAGE);
	}
}
