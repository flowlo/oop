



public class Test {

	public static void main(String[] args) 
	{
		GameField field=new GameField(10, 10);
		fastCar car1=new fastCar(field, 5, 5, Autodrom.direction.west, 'x', 1);
		FlexibleCar car2=new FlexibleCar(field, 2, 2, Autodrom.direction.west, 'i', 1);
		Watcher watcher=new Watcher(field);
		watcher.start();		
		car1.start();
		car2.start();
		
	}
	
	public static class Watcher extends Thread
	{
		private GameField field;
		Watcher(GameField field)
		{
			this.field=field;
		}
		
		public void run()
		{
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			field.stopRace();
			
		}
	}

}
