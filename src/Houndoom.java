import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Houndoom extends Pokemon {

	public Houndoom()
	{
		super(291,216,136,256,196,226,new Dark(),new Fire());
		
		String name = "Houndoom";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("229_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("229_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("229.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new BodySlam(), new Crunch(), new DarkPulse(), new Flamethrower(), new Return(), new ShadowBall(), new SludgeBomb()}; 

		setPossibleMoves(posMoves);
	}
	
}
