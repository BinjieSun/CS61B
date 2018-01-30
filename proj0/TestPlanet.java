public class TestPlanet {
	public static void main(String[] args) {
		checkPlanet();
	}

	public static void checkPlanet() {
		Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, " ");
		Planet p2 = new Planet(3.0, 3.0, 1.0, 5.0, 2.0, " ");
		double f = p1.calcForceExertedBy(p2);
		System.out.println("Pairwise force between p1 and p2 equals: " + f);
	}
}