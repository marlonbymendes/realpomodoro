package settings_card_view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import home_card_view.StartButton;
import home_view.AppColors;
import home_view.StyledViewFactory;
import input_validation.IntegerTextField;

public class IntegerInputPanel extends JPanel {
	
	private String message;
	private JLabel messageLabel;
	private int initialNumber;
	
	private IntegerTextField integerInput;
	
	private final int X_SIZE = StartButton.X_SIZE;
	private final int Y_SIZE = 30;
	
	private Dimension PANEL_DIMENSION = new Dimension(X_SIZE, Y_SIZE);
	private JPanel inputPanel;
	
	public IntegerInputPanel(final String message, final int initialNumber) {
		super();
		
		initPanel();
		
		setMessage(message);
		setInitialNumber(initialNumber);
		setLabel();
		setIntegerInput();
		setInputPanel();
		integerInput.setText(initialNumber);
		
		
		addAllComponents();
	}

	private void setInitialNumber(final int initialNumber) {
		this.initialNumber = initialNumber;
		
	}

	private void initPanel() {
		FlowLayout flowLayout = StyledViewFactory.createFlowLayoutWithNoGaps();
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
		FlowLayout flowLayout = StyledViewFactory.createFlowLayoutWithNoGaps();
		inputPanel.setLayout(flowLayout);
		
		inputPanel.setBackground(Color.yellow);
		
		Border border = BorderFactory.createLineBorder(AppColors.DARK_GRAY, 1);
		inputPanel.setBorder(border);
		
		inputPanel.add(createRigidPanel());
		inputPanel.add(integerInput);
	}
	
	public boolean wasUpdated() {
		return integerInput.wasUpdated();
	}
	
	public int getInteger() {
		final Integer integer = new Integer(integerInput.getText());
		return integer;
	}

	public void setUpdated(final boolean status) {
		integerInput.setUpdated(status);
	}

	public void restart() {
		integerInput.setText(initialNumber);
		integerInput.setUpdated(false);
	}
}
