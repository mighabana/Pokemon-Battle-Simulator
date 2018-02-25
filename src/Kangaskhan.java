import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Kangaskhan extends Pokemon {

	public Kangaskhan()
	{
		super(351,226,196,116,196,216,new Normal(),new Nothing());
		
		String name = "Kangaskhan";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("115_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("115_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("115.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new Blizzard(), new BodySlam(), new BrickBreak(), new Return(), new Earthquake(), new FirePunch(), new Flamethrower(), new FocusBlast(), 
				new IceBeam(), new IcePunch(), new RockSlide(), new ShadowBall(), new ShadowClaw(), new Thunder(), new Thunderbolt(), new ThunderPunch()}; 

		setPossibleMoves(posMoves);
	}
	
}
