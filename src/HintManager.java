import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HintManager {
    private int[] randomNumbers = new int[3];
    private int[] userInput;
    private String[] hintReturn = new String[3];

    
    
    // -----------------------constructor method
    public HintManager (){
        populateRandList();
       
    
        
    }
    // -----------------------------------------------------gets/sets
    public void setUserInput(int[]userGuesses){
        userInput = userGuesses;
        System.out.printf(" user guess: %d%d%d\n", userInput[0],userInput[1],userInput[2]);

        
    }

    // ------------------------------------------public methods
    public void checkUserInput(){ 
        // list to store numbers that are used already to check for
        List<Integer> alreadyUsed = new ArrayList<>();

        for (int i = 0; i < userInput.length; i++){
            int num1 = userInput[i];
            boolean numFound = false;
            // check if num1 matches the number in the same index in Randomnumbers array and make sure num1 does not exist in the already used list
            if (num1 == randomNumbers[i] && !alreadyUsed.contains(num1)){
                hintReturn[i] = "Fermi";
                alreadyUsed.add(num1);
                numFound = true;
            } else {
                // checks if num1 matches any number in the random numbers array  
                for (int num2 : randomNumbers){
                    if(num1 == num2 && !alreadyUsed.contains(num1)){
                        hintReturn[i]= "Pico";
                        alreadyUsed.add(num1);
                        numFound = true;
                        break;
                    }
                }
            }
            if(!numFound){
                hintReturn[i] = "Nano";
            }
       
        }
        // shuffles the order of the hintReturn Array
        Collections.shuffle(Arrays.asList(hintReturn));
     
    }
    public void populateRandList(){
        Random rand = new Random();
        // use a list of booleans to assign if a nmumber has been used or not
        boolean[] used = new boolean[10];
        // iterate over  every spot in the randomNumbers array, make an int called num
        for ( int i = 0; i<randomNumbers.length; i++){
            int num;
            // the "do while keeps"  trying to assign a value to num thats random so long as the number is in used boolean list as true
            do{
                num = rand.nextInt(10);
            }while (used[num]);
            // once it gets to a number that is not set as true in the boolean list it assigns that random number to the index it is on in the ranomNumbers array iteration. it then sets that number value as true in the used boolean list. 
            randomNumbers[i] = num;
            used[num] = true;
            
        }
        System.out.printf("number gnerated: %d%d%d \n",randomNumbers[0],randomNumbers[1],randomNumbers[2]);
    // --------------------------------------------private methods
    }
    public String displayOutcome(){
        return hintReturn[0]+ hintReturn[1]+hintReturn[2];
    }
}