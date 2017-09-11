package settings_card_view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import home_view.AppColors;
import home_view.Home;
import home_view.StyledViewFactory;

public class StyledButton extends JButton {
	
	private float xProportion;
	private int ySize;
		
	public StyledButton(final String text, final float xProportion, final int ySize) {
		super(text);
		
		setxProportion(xProportion);
		setySize(ySize);

		setButtonStyle();
		
	}

	private void setButtonStyle() {
		setBorderPainted(true);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setOpaque(true);
		setBackground(AppColors.HOME_BACKGROUND);
		setBackground(Color.BLUE);
		setMargin(new Insets(0, 0, 0, 0));
		StyledViewFactory.setWhiteBorder(this);
		setFont(StyledViewFactory.DEFAULT_FONT);
		setForeground(AppColors.TIME_PAD_DIGITS);
		setButtonSize();
		
	}
	
	private void setButtonSize() {
		final int BUTTON_X_DIMENSION = (int) (Home.HOME_X_SIZE * getxProportion());
		final int BUTTON_Y_DIMENSION = getySize();
		final Dimension buttonDimension = new Dimension(BUTTON_X_DIMENSION, BUTTON_Y_DIMENSION);
		StyledViewFactory.forceComponentSize(this, buttonDimension);
	}

	public float getxProportion() {
		return xProportion;
	}
	
	public void setxProportion(float xProportion) {
		this.xProportion = xProportion;
	}

	public int getySize() {
		return ySize;
	}

	public void setySize(int ySize) {
		this.ySize = ySize;
	}

}