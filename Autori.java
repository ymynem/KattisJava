public class Autori {
    public static void main(String[] args){
        Kattio io = new Kattio(System.in);
        String names = io.getWord();
        String[] nameList = names.split("-");
        StringBuilder sb = new StringBuilder();

        for(String name : nameList){
            sb.append(name.charAt(0));
        }
        System.out.println(sb);


    }
}
