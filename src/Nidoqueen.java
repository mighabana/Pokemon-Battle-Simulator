import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Nidoqueen extends Pokemon {

	public Nidoqueen()
	{
		super(321,220,210,186,206,188,new Ground(), new Poison());
		
		String name = "Nidoqueen";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("31_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("31_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("31.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		Moves[] posMoves = {new Blizzard(), new BodySlam(), new BrickBreak(), new Return(), new DragonPulse(), new Earthquake(), new FirePunch(), new Flamethrower(), new FocusBlast(),
		new IceBeam(), new IcePunch(), new PoisonJab(), new RockSlide(), new ShadowBall(), new SludgeBomb(), new Thunderbolt(), new ThunderPunch(), new AerialAce(), new ShadowClaw()};
		setPossibleMoves(posMoves);
	}
	
}

