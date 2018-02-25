import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Flareon extends Pokemon {

	public Flareon()
	{
		super(271,296,156,226,256,166,new Fire(),new Nothing());
		
		String name = "Flareon";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("136_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("136_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("136.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new BodySlam(), new Flamethrower(), new Return(), new ShadowBall()}; 

		setPossibleMoves(posMoves);
	}
	
}
