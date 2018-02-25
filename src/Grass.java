
public class Grass implements Type {

	private String name;
	private String[] weakness;
	private String[] ineffective;
	private String[] notEffective;
	
	public Grass()
	{
		name = "Grass";
		
		String[] w = {"Flying", "Poison", "Bug", "Fire","Ice"};
		weakness = w;
		String[] i = {"Ground","Water", "Electric", "Grass"};
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