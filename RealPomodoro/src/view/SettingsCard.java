package view;

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
		timeInput.setColumns(20);

		add(timeInput);
	}
}
