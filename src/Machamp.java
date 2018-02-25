import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Machamp extends Pokemon {

	public Machamp()
	{
		super(321,296,196,166,206,146,new Fighting(), new Nothing());
		
		String name = "Machamp";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("68_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("68_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("68.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		Moves[] posMoves = {new BodySlam(), new BrickBreak(), new Earthquake(), new Flamethrower(), new FirePunch(), new FocusBlast(), new IcePunch(), new KnockOff(), new PoisonJab(),
				new Return(), new RockSlide(), new ThunderPunch()};
		setPossibleMoves(posMoves);
	}
	
}
