
public class Dark implements Type {

	private String name;
	private String[] weakness;
	private String[] ineffective;
	private String[] notEffective;
	
	public Dark()
	{
		name = "Dark";
		
		String[] w = {"Fighting", "Bug"};
		weakness = w;
		String[] i = {"Ghost","Dark"};
		ineffective = i;
		String[] n = {"Psychic"};
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