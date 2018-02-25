
public class Ground implements Type {

	private String name;
	private String[] weakness;
	private String[] ineffective;
	private String[] notEffective;
	
	public Ground()
	{
		name = "Fire";
		
		String[] w = {"Water", "Grass", "Ice"};
		weakness = w;
		String[] i = {"Posion", "Rock"};
		ineffective = i;
		String[] n = {"Electric"};
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