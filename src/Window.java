
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
    private String gameRegEx = "[0-9]";
    private JButton okay;
    private int guessCounter = 1 ;
    // private JScrollPane outputPane;
    private JTextArea gameOutput;
    private TextFieldValidator one, two, three;
    private TextFieldValidator[] tfvo;
    private HintManager game = new HintManager();
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

        // *************************** Button event listeners*************
        okay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                okClicked(e);
            }
        });
        reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                resetClicked(e);
            }
        });
        //****************************************************************
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
        gameOutput = new JTextArea(17,30);
        gameOutput.setLineWrap(true);
        gameOutput.setEditable(false);
        // gameOutput.setPreferredSize(new Dimension(240,280));
        gameOutput.setBorder(startBorder);

        // adding contents to the rightPanel. 
        rightPanel.add(hints,"wrap");
        JScrollPane outputPane = new JScrollPane(gameOutput);
        outputPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        rightPanel.add(outputPane);
       
    
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
    }
// ********************************************************constructor end************************************************************************

    // --------------------------------------------BUTTON event handlers
    public void okClicked(ActionEvent e ){
    
        // string array to hold guesses to be passed to HintManager
        int [] guesses = new int[3];
        // making TextFieldValidator objects
        one = new TextFieldValidator(numOne);
        two = new TextFieldValidator(numTwo);
        three = new TextFieldValidator(numThree);
        
        // storing the objects in tfvo list
        tfvo = new TextFieldValidator[3];
        tfvo[0] = one;
        tfvo[1] = two;
        tfvo[2] = three;
        int i = -1;
        // for loop to test all input againts the gameregex and store the value if it returns true, 404 if returns false. 
        for (TextFieldValidator val : tfvo){
            i++;
            val.setRegExp(gameRegEx);
            boolean isValid = val.check();
            if(isValid){
                val.reset();
                guesses[i] = Integer.parseInt(val.getJTextField().getText());    
            }else {
                guesses[i] = 404;
            }
        }
        // if all inputs are valid, start game with hintmanager
        
        String winner = String.format(" You WIN!\n you made %d guesses", guessCounter);
        if (guesses[0] != 404 && guesses[1] != 404 && guesses[2] != 404 ){
            guessCounter++ ;
            game.setUserInput(guesses);
            game.checkUserInput();
            gameOutput.append(game.displayOutcome());
            if (game.getHintReturn()[0] == "Fermi" && game.getHintReturn()[1] == "Fermi" && game.getHintReturn()[2] == "Fermi"){
                okay.setEnabled(false);
                numOne.setEnabled(false);
                numTwo.setEnabled(false);
                numThree.setEnabled(false);
                gameOutput.append(winner);
            }

            // System.out.println("all good");
        }else{
             System.out.println("ERROR: bad input");
        }
       
    }

    public void resetClicked(ActionEvent e ){
        numOne.setText("");
        numTwo.setText("");
        numThree.setText("");
        gameOutput.setText("");
        game.populateRandList();
        okay.setEnabled(true);
        numOne.setEnabled(true);
        numTwo.setEnabled(true);
        numThree.setEnabled(true);
        
    }




     public static void main(String[] args) throws Exception {
        Window window = new Window();
		window.setVisible(true);
    
    }
}
