
public class Rock implements Type {

	private String name;
	private String[] weakness;
	private String[] ineffective;
	private String[] notEffective;
	
	public Rock()
	{
		name = "Rock";
		
		String[] w = {"Fighting", "Steel", "Ground", "Water", "Grass"};
		weakness = w;
		String[] i = {"Normal","Flying","Fire", "Poison"};
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