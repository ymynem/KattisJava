public class Pot {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);


        Long n = io.getLong();
        int len_n = n.toString().length();
        long sum = 0;
        for(int i = 0; i < n; i++){
            String s  = io.getWord();
            String b = s.substring(0, s.length() - 1);
            String p = s.substring(s.length()-len_n);
            sum += Math.pow(Long.parseLong(b), Long.parseLong(p));

        }
        System.out.println(sum);
    }

}
