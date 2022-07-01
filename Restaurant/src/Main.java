public class Main
{
	public static void main(String [] args) throws InterruptedException
	{
		Time seconds = new Time(); 
		Thread clock = new Thread(seconds); //Makes a clock to keep track of time 
		
		Waiter Linda = new Waiter();
		Waiter Mark = new Waiter();
		Waiter Joe = new Waiter();
		
		Thread T_Linda = new Thread(Linda); //Thread waiter Linda
		Thread T_Mark = new Thread(Mark); //Thread waiter Mark
		Thread T_Joe = new Thread(Joe); //Thread waiter Joe
		
		clock.start();
		Thread.sleep(100);
		
		T_Linda.start();
		Thread.sleep(100);
		
		T_Mark.start();
		
		Thread.sleep(100);
		T_Joe.start();
		
	}
}
