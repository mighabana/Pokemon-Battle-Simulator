
public class Electric implements Type {

	private String name;
	private String[] weakness;
	private String[] ineffective;
	private String[] notEffective;
	
	public Electric()
	{
		name = "Electric";
		
		String[] w = {"Ground"};
		weakness = w;
		String[] i = {"Flying","Steel", "Grass"};
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