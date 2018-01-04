public class NastyHacks {
    public static void main(String[] args){
        Kattio io = new Kattio(System.in);

        int n = io.getInt();
        int i = 0;
        while(i < n){
            long r = io.getLong(); // Expected revenue with no advertising
            long e = io.getLong(); // Expected revenue with advertising
            long c = io.getLong(); // Cost of advertising

            long total = e - c;
            if(r > total){
                System.out.println("do not advertise");}
            else if((total > r)){
                System.out.println("advertise");
            } else{
                System.out.println("does not matter");
            }
            i++;
        }

    }
}
