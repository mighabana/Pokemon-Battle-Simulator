
public class Ice implements Type {

	private String name;
	private String[] weakness;
	private String[] ineffective;
	private String[] notEffective;
	
	public Ice()
	{
		name = "Ice";
		
		String[] w = {"Fighting", "Rock", "Steel", "Fire"};
		weakness = w;
		String[] i = {"Ice"};
		ineffective = i;
		String[] n = {};
		notEffective = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String[] getWeakness()
	{
		return weakness;
	}
	
	public String[] getIneffective()
	{
		return ineffective;
	}
	
	public String[] getNotEffective()
	{
		return notEffective;
	}
}