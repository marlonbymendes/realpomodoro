package settings_card_view.buttons;

public class DailyCountResetButton extends StyledButton {
	
	private final static String LABEL = "Daily count";
	private final static float X_SIZE_PROPORTION = 0.35F;
	private final static int Y_SIZE = 25;
	
	public DailyCountResetButton() {
		super(LABEL, X_SIZE_PROPORTION, Y_SIZE);
	}

}
