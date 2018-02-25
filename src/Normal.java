
public class Normal implements Type {

	private String name;
	private String[] weakness;
	private String[] ineffective;
	private String[] notEffective;
	
	public Normal()
	{
		name = "Normal";
		
		String[] w = {"Fighting"};
		weakness = w;
		String[] i = {""};
		ineffective = i;
		String[] n = {"Ghost"};
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
