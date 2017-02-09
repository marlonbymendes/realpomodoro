package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class PomodoroHistoryFileUtilities {

	private final static String USER_HOME = System.getProperty("user.home");
	private final static String SEPARATOR = File.separator;
	
	private final static String POMODORO_FOLDER_NAME = "RealPomodoro";
	private final static String POMODORO_FOLDER_PATH = USER_HOME + SEPARATOR + POMODORO_FOLDER_NAME;
	
	private final static String POMODORO_HISTORY_NAME = "pomodoro_history.txt";
	private final static String POMODORO_HISTORY_PATH = POMODORO_FOLDER_PATH + SEPARATOR + POMODORO_HISTORY_NAME;

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

	public static void preparePomodoroHistoryFile() {
		boolean prepared = true;
		try {
			createPomodoroFolder();
			createPomodoroHistoryFile();
		} catch (FileNotFoundException e) {
			prepared = false;
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			prepared = false;
			e.printStackTrace();
		}
		assert prepared;
	}
}
