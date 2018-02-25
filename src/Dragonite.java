import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Dragonite extends Pokemon {

	public Dragonite()
	{
		super(323,304,226,236,236,196,new Dragon(),new Flying());
		
		String name = "Dragonite";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("149_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("149_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("149.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new Blizzard(), new BodySlam(), new BrickBreak(), new DragonClaw(), new DragonPulse(), new Earthquake(), new FirePunch(), new Flamethrower(), 
				new FocusBlast(), new IceBeam(), new IcePunch(), new IronHead(), new RockSlide(), new Thunder(), new ThunderPunch(), new Thunderbolt(), new Waterfall(), new Return()}; 

		setPossibleMoves(posMoves);
	}
	
}
