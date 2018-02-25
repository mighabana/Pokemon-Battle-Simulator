import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * This is the class for the player
 * @author Miguel Habana
 *
 */
public class Player implements Serializable {

	private Pokemon[] party;
	private DMSRecord sprite = new DMSRecord();
	private String name;
	
	/**
	 * constructor for an instance of Player
	 * 
	 * The constructor by default sets the name of the player to Red and the pokemon to a Chaizard whose all 4 moves are flamethrower
	 */
	public Player()
	{
		party = new Pokemon[1];	
		setName("Red");
		
		BufferedImage img = null;
		
		try
		{
			img = ImageIO.read(new File("Red.png"));
			
			
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
		
		setSprite(img);
		
		setPokemon1(new Charizard());

		
		Pokemon[] playerPoke = getParty();
		
		playerPoke[0].setMove1(new Flamethrower());
		playerPoke[0].setMove2(new Flamethrower());
		playerPoke[0].setMove3(new Flamethrower());
		playerPoke[0].setMove4(new Flamethrower());
		
	}
	
	
	/**
	 * sets the name of the player
	 * @param s name
	 */
	public void setName(String s)
	{
		name = s;
	}
	/**
	 * gets the name of the player
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * sets the 1st pokemon of the player
	 * @param p the pokemon
	 */
	public void setPokemon1(Pokemon p)
	{
		party[0] = p;
	}
	
	/*public void setPokemon2(Pokemon p)
	{
		party[1] = p;
	}
	
	public void setPokemon3(Pokemon p)
	{
		party[2] = p;
	}
	*/
	
	/**
	 * gets the 1st pokemon of the player
	 * @return the 1st pokemon
	 */
	public Pokemon getPokemon1()
	{
		return party[0];
	}
	
	/*
	public Pokemon getPokemon2()
	{
		return party[1];
	}
	
	public Pokemon getPokemon3()
	{
		return party[2];
	}
	*/
	
	/**
	 * gets the party of the player
	 * @return the party of the player
	 */
	public Pokemon[] getParty()
	{
		return party;
	}
	
	/**
	 * sets the sprite/image of the player
	 * @param img the image to be set
	 */
	public void setSprite(BufferedImage img)
	{
		sprite.setImage(img);
	}
	
	/**
	 * gets the sprite/image of the player
	 * @return the player's sprite/image
	 */
	public BufferedImage getSprite()
	{
		return sprite.getImage();
	}
	
    
}
