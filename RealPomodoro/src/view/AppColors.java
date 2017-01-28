package view;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class AppColors {

	final static Color HOME_BACKGROUND = Color.decode("#34495E");
	final static Color TIME_PAD_DIGITS = Color.decode("#ECF0F1");
	
	final static Color APP_GREEN = Color.decode("#2ecc71");
	final static Color APP_RED = Color.decode("#e74c3c");
	public static final Color DARK_GRAY = Color.decode("#37474F");
	
	public AppColors() {
			
	}
	
	public ImageIcon createIconFromResources(final String fileName) throws IOException {
		final String iconsFolder = "resources/icons/";
		final String filePath = iconsFolder + fileName;
		
		ClassLoader classLoader = getClass().getClassLoader();
		Image image = ImageIO.read(classLoader.getResource(filePath));
		ImageIcon imageIcon = new ImageIcon(image);
		
		return imageIcon;
	}
}
