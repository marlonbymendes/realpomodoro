package view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

public class AutoRunCheckBox extends JCheckBox implements ItemListener {

	private static final String LABEL = "Enable AutoRun";
	
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
		System.out.println("Box was changed.");
		
		final int STATUS = event.getStateChange();
		
        if(STATUS == ItemEvent.DESELECTED) {
        	System.out.println("Box is now deselected.");
        }
        else {
        	System.out.println("Box is now selected.");
        }
    }
}
