import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Jolteon extends Pokemon {

	public Jolteon()
	{
		super(271,166,156,256,226,296,new Electric(),new Nothing());
		
		String name = "Jolteon";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("135_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("135_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("135.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new BodySlam(), new Return(), new ShadowBall(), new SignalBeam(), new Thunder(), new Thunderbolt()}; 

		setPossibleMoves(posMoves);
	}
	
}
