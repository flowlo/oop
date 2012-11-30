



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameField field=new GameField(10, 10);
		fastCar car1=new fastCar(field, 5, 5, Autodrom.direction.west, 'x', 7);
		fastCar car2=new fastCar(field, 2, 2, Autodrom.direction.west, 'i', 30);
		Watcher watcher=new Watcher(field);
		watcher.start();		
		car1.start();
		car2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("car1 (x): "+car1.getPoints());
		System.out.println("car2 (i): "+car2.getPoints());
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
				int counter=0;
				while(!this.isInterrupted())
				{
					counter++;
					if(counter>10)
					{
						this.interrupt();
						break;
					}
					Thread.sleep(50);
					System.out.println(field.toString());
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
