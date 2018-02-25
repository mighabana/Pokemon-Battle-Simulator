import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Meganium extends Pokemon {

	public Meganium()
	{
		super(301,200,236,202,236,196,new Grass(),new Nothing());
		
		String name = "Meganium";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("154_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("154_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("154.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new Earthquake(), new EnergyBall(), new AncientPower(), new Return()}; 

		setPossibleMoves(posMoves);
	}
	
}
