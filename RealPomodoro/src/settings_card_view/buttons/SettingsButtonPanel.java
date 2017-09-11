package settings_card_view.buttons;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import home_view.AppColors;
import home_view.Home;
import home_view.StyledViewFactory;

public class SettingsButtonPanel extends JPanel {
	
	private ResetTimerButton resetTimerButton;
	private DailyCountResetButton dailyCountResetButton;
	private WeeklyCountResetButton weeklyCountResetButton;
	
	private final int PANEL_X_SIZE = (int) (Home.HOME_X_SIZE * 0.84F);
	private final int PANEL_Y_SIZE = 100;
	
	private final Dimension DIMENSION = new Dimension(PANEL_X_SIZE, PANEL_Y_SIZE);
	
	private StyledButton[] allButtons;

	private Home home;
	
	public SettingsButtonPanel(final Home home) {
		super();
		
		setHome(home);
		
		setSettingsButtonPanel();
		createButtons();
		addButtons();
	}

	private void setSettingsButtonPanel() {
		this.setBackground(AppColors.HOME_BACKGROUND);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		StyledViewFactory.forceComponentSize(this, DIMENSION);
	}
	
	private void createButtons() {
		resetTimerButton = new ResetTimerButton(getHome());
		dailyCountResetButton = new DailyCountResetButton(home.getPomodoroCounting());
		weeklyCountResetButton = new WeeklyCountResetButton();
		
		allButtons = new StyledButton[]{resetTimerButton,
										dailyCountResetButton,
										weeklyCountResetButton};
		
		for(StyledButton button : allButtons) {
			button.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
	}
	
	
	private void addButtons() {
		StyledViewFactory.addPad(this, 0, 8);
		for(StyledButton button : allButtons) {
			this.add(button); 
			StyledViewFactory.addPad(this, 0, 8);
		}
	}
	
	private void setHome(Home home) {
		this.home = home;
	}
	
	private Home getHome() {
		return home;
	}
}
