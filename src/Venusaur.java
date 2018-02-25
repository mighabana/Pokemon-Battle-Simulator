import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Venusaur extends Pokemon {
	
	public Venusaur()
	{
		super(301,200,202,236,236,196,new Grass(), new Poison());
		
		String name = "Venusaur";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("3_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("3_back.png"));
			setBackImage(backImage);
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("3.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new EnergyBall(), new Earthquake(), new Return(), new BodySlam(), new PowerWhip(),new KnockOff(),new SludgeBomb() }; 
		
		setPossibleMoves(posMoves);
	}

}