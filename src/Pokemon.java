import java.awt.image.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import javax.imageio.ImageIO;

/**
 * This is the super class for all the pokemon
 * @author Miguel Habana
 *
 */
public class Pokemon implements Serializable {

	private String name;
	
	private int maxHP;
	private int remHP;
	private double percentHP;
	private int baseHP;
	private int attack;
	private int baseAttack;
	private int defense;
	private int baseDefense;
	private int spAttack;
	private int baseSpAttack;
	private int spDefense;
	private int baseSpDefense;
	private int speed;
	private int baseSpeed;
	
	
	private ArrayList<Type> type;
	
	private DMSRecord frontImage = new DMSRecord();
	private DMSRecord backImage = new DMSRecord();
	private DMSRecord miniImage = new DMSRecord();
	
	private Moves[] moves;
	private Moves[] possibleMoves;
	
	private boolean isFainted;
	private boolean isBurned;
	private boolean isFrozen;
	private boolean isParalyzed;
	private boolean isAsleep;
	private boolean isPoisoned;
	private boolean isConfused;
	
	/**
	 * Basic no parameter constructor for the pokemon
	 */
	public Pokemon()
	{
		maxHP = 0;
		remHP = 0;
		percentHP = 0;
		defense = 0;
		spAttack = 0;
		spDefense = 0;
		speed = 0;
		
		moves = new Moves[4];
	}
	
	/**
	 * This is the constructor for the class Pokemon where in the different stats can be altered
	 * @param hp the hp stat
	 * @param a the attack stat
	 * @param d the defense stat
	 * @param spa the special attack stat
	 * @param spd the special defense stat
	 * @param s the speed stat
	 * @param t1 the first type of the pokemon
	 * @param t2 the second type of the pokemon
	 */
	public Pokemon(int hp, int a, int d, int spa, int spd, int s, Type t1, Type t2)
	{
		maxHP = hp;
		remHP = hp;
		percentHP = hp/hp;
		baseHP = hp;
		attack = a;
		baseAttack = a;
		defense = d;
		baseDefense = d;
		spAttack = spa;
		baseSpAttack = spa;
		spDefense = spd;
		baseSpDefense = spd;
		speed = s;		
		baseSpeed = s;
		
		type = new ArrayList<Type>();
		type.add(t1);
		type.add(t2);
		
		moves = new Moves[4];
		
	}
	
	/**
	 * sets the name of the pokemon
	 * @param n the name of the pokemon
	 */
	public void setName(String n)
	{
		name = n;
	}
	
	/**
	 * gets the name of the pokemon
	 * @return the name of the pokemon
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * gets the maximum HP of the pokemon
	 * @return the maximum HP of the pokemon
	 */
	public int getMaxHP()
	{
		return maxHP;
	}
	
	/**
	 * get the remaining HP of the pokemon
	 * @return the remaining HP of the pokemon
	 */
	public int getRemHP()
	{
		return remHP;
	}
	
	/**
	 * the percentage of HP of the pokemon
	 * @return the percentage of HP
	 */
	public double getPercentHP()
	{
		return percentHP;
	}
	
	/**
	 * adds HP EVs to the pokemon
	 * @param e the amount of EVs added (will not change if greater than 252)
	 */
	public void addHPEVs(int e)
	{
		if(e <= 252){
			maxHP = baseHP + e;
		}
	}
	
	/**
	 * gets the attack stat of the pokemon
	 * @return the attack stat
	 */
	public int getAttack()
	{
		return attack;
	}
	
	/**
	 * adds Attack EVs to the pokemon
	 * @param e the amount of EVs added (will not change if greater than 252)
	 */
	public void addAttackEVs(int e)
	{
		if(e <= 252){
			attack = baseAttack + e;
		}
	}
	
	/**
	 * gets the defense stat of the pokemon
	 * @return the defense stat of the pokemon
	 */
	public int getDefense()
	{
		return defense;
	}
	
	/**
	 * adds defense EVs to the pokemon
	 * @param e the amount of EVs added (will not change if greater than 252)
	 */
	public void addDefenseEVs(int e)
	{
		if(e <= 252){
			defense = baseDefense + e;
		}
	}
	
	/**
	 * gets the special attack stat of the pokemon
	 * @return the special attack stat of the pokemon
	 */
	public int getSpAttack()
	{
		return spAttack;
	}
	
	/**
	 * adds special attack EVs to the pokemon
	 * @param e the amount of EVs added (will not change if greater than 252)
	 */
	public void addSpAttackEVs(int e)
	{
		if(e <= 252){
			spAttack = baseSpAttack + e;
		}
	}
	
