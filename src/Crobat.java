import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Crobat extends Pokemon {

	public Crobat()
	{
		super(311,216,196,176,196,296,new Poison(),new Flying());
		
		String name = "Crobat";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("169_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("169_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("169.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new Acrobatics(), new DarkPulse(), new Return(), new ShadowBall(), new SludgeBomb(), new XScissor(), new ZenHeadbutt()}; 

		setPossibleMoves(posMoves);
	}
	
}
