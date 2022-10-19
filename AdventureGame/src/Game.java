import java.util.Scanner;

public class Game {

	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);

	public void login() {

		System.out.println("Macera oyununa ho�geldiniz !");
		System.out.print("Oyuna ba�lamadan �nce isminizi giriniz: ");
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
			System.out.println("Eylem ger�ekle�tirmek i�in bir yerler ");
			System.out.println("1. G�venli Ev --> Size ait g�venli bir mekan");
			System.out.println("2. Ma�ara --> Kar��n�za zombi ��kabilir!");
			System.out.println("3. Orman--> Kar��n�za vampir ��kabilir!");
			System.out.println("4. Nehir --> Kar��n�za ay� ��kabilir!");
			System.out.println("5. Ma�aza --> Silah veya Z�rh alabilirsiniz..");
			System.out.println("Gitmek istedi�iniz yer :  ");
			int selectLocation = scan.nextInt();

			while (selectLocation < 0 || selectLocation > 5) {
				System.out.println("L�tfen ge�erli bir lokasyon se�iniz!!!");
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
					System.out.println("Tebrikler Kazand�n�z!!!!");
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
