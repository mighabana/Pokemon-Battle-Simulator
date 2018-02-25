import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Umbreon extends Pokemon {

	public Umbreon()
	{
		super(331,166,256,156,296,166,new Dark(),new Nothing());
		
		String name = "Umbreon";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("197_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("197_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("197.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new DarkPulse(), new BodySlam(), new PsychicMove(), new Return(), new ShadowBall()}; 

		setPossibleMoves(posMoves);
	}
	
}
