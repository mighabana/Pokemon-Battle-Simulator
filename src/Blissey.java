import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Blissey extends Pokemon {

	public Blissey()
	{
		super(651,56,56,186,306,146,new Normal(),new Nothing());
		
		String name = "Blissey";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("242_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("242_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("242.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new Blizzard(), new BodySlam(), new BrickBreak(), new Earthquake(), new FirePunch(), new Flamethrower(), new FocusBlast(), new IceBeam(), 
				new IcePunch(), new RockSlide(), new Thunder(), new Thunderbolt(), new ThunderPunch(), new ShadowBall(), new ZenHeadbutt()}; 

		setPossibleMoves(posMoves);
	}
	
}
