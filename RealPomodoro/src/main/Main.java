package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import home_view.Home;
import utils.FileUtils;

public class Main {

	public static void main(String[] args)  throws IOException {
		// TODO Auto-generated method stub
		
		Home home = new Home();
		home.showHome();
		
		FileUtils fileReader = new FileUtils();
		final String fileTestName = "file_test.txt";
		final File file = fileReader.getFileFromResources(fileTestName);
		FileUtils fileUtils = new FileUtils();
	
		//fileUtils.appendToFile(file, "ONE MORE LINE");
		ArrayList<String> output = fileReader.getStringInResourcesFile(file);
		for(String line : output) {
			System.out.println(line);
		}
		
		System.out.println("");
		fileUtils.updateLastLine(file, "@@@@");
	}



}
	