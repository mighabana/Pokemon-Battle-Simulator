import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Kingdra extends Pokemon {

	public Kingdra()
	{
		super(291,226,226,226,226,206,new Water(),new Dragon());
		
		String name = "Kingdra";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("230_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("230_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("230.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new Blizzard(), new BodySlam(), new DragonPulse(), new FlashCanon(), new IceBeam(), new IronHead(), new Return(), new SignalBeam(), new Waterfall()}; 

		setPossibleMoves(posMoves);
	}
	
}
