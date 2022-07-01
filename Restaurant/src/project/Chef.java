package project;

public class Chef 
{
	private static Menu dish = null;

	
	
	public synchronized void getChef(int choice, char size) throws InterruptedException
	{
		if(dish != null) wait();
		dish = cookBook(choice, size);
	}
	
	
	public static synchronized boolean busy()
	{
			if(dish == null) return false;
			return true;
	}
	
	
	private Menu cookBook(int choice, char size)
	{
		Menu cook = new NewYorkPizza<>(size);
		switch(choice)
		{
			case 2:
				cook = new ChicagoPizza<>(size);
				return cook;
			case 3:
				cook = new NepolitanPizza<>(size);
				return cook;
			case 4:
				cook = new SicillanPizza<>(size);
				return cook;
			default:
				return cook;
		}
	}
	
	
	public static int cookTime()
	{
		synchronized(Chef.class)
		{
			return dish.getTime();
		}
	}
	
	
	public synchronized Menu getFood()
	{
		Menu delievered = dish;
		dish = null;
		notifyAll();
		return delievered;
	}
	
}
