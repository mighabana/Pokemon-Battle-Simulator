import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Ampharos extends Pokemon {

	public Ampharos()
	{
		super(321,155,206,266,216,146,new Electric(),new Nothing());
		
		String name = "Ampharos";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("181_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("181_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("181.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new BodySlam(), new BrickBreak(), new DragonPulse(), new FirePunch(), new FocusBlast(), new Return(), new SignalBeam(), 
				new Thunder(), new Thunderbolt(), new ThunderPunch()}; 

		setPossibleMoves(posMoves);
	}
	
}
