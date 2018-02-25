
public class Dragon implements Type {

	private String name;
	private String[] weakness;
	private String[] ineffective;
	private String[] notEffective;
	
	public Dragon()
	{
		name = "Dragon";
		
		String[] w = {"Ice","Dragon"};
		weakness = w;
		String[] i = {"Fire","Water", "Grass","Electric"};
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
