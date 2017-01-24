package view;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimePad extends JPanel {

	JLabel twoPoints;
	JLabel timeDigits[];
	
	private static final long serialVersionUID = -7368579241109062499L;
	
	public TimePad() {
		super();
		
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		setAlignmentX(JPanel.CENTER_ALIGNMENT);
		
		addAllDigits();
	}
	
	private void initTimeDigits() {
		final int TIME_DIGITS_SIZE = 4;
		timeDigits = new JLabel[TIME_DIGITS_SIZE];
		
		for(int i = 0; i < timeDigits.length; ++i) {
			timeDigits[i] = new JLabel();
			timeDigits[i].setFont(new Font("Courier New", Font.PLAIN, 100));
			updateTimeDigit(i, 0);
		}
	}
	
	private void updateTimeDigit(final int index, final int digit) {
		final String digitString = Integer.toString(digit);
		timeDigits[index].setText(digitString);
	}
	
	private void initDigits() {
		initTimeDigits();
		setTwoPointsLabel();
	}
	
	private void setTwoPointsLabel() {
		final String TWO_POINTS = ":";
		twoPoints = new JLabel(TWO_POINTS);
		twoPoints.setFont(new Font("Courier New", Font.PLAIN, 100));
	}
	
	private void addAllDigits() {
		initDigits();
		
		final int MINUTES_SIZE = 2;
		for(int i = 0; i < MINUTES_SIZE; ++i) {
			add(timeDigits[i]);
		}
		
		add(twoPoints);
		
		final int SECONDS_START = 2;
		final int SECONDS_ENDING = 4;
		for(int i = SECONDS_START; i < SECONDS_ENDING; ++i) {
			add(timeDigits[i]);
		}
	}
}
