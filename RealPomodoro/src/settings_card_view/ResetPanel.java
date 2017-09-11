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

public class ResetPanel extends JPanel {
	
	final int PANEL_X_SIZE = Home.HOME_X_SIZE;
	final int PANEL_Y_SIZE = 26	;
	
	final Dimension PANEL_DIMENSION = new Dimension(PANEL_X_SIZE, PANEL_Y_SIZE);
	
	AutoRunCheckBox autoRunCheckBox;
	private JPanel verticalPanel;
	private JLabel resetLabel;
	
	public ResetPanel() {
		super();
		
		setResetLabel();
		setResetPanel();
		setVerticalPanel();
	
		addAllComponents();
	}
	
	private void addAllComponents() {
		this.add(verticalPanel);
		addComponentsToVerticalPanel();
	}
	
	private void setResetPanel() {
		FlowLayout flowLayout = StyledViewFactory.createFlowLayoutWithNoGaps();
		this.setLayout(flowLayout);
		
		this.setOpaque(true);
		this.setBackground(AppColors.HOME_BACKGROUND);
	}
	
	private void setResetLabel() {
		final String RESET_PANEL_TEXT = "Reset history";
		final int fontSize = 17;
		resetLabel = StyledViewFactory.createStyledLabel(RESET_PANEL_TEXT, fontSize);
	}
	
	private void setVerticalPanel() {
		verticalPanel = new JPanel();
		verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
		verticalPanel.setBackground(AppColors.HOME_BACKGROUND);

	}
	
	private void addComponentsToVerticalPanel() {
		verticalPanel.add(resetLabel);
	}
}

