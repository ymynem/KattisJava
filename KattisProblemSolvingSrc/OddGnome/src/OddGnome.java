public class OddGnome {

    public static void main(String[] args) {

        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        int controlCounter;
        int next = 0;
        int y;
        int current;

        for(int i = 0; i < n; i ++){

            y = io.getInt();
            current = io.getInt();

            next = getNextGnomeAndCheckIfKing(io, next, y, current);


        }
        io.close();

    }

    private static int getNextGnomeAndCheckIfKing(Kattio io, int next, int y, int current) {
        int controlCounter;
        for(int j = 2; j < y; j++){

            if(io.hasMoreTokens()){
                next = io.getInt();
                controlCounter = current + 1;

                if (findKingsPosition(io, controlCounter, next, y, j)) break;
            }
            current = next;
        }
        return next;
    }

    private static boolean findKingsPosition(Kattio io, int controlCounter, int next, int y, int j) {
        if(next != controlCounter){
            System.out.println(j);
            int readsLeftInLine = y-j;
            getRidOfRedundantGnomes(io, readsLeftInLine);
            return true;
        }
        return false;
    }

    private static void getRidOfRedundantGnomes(Kattio io, int readsLeftInLine) {
        for(int left = 0; left < readsLeftInLine; left++){
            io.getInt();
        }
    }
}
