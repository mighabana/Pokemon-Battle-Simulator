import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Beedrill extends Pokemon {
	
	public Beedrill()
	{
		super(271,216,116,126,196,186,new Bug(), new Poison());
		
		String name = "Beedrill";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("15_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("15_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("15.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		Moves[] posMoves = {new Acrobatics(), new BrickBreak(), new SludgeBomb(), new KnockOff(), new AerialAce(), new XScissor(), new PoisonJab()};
		setPossibleMoves(posMoves);
	}
	
}