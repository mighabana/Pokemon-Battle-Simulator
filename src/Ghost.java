
public class Ghost implements Type {

	private String name;
	private String[] weakness;
	private String[] ineffective;
	private String[] notEffective;
	
	public Ghost()
	{
		name = "Ghost";
		
		String[] w = {"Ghost", "Dark"};
		weakness = w;
		String[] i = {"Poison","Bug"};
		ineffective = i;
		String[] n = {"Normal", "Fighting"};
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