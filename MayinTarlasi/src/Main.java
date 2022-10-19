import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int row, column;
		System.out.println("Hoþgeldin");
		System.out.println("Oynamak istediðiniz boyutlarý giriniz.");
		System.out.print("Satýr Sayýsý:");
		row = scan.nextInt();
		System.out.print("Sütun Sayýsý:");
		column = scan.nextInt();

		MayinTarlasi oyun = new MayinTarlasi(row, column);

		oyun.run();
	}

}
