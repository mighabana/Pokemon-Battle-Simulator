import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Arcanine extends Pokemon {

	public Arcanine()
	{
		super(321,256,196,236,196,226,new Fire(), new Nothing());
		
		String name = "Arcanine";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("59_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("59_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("59.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		Moves[] posMoves = {new DragonPulse(), new Crunch(), new Flamethrower(), new IronHead(), new AerialAce(), new Return(), new BodySlam()};
		setPossibleMoves(posMoves);
	}
	
}
