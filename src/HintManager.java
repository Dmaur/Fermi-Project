import java.util.Random;

public class HintManager {
    private int[] randomNumbers = new int[3];
    private int[] userInput;

    
    
    // -----------constructor method
    public HintManager (int[] userGuesses){
        userInput  = userGuesses;
        populateRandList();
        System.out.printf("%d %d %d",randomNumbers[0],randomNumbers[1],randomNumbers[2]);
    
        
    }


    // --------------------------------------------private methods

    private void populateRandList(){
        Random rand = new Random();
        boolean[] used = new boolean[10];
        for ( int i = 0; i<randomNumbers.length; i++){
            int num;
            do{
                num = rand.nextInt(10);
            }while (used[num]);
            randomNumbers[i] = num;
            used[num] = true;
        }
        // System.out.println(randomNumbers[0]+randomNumbers[1]+randomNumbers[2]);
        // System.out.println(randomNumbers[0]);
        // System.out.println(randomNumbers[1]);
        // System.out.println(randomNumbers[2]);

        
        
        // randomNumbers[0] = generateRandomNum();
        // randomNumbers[1] = generateRandomNum();
        // randomNumbers[2] = generateRandomNum();

    }
}

//     private int generateRandomNum(){
//         Random rand = new Random();
//         System.out.println(rand.nextInt(10));
//         return rand.nextInt(10);
//     }
// }