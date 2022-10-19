
public class SafeHouse extends NormalLocation {

	public SafeHouse(Player player) {
		super(player, "Güvenli Ev");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean getLocation() {
		player.setHealth(player.getrHealth());
		System.out.println("Saðlýnýz iyileþti!!");
		System.out.println("Þuan Güvenli Evdesiniz..");
		return true;
	}
}
