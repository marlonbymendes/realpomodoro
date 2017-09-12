package settings_card_view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import home_card_view.PomodoroCounting;

public class WeeklyCountResetButton extends StyledButton {
	
	private final static String LABEL = "Weekly count";
	private final static float X_SIZE_PROPORTION = 0.35F;
	private final static int Y_SIZE = 25;
	
	private PomodoroCounting pomodoroCounting;
	
	public WeeklyCountResetButton(final PomodoroCounting pomodoroCounting) {
		super(LABEL, X_SIZE_PROPORTION, Y_SIZE);
		
		setPomodoroCounting(pomodoroCounting);
		this.addActionListener(new Listener());

	}

	private class Listener implements ActionListener {

		public void actionPerformed(final ActionEvent event) {
			System.out.println("Reset weekly count");
			getPomodoroCounting().resetWeeklyCounting();
		}
	}
	
	private PomodoroCounting getPomodoroCounting() {
		return pomodoroCounting;
	}

	private void setPomodoroCounting(PomodoroCounting pomodoroCounting) {
		this.pomodoroCounting = pomodoroCounting;
	}
}
