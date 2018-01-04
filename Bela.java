import java.util.HashMap;
import java.util.Map;

public class Bela {
    public static void main(String[] args){
        Kattio io = new Kattio(System.in);
        Map<String, Integer> tableOne = new HashMap<String, Integer>();
        tableOne.put("AD", 11);
        tableOne.put("KD", 4);
        tableOne.put("QD", 3);
        tableOne.put("JD", 20);
        tableOne.put("TD", 10);
        tableOne.put("9D", 14);
        tableOne.put("8D", 0);
        tableOne.put("7D", 0);
        tableOne.put("A", 11);
        tableOne.put("K", 4);
        tableOne.put("Q", 3);
        tableOne.put("J", 2);
        tableOne.put("T", 10);
        tableOne.put("9", 0);
        tableOne.put("8", 0);
        tableOne.put("7", 0);

        int numberOfHands = io.getInt() * 4;
        String suit = io.getWord();
        String cardDescription = null;
        int sum = 0;
        String key = "";
        while(numberOfHands > 0){
            cardDescription = io.getWord();
             key += cardDescription.charAt(0);
            if(cardDescription.charAt(1) == suit.charAt(0)){
                sum += tableOne.get(key + 'D');
            } else {
                sum += tableOne.get(key);
            }
            numberOfHands--;
        }

        System.out.println(sum);
    }
}

