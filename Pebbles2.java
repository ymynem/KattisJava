import java.util.HashMap;
import java.util.Scanner;

public class Pebbles2{
	private static int min = 23;
	private static HashMap<String, Integer> map = new HashMap<>();

	public static void main(String[] args) {

		// Scanner
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int nr = Integer.parseInt(str);
		for (int i = 0; i < nr; i++) {
			str = sc.nextLine();
			pebble(str.toCharArray());
			System.out.println(min);
			min = 23;
		}
		sc.close();
	}

	public static int pebble(char[] c) {
		int a = 0; //
		String str = new String(c);
		if (map.containsKey(str)) {
			return map.get(str);
		}
		for (int i = 0; i < c.length - 2; i++) {
			String str1;
			if (c[i] == 'o' && c[i + 1] == 'o' && c[i + 2] == '-') {
				c[i] = '-';
				c[i + 1] = '-';
				c[i + 2] = 'o';
				str1 = new String(c);
				a = pebble(c);
				map.put(str1, a);
				c[i] = 'o';
				c[i + 1] = 'o';
				c[i + 2] = '-';
			}

			if (c[i] == '-' && c[i + 1] == 'o' && c[i + 2] == 'o') {
				c[i] = 'o';
				c[i + 1] = '-';
				c[i + 2] = '-';
				str1 = new String(c);
				a = pebble(c);
				map.put(str1, a);
				c[i] = '-';
				c[i + 1] = 'o';
				c[i + 2] = 'o';
			}

		}

		int count = 0;
		for (int i = 0; i < c.length; i++) {

			if (c[i] == 'o') {
				count++;
			}
		}
		if (count < min) {
			min = count;
		}

		return a;
	}
}