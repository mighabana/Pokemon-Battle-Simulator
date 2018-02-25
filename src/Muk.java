import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Muk extends Pokemon {

	public Muk()
	{
		super(351,246,186,166,236,138,new Poison(), new Nothing());
		
		String name = "Muk";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("89_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("89_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("89.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		Moves[] posMoves = {new SludgeBomb(), new BodySlam(), new BrickBreak(), new DarkPulse(), new FirePunch(), new Flamethrower(), new FocusBlast(),new IcePunch(), new PoisonJab(),
				new Return(), new RockSlide(), new ShadowBall(), new Thunder(), new Thunderbolt(), new ThunderPunch()};
		setPossibleMoves(posMoves);
	}
	
}
