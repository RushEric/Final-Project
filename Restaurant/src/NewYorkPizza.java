public class NewYorkPizza <C extends Character, S extends String> extends Menu
{
	private int multi = 1;
	
	
	public NewYorkPizza(C size)
	{
		if(size == 'L')
			multi = 3;
		else if(size == 'M')
			multi = 2;
	}
	
	public NewYorkPizza(S size)
	{
		if(size == "LARGE")
			multi = 3;
		else if(size == "MEDIUM")
			multi = 2;
	}
	
	
	@Override
	public int getTime() 
	{
		return 300 * multi;
	}
	
}
