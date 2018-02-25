import javax.swing.JFrame;

/**
 * Main method for launching the pokemon game
 * @author Miguel Habana
 *
 */

public class LaunchGame {

	public static void main(String[] args)
	{
		Player p = new Player();
		GameFrame gf = new GameFrame(p, 20);
		
		
		gf.setSize( 417, 300);
		gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gf.setVisible( true );
		
		Thread t = new Thread(gf);
		t.start();
	}
	
}
