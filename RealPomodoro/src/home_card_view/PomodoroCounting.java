package home_card_view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import home_view.AppColors;
import home_view.StyledViewFactory;
import utils.PomodoroHistoryFileUtilities;

public class PomodoroCounting extends JPanel {
	
	
	private final int COUNTING_TEXT_FONT_SIZE = 15;
	private final int COUNTING_NUMBER_FONT_SIZE = 17;

	private JPanel verticalPanel;
	
	private JPanel dailyPanel;
	private Integer dailyPomodoros;
	private JLabel dailyCountText;
	private JLabel dailyCount;
	private final String DAILY_COUNTING_MESSAGE = "Pomodoros today: ";
	
	private JPanel weeklyPanel;
	private JLabel weeklyCountText;
	private JLabel weeklyCount;
	private Integer weeklyPomodoros;
	private static final String WEEKLY_COUNTING_MESSAGE = "Pomodoros this week: ";

	public PomodoroCounting() {
		super();
		
		PomodoroHistoryFileUtilities.preparePomodoroHistoryFiles();
		initPomodoroCounting();
		
		setPomodoroCountingStyle();
		
		final int savedDailyCount = PomodoroHistoryFileUtilities.getPomodorosLastSession();
		setDailyPomodoros(savedDailyCount);
		
		final int savedWeeklyCount = PomodoroHistoryFileUtilities.getSavedWeeklyPomodorosCounting();
		setWeeklyPomodoros(savedWeeklyCount);
		
		updateText();
	}
	
	private void setPomodoroCountingStyle() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		this.setBackground(AppColors.HOME_BACKGROUND);
	}
	
	private void setDailyPanel() {
		dailyPanel = new JPanel();
		dailyPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		dailyPanel.setBackground(AppColors.HOME_BACKGROUND);
		
		initDailyLabels();
		
		dailyPanel.add(dailyCountText);
		dailyPanel.add(dailyCount);
		dailyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
	}
	
	private void setWeeklyPanel() {
		weeklyPanel = new JPanel();
		weeklyPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		weeklyPanel.setBackground(AppColors.HOME_BACKGROUND);
		
		initWeeklyLabels();
		
		weeklyPanel.add(weeklyCountText);
		weeklyPanel.add(weeklyCount);
		weeklyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
	}
	
	
	private void setVerticalPanel() {
		verticalPanel = new JPanel();
		verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
		verticalPanel.setBackground(AppColors.HOME_BACKGROUND);
		
		addComponentsToVerticalPanel();
		
		this.add(verticalPanel);
	}
	
	private void addComponentsToVerticalPanel() {
		verticalPanel.add(dailyPanel);
		verticalPanel.add(Box.createRigidArea(new Dimension(0, 7)));
		verticalPanel.add(weeklyPanel);
	}
	
	public void resetDailyCounting() {
		setDailyPomodoros(0);
		updateText();
		PomodoroHistoryFileUtilities.createSessionInHistory();
	}
	
	public void resetWeeklyCounting() {
		setWeeklyPomodoros(0);
		updateText();
		PomodoroHistoryFileUtilities.createNewWeeklyCounting();
	}
	
	public void update() {
		updatePomodorosCounting();
		updateText();
		saveCurrentPomodorosInFile();
	}
	
	public void restartPomodoros() {
		dailyPomodoros = 0;
		weeklyPomodoros = 0;
	}

	private void updatePomodorosCounting() {
		++dailyPomodoros;
		++weeklyPomodoros;
	}
	
	private void updateText() {
		final String daily = dailyPomodoros.toString();
		dailyCount.setText(daily);
		
		final String weekly = weeklyPomodoros.toString();
		weeklyCount.setText(weekly);
	}
	
	private void saveCurrentPomodorosInFile() {
		final Integer dailyPomodoros = getDailyPomodoros();
		PomodoroHistoryFileUtilities.updateHistoryLastLine(dailyPomodoros.toString());
		
		final Integer weeklyPomodoros = getWeeklyPomodoros();
		PomodoroHistoryFileUtilities.updateWeeklyPomodorosCounting(weeklyPomodoros.toString());
	}
	
	private Integer getWeeklyPomodoros() {
		return this.weeklyPomodoros;
	}

	private int getDailyPomodoros() {
		return dailyPomodoros;
	}
	
	private void initPomodoroCounting() {
		setDailyPanel();
		setWeeklyPanel();
		setVerticalPanel();
	}

	private void initDailyLabels() {
		dailyCountText = StyledViewFactory.createStyledLabel(DAILY_COUNTING_MESSAGE, COUNTING_TEXT_FONT_SIZE);
		dailyCount = StyledViewFactory.createStyledLabel("", COUNTING_NUMBER_FONT_SIZE);
	}
	
	private void initWeeklyLabels() {		
		weeklyCountText = StyledViewFactory.createStyledLabel(WEEKLY_COUNTING_MESSAGE, COUNTING_TEXT_FONT_SIZE);
		weeklyCount = StyledViewFactory.createStyledLabel("", COUNTING_NUMBER_FONT_SIZE);
	}


	private void setDailyPomodoros(final int count) {
		this.dailyPomodoros = count;
	}

	private void setWeeklyPomodoros(final int count) {
		this.weeklyPomodoros = count;
	}

}
