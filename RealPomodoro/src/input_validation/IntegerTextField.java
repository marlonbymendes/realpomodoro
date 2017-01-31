package input_validation;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

import view.FontConstants;
import view.StyledViewFactory;

public class IntegerTextField extends JTextField {
	
	public static final int MAXIMUM_NUMBER_OF_DIGITS = 2;
	private PlainDocument IntegerDocumentFilter;

	public IntegerTextField() {
		super();
		
		setFontStyle();
		setStyle();
		

	}
	
	private void setStyle() {
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		this.setColumns(MAXIMUM_NUMBER_OF_DIGITS);
		this.setIntegerDocumentFilter();
		this.setCaretColor(Color.WHITE);
		this.setBackground(Color.yellow);
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
		
		setDocument(IntegerDocumentFilter);
	}
	
	public String getFormattedText() {
		final String currentText = this.getText();
		Integer integerText = 0;
		
		if(currentText != null && !currentText.isEmpty()) {
			integerText = new Integer(currentText);
		}
		else {
			integerText = 0;
		}
		
		final String formattedText = StyledViewFactory.formatInteger(integerText);
	
		return formattedText;
	}

	public void setFormattedText() {
		final String formattedText = getFormattedText();
		this.setText(formattedText); 
	}
	
	private void setFontStyle() {
		final int FONT_SIZE = 22;
		final Font font = new Font(FontConstants.APP_FONT_NAME, FontConstants.APP_FONT_STYLE, FONT_SIZE);
		this.setFont(font);
	}
}
