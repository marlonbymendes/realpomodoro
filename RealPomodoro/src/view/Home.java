package view;

import java.awt.CardLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;

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
		 settingsCard.setFocusInMinutesText();
	}
	
	public void showHomeCard() {
		 System.out.println("Home card opened.");
		 CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
		 cardLayout.show(getContentPane(),  HOME_TITLE);
	}
	
	public boolean isAutoRunEnabled() {
		return settingsCard.isAutoRunEnabled();
	}
}
