package view;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SettingsButton extends JButton {
	
	private Home home;
	
	public SettingsButton(final Home home) {
		super();
		
		setHome(home);
		initButton();
	}
	
	private void initButton() {
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setOpaque(true);
		setBackground(AppColors.HOME_BACKGROUND);
		
		setMargin(new Insets(0, 0, 0, 0));
		
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
			home.showSettingsCard();
		}
	}
	
	private void setHome(final Home home) {
		this.home = home;
	}
}
