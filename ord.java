import java.util.Scanner;
public class ord{
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                String input1 = sc.nextLine();
                String input3 = "";
                while(sc.hasNext()){
                        
                        String input2 = sc.next();

                        input3 += input2;
                }
                System.out.println(input3);
                sc.close();
        }
                      
}
                