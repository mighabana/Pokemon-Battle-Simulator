import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Raichu extends Pokemon {

	public Raichu()
	{
		super(261,216,146,216,196,256,new Electric(),new Nothing());
		
		String name = "Raichu";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("26_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("26_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("26.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new BrickBreak(), new BodySlam(), new FocusBlast(), new KnockOff(), new SignalBeam(), new Return(), new ThunderPunch(), new Thunderbolt(), new Thunder()}; 

		setPossibleMoves(posMoves);
	}
	
}