package home_card_view;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

import home_view.AppColors;

public class RestartPomodoroCountingButton extends JButton {
	
	private PomodoroCounting pomodoroCounting;

	public RestartPomodoroCountingButton(final PomodoroCounting pomodoroCounting) {
		super();
		setPomodoroCounting(pomodoroCounting);
		
		initButton();
	}
	
	private void initButton() {
		setFocusPainted(false);
		setContentAreaFilled(false);
		setOpaque(true);
		setBackground(AppColors.HOME_BACKGROUND);
		
		setMargin(new Insets(0, 0, 0, 0));
		
		addActionListener(new RestartButtonListener());
		setRestartIcon();
		Border border = BorderFactory.createLineBorder(AppColors.TIME_PAD_DIGITS, 1);
		this.setBorder(border);
		
	}
	
	private void setRestartIcon() {
		final String ICON_FILE_NAME = "restart_counting.png";
		try {
			ImageIcon imageIcon = (new AppColors()).createIconFromResources(ICON_FILE_NAME);
			setIcon(imageIcon);
			
		} catch (Exception ex) {
		    System.out.println("Can't load icon with name: " + ICON_FILE_NAME);
		}
	}
	
	private class RestartButtonListener implements ActionListener {

		public void actionPerformed(final ActionEvent event) {
			System.out.println("Restart pomodoro counting button was clicked.");
			pomodoroCounting.startNewSession();
		}
	}
	
	private void setPomodoroCounting(final PomodoroCounting pomodoroCounting) {
		this.pomodoroCounting = pomodoroCounting;
	}
}