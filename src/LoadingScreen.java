import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

/**
 * This class is the JComponent for the Loading Screen that is displayed when the player is either waiting to connect or waiting for a connection
 * @author Migue909
 *
 */
public class LoadingScreen extends JComponent {

	private BufferedImage outerRing;
	private BufferedImage innerRing;
	private int count1;
	private int count2;
	private int count3;
	private int rotation1;
	private int rotation2;
	private int position;
	
	/**
	 * constructs an instance of the LoadingScreen
	 */
	public LoadingScreen()
	{
		count1 = 0;
		count2 = 0;
		count3 = 1;
		rotation1 = 5;
		rotation2 = 5;
		position = 1;
		
		try
		{
			outerRing = ImageIO.read(new File("OuterRing.png"));
			innerRing = ImageIO.read(new File("InnerRing.png"));
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
	}
	
	/**
	 * paints the design of the component
	 */
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
        
       Rectangle2D.Double background = new Rectangle2D.Double(0,0,417,300);
       g2d.setColor(Color.BLACK);
       g2d.fill(background);
       
       AffineTransform initTrans = g2d.getTransform();
       g2d.translate(417/2, 300/2);
       g2d.rotate(Math.toRadians(rotation1));
       g2d.drawImage(outerRing, -32, -32, null);
       g2d.setTransform(initTrans);
       g2d.translate(417/2, 300/2);
       g2d.rotate(Math.toRadians(rotation2));
       g2d.drawImage(innerRing, -17, -17, null);
       
       g2d.setTransform(initTrans);
       
       g2d.setFont(new Font("Pokemon FireLeaf", Font.PLAIN, 18));
       g2d.setColor(Color.WHITE);
       if(position == 1)
       {
    	   g2d.drawString("SEARCHING", 170, 220);
       }
       else if(position == 2)
       {
    	   g2d.drawString("SEARCHING.", 170, 220);
       }
       else if(position == 3)
       {
    	   g2d.drawString("SEARCHING..", 170, 220);
       }
       else if(position == 4)
       {
    	   g2d.drawString("SEARCHING...", 170, 220);
       }
       
       
	}
	
	/**
	 * animates the contents of the component
	 */
	public void animate()
	{
		
		count1++;
		count2++;
		if(count1 == 5)
		{
			rotation1 +=1;
		}
		else if(count1 > 5)
		{
			count1 = 0;
		}
			
		if(count2 == 2)
		{
			rotation2 +=1;
		}
		else if(count2 > 2)
		{
			count2 = 0;
		}
		
		count3++;
		if(count3 == 50)
		{
			position++;
			if(position > 4)
			{
				position = 1;
			}
		}
		else if(count3 > 50)
		{
			count3 = 0;
		}
		
		
	}
}
