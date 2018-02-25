
public class Fire implements Type {

	private String name;
	private String[] weakness;
	private String[] ineffective;
	private String[] notEffective;
	
	public Fire()
	{
		name = "Fire";
		
		String[] w = {"Ground", "Rock", "Water"};
		weakness = w;
		String[] i = {"Bug","Steel", "Fire", "Grass", "Ice"};
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