	/**
	 * gets the special defense stat of the pokemon
	 * @return the special defense stat of the pokemon
	 */
	public int getSpDefense()
	{
		return spDefense;
	}
	
	
	/**
	 * adds special defense EVs to the pokemon
	 * @param e the amount of EVs added (will not change if greater than 252)
	 */
	public void addSpDefenseEVs(int e)
	{
		if(e <= 252){
			spDefense = baseSpDefense + e;
		}
	}
	
	/**
	 * gets the speed stat of the pokemon
	 * @return the speed stat of the pokemon
	 */
	public int getSpeed()
	{
		return speed;
	}
	
	/**
	 * adds speed EVs to the pokemon
	 * @param e the amound of EVs added (will not change if greater than 252)
	 */
	public void addSpeedEVs(int e)
	{
		if(e <= 252){
			speed = baseSpeed + e;
		}
	}
	
	/**
	 * gets the ArrayList of Types of the pokemon
	 * @return the types of the pokemon
	 */
	public ArrayList<Type> getType()
	{
		return type;
	}
	
	
	
	/**
	 * gets the front image of the pokemon
	 * @return the front image
	 */
	public BufferedImage getFrontImage()
	{
		return frontImage.getImage();
	}
	
	/**
	 * sets the front image of the pokemon
	 * @param img the front image
	 */
	public void setFrontImage(BufferedImage img)
	{
		frontImage.setImage(img);
	}
	
	/**
	 * gets the back image of the pokemon
	 * @return the back image
	 */
	public BufferedImage getBackImage()
	{
		return backImage.getImage();
	}
	
	/**
	 * sets the back image of the pokemon
	 * @param img the back image
	 */
	public void setBackImage(BufferedImage img)
	{
		backImage.setImage(img);
	}
	
	/**
	 * gets the mini image of the pokemon
	 * @return the mini image of the pokemon
	 */
	public BufferedImage getMiniImage()
	{
		return miniImage.getImage();
	}
	
	/**
	 * sets the mini image of the pokemon
	 * @param img the mini image of the pokemon
	 */
	public void setMiniImage(BufferedImage img)
	{
		miniImage.setImage(img);
	}
	
	/**
	 * sets the 1st move of the pokemon
	 * @param m the move
	 */
	
	public void setMove1(Moves m)
	{
		moves[0] = m;
	}
	
	/**
	 * gets the 1st move of the pokemon
	 * @return 1st move
	 */
	public Moves getMove1()
	{
		return moves[0];
	}
	
	/**
	 * sets the 2nd move of the pokemon
	 * @param m the move
	 */
	public void setMove2(Moves m)
	{
		moves[1] = m;
	}
	
	
	/**
	 * gets the 2nd move of the pokemon
	 * @return 2nd move
	 */
	public Moves getMove2()
	{
		return moves[1];
	}
	
	
	/**
	 * sets the 3rd move of the pokemon
	 * @param m the move
	 */
	public void setMove3(Moves m)
	{
		moves[2] = m;
	}
	
	/**
	 * gets the 3rd move of the pokemon
	 * @return 3rd move
	 */
	public Moves getMove3()
	{
		return moves[2];
	}
	
	/**
	 * sets the 4th move of the pokemon
	 * @param m the move
	 */
	public void setMove4(Moves m)
	{
		moves[3] = m;
	}
	
	/**
	 * gets the 4th move of the pokemon
	 * @return 4th move
	 */
	public Moves getMove4()
	{
		return moves[3];
	}
	
	/**
	 * sets the possible moves that the pokemon can learn
	 * @param m
	 */
	public void setPossibleMoves(Moves[] m)
	{
		possibleMoves = m;
	}
	
	/**
	 * gets the ArrayList of possible moves that the pokemon can learn
	 * @return the possible moves
	 */
	public Moves[] getPossibleMoves()
	{
		return possibleMoves;
	}

	/**
	 * damages the pokemon and reduces its remaining hp and alters the boolean value of isFainted if the pokemon's health drops to 0 and below
	 * @param damage the amount of damage being dealt
	 */
	public void damage(int damage)
	{
		if(!isFainted)
			remHP -= damage;
		if(remHP <= 0)
			isFainted = true;
		percentHP = (double)remHP/maxHP;
	}
	
	/**
	 * gets whether or not the pokemon has fainted
	 * @return if the pokemon has fainted or not
	 */
	public boolean getFainted()
	{
		return isFainted;
	}
}
