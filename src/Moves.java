import java.io.Serializable;


/**
 * This class is the super class for all the pokemon's moves
 * @author Miguel Habana
 *
 */
public class Moves implements Serializable {

	private String name;
	private int power;
	private int accuracy;
	private int maxPP;
	private int remPP;
	private String type;
	private String kind;
	
	/**
	 * Basic no parameter constructor for the class
	 */
	
	public Moves()
	{
		name = "";
		power = 0;
		accuracy = 0;
		maxPP = 0;
		remPP = 0;
		type = "";
		kind = "";
	}
	
	/**
	 * Constructor that allows for alteration of the name power, accuracy, pp details, type, and kind of attack
	 * @param n name of the move
	 * @param p power of the move
	 * @param a accuracy of the move
	 * @param mPP maximum PP of the move
	 * @param rPP remaining PP of the move
	 * @param t type of the move
	 * @param k kind of attack
	 */
	public Moves(String n, int p, int a, int mPP, int rPP, String t,String k)
	{
		name = n;
		power = p;
		accuracy = a;
		maxPP = mPP;
		remPP = rPP;
		type = t;
		kind = k;
	}
	
	/**
	 * gets the name of the move
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * gets the power of the move
	 * @return power
	 */
	public int getPower()
	{
		return power;
	}
	
	/**
	 *  gets the accuracy of the move
	 * @return accuracy
	 */
	public int getAccuracy()
	{
		return accuracy;
	}
	
	/**
	 * gets the maximum PP of the move
	 * @return maxPP
	 */
	public int getMaxPP()
	{
		return maxPP;
	}
	
	/**
	 * gets the remaining PP of the move
	 * @return remaining PP
	 */
	public int getRemPP()
	{
		return remPP;
	}
	
	/**
	 * subtracts the PP of the move
	 */
	public void subtractPP()
	{
		remPP--;
	}
	
	/**
	 * Gets the type of the move
	 * @return
	 */
	public String getType()
	{
		return type;
	}
	
	/**
	 * uses the move and returns a value representing the damage of the move
	 * @param user the user of the move
	 * @param target the target of the move
	 * @return the damage dealt
	 */
	public int use(Pokemon user, Pokemon target)
	{
		
		double STAB = 1;
		
		if(this.getType().equals(user.getType().get(0).getName()) || this.getType().equals(user.getType().get(1).getName()))
			STAB = 1.5;
		
		//=======================================================//
		
		double effectiveness = 1;
		
		for(int i = 0; i < (target.getType()).size();i++ )
		{
			Type t = (target.getType()).get(i);
			for(int z = 0; z < t.getWeakness().length; z++)
			{
				String[] weak = t.getWeakness();
				if(weak[z].equals(this.getType()))
				{
					effectiveness *= 2;
				}
			}
			for(int z = 0; z < t.getIneffective().length; z++)
			{
				String[] inef = t.getIneffective();
				if(inef[z].equals(this.getType()))
				{
					effectiveness *= 0.5;
				}
				
			}
			for(int z = 0; z < t.getNotEffective().length; z++)
			{
				String[] not = t.getNotEffective();
				if(not[z].equals(this.getType()))
				{
					effectiveness *= 0;
				}
			}
		}
		
		//=======================================================//

		
		int crit = 1;
		boolean critChance = (int) (Math.random()*16) + 1 == 1;
			//still have to adjust crit chance for high crit ratio moves and triggered effects
			//http://bulbapedia.bulbagarden.net/wiki/Critical_hit
		
		
		if(critChance)
			crit = 2;
			//critical hit message;
		
		
		//=======================================================//

		double rand = ((int) (Math.random()*16) + 85)/100.0;
		
		double modifier = STAB*effectiveness*crit*rand;
		
		
		
		int damage = 0;
		if(this.kind.equals("Special"))
			damage = (int) (((0.84)*((double) user.getSpAttack()/target.getSpDefense())*this.getPower() + 2) * modifier);
		else if(this.kind.equals("Physical"))
			damage = (int) (((0.84)*((double) user.getAttack()/target.getDefense())*this.getPower() + 2) * modifier);
		
		subtractPP();
		
		if((int)(Math.random()*100)+1 <= this.getAccuracy())
			return damage;
		else
			return 0;
		
	}
	
}