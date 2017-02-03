package home_card_view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import home_view.AppColors;
import home_view.StyledViewFactory;

public class PomodoroCounting extends JPanel {
	
	private Integer totalPomodoros;
	
	private JLabel countingText;
	private JLabel countingNumber;
	private RestartPomodoroCountingButton restartButton;
	
	private final String COUNTING_MESSAGE = "Pomodoros in this session: ";
	
	public PomodoroCounting() {
		super();
		
		initPomodoroCounting();
		totalPomodoros = 0;
		updateText();
		
		setRestartButton();
	}
	
	private void updatePomodoros() {
		++totalPomodoros;
	}
	
	private void updateText() {
		final String currentPomodoros = totalPomodoros.toString();
		countingNumber.setText(currentPomodoros);
	}
	
	public void update() {
		updatePomodoros();
		updateText();
	}
	
	private void initPomodoroCounting() {
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		setBackground(AppColors.HOME_BACKGROUND);
		
		initLabels();
		add(countingText);
		add(countingNumber);
	}
	
	private void initLabels() {
		final int COUNTING_TEXT_FONT_SIZE = 15;
		countingText = StyledViewFactory.createStyledLabel(COUNTING_MESSAGE, COUNTING_TEXT_FONT_SIZE);
		
		final int COUNTING_NUMBER_FONT_SIZE = 17;
		countingNumber = StyledViewFactory.createStyledLabel("", COUNTING_NUMBER_FONT_SIZE);
	}
	
	private  void setRestartButton() {
		this.restartButton = new RestartPomodoroCountingButton();
		this.add(Box.createRigidArea(new Dimension(30 + 26, 0)));
		this.add(restartButton);
	}
}
