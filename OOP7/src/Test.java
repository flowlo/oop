/**
 * @author Simon
 * 
 *         Die Zusicherungen in allen Klassen wurden von Dominik geschrieben.
 * 
 *         Zusicherungen:
 *         * Die Testlaeufe dauern in Summe nicht laenger, als 10 Sekunden
 *         * Jeder Testlauf erzeugt unterschiedlich grosse Felder und eine verschiedene Anzahl an Autodroms.
 *         * In jedem Testlauf muessen Autodroms zusammenstossen.
 */
public class Test {

	private static int count = 0;
	private static GameField field;
	private static boolean stop = false;
	private static Watcher watcher = new Watcher();

	public static void main(String[] args)
	{
		watcher.start();
		nextTest();
	}

	public static void nextTest()
	{
		if (stop)
			return;
		count++;
		if (count == 1)
		{
			System.out.println("Die Autos haben zufaellige bewegungen. Jeder Durchlauf hat also ein anderes Ergebnis.");
			System.out.println("\nStarte Test mit 10x10 Feld und 3 Autos.\n");
			field = new GameField(10, 10);
			FastCar car1 = new FastCar(field, 5, 5, Autodrom.direction.west, 10, 100, 'x');
			FlexibleCar car2 = new FlexibleCar(field, 2, 2, Autodrom.direction.east, 20, 100, 'i');
			FlexibleCar car3 = new FlexibleCar(field, 7, 7, Autodrom.direction.north, 20, 100, 'l');
			car1.start();
			car2.start();
			car3.start();
		}
		else if (count == 2)
		{
			field = new GameField(100, 100);
			System.out.println("\n\nStarte Test mit 15x15 Feld und 6 Autos.\n");
			FastCar car1 = new FastCar(field, 5, 5, Autodrom.direction.west, 10, 200, 'x');
			FastCar car2 = new FastCar(field, 13, 13, Autodrom.direction.west, 10, 200, 'y');
			FlexibleCar car3 = new FlexibleCar(field, 8, 8, Autodrom.direction.east, 20, 200, 'i');
			FlexibleCar car4 = new FlexibleCar(field, 12, 3, Autodrom.direction.south, 20, 200, 'j');
			FlexibleCar car5 = new FlexibleCar(field, 3, 13, Autodrom.direction.north, 20, 200, 'l');
			FlexibleCar car6 = new FlexibleCar(field, 2, 9, Autodrom.direction.north, 20, 200, 'l');
			car1.start();
			car2.start();
			car3.start();
			car4.start();
			car5.start();
			car6.start();
		}
		else if (count == 3)
		{
			System.out.println("\n\nStarte Test mit 5x7 Feld und 2 Autos.\n");
			field = new GameField(5, 7);
			FastCar car2 = new FastCar(field, 2, 2, Autodrom.direction.east, 10, 100, 'y');
			FlexibleCar car3 = new FlexibleCar(field, 3, 6, Autodrom.direction.north, 20, 100, 'i');
			car2.start();
			car3.start();
		}
		else
		{
			System.out.println("ENDE");
			watcher.interrupt();
		}
	}

	public static class Watcher extends Thread
	{
		@Override
		public void run()
		{
			try {
				Thread.sleep(8000);
				System.out.println("\nWatcher - Beendet nach 8 sekunden");
			} catch (InterruptedException e) {
				System.out.println("\nWatcher wurde beendet. Programm terminiert.");
			}
			Test.stop = true;
			Test.field.stopRace();
		}
	}

}
