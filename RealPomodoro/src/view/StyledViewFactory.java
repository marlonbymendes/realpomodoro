package view;

import java.awt.Font;

import javax.swing.JLabel;

public class StyledViewFactory {

	public static JLabel createStyledLabel(final int fontSize) {
		JLabel label = new JLabel();
		label.setOpaque(true);
		label.setBackground(AppColors.HOME_BACKGROUND);
		final Font digitFont = new Font(FontConstants.APP_FONT_NAME,
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
}
