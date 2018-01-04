public class Tarifa {
    public static void main(String[] args){
        Kattio io = new Kattio(System.in);
        int mb = io.getInt();
        int months = io.getInt();
        int monthsLef = months;
        long consumed = 0;
        while(monthsLef > 0){
            consumed += io.getLong();
            monthsLef--;
        }
        System.out.println(((mb*months)+mb) - consumed);

    }
}
