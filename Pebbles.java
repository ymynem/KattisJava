import java.util.Scanner;

public class Pebbles {
	private static int min = 12;

	public static void main(String[] args) {

		// Scanner
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int nr = Integer.parseInt(str);
		for (int i = 0; i < nr; i++) {
			str = sc.nextLine();
			pebble(str.toCharArray());
			System.out.println(min);
			min = 12;
		}
		sc.close();
	}

	public static void pebble(char[] c) {
		for (int i = 0; i < c.length - 2; i++) {
			if (c[i] == 'o' && c[i + 1] == 'o' && c[i + 2] == '-') {
				c[i] = '-';
				c[i + 1] = '-';
				c[i + 2] = 'o';
				pebble(c);
				c[i] = 'o';
				c[i + 1] = 'o';
				c[i + 2] = '-';
			}

			if (c[i] == '-' && c[i + 1] == 'o' && c[i + 2] == 'o') {
				c[i] = 'o';
				c[i + 1] = '-';
				c[i + 2] = '-';
				pebble(c);
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

	}
}