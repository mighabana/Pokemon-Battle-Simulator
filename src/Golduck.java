import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Golduck extends Pokemon {

	public Golduck()
	{
		super(301,200,196,226,196,206,new Water(), new Nothing());
		
		String name = "Golduck";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("55_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("55_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("55.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		Moves[] posMoves = {new Blizzard(), new BodySlam(), new BrickBreak(), new FocusBlast(), new HydroPump(), new Return(), new IceBeam(), new IcePunch(), new ShadowClaw(),
				new ZenHeadbutt(), new Waterfall()};
		setPossibleMoves(posMoves);
	}
	
}

