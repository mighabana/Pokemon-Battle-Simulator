import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Typhlosion extends Pokemon {

	public Typhlosion()
	{
		super(297,204,192,254,206,236,new Fire(),new Nothing());
		
		String name = "Typhlosion";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("157_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("157_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("157.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new BodySlam(), new BrickBreak(), new Earthquake(), new FirePunch(), new Flamethrower(), new FocusBlast(), new Return(), new RockSlide(), new ShadowClaw(),
				new ThunderPunch()}; 

		setPossibleMoves(posMoves);
	}
	
}
