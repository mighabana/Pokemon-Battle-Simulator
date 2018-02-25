import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Gyarados extends Pokemon {

	public Gyarados()
	{
		super(331,286,194,156,236,198,new Water(),new Flying());
		
		String name = "Gyarados";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("130_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("130_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("130.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new Blizzard(), new BodySlam(), new DarkPulse(), new DragonPulse(), new Earthquake(), new Flamethrower(), new HydroPump(), new IceBeam(),
				new IronHead(), new Thunder(), new Thunderbolt(), new Waterfall()}; 

		setPossibleMoves(posMoves);
	}
	
}
