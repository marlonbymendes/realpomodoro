package main;

import java.io.IOException;

import home_view.Home;
import utils.FileUtils;

public class Main {

	public static void main(String[] args)  throws IOException {
		// TODO Auto-generated method stub
		
		Home home = new Home();
		home.showHome();
		
		FileUtils fileReader = new FileUtils();
		final String fileTestName = "file_test.txt";
		final String output = fileReader.getStringInResourcesFile(fileTestName);
		System.out.println(output);
	}
}
