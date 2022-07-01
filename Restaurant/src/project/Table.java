package project;

public class Table 
{
	private static boolean [] tables = new boolean[5];
	private static boolean busy = false;
	
	
	public synchronized void seatTable(int i)
	{
		busy = false;
		tables[i] = true;
		notifyAll();
	}
	
	
	public static void openTable(int i)
	{
			tables[i] = false;
	}
	
	
	public synchronized int findTable() throws InterruptedException
	{
		if(busy)
			wait();
		busy = true;
		
		while(maxCapacity())
			Thread.sleep(1);
		
		for(int i = 0; i < tables.length; i++)
			if(!tables[i]) return i;
		return -1;
	}
	
	
	public synchronized boolean maxCapacity()
	{
		
		for(int i = 0; i < tables.length; i++)
			if(!tables[i]) return false;
		return true;

	}
	
}
