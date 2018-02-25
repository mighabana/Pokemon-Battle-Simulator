import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Skarmory extends Pokemon {

	public Skarmory()
	{
		super(271,196,316,116,176,176,new Steel(),new Flying());
		
		String name = "Skarmory";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("227_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("227_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("227.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new IronHead(), new FlashCanon(), new RockSlide(), new XScissor(), new DarkPulse(), new Return()}; 

		setPossibleMoves(posMoves);
	}
	
}
