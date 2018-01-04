public class Spavanac {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int hour = io.getInt();
        int min = io.getInt();
        int conv = hour * 60 + min;

        int newMin = 60 - 45 + min;
        int minutes = newMin % 60;

        if (conv > 45) {

            if (minutes > 0 && hour > 0) {
                hour -= 1;
                System.out.println("A " + hour + " " + minutes);
            } else {
                System.out.println("E " + 23 + " " + minutes);
            }

        } else if (conv <= 45) {
            if (min == 45 && hour == 00) {

                System.out.println("B " + 0 + " " + minutes);

            } else if (minutes >= 0 && minutes < 45 && hour == 0) {

                System.out.println("C " + 23 + " " + minutes);

            } else {
                hour = 23;
                System.out.println("D " + hour + " " + minutes);

                /*
                 *   00 00 - 45 min  = 23 15
                 *   00 01 - 45 min  = 23 16
                 *   00 05 - 45 min  = 23 20
                 *   00 10 - 45 min  = 23 25
                 *   00 45 - 45 min  = 00 00
                 *   00 55 - 45 min  = 00 10
                 *
                 *
                 * */
            }
        }
    }
}
