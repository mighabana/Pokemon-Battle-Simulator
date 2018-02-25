import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Gengar extends Pokemon {

	public Gengar()
	{
		super(261,166,156,296,186,256,new Ghost(),new Poison());
		
		String name = "Gengar";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("94_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("94_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("94.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new BodySlam(), new BrickBreak(), new DarkPulse(), new EnergyBall(), new FirePunch(), new FocusBlast(), new IcePunch(), new KnockOff(), new PoisonJab(),
		new PsychicMove(), new ShadowBall(), new ShadowClaw(), new SludgeBomb(), new Thunder(), new Thunderbolt(), new ThunderPunch()}; 

		setPossibleMoves(posMoves);
	}
	
}
