import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int row, column;
		System.out.println("Ho�geldin");
		System.out.println("Oynamak istedi�iniz boyutlar� giriniz.");
		System.out.print("Sat�r Say�s�:");
		row = scan.nextInt();
		System.out.print("S�tun Say�s�:");
		column = scan.nextInt();

		MayinTarlasi oyun = new MayinTarlasi(row, column);

		oyun.run();
	}

}
