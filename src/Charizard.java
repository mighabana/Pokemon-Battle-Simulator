import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Charizard extends Pokemon {

	public Charizard()
	{
		super(297,204,192,254,206,236,new Fire(),new Flying());
		
		String name = "Charizard";
		setName(name);
		
		try{
			BufferedImage frontImage = ImageIO.read(new File("6_front.png"));
			setFrontImage(frontImage);
			BufferedImage backImage = ImageIO.read(new File("6_back.png"));
			setBackImage(backImage);
			BufferedImage miniImage = ImageIO.read(new File("6.png"));
			setMiniImage(miniImage);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Moves[] posMoves = {new Flamethrower(),new WingAttack(), new BrickBreak(), new DragonClaw(), new DragonPulse(), new AncientPower(), 
				new RockSlide(), new Crunch(),new FirePunch(), new FocusBlast(), new ThunderPunch(), new Earthquake(), new AerialAce(), new Return(),
				new Acrobatics()}; 

		setPossibleMoves(posMoves);
	}
	
}
