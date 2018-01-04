import java.util.Scanner;
 
public class Aah{
        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
                String input1 = sc.nextLine();
                String input2 = sc.nextLine();
                whAt(input1, input2);
				sc.close();
        }
 
        public static void whAt(String jm, String doctor){
        
                if(jm.equals(doctor)){
                        System.out.println("go");
                }
                if(jm.length() > doctor.length()){
                        System.out.println("go");
                }
                if(jm.length() < doctor.length()){
                        System.out.println("no");
                }
                
        }
}