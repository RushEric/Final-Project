public class Waiter implements Runnable
{
	private Customer serving = null;
	private int serving_table;
	
	
	public void getCustomer()
	{
		serving = new Customer();
	}
	
	
	private void seatTable() throws InterruptedException
	{	
		Table ourTable = new Table();
		
		serving_table = ourTable.findTable(); //Finds a table thats open
		serving.setTable(serving_table); //Customer is seated on that open table (Customer Object holds index number for the table it was seated in)
		ourTable.seatTable(serving_table); //Table is labeled occupied (The table index is set to true[meaning its occupied])
	}
	
	
	
	public void gotoChef() throws InterruptedException
	{
		Chef ourChef = new Chef();
		int order = serving.getOrder();
		char size = serving.getSize();
		ourChef.getChef(order, size);
	}
	
	
	public Menu getFood()
	{
		Chef ourChef = new Chef();
		return ourChef.getFood();
	}
	
	
	private void serveCustomer(Menu food)
	{
		serving.giveFood(food);
		serving = null;
	}
	
	
	@Override
	public void run() 
	{
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		while(!Time.hasStopped())
		{
			
			getCustomer(); //Calls Customer from 
			
			
			Thread customer = new Thread(serving);
			customer.start();
			
			
			try 
			{
				seatTable(); //Seats a Customer (Assigns a table number to Customer)
			} 
			catch (InterruptedException e2) 
			{
				e2.printStackTrace();
			}
				
			
			try 
			{
				gotoChef(); //Tells Chef to cook Customer order
			} 
			catch (InterruptedException e1) 
			{
				e1.printStackTrace();
			}
		
			
			Menu food = null;
			
			
			try 
			{
				Thread.sleep(Chef.cookTime());
				food = getFood();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			serveCustomer(food); //Waiter delivers food to customer
		}
	}
	
}
