package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import pomodoro.PomodoroConstants;

public class PomodoroHistoryFileUtilities {

	private final static String USER_HOME = System.getProperty("user.home");
	private final static String SEPARATOR = File.separator;
	
	private final static String POMODORO_FOLDER_NAME = "RealPomodoro";
	private final static String POMODORO_FOLDER_PATH = USER_HOME + SEPARATOR + POMODORO_FOLDER_NAME;
	
	private final static String POMODORO_HISTORY_NAME = "pomodoro_history.txt";
	private final static String POMODORO_HISTORY_PATH = POMODORO_FOLDER_PATH + SEPARATOR + POMODORO_HISTORY_NAME;
	
	private final static String POMODORO_LAST_TIME_NAME = "pomodoro_last_time.txt";
	private final static String POMODORO_LAST_TIME_PATH = POMODORO_FOLDER_PATH + SEPARATOR + POMODORO_LAST_TIME_NAME;
	
	private final static String POMODORO_WEEKLY_COUNTING_NAME = "pomodoro_weekly_counting.txt";
	private final static String POMODORO_WEEKLY_COUNTING_PATH = POMODORO_FOLDER_PATH
															  + SEPARATOR
															  + POMODORO_WEEKLY_COUNTING_NAME;
	
	
	/**
	 * Creates pomodoro folder if it doesn't exist yet
	 * @throws FileNotFoundException if folder didn't exist but couldn't create it
	 */
	public static void createPomodoroFolder() throws FileNotFoundException {
		File pomodoroFolder = new File(POMODORO_FOLDER_PATH);
		if (!pomodoroFolder.exists()) {
			final boolean folderCreated = pomodoroFolder.mkdirs();
			if (!folderCreated) {
				throw new FileNotFoundException();
			}
			else {
				System.out.println("Pomodoro history folder created.");
			}
		}
	}

	/**
	 * Creates pomodoro history file if it doesn't exist yet
	 * @throws FileNotFoundException if file didn't exist but couldn't create it
	 * @throws UnsupportedEncodingException
	 */
	public static void createPomodoroHistoryFile() throws FileNotFoundException,
														  UnsupportedEncodingException {
		File pomodoroFile = new File(POMODORO_HISTORY_PATH);
		if (!pomodoroFile.exists()) {
			PrintWriter writer = new PrintWriter(POMODORO_HISTORY_PATH, "UTF-8");
			writer.println("0");
			writer.close();
			System.out.println("Pomodoro history file created.");
		}
	}
	
	/**
	 * Creates pomodoro last time file if it doesn't exist yet
	 * @throws FileNotFoundException if file didn't exist but couldn't create it
	 * @throws UnsupportedEncodingException
	 */
	public static void createPomodoroLastTimeFile() throws FileNotFoundException,
	  UnsupportedEncodingException {
		File pomodoroFile = new File(POMODORO_LAST_TIME_PATH);
		if (!pomodoroFile.exists()) {
			PrintWriter writer = new PrintWriter(POMODORO_LAST_TIME_PATH, "UTF-8");
			
			final String POMODORO_TOTAL_TIME = PomodoroConstants.TOTAL_POMODORO_TIME_IN_SECONDS.toString();
			writer.println(POMODORO_TOTAL_TIME);
			writer.close();
			System.out.println("Pomodoro last time file created.");
		}
	}

	public static void preparePomodoroHistoryFiles() {
		boolean prepared = true;
		try {
			createPomodoroFolder();
			createPomodoroHistoryFile();
			createPomodoroLastTimeFile();
			createPomodoroWeeklyCountingFile();
		} catch (FileNotFoundException e) {
			prepared = false;
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			prepared = false;
			e.printStackTrace();
		}
		assert prepared;
	}
	
	
	/**
	 * Creates pomodoro weekly counting file if it doesn't exist yet
	 * @throws FileNotFoundException if file didn't exist but couldn't create it
	 * @throws UnsupportedEncodingException
	 */
	public static void createPomodoroWeeklyCountingFile() throws FileNotFoundException,
	  UnsupportedEncodingException {
		File pomodoroFile = new File(POMODORO_WEEKLY_COUNTING_PATH);
		if (!pomodoroFile.exists()) {
			PrintWriter writer = new PrintWriter(POMODORO_WEEKLY_COUNTING_PATH, "UTF-8");
			
			writer.println("0");
			writer.close();
			System.out.println("Pomodoro weekly counting file was created.");
		}
	}
	
