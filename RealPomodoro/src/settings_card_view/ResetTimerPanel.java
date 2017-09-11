package settings_card_view;

import java.awt.Color;
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
	
	private StyledButton restartTimerButton;
	
	public ResetTimerPanel() {
		super();
		
		setRestartTimerPanel();
		setRestartTimerButton();
		addButtons();
	}
	
	private void setRestartTimerPanel() {
		new JPanel();
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		setBackground(AppColors.HOME_BACKGROUND);
	}
	
	private void setRestartTimerButton() {
		final float xProportion = 0.35F;
		final int ySize = 25;
		final String label = "Reset timer";
		
		restartTimerButton = new StyledButton(label, xProportion, ySize);
	}
	
	private void addButtons() {
		this.add(restartTimerButton);
	}
}
