package input_validation;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class IntegerTextField extends JTextField {
	
	private PlainDocument IntegerDocumentFilter;

	public IntegerTextField() {
		super();
		
		setIntegerDocumentFilter();
	}
	
	private void setIntegerDocumentFilter() {
		IntegerDocumentFilter = new PlainDocument();
		
		IntegerDocumentFilter.setDocumentFilter(new DocumentFilter() {
		    @Override
		    public void insertString(FilterBypass fb, int off, String str, AttributeSet attr) 
		        throws BadLocationException 
		    {
		        fb.insertString(off, str.replaceAll("\\D++", ""), attr);  // remove non-digits
		    } 
		    @Override
		    public void replace(FilterBypass fb, int off, int len, String str, AttributeSet attr) 
		        throws BadLocationException 
		    {
		        fb.replace(off, len, str.replaceAll("\\D++", ""), attr);  // remove non-digits
		    }
		});
		
		setDocument(IntegerDocumentFilter);
	}
}
