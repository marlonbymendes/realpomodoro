package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SettingsButton extends JButton {
	
	
	public SettingsButton() {
		super();
		
		initButton();
	}
	
	private void initButton() {
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setOpaque(true);
		setBackground(AppColors.HOME_BACKGROUND);
		
		final int BUTTON_X_DIMENSION = 40;
		final int BUTTON_Y_DIMENSION = 40;
		final Dimension buttonDimension = new Dimension(BUTTON_X_DIMENSION, BUTTON_Y_DIMENSION);
		setMinimumSize(buttonDimension);
		setMaximumSize(buttonDimension);
		
		addActionListener(new SettingsButtonListener());
		setSettingsIcon();
		
	}
	
	private void setSettingsIcon() {
		final String settingsIconName = "settings.png";
		try {
			ImageIcon imageIcon = (new AppColors()).createIconFromResources(settingsIconName);
			setIcon(imageIcon);
			
		} catch (Exception ex) {
		    System.out.println("Can't load icon with name: " + settingsIconName);
		}
	}
	
	private class SettingsButtonListener implements ActionListener {

		public void actionPerformed(final ActionEvent event) {
			System.out.println("Settings opened.");
		}
	}
}
