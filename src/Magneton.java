import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Magneton extends Pokemon {

	public Magneton()
	{
		super(241,156,226,276,176,176,new Electric(), new Steel());
		
		String name = "Magneton";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("82_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("82_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("82.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		Moves[] posMoves = {new FlashCanon(), new Return(), new SignalBeam(), new Thunder(), new Thunderbolt()};
		setPossibleMoves(posMoves);
	}
	
}
