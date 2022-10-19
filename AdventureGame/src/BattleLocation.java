
public abstract class BattleLocation extends Location {

	protected Obstacle obstacle;
	protected String award;

	public BattleLocation(Player player, String name, Obstacle obstacle, String award) {
		super(player);
		this.name = name;
		this.obstacle = obstacle;
		this.award = award;
	}

	@Override
	public boolean getLocation() {

		int obstacleCount = obstacle.obstacleCount();
		System.out.println("Þuan buradasýnýz : " + this.getName());
		System.out.println("Dikkatli ol! Burada " + obstacleCount + " tane " + obstacle.getName() + " yaþýyor !");
		System.out.println("<S>avaþ veya <K>aç");
		String selectCase = scan.nextLine();
		selectCase = selectCase.toUpperCase();
		if (selectCase.equals("S")) {
			if (combat(obstacleCount)) {
				System.out.println(this.getName() + " bölgesindeki" + "Tüm düþmanlarý temizlediniz!!");
				if (this.award.equals("Food") && player.getInv().isFood() == false) {
					System.out.println(this.award + " Kazandýnýz!");
					player.getInv().setFood(true);
				} else if (this.award.equals("Firewood") && player.getInv().isFirewood() == false) {
					System.out.println(this.award + " Kazandýnýz!");
					player.getInv().setFirewood(true);
				} else if (this.award.equals("Water") && player.getInv().isWater() == false) {
					System.out.println(this.award + " Kazandýnýz!");
					player.getInv().setWater(true);
				}
				return true;
			}
			if (player.getHealth() <= 0) {
				System.out.println("Öldünüz!!");
				return false;
			}

		}

		return true;
	}

	public boolean combat(int obstacleCount) {
		for (int i = 0; i < obstacleCount; i++) {
			int defObsHealt = obstacle.getHealth();
			playerStats();
			enemyStats();
			while (player.getHealth() > 0 && obstacle.getHealth() > 0) {
				System.out.println("<V>ur veya <K>aç");
				String selCase = scan.nextLine();
				selCase = selCase.toUpperCase();
				if (selCase.equals("V")) {
					System.out.println("Siz vurdunuz !");
					obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
					afterHit();
					if (obstacle.getHealth() > 0) {
						System.out.println("Canavar size vurdu !");
						player.setHealth(player.getHealth() - (obstacle.getDamage() - player.getInv().getArmor()));
						afterHit();
					}

				} else {
					break;
				}
			}
			if ((obstacle.getHealth() <= 0) && (player.getHealth() > 0)) {
				System.out.println("Düþmaný yendiniz !");
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("Güncel Paranýz : " + player.getMoney());
				obstacle.setHealth(defObsHealt);
			} else {
				return false;
			}
			System.out.println("----------------------");

		}
		return true;
	}

	public void afterHit() {
		System.out.println("Oyuncu Can: " + player.getHealth());
		System.out.println(obstacle.getName() + " Caný: " + obstacle.getHealth() + "\n");
	}

	private void enemyStats() {
		System.out.println("\n" + obstacle.getName() + " Deðerleri\n------------");
		System.out.println("Can: " + obstacle.getHealth());
		System.out.println("Hasar: " + obstacle.getDamage());
		System.out.println("Ödül: " + obstacle.getAward());
	}

	public void playerStats() {
		System.out.println("Oyuncu Bilgileri\n------------");
		System.out.println("Can: " + player.getHealth());
		System.out.println("Hasar: " + player.getTotalDamage());
		System.out.println("Para: " + player.getMoney());
		if (player.getInv().getDamage() > 0) {
			System.out.println("Silah: " + player.getInv().getWeaponName());
		}
		if (player.getInv().getArmor() > 0) {
			System.out.println("Zýrh: " + player.getInv().getArmorName());
		}
	}

}
