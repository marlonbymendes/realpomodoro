package view;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PomodoroCounting extends JPanel {
	
	private Integer totalPomodoros;
	
	private JLabel countingText;
	private JLabel countingNumber;
	
	private final String COUNTING_MESSAGE = "Pomodoros in this session: ";
	
	public PomodoroCounting() {
		super();
		initPomodoroCounting();
		totalPomodoros = 0;
		updateText();
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
		countingText = StyledViewFactory.createStyledLabel(COUNTING_TEXT_FONT_SIZE);
		countingText .setText(COUNTING_MESSAGE);
		
		final int COUNTING_NUMBER_FONT_SIZE = 17;
		countingNumber = StyledViewFactory.createStyledLabel(COUNTING_NUMBER_FONT_SIZE);
	}
}
