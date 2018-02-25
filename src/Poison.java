
public class Poison implements Type {

	private String name;
	private String[] weakness;
	private String[] ineffective;
	private String[] notEffective;
	
	public Poison()
	{
		name = "Poison";
		
		String[] w = {"Ground", "Psychic"};
		weakness = w;
		String[] i = {"Fight","Poison", "Bug", "Grass"};
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