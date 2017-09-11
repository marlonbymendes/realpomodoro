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
		} catch (FileNotFoundException e) {
			prepared = false;
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			prepared = false;
			e.printStackTrace();
		}
		assert prepared;
	}
	
	
	public static int getPomodorosLastSession() {
		FileUtils fileUtils = new FileUtils();
		File pomodoroHistory = new File(POMODORO_HISTORY_PATH);
		assert pomodoroHistory.exists();

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
	
	
	public static void createSessionInHistory() {
		File pomodoroFile = new File(POMODORO_HISTORY_PATH);
		FileUtils fileUtils = new FileUtils();
		fileUtils.appendToFile(pomodoroFile, "0");
	}
	
}
