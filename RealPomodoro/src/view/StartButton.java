package view;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

public class StartButton extends JButton {
	
	final static String START_BUTTON_NAME = "START";
	
	private static final long serialVersionUID = -6839276097281926270L;
	
	public StartButton() {
		super(START_BUTTON_NAME);
	
		setMnemonic(KeyEvent.VK_SPACE); // Pressing SPACE will have the same result as clicking the button
		setActionCommand(START_BUTTON_NAME);
		
		setBackground(Color.GRAY);
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setOpaque(true);

	}
}
