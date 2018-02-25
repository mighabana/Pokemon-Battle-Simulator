import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Golem extends Pokemon {

	public Golem()
	{
		super(301,276,296,146,166,126,new Ground(), new Rock());
		
		String name = "Golem";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("76_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("76_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("76.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		Moves[] posMoves = {new AncientPower(), new BrickBreak(), new BodySlam(), new Earthquake(), new Flamethrower(), new FirePunch(), new RockSlide(), new ThunderPunch(),
				new Return()};
		setPossibleMoves(posMoves);
	}
	
}
