
public class ToolStore extends NormalLocation {

	public ToolStore(Player player) {
		super(player, "Ma�aza");

	}

	@Override
	public boolean getLocation() {
		System.out.println("Para : " + getPlayer().getMoney());
		System.out.println("1. Silahlar");
		System.out.println("2. Z�rhlar");
		System.out.println("3. ��k��");
		System.out.println("Se�iminiz : ");
		int selectTool = scan.nextInt();
		int selectItemID;
		switch (selectTool) {
		case 1:
			selectItemID = weaponMenu();
			buyWeapon(selectItemID);
			break;
		case 2:
			selectItemID = armorMenu();
			buyArmor(selectItemID);
			break;

		default:

		}

		return true;
	}

	public void buyArmor(int itemID) {

		int avoid = 0, price = 0;
		String aName = null;

		switch (itemID) {
		case 1:
			avoid = 1;
			aName = "Hafif Z�rh";
			price = 15;
			break;
		case 2:
			avoid = 3;
			aName = "Orta Z�rh";
			price = 25;
			break;
		case 3:
			avoid = 5;
			aName = "A��r";
			price = 45;
			break;
		case 4:
			System.out.println("��k�� yap�ld�..");
			break;
		default:
			System.out.println("Ge�ersiz i�lem!");
			break;
		}

		if (price > 0) {

			if (player.getMoney() >= price) {
				player.getInv().setArmor(avoid);
				player.getInv().setArmorName(aName);
				player.setMoney(player.getMoney() - price);
				System.out.println(aName + " sat�n ald�n�z, Engellenen Hasar : " + player.getInv().getArmor());
				System.out.println("Kalan Para : " + player.getMoney());

			} else {
				System.out.println("Para yetersiz!!");
			}
		}
	}

	public int armorMenu() {
		System.out.println("1. Hafif\t  <Para : 15 - Engelleme : 1>");
		System.out.println("2. Orta \t  <Para : 25 - Engelleme : 3>");
		System.out.println("3. A��r \t  <Para : 40 - Engelleme : 5>");
		System.out.println("4. ��k��");
		System.out.println("Z�rh Se�iniz : ");
		int selectArmor = scan.nextInt();
		return selectArmor;

	}

	public int weaponMenu() {
		System.out.println("1. Taban\t <Para : 25 - Hasar : 2>");
		System.out.println("2. K�l��\t <Para : 35 - Hasar : 3>");
		System.out.println("3. T�fek\t <Para : 45 - Hasar : 7>");
		System.out.println("4. ��k��");
		System.out.println("Silah Se�iniz : ");
		int selectWeapon = scan.nextInt();
		return selectWeapon;

	}

	public void buyWeapon(int itemID) {

		int damage = 0, price = 0;
		String wName = null;

		switch (itemID) {
		case 1:
			damage = 2;
			wName = "Tabanca";
			price = 25;
			break;
		case 2:
			damage = 3;
			wName = "K�l��";
			price = 35;
			break;
		case 3:
			damage = 7;
			wName = "T�fek";
			price = 45;
			break;
		case 4:
			System.out.println("��k�� yap�ld�..");
			break;
		default:
			System.out.println("Ge�ersiz i�lem!");
			break;
		}

		if (price > 0) {

			if (player.getMoney() >= price) {
				player.getInv().setDamage(damage);
				player.getInv().setWeaponName(wName);
				player.setMoney(player.getMoney() - price);
				System.out.println(wName + " sat�n ald�n�z, �nceki Hasar: " + player.getDamage() + ", Yeni Hasar : "
						+ player.getTotalDamage());
				System.out.println("Kalan Para : " + player.getMoney());

			} else {
				System.out.println("Para yetersiz!!");
			}
		}

	}

}
