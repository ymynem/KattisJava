public class R2 {
    public static void main(String[] args){
        Kattio io = new Kattio(System.in);

        int r1 = io.getInt();

        int r2 = (io.getInt() * 2) - r1;
        System.out.println(r2);

    }
}
