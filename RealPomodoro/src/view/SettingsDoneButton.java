package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SettingsDoneButton extends JButton {
	
	private Home home;
	
	private static final String DONE_BUTTON_TEXT = "DONE";
	
	public SettingsDoneButton(final Home home) {
		super(DONE_BUTTON_TEXT);
		setHome(home);
		
		setSettingsDoneButtonSyle();
		addActionListener(new ButtonListener());
	}
	
	private void setSettingsDoneButtonSyle() {
		StyledViewFactory.setButtonStyle(this);
		
		setFontStyle();
		setBackground(AppColors.APP_GREEN);
	}
	
	private void setFontStyle() {
		final int fontSize = 17;
		final Font font = new Font(FontConstants.APP_FONT_NAME, FontConstants.APP_FONT_STYLE, fontSize);
		setFont(font);
		setForeground(AppColors.TIME_PAD_DIGITS);
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(final ActionEvent event) {
			if(home == null) {
				System.out.println("HOME IS NULL!");
			}
			home.showHomeCard();
		}
	}
	
	private void setHome(final Home home) {
		this.home = home;
	}
}
