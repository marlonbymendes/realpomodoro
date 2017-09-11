package settings_card_view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import home_card_view.PomodoroCounting;

public class DailyCountResetButton extends StyledButton {
	
	private final static String LABEL = "Daily count";
	private final static float X_SIZE_PROPORTION = 0.35F;
	private final static int Y_SIZE = 25;
	
	private PomodoroCounting pomodoroCounting;
	


	public DailyCountResetButton(final PomodoroCounting pomodoroCounting) {
		super(LABEL, X_SIZE_PROPORTION, Y_SIZE);
		
		setPomodoroCounting(pomodoroCounting);
		this.addActionListener(new Listener());
	}

	private class Listener implements ActionListener {

		public void actionPerformed(final ActionEvent event) {
			System.out.println("Reset daily count");
			getPomodoroCounting().startNewSession();
		}
	}
	
	private PomodoroCounting getPomodoroCounting() {
		return pomodoroCounting;
	}

	private void setPomodoroCounting(PomodoroCounting pomodoroCounting) {
		this.pomodoroCounting = pomodoroCounting;
	}
	
}
