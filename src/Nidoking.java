import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Nidoking extends Pokemon {

	public Nidoking()
	{
		super(303,240,190,206,186,206,new Ground(), new Poison());
		
		String name = "Nidoking";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("34_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("34_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("34.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		Moves[] posMoves = {new Blizzard(), new BodySlam(), new BrickBreak(), new Return(), new DragonPulse(), new Earthquake(), new FirePunch(), new Flamethrower(), new FocusBlast(),
				new IceBeam(), new IcePunch(), new PoisonJab(), new RockSlide(), new ShadowBall(), new SludgeBomb(), new Thunderbolt(), new ThunderPunch(), new AerialAce(), new Megahorn(),
				new ShadowClaw()};
		setPossibleMoves(posMoves);
	}
	
}
