package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileUtils {

	
	public ArrayList<String> getStringInResourcesFile(final File file) {  
	  FileInputStream inputStream = null;  
	  ArrayList<String> stringInFile = new ArrayList<String>();
	    
	  try {
		  inputStream = new FileInputStream(file);  
	   
		  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));  
		  while (true) {
			  final String nextLine = reader.readLine();
			  if(nextLine == null) {
				  break;
			  }
			  stringInFile.add(nextLine);
		  }
		  reader.close();  
	  } catch (IOException e) {
		  System.out.println("Can't read file " + file.getName()); 
	  }  
	  finally {  
		  try {
			  inputStream.close();
		  }
		  catch(IOException exception) {
			  System.out.println("Can't read file " + file.getName());
		  }
	  }
	  
	  return stringInFile;
	}
	
	public File getFileFromResources(final String fileName) {
		  final ClassLoader classLoader = this.getClass().getClassLoader();    
		  final String filePath = "resources/" + fileName;
		  final File file = new File(classLoader.getResource(filePath).getFile());  
		  
		  return file;
	}
	
	
	public static String getLastLineInFile(final File file) throws IOException {
		FileInputStream inputStream = null;  
		inputStream = new FileInputStream(file);
		
		StringBuilder lastLine = new StringBuilder();
		   
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));  
		while (true) {
			final String nextLine = reader.readLine();
			if(nextLine == null) {
				break;		
			}
			lastLine = new StringBuilder(nextLine);  
		}
		reader.close();  
		return lastLine.toString();
	}
	
	public void removeLastLineInFile(final File file) {
		ArrayList<String> currentString = getStringInResourcesFile(file);
		currentString.remove(currentString.size() - 1);
		appendToFile(file, currentString, false);
	}
	
	public void updateLastLine(final File file, final String newText) {
		removeLastLineInFile(file);
		appendToFile(file, newText);
	}
	
	
	public void appendToFile(final File file, final String line) {
		ArrayList<String> lineArrayList = new ArrayList<String>();
		lineArrayList.add(line);
		appendToFile(file, lineArrayList, true);
	}
	
	public static void appendToFile(final File file, final ArrayList<String> text, final boolean append) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter out = null;
		final String FILE_NAME = file.getName();
		
		try {
		    fw = new FileWriter(file, append);
		    bw = new BufferedWriter(fw);
		    out = new PrintWriter(bw);
		    
		    for(String line : text)
		    	out.println(line);
		    out.close();
		} catch (IOException e) {
			final String CANT_OPEN_FILE_MESSAGE = "the file [" + FILE_NAME + "] is a directory or can't be opened for some reason.";
		    System.out.println(CANT_OPEN_FILE_MESSAGE);
		}
		finally {
			final String CLOSE_FAIL_MESSAGE = "Can't close the file " + FILE_NAME + " properly.";
		    if(out != null)
		            out.close();
		    try {
		        if(bw != null)
		            bw.close();
		    } catch (IOException e) {
		       	System.out.println(CLOSE_FAIL_MESSAGE);
		    }
		    try {
		        if(fw != null)
		            fw.close();
		    } catch (IOException e) {
		    	System.out.println(CLOSE_FAIL_MESSAGE);
		    }
		}
	}
}
