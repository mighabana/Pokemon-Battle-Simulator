import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Alakazam extends Pokemon {

	public Alakazam()
	{
		super(251,136,126,306,226,276,new Psychic(), new Nothing());
		
		String name = "Alakazam";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("65_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("65_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("65.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		Moves[] posMoves = {new BodySlam(), new EnergyBall(), new FirePunch(), new FocusBlast(), new IcePunch(), new KnockOff(), new ShadowBall(), new SignalBeam(), new ThunderPunch(), new ZenHeadbutt(),
				new Return()};
		setPossibleMoves(posMoves);
	}
	
}
