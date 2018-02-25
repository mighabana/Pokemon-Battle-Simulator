
public class Bug implements Type {

	private String name;
	private String[] weakness;
	private String[] ineffective;
	private String[] notEffective;
	
	public Bug()
	{
		name = "Bug";
		
		String[] w = {"Flying", "Rock", "Fire"};
		weakness = w;
		String[] i = {"Fighting","Ground", "Grass"};
		ineffective = i;
		String[] n = {""};
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
