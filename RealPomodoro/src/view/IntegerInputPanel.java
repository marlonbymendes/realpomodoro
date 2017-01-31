package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import input_validation.IntegerTextField;

public class IntegerInputPanel extends JPanel {
	
	private String message;
	private JLabel messageLabel;
	
	private IntegerTextField integerInput;
	
	private int PANEL_X_SIZE = Home.HOME_X_SIZE;
	private int PANEL_Y_SIZE = 30;
	private Dimension PANEL_DIMENSION = new Dimension(PANEL_X_SIZE, PANEL_Y_SIZE);
	
	public IntegerInputPanel(final String message) {
		super();
		
		initPanel();
		
		setMessage(message);
		setLabel();
		setIntegerInput();
		
		addAllComponents();
	}

	private void initPanel() {
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		this.setLayout(flowLayout);
		
		StyledViewFactory.forcePanelSize(this, PANEL_DIMENSION);
	}
	
	private void setLabel() {
		this.messageLabel = StyledViewFactory.createStyledLabel(message, StyledViewFactory.DEFAULT_FONT_SIZE);
	}
	
	private void setMessage(final String message) {
		this.message = message;
	}
	
	private void addAllComponents() {
		this.add(messageLabel);
		this.add(integerInput);
	}
	
	private void setIntegerInput() {
		integerInput = new IntegerTextField();
	}
}
