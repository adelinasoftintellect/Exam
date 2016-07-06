import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Arrayconvert {
	public int[] convert(int b[][]) {
		int c[] = new int[b.length * b.length];
		for (int i = 0, k = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++, k++) {
				c[k] = b[j][i] * k;
			}
		}
		return c;
	}

	public int[][] convert(int c[]) {
		int size = (int) Math.sqrt(c.length);
		int b[][] = new int[size][size];
		for (int i = 0, k = 0; i < size; i++) {
			for (int j = 0; j < size; j++, k++) {
				b[j][i] = c[k] * k;
			}
		}
		return b;
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int select = -1;
		int n;
		int b[][] = null;
		int c[] = null;
		Arrayconvert a = new Arrayconvert();

		do {
			System.out.println("0. Exit");
			System.out.println("1. Convert 1D array into 2D");
			System.out.println("2. Convert 2D array into 1D");
			System.out.print("Select option (0 - 2)");
			select = input.nextInt();
			switch (select) {
			case 1:
				System.out.print("Array size: ");
				n = input.nextInt();
				if (n >= 2 && n <= 9) {
					c = new int[n];
					for (int i = 0; i < n; i++) {
						System.out.print("index: ");
						c[i] = input.nextInt();
					}
					b = a.convert(c);
					break;
				} else {
					System.out.println("Please enter size between \"2 - 9\"");
					break;
				}
			case 2:
				System.out.print("Side size: ");
				n = input.nextInt();
				if (n >= 2 && n <= 9) {
					b = new int[n][n];

					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							System.out.print("index: ");
							b[i][j] = input.nextInt();
						}
					}
					c = a.convert(b);
					break;
				} else {
					System.out.println("Please enter size between \"2 - 9\"");
					break;
				}
			}

			if (b != null && c != null) {
				try {
					FileWriter fileStream = new FileWriter("./input/array.txt", true);

					BufferedWriter writer = new BufferedWriter(fileStream);

					System.out.println("c = ");
					for (int i = 0; i < c.length; i++) {
						System.out.print(c[i] + " ");
						writer.write(c[i] + " ");
					}
					System.out.println();
					System.out.println("b = ");
					for (int i = 0; i < b.length; i++) {
						for (int j = 0; j < b[i].length; j++) {
							System.out.print(b[i][j] + " ");
							writer.write(b[i][j] + " ");
						}
						System.out.println();
					}
					writer.flush();
					writer.close();

				} catch (IOException e) {
					System.out.println("Error while reading a file.");
					System.out.println(e.getMessage());
					System.exit(0);
				}
			}

		} while (select != 0);
		input.close();
	}
}
