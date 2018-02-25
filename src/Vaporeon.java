import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Vaporeon extends Pokemon {

	public Vaporeon()
	{
		super(401,166,156,256,226,166,new Water(),new Nothing());
		
		String name = "Vaporeon";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("134_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("134_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("134.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new Blizzard(), new BodySlam(), new ShadowBall(), new SignalBeam(), new IceBeam(), new Return(), new Waterfall()}; 

		setPossibleMoves(posMoves);
	}
	
}
