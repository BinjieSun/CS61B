public class NBody {
	public static double readRadius(String filePath) {
		In in = new In(filePath);
		int numberOfPlanets = in.readInt();
		double radiusOfUniverse = in.readDouble();
		return radiusOfUniverse;
	}

	public static Planet[] readPlanets(String filePath) {
		In in = new In(filePath);
		int numberOfPlanets = in.readInt();
		double radiusOfUniverse = in.readDouble();
		Planet[] planets = new Planet[numberOfPlanets];

		for (int i = 0; i < numberOfPlanets; i += 1) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble(); 
			String img = in.readString();

			planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
		}
		return planets;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);

		double t = 0;
		StdAudio.play("audio/2001.mid");

		while (t < T) {
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];
			
			for (int i = 0; i < planets.length; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			
			for (int i = 0; i < planets.length; i++) {
				planets[i].update(dt, xForces[i], yForces[i]);
			}

			String imgToDraw = "images/starfield.jpg";
			StdDraw.setScale(-radius, radius);
			StdDraw.picture(0, 0, imgToDraw, 2*radius, 2*radius);

			for (Planet p: planets) {
				p.draw();
			}

			StdDraw.enableDoubleBuffering();
			StdDraw.show(10);	
			t = t + dt;		
		}
		
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
		                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}		
	}
}