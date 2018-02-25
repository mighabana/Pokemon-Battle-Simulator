import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Blastoise extends Pokemon {

	
	public Blastoise()
	{
		super(299,171,236,206,246,192, new Water(), new Nothing());
		
		String name = "Blastoise";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("9_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("9_back.png"));
			setBackImage(backImage);
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("9.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new Blizzard(), new AuraSphere(), new DragonPulse(), new Earthquake(), new FocusBlast(), new RockSlide(), new BodySlam(),new DarkPulse(), new FlashCanon(), 
				new HydroPump(), new IceBeam(), new SignalBeam(), new Waterfall()}; 
		setPossibleMoves(posMoves);
	}
	
}