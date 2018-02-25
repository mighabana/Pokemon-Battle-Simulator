
public class Fighting implements Type {

	private String name;
	private String[] weakness;
	private String[] ineffective;
	private String[] notEffective;
	
	public Fighting()
	{
		name = "Fighting";
		
		String[] w = {"Flying", "Psychic"};
		weakness = w;
		String[] i = {"Rock","Bug", "Dark"};
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