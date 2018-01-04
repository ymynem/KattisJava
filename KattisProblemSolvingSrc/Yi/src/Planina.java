public class Planina {


    public static void main(String[] args){
        Kattio io = new Kattio(System.in);

        int nrOfIterations = io.getInt();

        int nrOfVerticesPerSide = calculateNrOfVerticesPerSide(nrOfIterations);
        System.out.println(nrOfVerticesPerSide * nrOfVerticesPerSide);
    }

    public static int calculateNrOfVerticesPerSide(int nrOfIterations){
        if(nrOfIterations == 0){
            return 2;
        }
        else{
            return (2 * calculateNrOfVerticesPerSide(nrOfIterations - 1) ) - 1;
        }


    }
}
