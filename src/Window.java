
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import net.miginfocom.swing.MigLayout;


public class Window extends JFrame {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JTextField numOne;
    private JTextField numTwo;
    private JTextField numThree;
    private JButton okay;
    private Border startBorder = BorderFactory.createLineBorder(Color.BLACK,1);

// ****************************************************************Window constructor **********************************************************
public Window(){
    this.setTitle("Fermi Guessing Game");
    this.setSize(550,400);  
    this.setLocation(600,200);
    this.setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // create main panel and place it in window
    mainPanel = new JPanel( );
    this.add(mainPanel);
    mainPanel.setLayout(new MigLayout("",
                                          "[250][250]",
                                          "[525]"));

    // setting up the left pannel with the buttons and text fields. 
    leftPanel = new JPanel();
    leftPanel.setSize(200,400);
    leftPanel.setLayout(new MigLayout("",
                                        "[240]",
                                        "30[]10[]10[]10[]10[30]140[30]"));
    JLabel enterMsg = new JLabel("Enter your three guesses (0-9)");
    numOne = new JTextField(8);
    numTwo = new JTextField(8);
    numThree = new JTextField(8);
    numOne.setBorder(startBorder);
    numTwo.setBorder(startBorder);
    numThree.setBorder(startBorder);
    okay = new JButton("OK");
    okay.setPreferredSize(new Dimension(100,0));
    JButton reset = new JButton("Reset");
    reset.setPreferredSize(new Dimension(100,0));
   
    //adding all the contents to the left panel.  
    leftPanel.add(enterMsg,"wrap");
    leftPanel.add(numOne, "wrap");
    leftPanel.add(numTwo,"wrap");
    leftPanel.add(numThree,"wrap");
    leftPanel.add(okay,"wrap");
    leftPanel.add(reset,"wrap");


     // setting up the right panel with text area and lable. 
    rightPanel = new JPanel();
    rightPanel.setSize(200,400);
    rightPanel.setLayout(new MigLayout("",
                                        "[]",
                                        "[]10[]120"));
    JLabel hints = new JLabel("Hints:");
    JTextArea gameOutput = new JTextArea();
    gameOutput.setPreferredSize(new Dimension(240,280));
    gameOutput.setBorder( startBorder);
    // adding contents to the rightPanel. 
    rightPanel.add(hints,"wrap");
    rightPanel.add(gameOutput);
   
    mainPanel.add(leftPanel);
    mainPanel.add(rightPanel);
}






























    public static void main(String[] args) throws Exception {
        Window window = new Window();
		window.setVisible(true);
    
    }
}
