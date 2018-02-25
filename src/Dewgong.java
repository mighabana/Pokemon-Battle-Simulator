import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Dewgong extends Pokemon {

	public Dewgong()
	{
		super(321,176,196,176,226,176,new Water(), new Ice());
		
		String name = "Dewgong";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("87_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("87_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("87.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		Moves[] posMoves = {new Blizzard(), new BodySlam(), new Return(), new IceBeam(), new SignalBeam(), new Waterfall()};
		setPossibleMoves(posMoves);
	}
	
}
