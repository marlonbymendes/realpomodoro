package input_validation;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class IntegerTextField extends JTextField {
	
	public static final int MAXIMUM_NUMBER_OF_DIGITS = 2;
	private PlainDocument IntegerDocumentFilter;

	public IntegerTextField() {
		super();
		
		setBorder(javax.swing.BorderFactory.createEmptyBorder());
		setColumns(MAXIMUM_NUMBER_OF_DIGITS);
		setIntegerDocumentFilter();
		setCaretColor(Color.WHITE);
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
}
