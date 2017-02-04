package home_card_view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import home_view.AppColors;
import home_view.StyledViewFactory;
import utils.FileUtils;

public class PomodoroCounting extends JPanel {
	
	private Integer totalPomodoros;
	
	private JLabel countingText;
	private JLabel countingNumber;
	private RestartPomodoroCountingButton restartButton;
	
	private final String COUNTING_MESSAGE = "Pomodoros in this session: ";
	
	private final String POMODORO_HISTORY_FILE_NAME = "pomodoro_history.txt";
	private final String POMODORO_HISTORY_FOLDER = "src/history/";
	private final String HISTORY_FILE_PATH = POMODORO_HISTORY_FOLDER + POMODORO_HISTORY_FILE_NAME;
	
	public PomodoroCounting() {
		super();
		
		initPomodoroCounting();
		
		final int pomodorosLastSession = this.getPomodorosLastSession();
		setTotalPomodoros(pomodorosLastSession);
		
		updateText();
		
		setRestartButton();
	}
	
	private void updatePomodoros() {
		++totalPomodoros;
	}
	
	private void updateText() {
		final String currentPomodoros = totalPomodoros.toString();
		countingNumber.setText(currentPomodoros);
	}
	
	public void update() {
		updatePomodoros();
		updateText();
		saveCurrentPomodorosInFile();
	}
	
	public void restartPomodoros() {
		totalPomodoros = 0;
	}
	
	private int getPomodorosLastSession() {
		FileUtils fileUtils = new FileUtils();
		File pomodoroHistory = new File(HISTORY_FILE_PATH);
		if(!pomodoroHistory.exists()) {
			createPomodoroHistoryFile();
		}
		Integer pomodorosLastSession = 0;
		
		try {
			String lastLineHistory = fileUtils.getLastLineInFile(pomodoroHistory);
			assert (lastLineHistory != null) : "Last line in history is null.";
			assert (!lastLineHistory.isEmpty()) : "Last line in history is empty.";
			
			pomodorosLastSession = new Integer(lastLineHistory);
			
		} catch (IOException e) {
			pomodorosLastSession = 0;
			final String CANT_READ_HISTORY_MESSAGE = "Can't read pomodoro history. Total pomodos will be set to zero";
			System.out.println(CANT_READ_HISTORY_MESSAGE);
		}
		return pomodorosLastSession;
	}
	
	private void saveCurrentPomodorosInFile() {
		final int currentPomodoros = getTotalPomodoros();
		final String pomodorosString = Integer.toString(currentPomodoros);
		System.out.printf("totalPomodoros = %d\n", currentPomodoros);
		System.out.println("pomodorosString = " + pomodorosString);
		
		File pomodoroFile = new File(HISTORY_FILE_PATH);
		
		FileUtils fileUtils = new FileUtils();
		fileUtils.updateLastLine(pomodoroFile, pomodorosString);
	}
	
	private int getTotalPomodoros() {
		return totalPomodoros;
	}
	
	private void createPomodoroHistoryFile() {
		try{
		    PrintWriter writer = new PrintWriter(HISTORY_FILE_PATH, "UTF-8");
		    writer.println("0");
		    writer.close();
		} catch (IOException e) {
		   System.out.println("Can't create file: " + HISTORY_FILE_PATH);
		}
	}
	
	private void initPomodoroCounting() {
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		setBackground(AppColors.HOME_BACKGROUND);
		
		initLabels();
		add(countingText);
		add(countingNumber);
	}
	
	private void initLabels() {
		final int COUNTING_TEXT_FONT_SIZE = 15;
		countingText = StyledViewFactory.createStyledLabel(COUNTING_MESSAGE, COUNTING_TEXT_FONT_SIZE);
		
		final int COUNTING_NUMBER_FONT_SIZE = 17;
		countingNumber = StyledViewFactory.createStyledLabel("", COUNTING_NUMBER_FONT_SIZE);
	}
	
	private  void setRestartButton() {
		this.restartButton = new RestartPomodoroCountingButton();
		this.add(Box.createRigidArea(new Dimension(50, 0)));
		this.add(restartButton);
	}
	
	private void setTotalPomodoros(final int count) {
		this.totalPomodoros = count;
	}
}
