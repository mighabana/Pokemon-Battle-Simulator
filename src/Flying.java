
public class Flying implements Type {

	private String name;
	private String[] weakness;
	private String[] ineffective;
	private String[] notEffective;
	
	public Flying()
	{
		name = "Flying";
		
		String[] w = {"Rock", "Electric", "Ice"};
		weakness = w;
		String[] i = {"Fighting","Bug", "Grass"};
		ineffective = i;
		String[] n = {"Ground"};
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
