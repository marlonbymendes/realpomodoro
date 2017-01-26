package view;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PomodoroCounting extends JPanel {
	
	private static final long serialVersionUID = -4932117620137377822L;
	private Integer totalPomodoros;
	
	private JLabel countingText;
	private JLabel countingNumber;
	
	private final String countingMessage = "Pomodoros in this session: ";
	
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
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBackground(AppColors.HOME_BACKGROUND);
		
		initLabels();
		add(countingText);
		add(countingNumber);
	}
	
	private void initLabels() {
		countingText = createStyledLabel();
		countingText.setText(countingMessage);
		
		countingNumber = createStyledLabel();
	}
	
	private JLabel createStyledLabel() {
		JLabel label = new JLabel();
		label.setOpaque(true);
		label.setBackground(AppColors.HOME_BACKGROUND);
		final Font digitFont = new Font(FontConstants.APP_FONT_NAME,
				FontConstants.APP_FONT_STYLE, 15);
		label.setFont(digitFont);
		label.setForeground(AppColors.TIME_PAD_DIGITS);
		return label;
	}
}
