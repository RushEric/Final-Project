package project;

public class Time implements Runnable 
{
	private static int time = 0;
	
	
	public void passage_of_time()
	{
		time++;
	}
	
	
	public static int timeGet()
	{
		return time;
	}
	
	
	public static boolean hasStopped()
	{
		return (time >= 28800 || time == 0);
	}
	
	
	@Override
	public void run() 
	{
		System.out.println("~=~=~=~=~=~=~=~=~=~= Log Starts ~=~=~=~=~=~=~=~=~=~=");
		while(time < 28800)
		{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			passage_of_time();
;			//System.out.println(time);
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("CUSTOMERS SERVED: " + Customer.getAmountServed());
		System.out.println("~=~=~=~=~=~=~=~=~=~= Log Ends ~=~=~=~=~=~=~=~=~=~=");
		System.exit(0);
	}
	
}
