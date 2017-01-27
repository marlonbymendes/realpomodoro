package view;

import java.awt.FlowLayout;
import java.awt.Font;

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
		countingText = createStyledLabel(COUNTING_TEXT_FONT_SIZE);
		countingText .setText(COUNTING_MESSAGE);
		
		final int COUNTING_NUMBER_FONT_SIZE = 17;
		countingNumber = createStyledLabel(COUNTING_NUMBER_FONT_SIZE);
	}
	
	private JLabel createStyledLabel(final int fontSize) {
		JLabel label = new JLabel();
		label.setOpaque(true);
		label.setBackground(AppColors.HOME_BACKGROUND);
		final Font digitFont = new Font(FontConstants.APP_FONT_NAME,
				FontConstants.APP_FONT_STYLE, fontSize);
		label.setFont(digitFont);
		label.setForeground(AppColors.TIME_PAD_DIGITS);
		return label;
	}
}
