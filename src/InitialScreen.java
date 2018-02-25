import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 * This class is the JComponent that represents the Initial Screen that pops up once a connection between
 * the server and the client has been made. In this screen the player's and the opponent's sprite are displayed
 * as well as the opponent's name. This is also displayed when the battle is over with modifications to the text.
 * 
 * @author Miguel Habana
 *
 */

public class InitialScreen extends JComponent {
	
	private BufferedImage screen;
	private Player player;
	private Player opponent;
	
	private String text1;
	private String text2;
	
	private int x;
	private double x1;
	private double x2;
	
	private int timer1;
	private int timer2;
	
	private GameFrame gf;
	
	/**
	 * Constructs an instance of the InitialScreen with the player, opponent and GameFrame parameters
	 * 
	 * @param p the player whose sprite is to be displayed
	 * @param o the opponent whose sprite and name is to be displayed
	 * @param gf the GameFrame wherein the instance of InitialScreen is drawn
	 */
	
	public InitialScreen(Player p, Player o, GameFrame gf)
	{
		player = p;
		opponent = o;
		this.gf = gf;
		
		text1 = "You are challenged by";
		text2 = "Pokemon Trainer " + opponent.getName();
		
		try
		{
			screen = ImageIO.read(new File("InitialScreen.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * paints the design of the JComponent
	 */
	public void paintComponent(Graphics g)
	{
			Graphics2D g2d = (Graphics2D) g;
	        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	        g2d.setRenderingHints(rh);
	        
	        g2d.drawImage(screen,0,0,null);
	        g2d.drawImage(opponent.getSprite(),425 - x,50,null);
	        g2d.drawImage(player.getSprite(), -70 + x,138,null);
	        
	        
	        g2d.setFont(new Font("Pokemon FireLeaf", Font.PLAIN, 18));
	        g2d.setColor(Color.BLACK);
	        
	        g2d.setColor(Color.WHITE);
	        g2d.drawString(text1, 30, 230);
	        g2d.drawString(text2, 30, 250);
	        
	        
	        Rectangle2D.Double textBar1 = new Rectangle2D.Double(30 + x1,218,160 -x1,15);
	        Rectangle2D.Double textBar2 = new Rectangle2D.Double(30 + x2,238,180 -x2,15);
	        g2d.setColor(new Color(82,145,153));
	        g2d.fill(textBar1);
	        g2d.fill(textBar2);
        
	}
	
	/**
	 * The method for animating the contents of the JComponent specifically to show the animation of the 
	 * sprites moving and the display of the text.
	 */
	public void animate()
	{
		
		x = (int) (1.5 * timer1);
		x1 = 1.6 * timer1;
		x2 = 1.8 * timer2;
		timer1 ++;
		if(timer1 >= 100){
			timer2++;
			if(timer2 >= 150)
			{
				if(!gf.isWin && !gf.isLose){
					gf.isInitial = false;
					gf.drawCommandScreen(gf.is);
				}
			}
			timer1 = 100;
			
		}	
	
		if(gf.isWin)
		{
			text1 = "You have defeated";
			text2 = "Pokemon Trainer " + opponent.getName();
		}
		if(gf.isLose)
		{
			text1 = "You lost to";
			text2 = "Pokemon Trainer " + opponent.getName();
				
		}
	}
}
