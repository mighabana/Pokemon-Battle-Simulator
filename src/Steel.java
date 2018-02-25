
public class Steel implements Type {

	private String name;
	private String[] weakness;
	private String[] ineffective;
	private String[] notEffective;
	
	public Steel()
	{
		name = "Steel";
		
		String[] w = {"Fighting", "Ground", "Fire"};
		weakness = w;
		String[] i = {"Normal","Flying", "Rock", "Bug", "Ghost", "Steel", "Grass", "Psychic","Ice" ,"Dragon", "Dark"};
		ineffective = i;
		String[] n = {"Poison"};
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