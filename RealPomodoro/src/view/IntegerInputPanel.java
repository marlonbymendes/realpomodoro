package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import input_validation.IntegerTextField;

public class IntegerInputPanel extends JPanel {
	
	private String message;
	private JLabel messageLabel;
	
	private IntegerTextField integerInput;
	
	private final int X_SIZE = StartButton.X_SIZE;
	private final int Y_SIZE = 30;
	
	private Dimension PANEL_DIMENSION = new Dimension(X_SIZE, Y_SIZE);
	private JPanel inputPanel;
	
	public IntegerInputPanel(final String message, final int initialNumber) {
		super();
		
		initPanel();
		
		setMessage(message);
		setLabel();
		setIntegerInput();
		setInputPanel();
		integerInput.setText(Integer.toString(initialNumber));
		
		
		addAllComponents();
	}

	private void initPanel() {
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		this.setLayout(flowLayout);
		this.setBackground(AppColors.HOME_BACKGROUND);
		
		StyledViewFactory.forceComponentSize(this, PANEL_DIMENSION);
	}
	
	private void setLabel() {
		this.messageLabel = StyledViewFactory.createStyledLabel(message, StyledViewFactory.DEFAULT_FONT_SIZE);
	}
	
	private void setMessage(final String message) {
		this.message = message;
	}
	
	private void addAllComponents() {
		this.add(messageLabel);
		this.add(Box.createRigidArea(new Dimension(23, 0)));
		this.add(inputPanel);
	}
	
	private void setIntegerInput() {
		integerInput = new IntegerTextField();
	}
	
	private JPanel createRigidPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(AppColors.LIGHT_GRAY);
		StyledViewFactory.forceComponentSize(panel, new Dimension(12, 24));
		return panel;
	}

	private void setInputPanel() {
		inputPanel = new JPanel();
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		inputPanel.setLayout(flowLayout);
		
		inputPanel.setBackground(Color.yellow);
		
		Border border = BorderFactory.createLineBorder(AppColors.DARK_GRAY, 1);
		inputPanel.setBorder(border);
		
		inputPanel.add(createRigidPanel());
		inputPanel.add(integerInput);
	}
}
