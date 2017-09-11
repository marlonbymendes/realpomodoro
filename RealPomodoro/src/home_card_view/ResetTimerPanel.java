package home_card_view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import home_view.AppColors;
import home_view.Home;
import home_view.StyledViewFactory;

public class ResetTimerPanel extends JPanel {
	
	public ResetTimerPanel() {
		super();
		
		setRestartTimerPanel();
	}
	
	private void setRestartTimerPanel() {
		new JPanel();
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		setBackground(AppColors.HOME_BACKGROUND);
		
		ResetTimerButton restartTimerButton = new ResetTimerButton();
		add(restartTimerButton);
	}

	
	private class ResetTimerButton extends JButton {
		
		private final static String BUTTON_LABEL = "Reset timer";
		
		public ResetTimerButton() {
			super(BUTTON_LABEL);

			initButton();
		}
		
		private void initButton() {
			setBorderPainted(true);
			setFocusPainted(false);
			setContentAreaFilled(false);
			setOpaque(true);
			setBackground(AppColors.HOME_BACKGROUND);
			setMargin(new Insets(0, 0, 0, 0));
			StyledViewFactory.setWhiteBorder(this);
			setFont(StyledViewFactory.DEFAULT_FONT);
			setForeground(AppColors.TIME_PAD_DIGITS);
			
			setButtonStyle();
			
			addActionListener(new ResetTimerButtonListener());
			
		}
		
		private void setButtonStyle() {
			final int BUTTON_X_DIMENSION = (int) (Home.HOME_X_SIZE * 0.35);
			final int BUTTON_Y_DIMENSION = 25;
			final Dimension buttonDimension = new Dimension(BUTTON_X_DIMENSION, BUTTON_Y_DIMENSION);
			StyledViewFactory.forceComponentSize(this, buttonDimension);
		}

		private class ResetTimerButtonListener implements ActionListener {

			public void actionPerformed(final ActionEvent event) {
				System.out.println("RESET TIMER!");
			}
		}
	}
}
