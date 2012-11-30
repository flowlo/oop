



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameField field=new GameField(10, 10);
		fastCar car1=new fastCar(field, 5, 5, Autodrom.direction.west);
		car1.start();
	}

}
