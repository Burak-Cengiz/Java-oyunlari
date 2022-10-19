import java.util.Scanner;

public class Game {

	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);

	public void login() {

		System.out.println("Macera oyununa hoþgeldiniz !");
		System.out.print("Oyuna baþlamadan önce isminizi giriniz: ");
		String playerName = scan.nextLine();
		player = new Player(playerName);
		player.selectCharacter();
		start();

	}

	public void start() {
		while (true) {
			System.out.println();
			System.out.println("=================");
			System.out.println();
			System.out.println("Eylem gerçekleþtirmek için bir yerler ");
			System.out.println("1. Güvenli Ev --> Size ait güvenli bir mekan");
			System.out.println("2. Maðara --> Karþýnýza zombi çýkabilir!");
			System.out.println("3. Orman--> Karþýnýza vampir çýkabilir!");
			System.out.println("4. Nehir --> Karþýnýza ayý çýkabilir!");
			System.out.println("5. Maðaza --> Silah veya Zýrh alabilirsiniz..");
			System.out.println("Gitmek istediðiniz yer :  ");
			int selectLocation = scan.nextInt();

			while (selectLocation < 0 || selectLocation > 5) {
				System.out.println("Lütfen geçerli bir lokasyon seçiniz!!!");
				selectLocation = scan.nextInt();
			}

			switch (selectLocation) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4:
				location = new River(player);
				break;
			case 5:
				location = new ToolStore(player);
				break;

			default:
				location = new SafeHouse(player);
				break;
			}

			if (location.getClass().getName().equals("SafeHouse")) {
				if (player.getInv().isFirewood() && player.getInv().isWater() && player.getInv().isFood()) {
					System.out.println("Tebrikler Kazandýnýz!!!!");
					break;
				}
			}

			if (!location.getLocation()) {
				System.out.println("Oyun Bitti!!");
				break;
			}

		}
	}
}
