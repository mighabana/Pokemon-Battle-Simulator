import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Tyranitar extends Pokemon {

	public Tyranitar()
	{
		super(341,304,256,226,236,158,new Rock(),new Dark());
		
		String name = "Tyranitar";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("248_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("248_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("248.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new AncientPower(), new Blizzard(), new BrickBreak(), new DarkPulse(), new DragonClaw(), new DragonPulse(), new Earthquake(), new Flamethrower(), new FirePunch(),
				new FocusBlast(), new IceBeam(), new IcePunch(), new IronHead(), new Return(), new RockSlide(), new ShadowClaw(), new Thunder(), new Thunderbolt(), new ThunderPunch()}; 

		setPossibleMoves(posMoves);
	}
	
}
