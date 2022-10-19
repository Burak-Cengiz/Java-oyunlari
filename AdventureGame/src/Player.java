import java.util.Scanner;

public class Player {

	private int damage, health, money, rHealth;
	private String name, cName;
	private Inventory inv;

	public int getrHealth() {
		return rHealth;
	}

	public void setrHealth(int rHealth) {
		this.rHealth = rHealth;
	}

	Scanner scan = new Scanner(System.in);

	public Player(String name) {
		this.name = name;
		this.inv = new Inventory();
	}

	public void selectCharacter() {

		switch (characterMenu()) {
		case 1:
			initPlayer("Samuray", 5, 21, 15);

			break;
		case 2:
			initPlayer("Okçu", 7, 18, 20);

			break;
		case 3:
			initPlayer("Þovalye", 8, 24, 5);

			break;
		default:
			initPlayer("Samuray", 5, 21, 15);

			break;

		}
		System.out.println("Karakter : " + getcName() + "\t Hasar:" + getDamage() + "\t Saðlýk :" + getHealth()
				+ "\t Para:" + getMoney());
	}

	public int characterMenu() {
		System.out.println("Lütfen bir karakter seçiniz : ");
		System.out.println("1- Samuray: \t Hasar : 5, \tSaðlýk : 21, \tPara : 15");
		System.out.println("2- Okçu:    \t Hasar : 7, \tSaðlýk : 18, \tPara : 20");
		System.out.println("3- Þovalye: \t Hasar : 8, \tSaðlýk : 24, \tPara : 5");
		System.out.println("Karakter Seçiminiz: ");
		int chaID = scan.nextInt();

		while (chaID < 1 || chaID > 3) {
			System.out.print("Lütfen geçerli bir karakter seçiniz.");
			chaID = scan.nextInt();
		}

		return chaID;
	}

	public int getTotalDamage() {
		return this.getDamage() + this.getInv().getDamage();
	}

	private void initPlayer(String cName, int dmg, int healt, int mny) {
		setcName(cName);
		setDamage(dmg);
		setHealth(healt);
		setMoney(mny);
		setrHealth(healt);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

}
