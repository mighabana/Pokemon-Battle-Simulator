import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Snorlax extends Pokemon {

	public Snorlax()
	{
		super(461,256,166,166,256,96,new Normal(),new Nothing());
		
		String name = "Snorlax";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("143_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("143_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("143.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new BodySlam(), new Return(), new Blizzard(), new BrickBreak(), new Earthquake(), new FirePunch(), new Flamethrower(), new FocusBlast(),
				new IceBeam(), new IcePunch(), new IronHead(),  new PsychicMove(), new ShadowBall(), new RockSlide(), new Thunder(), new Thunderbolt(), new ThunderPunch(),
				new ZenHeadbutt()}; 

		setPossibleMoves(posMoves);
	}
	
}
