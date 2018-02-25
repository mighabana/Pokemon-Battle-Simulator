import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Heracross extends Pokemon {

	public Heracross()
	{
		super(301,286,186,116,226,206,new Bug(),new Fighting());
		
		String name = "Heracross";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("214_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("214_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("214.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new BrickBreak(), new Megahorn(), new Return(), new PoisonJab(), new BodySlam(), new Earthquake(), new FocusBlast(), new RockSlide(), new ShadowClaw()}; 

		setPossibleMoves(posMoves);
	}
	
}
