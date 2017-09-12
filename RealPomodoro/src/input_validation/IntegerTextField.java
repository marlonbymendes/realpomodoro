package input_validation;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

import home_view.AppColors;
import home_view.FontConstants;

import javax.swing.event.DocumentListener;

public class IntegerTextField extends JTextField {
	
	public static final int MAXIMUM_NUMBER_OF_DIGITS = 2;
	private PlainDocument IntegerDocumentFilter;
	private boolean updated;

	public IntegerTextField() {
		super();
		
		setFontStyle();
		setStyle();
		setUpdated(false);
		
		this.getDocument().addDocumentListener(new FieldListener());
	}
	
	private void setStyle() {
		this.setColumns(MAXIMUM_NUMBER_OF_DIGITS);
		this.setIntegerDocumentFilter();
		this.setCaretColor(Color.BLACK);
		this.setBackground(AppColors.LIGHT_GRAY);
		
		this.setBorder(BorderFactory.createEmptyBorder());
	}
	
	private void setIntegerDocumentFilter() {
		IntegerDocumentFilter = new PlainDocument();
		
		IntegerDocumentFilter.setDocumentFilter(new DocumentFilter() {
		    @Override
		    public void insertString(FilterBypass fb, int off, String str, AttributeSet attr) 
		    		throws BadLocationException {
		    	if(str == null) return;
		    			 
		    	final int newSize = IntegerDocumentFilter.getLength() + str.length();
		    	
		    	if(newSize <= MAXIMUM_NUMBER_OF_DIGITS)
		    		fb.insertString(off, str.replaceAll("\\D++", ""), attr);  // remove non-digits
		    } 
		    @Override
		    public void replace(FilterBypass fb, int off, int len, String str, AttributeSet attr) 
		        throws BadLocationException 
		    {
		    	final int newSize = IntegerDocumentFilter.getLength() + str.length();
		    	if(newSize <= MAXIMUM_NUMBER_OF_DIGITS)
		    		fb.replace(off, len, str.replaceAll("\\D++", ""), attr);  // remove non-digits
		    }
		});
		
		this.setDocument(IntegerDocumentFilter);
	}
	
	private class FieldListener implements DocumentListener {
		@Override
	    public void insertUpdate(DocumentEvent e) {
			//setUpdated(true);
	    }

	    @Override
	    public void removeUpdate(DocumentEvent e) {
	    	setUpdated(true);
	    }

	    @Override
	    public void changedUpdate(DocumentEvent e) {
	    	setUpdated(true);
	    }
	}
	
	public void setText(final int integer) {
		final String integerString = String.format("%02d", integer);
		this.setText(integerString);
	}
	
	private void setFontStyle() {
		final int FONT_SIZE = 20;
		final Font font = new Font(FontConstants.APP_FONT_NAME, FontConstants.APP_FONT_STYLE, FONT_SIZE);
		
		this.setFont(font);
		this.setForeground(AppColors.MID_GRAY);
	}
	
	public void setUpdated(final boolean status) {
		this.updated = status;
	}
	
	public boolean wasUpdated() {
		return updated;
	}
}
