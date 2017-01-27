package view;

import java.awt.Font;

import javax.swing.JPanel;

import input_validation.IntegerTextField;

public class SettingsCard extends JPanel {
	
	private IntegerTextField timeInput; 

	public SettingsCard() {
		super();
		
		setSettingsCard();
		setTimeInput();
	}
	
	private void setSettingsCard() {
		setBackground(AppColors.HOME_BACKGROUND);
	}
	
	private void setTimeInput() {

		timeInput = new IntegerTextField();
		timeInput.setColumns(2);
		
		
		final Font digitFont = new Font(FontConstants.APP_FONT_NAME,
				FontConstants.APP_FONT_STYLE, FontConstants.TIMEPAD_DIGIT_SIZE);
		timeInput.setFont(digitFont);
		timeInput.setBackground(AppColors.HOME_BACKGROUND);
		timeInput.setForeground(AppColors.TIME_PAD_DIGITS);

		add(timeInput);
	}
}
