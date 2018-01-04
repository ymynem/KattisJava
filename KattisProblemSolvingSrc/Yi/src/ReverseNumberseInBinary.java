public class ReverseNumberseInBinary {

    public static void main(String[] args) {


        Kattio io = new Kattio(System.in, System.out);
        long nr = io.getLong();
        String binaryNumberInStrFormat = "";
        int remainder;
        long calcuatedNewValue = 0;
        int powerOf = -1;
        while(nr > 0 ){
            remainder = (int) (nr % 2);
            powerOf++;
            binaryNumberInStrFormat += remainder;
            nr = nr/2;
        }

        int index = 0;
        while(powerOf >=0){

            if(binaryNumberInStrFormat.charAt(index) == '1'){
                calcuatedNewValue += (long) Math.pow(2, powerOf);
            }
            powerOf--;
            index++;
        }

        System.out.println(calcuatedNewValue);
        io.close();
    }


}
