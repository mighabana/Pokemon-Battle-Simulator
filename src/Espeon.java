import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Espeon extends Pokemon {

	public Espeon()
	{
		super(271,166,156,296,226,256,new Psychic(), new Nothing());
		
		String name = "Espeon";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("196_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("196_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("196.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new PsychicMove(), new Return(), new ShadowBall(), new SignalBeam(), new ZenHeadbutt(), new BodySlam()}; 

		setPossibleMoves(posMoves);
	}
	
}
