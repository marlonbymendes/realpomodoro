package home_view;

import java.awt.CardLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;

import home_card_view.HomeCard;
import home_card_view.PomodoroCounting;
import pomodoro.PomodoroTimer;
import settings_card_view.SettingsCard;

public class Home extends JFrame {

	private SettingsCard settingsCard;
	private HomeCard homeCard;

	private static final String HOME_TITLE = "RealPomodoro";
	private final String SETTINGS_CARD = "SettingsCard";

	public static final int HOME_X_SIZE = 350;
	public static final int HOME_Y_SIZE = 550;

	public Home() {
		super(HOME_TITLE);
		
		setHomeFrame();
	}

	private void setHomeFrame() {
		initHomeFrame();
		setHomeBorder();
		setHomeCard();
		setSettingsCard();

		add(homeCard, HOME_TITLE);
		add(settingsCard, SETTINGS_CARD);
	}

	private void initHomeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		setLayout(new CardLayout());
	}

	public void showHome() {
		pack();
		setVisible(true);
	}

	private void setHomeBorder() {
		Border border = BorderFactory.createLineBorder(AppColors.HOME_BACKGROUND, 10);
		getRootPane().setBorder(border);
	}

	private void setHomeCard() {
		homeCard = new HomeCard(this);
	}
	
	private void setSettingsCard() {
		settingsCard = new SettingsCard(this);
	}
			
	public void showSettingsCard() {
		 CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
		 cardLayout.show(getContentPane(), SETTINGS_CARD);
	}
	
	public void showHomeCard() {
		 CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
		 cardLayout.show(getContentPane(),  HOME_TITLE);
	}
	
	public boolean isAutoRunEnabled() {
		return settingsCard.isAutoRunEnabled();
	}
	
	public PomodoroTimer getPomodoroTimer() {
		return homeCard.getPomodoroTimer();
	}
	
	public void setPomodoroTimer(final int minutes, final int seconds) {
		homeCard.setPomodoroTimer(minutes, seconds);
	}
	
	public boolean isPomodoroRunning() {
		return homeCard.isPomodoroRunning();
	}
	
	public HomeCard getHomeCard() {
		return this.homeCard;
	}
	
	public PomodoroCounting getPomodoroCounting() {
		return this.getHomeCard().getPomodoroCounting();
	}
}
