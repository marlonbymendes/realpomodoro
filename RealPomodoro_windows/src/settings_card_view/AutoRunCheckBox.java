package settings_card_view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import home_view.AppColors;
import home_view.StyledViewFactory;

public class AutoRunCheckBox extends JCheckBox implements ItemListener {

	private static final String LABEL = "Automatically restart pomodoro";
	
	public AutoRunCheckBox() {
		super(LABEL);
		
		setBox();
	}
	
	private void setBox() {
		addItemListener(this);
		
		setOpaque(true);
		setBackground(AppColors.HOME_BACKGROUND);
		setForeground(AppColors.TIME_PAD_DIGITS);
		this.setFont(StyledViewFactory.DEFAULT_FONT);
	}
	
	public void itemStateChanged(final ItemEvent event) {
		final int STATUS = event.getStateChange();
		
        if(STATUS == ItemEvent.DESELECTED) {
        	System.out.println("AutoRun disabled.");
        }
        else {
        	System.out.println("AutoRun enabled.");
        }
    }
}
