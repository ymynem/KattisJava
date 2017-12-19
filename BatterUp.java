public class BatterUp {
    public static void main(String[] args){
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        int next;
        int sum = 0;
        int count = 0;
        while( n > 0) {
            next =  io.getInt();
            if (next != -1) {

                sum += next;

                count++;

            }
            n--;
        }
        System.out.println((float)sum/count);
    }
}