	public static int getPomodorosLastSession() {
		Integer pomodorosLastSession = getIntegerInLastLine(POMODORO_HISTORY_PATH);
		return pomodorosLastSession;
	}
	
	public static int getSavedWeeklyPomodorosCounting() {
		Integer weeklyCount = getIntegerInLastLine(POMODORO_WEEKLY_COUNTING_PATH);
		return weeklyCount;
	}
	
	private static int getIntegerInLastLine(final String path) {
		FileUtils fileUtils = new FileUtils();
		File file = new File(path);
		assert file.exists();

		Integer integer = 0;		
		try {
			String lastLineHistory = fileUtils.getLastLineInFile(file);
			assert (lastLineHistory != null) : "Last line in file is null.";
			assert (!lastLineHistory.isEmpty()) : "Last line in file is empty.";
			
			integer = new Integer(lastLineHistory);
			
		} catch (IOException e) {
			integer = 0;
			final String CANT_READ_FILE_MESSAGE = "Can't read last line. It will be assumed as 0";
			System.out.println(CANT_READ_FILE_MESSAGE);
		}
		return integer;
	}
	
	public static int getLastPomodoroTime() {
		FileUtils fileUtils = new FileUtils();
		File pomodoroHistory = new File(POMODORO_LAST_TIME_PATH);
		assert pomodoroHistory.exists();

		
		Integer lastTime = 0;
		
		try {
			String lastLineHistory = fileUtils.getLastLineInFile(pomodoroHistory);
			assert (lastLineHistory != null) : "Last line in history is null.";
			assert (!lastLineHistory.isEmpty()) : "Last line in history is empty.";
			
			lastTime = new Integer(lastLineHistory);
			
		} catch (IOException e) {
			lastTime = PomodoroConstants.TOTAL_POMODORO_TIME_IN_SECONDS;
			final String CANT_READ_LAST_TIME_MESSAGE = "Can't read pomodoro last time file. Last time will be set to default";
			System.out.println(CANT_READ_LAST_TIME_MESSAGE);
		}
		
		return lastTime;
	}
	
	public static void updateHistoryLastLine(final String newLine) {
		File pomodoroFile = new File(POMODORO_HISTORY_PATH);
		FileUtils fileUtils = new FileUtils();
		fileUtils.updateLastLine(pomodoroFile, newLine);
	}
	
	public static void updateLastTimeFile(final Integer newTime) {
		File lastTimeFile = new File(POMODORO_LAST_TIME_PATH);
		FileUtils fileUtils = new FileUtils();
		fileUtils.updateLastLine(lastTimeFile, newTime.toString());
	}
	
	
	public static void createSessionInHistory() {
		File pomodoroFile = new File(POMODORO_HISTORY_PATH);
		FileUtils fileUtils = new FileUtils();
		fileUtils.appendToFile(pomodoroFile, "0");
	}
	
	public static int getMinutesInLastPomodoro() {
		final int totalTime = PomodoroHistoryFileUtilities.getLastPomodoroTime();
		final int minutes = totalTime / PomodoroConstants.SECONDS_IN_A_MINUTE;

		return minutes;
	}
	
	public static int getSecondsInLastPomodoro() {
		final int totalTime = PomodoroHistoryFileUtilities.getLastPomodoroTime();
		final int seconds = totalTime % PomodoroConstants.SECONDS_IN_A_MINUTE;
		return seconds;
	}

	public static void updateWeeklyPomodorosCounting(String string) {
		File pomodoroFile = new File(POMODORO_WEEKLY_COUNTING_PATH);
		FileUtils fileUtils = new FileUtils();
		fileUtils.updateLastLine(pomodoroFile, string);
	}

	public static void createNewWeeklyCounting() {
		File pomodoroFile = new File(POMODORO_WEEKLY_COUNTING_PATH);
		FileUtils fileUtils = new FileUtils();
		fileUtils.appendToFile(pomodoroFile, "0");
	}
}
