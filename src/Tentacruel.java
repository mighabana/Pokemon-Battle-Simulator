import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Tentacruel extends Pokemon {

	public Tentacruel()
	{
		super(301,176,166,196,276,236,new Water(), new Poison());
		
		String name = "Tentacruel";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("73_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("73_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("73.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		Moves[] posMoves = {new Blizzard(), new HydroPump(), new IceBeam(), new KnockOff(), new PoisonJab(), new SludgeBomb(), new Return(), new Waterfall()};
		setPossibleMoves(posMoves);
	}
	
}
