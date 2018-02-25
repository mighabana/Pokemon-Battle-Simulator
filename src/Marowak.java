import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Marowak extends Pokemon {

	public Marowak()
	{
		super(261,196,256,136,196,126,new Ground(),new Nothing());
		
		String name = "Marowak";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("105_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("105_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("105.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new Earthquake(), new Blizzard(), new AncientPower(), new BrickBreak(), new FirePunch(), new Flamethrower(), new IceBeam(), new KnockOff(), new IronHead(), 
				new KnockOff(), new ThunderPunch()}; 

		setPossibleMoves(posMoves);
	}
	
}

