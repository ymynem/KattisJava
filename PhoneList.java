import java.util.SortedMap;
import java.util.TreeMap;


public class PhoneList {

    public static void main(String[] args) {
        try {
            //BufferedReader br = new BufferedReader(new FileReader("src/phone.in"));
            //Scanner sc = new Scanner(System.in);
            Kattio io = new Kattio(System.in, System.out);

            String cases = io.getWord();

            int nrOfCases = Integer.parseInt(cases);

            while (nrOfCases > 0) {
                TreeMap<String, String> treeMap = new TreeMap<>();
                String nr = io.getWord();

                if (nr == null) {
                    break;
                }

                long nrOfPhoneNrs = Long.parseLong(nr);

                for (int i = 0; i < nrOfPhoneNrs; i++) {
                    treeMap.put(io.getWord(), "");
                }
                boolean flag = false;
                for (String key : treeMap.keySet()) {
                    SortedMap<String, String> valuesByPrefix = treeMap.subMap(key, key + Character.MAX_VALUE);
                    if (valuesByPrefix.size() > 1) {
                        System.out.println("No");
                        flag = true;
                        break;
                    }
                }


                if (flag == false) {
                    System.out.println("YES");
                }

            }
            nrOfCases--;

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
