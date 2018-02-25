
public class Water implements Type {

	private String name;
	private String[] weakness;
	private String[] ineffective;
	private String[] notEffective;
	
	public Water()
	{
		name = "Water";
		
		String[] w = {"Grass", "Electric"};
		weakness = w;
		String[] i = {"Water","Steel","Fire","Ice"};
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