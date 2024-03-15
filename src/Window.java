
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
    JLabel enterMsg = new JLabel("Enter your three guesses (0-9)");
}






























    public static void main(String[] args) throws Exception {
        Window window = new Window();
		window.setVisible(true);
    
    }
}
