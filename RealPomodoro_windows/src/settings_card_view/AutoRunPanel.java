package settings_card_view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import home_view.AppColors;
import home_view.Home;
import home_view.StyledViewFactory;

public class AutoRunPanel extends JPanel {
	
	final int PANEL_X_SIZE = Home.HOME_X_SIZE;
	final int PANEL_Y_SIZE = 26	;
	
	final Dimension PANEL_DIMENSION = new Dimension(PANEL_X_SIZE, PANEL_Y_SIZE);
	
	AutoRunCheckBox autoRunCheckBox;
	private JPanel verticalPanel;
	private JLabel autoRunLabel;
	
	public AutoRunPanel() {
		super();
		
		setAutoRunCheckBox();
		setAutoRunLabel();
		setAutoRunPanel();
		setVerticalPanel();
	
		addAllComponents();
	}
	
	private void addAllComponents() {
		this.add(verticalPanel);
	}

	private void setAutoRunCheckBox() {
		autoRunCheckBox = new AutoRunCheckBox();
	}
	
	private void setAutoRunPanel() {
		FlowLayout flowLayout = StyledViewFactory.createFlowLayoutWithNoGaps();
		this.setLayout(flowLayout);
		
		this.setOpaque(true);
		this.setBackground(AppColors.HOME_BACKGROUND);
	}
	
	public boolean isAutoRunEnabled() {
		return autoRunCheckBox.isSelected();
	}
	
	private void setAutoRunLabel() {
		final String AUTO_RUN_TEXT = "AutoRun pomodoros";
		final int fontSize = 17;
		autoRunLabel = StyledViewFactory.createStyledLabel(AUTO_RUN_TEXT, fontSize);
	}
	
	private void setVerticalPanel() {
		verticalPanel = new JPanel();
		verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
		verticalPanel.setBackground(AppColors.HOME_BACKGROUND);
		
		verticalPanel.add(autoRunLabel);
		verticalPanel.add(Box.createRigidArea(new Dimension(0, 7)));
		verticalPanel.add(autoRunCheckBox);
	}
}

