
public class SafeHouse extends NormalLocation {

	public SafeHouse(Player player) {
		super(player, "G�venli Ev");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean getLocation() {
		player.setHealth(player.getrHealth());
		System.out.println("Sa�l�n�z iyile�ti!!");
		System.out.println("�uan G�venli Evdesiniz..");
		return true;
	}
}
