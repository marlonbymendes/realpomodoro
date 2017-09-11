package settings_card_view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetTimerButton extends StyledButton {
	
	private final static String LABEL = "Timer";
	private final static float X_SIZE_PROPORTION = 0.35F;
	private final static int Y_SIZE = 25;
	
	public ResetTimerButton() {
		super(LABEL, X_SIZE_PROPORTION, Y_SIZE);
		
		this.addActionListener(new Listener());
	}
	
	private class Listener implements ActionListener {

		public void actionPerformed(final ActionEvent event) {
			System.out.println("Reset timer");
		}
	}
}
