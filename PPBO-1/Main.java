public class Main {
	public static void main(String[] args) {
		Kendaraan aceng = new Kendaraan(5);
		Kendaraan gtr = new Kendaraan();

		gtr.jalan("mmmmmm");

		aceng.jalan("waaaaaa");
		aceng.jalan("wooooo");

		System.out.println(aceng.getCalorie());
		System.out.println(gtr.getCalorie());
	}
}