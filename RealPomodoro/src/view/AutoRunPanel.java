package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class AutoRunPanel extends JPanel {
	
	final int PANEL_X_SIZE = Home.HOME_X_SIZE;
	final int PANEL_Y_SIZE = 26	;
	
	final Dimension PANEL_DIMENSION = new Dimension(PANEL_X_SIZE, PANEL_Y_SIZE);
	
	AutoRunCheckBox autoRunCheckBox;
	
	public AutoRunPanel() {
		super();
		
		setAutoRunCheckBox();
		setAutoRunPanel();
		
		this.add(autoRunCheckBox);
	}

	private void setAutoRunCheckBox() {
		autoRunCheckBox = new AutoRunCheckBox();
	}
	
	private void setAutoRunPanel() {
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
		flowLayout.setHgap(0);
		flowLayout.setVgap(0);
		
		this.setLayout(flowLayout);
		this.setOpaque(true);
		this.setBackground(AppColors.HOME_BACKGROUND);
		
		StyledViewFactory.forcePanelSize(this, PANEL_DIMENSION);
	}
	
	public boolean isAutoRunEnabled() {
		return autoRunCheckBox.isSelected();
	}
}

