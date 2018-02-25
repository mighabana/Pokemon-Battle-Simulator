import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Rhydon extends Pokemon {

	public Rhydon()
	{
		super(351,296,276,126,126,116,new Rock(),new Ground());
		
		String name = "Rhydon";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("112_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("112_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("112.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new AncientPower(), new Blizzard(), new BodySlam(), new BrickBreak(), new Crunch(), new DragonPulse(), new Earthquake(), new FirePunch(), new Flamethrower(),
				new FocusBlast(), new IceBeam(), new IcePunch(), new PoisonJab(), new RockSlide(), new ShadowClaw(), new Thunder(), new Thunderbolt(), new ThunderPunch()}; 
		setPossibleMoves(posMoves);
	}
	
}
