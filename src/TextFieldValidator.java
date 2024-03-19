/**
 * TextFieldValidator custom class
 * PROG1400 object oriented Programming
 * project2 
 * @author Derrick Maurais
 */


import javax.swing.*;
import java.awt.*;


public class TextFieldValidator {
    /**default regEx of this TextFieldValidator */
    private String regExp = "\\w";
    /**default errorColor of this TextFieldValidator*/ 
    private Color errorColor = Color.RED;
    /**holds the fieldToTest for this TextFieldValidator */
    private JTextField fieldToTest;

    // -----------------------------constructor methods
    public TextFieldValidator (JTextField myTarget, Color myErrorColor){
        this.fieldToTest = myTarget;
        this.errorColor = myErrorColor;
    };

    public TextFieldValidator (JTextField myTarget){
        this.fieldToTest = myTarget;
        this.errorColor = Color.RED;
    };


    // ----------------------------------------------------------------Gets/Sets
    /**
     * sets the RegEx to be tested against
     * @param myRegEx the String regex that will be tested against user input
     */
    public void setRegExp(String myRegEx){
        this.regExp = myRegEx;
    }
    /**
     * sets the errorColor to be used
     * @param myColor is the color to be used as the errorColor
     */
    public void setErrorColor(Color myColor){
        this.errorColor = myColor;
    };

    /**
     * returns the currentErrorcolor of the textFieldValidator
     * @return this returns a Color elemnt value
     */
    public Color getErrorColor(){
        return errorColor;
    }
    /**
     * returns a JTextField object
     * @return the JtextField being tested
     */
    public JTextField getJTextField(){
        return fieldToTest;
    }
    // --------------------------------------------------------------public methods
    /**
     * returns a boolean 
     * @return this returns a boolean of true if the user input matches the set regex, returns false and changes the inputfeild color if it does not match
     */
    public Boolean check(){
        String textToTest = fieldToTest.getText();
        if (textToTest.matches(regExp)){
            return true;
        } else {
            fieldToTest.setBorder(BorderFactory.createLineBorder(errorColor,1));
            return false;
        }
    };
    /**
     * changes the color of the fieldtoTest border to black when called. 
     */
    public void reset(){
        fieldToTest.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
    };


}
