import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

/**
 * This class is the JComponent for the MenuScreen where the player selects what action to take
 * @author Miguel Habana
 *
 */
public class MenuScreen extends JComponent{

	private Player player;
	private BufferedImage screen;
	private BufferedImage triangle;
	private int position;
	
	/**
	 * Constructs an instance of the menu screen with parameter player 
	 * @param p the player
	 */
	public MenuScreen(Player p)
	{
		player = p;
		position = 1;
		try
		{
			screen = ImageIO.read(new File("MenuScreen.png"));
			triangle = ImageIO.read(new File("Triangle.png"));
			
			
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
		
		
	}
	
	/**
	 * sets the position of the triangle
	 * @param p the position of the triangle
	 */
	public void setPosition(int p)
	{
		if(p > 0 || p < 5)
		position = p;
	}
	
	/**
	 * gets the position of the triangle
	 * @return the position of the triangle
	 */
	public int getPosition()
	{
		return position;
	}
	
	/**
	 * paints the design of the component
	 */
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHints(rh);
		
		g2d.drawImage(screen,0,0,null);
		
		if(position == 1)
		{
			g2d.drawImage(triangle,25,140,null);
		}
		else if(position == 2)
		{
			g2d.drawImage(triangle, 25, 170, null);
		}
		else if(position == 3)
		{
			g2d.drawImage(triangle, 25, 197, null);
		}
		else if(position == 4)
		{
			g2d.drawImage(triangle, 25, 225, null);
		}
		
		g2d.drawImage(player.getSprite(),280,160,null);
		g2d.setFont(new Font("Pokemon FireLeaf",Font.PLAIN, 18));
		g2d.drawString(player.getName(), 250,260);
		
	}
	
	
}