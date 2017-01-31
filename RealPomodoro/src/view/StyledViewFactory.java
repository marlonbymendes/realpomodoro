package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class StyledViewFactory {
	
	public static int DEFAULT_FONT_SIZE = 15;
	public static Font DEFAULT_FONT = new Font(FontConstants.APP_FONT_NAME,
			FontConstants.APP_FONT_STYLE, DEFAULT_FONT_SIZE);

	public static JLabel createStyledLabel(final int fontSize) {
		JLabel label = new JLabel();
		label.setOpaque(true);
		label.setBackground(AppColors.HOME_BACKGROUND);
		
		Font digitFont = new Font(FontConstants.APP_FONT_NAME,
				FontConstants.APP_FONT_STYLE, fontSize);
		
		label.setFont(digitFont);
		label.setForeground(AppColors.TIME_PAD_DIGITS);
		return label;
	}
	
	public static JLabel createStyledLabel(final String text, final int fontSize) {
		JLabel label = createStyledLabel(fontSize);
		label.setText(text);
		return label;
	}
	
	public static void setTimePadBorder(JPanel panel) {
		Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
		panel.setBorder(border);
	}
	
	public static void setButtonStyle(JButton button) {
		
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setOpaque(true);
		
		final int BUTTON_X_DIMENSION = (int) (Home.HOME_X_SIZE * 0.90);
		final int BUTTON_Y_DIMENSION = 40;
		final Dimension buttonDimension = new Dimension(BUTTON_X_DIMENSION, BUTTON_Y_DIMENSION);
		button.setMinimumSize(buttonDimension);
		button.setMaximumSize(buttonDimension);
	}
	
	public static void forcePanelSize(JPanel panel, final Dimension dimension) {
		panel.setMinimumSize(dimension);
		panel.setMaximumSize(dimension);
	}
	
	
	public static void addPad(JComponent component, final int width, final int height) {
		component.add(Box.createRigidArea(new Dimension(width, height)));
	}
	
	public static String formatInteger(final Integer integer) {
		final String FORMAT = "%02d";
		return String.format(FORMAT, integer);
	}
}
