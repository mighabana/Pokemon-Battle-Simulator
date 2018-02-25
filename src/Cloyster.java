import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Cloyster extends Pokemon {

	public Cloyster()
	{
		super(241,226,396,206,126,176,new Water(),new Ice());
		
		String name = "Cloyster";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("91_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("91_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("91.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new Blizzard(), new HydroPump(), new IceBeam(), new PoisonJab(), new Return(), new SignalBeam()}; 

		setPossibleMoves(posMoves);
	}
	
}
