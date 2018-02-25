import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Butterfree extends Pokemon {

	public Butterfree()
	{
		super(261,126,136,216,196,176,new Bug(),new Flying());
		
		String name = "Butterfree";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("12_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("12_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("12.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new Acrobatics(), new EnergyBall(), new Return(), new SignalBeam(), new PsychicMove(), new ShadowBall(), new BugBuzz()}; 

		setPossibleMoves(posMoves);
	}
	
}