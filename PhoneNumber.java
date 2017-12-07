import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;

public class PhoneNumber {
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/phone.in"));
            String cases = br.readLine();
            int nrOfCases = Integer.parseInt(cases);
            while (nrOfCases > 0) {
                TreeMap<String, String> treeMap = new TreeMap<>();
                String nr = br.readLine();

                if(nr == null){
                    break;
                }
                long nrOfPhoneNrs = Long.parseLong(nr);

                for (int i = 0; i < nrOfPhoneNrs; i++) {
                    String phoneNr = br.readLine();
                    treeMap.put(phoneNr, cases);
                }

                //treeMap.
                boolean flag = false;
                for (String key : treeMap.keySet()) {
                    SortedMap<String, String> valuesByPrefix = getByPrefix(treeMap, key);
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

            cases += 1;
            nrOfCases--;

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static SortedMap<String, String> getByPrefix(NavigableMap<String, String> myMap, String prefix) {
        /*
         *   A       Y
         *   A B     Y
         *   B       N
         *   A Ö     Y
         *   A 1     Y
         *   1 2
         *   1 0 0
         *   1 0 0 0 0 0 0
         * */
        return myMap.subMap(prefix, prefix + Character.MAX_VALUE);
    }
}


