public class Kendaraan {
	int jumlahRoda;
	Makanan food;

	public Kendaraan(int jumlahRoda) {
		this.jumlahRoda = jumlahRoda;

		if(this.jumlahRoda > 4) {
			food = new Makanan();
		}
	}

	public Kendaraan() {
		this.jumlahRoda = 4;
	}
 
	public void jalan(String message) {
		System.out.println("Vrmm" + message + "......////");

		if(this.food != null) {
			this.food.calorie++;
		}
	}
}