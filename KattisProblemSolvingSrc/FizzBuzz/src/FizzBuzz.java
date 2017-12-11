
// import java.util.Scanner;
public class FizzBuzz {

    public static void main(String[] args) {

            //Scanner sc = new Scanner(System.in);
            Kattio io = new Kattio(System.in, System.out);
            int x = io.getInt(); //sc.nextInt();
            int y = io.getInt(); //sc.nextInt();
            int n = io.getInt(); //sc.nextInt();


            for(int i = 1; i <= n; i++ ){
                if(i % x == 0 & i%y ==0){
                    System.out.println("FizzBuzz");
                } else if(i % x == 0){
                    System.out.println("Fizz");

                } else if (i % y == 0){
                    System.out.println("buzz");
                } else {
                    System.out.println(i);
                }
            }


    }
}
