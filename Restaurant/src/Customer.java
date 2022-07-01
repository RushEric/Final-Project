import java.util.*;

public class Customer implements Runnable
{
	private Random random = new Random();
	private int customer_num = random.nextInt(899999) + 100001;
	private int choice;
	private int size;
	private int eat_time;
	
	private static int amount = 0;
	
	private int table = -1;
	private boolean hasFood = false;
	

	
	public Customer()
	{
		choice = random.nextInt(4) + 1;
		size = random.nextInt(3) + 1;
		eat_time = random.nextInt(800 + 1) + 400;
		amount++;
	}

	
	public static int getAmountServed()
	{
		return amount;
	}
	

	public void leaveTable()
	{
		Table.openTable(table);
	}
	
	
	public void setTable(int table)
	{
		this.table = table;
	}
	
	
	public int getOrder()
	{
		return choice;
	}
	
	
	public char getSize()
	{
		switch(size)
		{
			case 1:
				return 'S';
			case 2:
				return 'L';
			default:
				return 'M';
		}
	}
	
	
	public boolean hasFood()
	{
		return hasFood;
	}
	
	
	public void giveFood(Menu food)
	{
		hasFood = true;
	}
	
	
	
	@Override
	public void run() 
	{
		System.out.println("     Customer #" + customer_num + " enters store at Time : " + Time.timeGet());
		while(!hasFood)
			Thread.yield();
		
		System.out.println("     Customer #" + customer_num + " eating at Table : " + table + " : " + Time.timeGet());
		
		try 
		{
			Thread.sleep(eat_time);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("     Customer #" + customer_num + " leaves Table :  " + table + " : " + Time.timeGet());
		leaveTable();
	}
}
