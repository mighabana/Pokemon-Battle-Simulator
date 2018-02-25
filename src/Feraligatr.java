import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Feraligatr extends Pokemon {

	public Feraligatr()
	{
		super(311,246,236,194,202,192,new Water(),new Nothing());
		
		String name = "Feraligatr";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("160_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("160_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("160.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new AncientPower(), new Blizzard(), new BrickBreak(), new DragonClaw(), new DragonPulse(), new Earthquake(), new FocusBlast(), new HydroPump(), 
				new IceBeam(), new IcePunch(), new RockSlide(), new ShadowClaw(), new Waterfall()}; 

		setPossibleMoves(posMoves);
	}
	
}
