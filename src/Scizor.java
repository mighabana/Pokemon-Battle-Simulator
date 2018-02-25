import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Scizor extends Pokemon {

	public Scizor()
	{
		super(281,296,236,146,196,166,new Steel(),new Bug());
		
		String name = "Scizor";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("212_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("212_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("212.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new Acrobatics(), new BrickBreak(), new BugBuzz(), new FlashCanon(), new IronHead(), new KnockOff(), new XScissor()}; 

		setPossibleMoves(posMoves);
	}
	
}
