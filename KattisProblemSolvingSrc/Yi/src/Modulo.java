
import java.util.ArrayList;
import java.util.Collections;

public class Modulo {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        ArrayList<Integer> allNumbers = new ArrayList<Integer>();

        while(io.hasMoreTokens()){
            allNumbers.add(io.getInt());
        }

        Collections.sort(allNumbers);
        for(int e: allNumbers){

            System.out.println(e);
        }


    }
}
