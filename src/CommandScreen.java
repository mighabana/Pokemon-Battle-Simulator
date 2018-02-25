import javax.imageio.*;
import javax.swing.*;

import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.*;
import java.io.*;
/**
 * this class represents the JComponent of the command screen the screen wherein you select what you are going to do in the battle
 * @author Miguel Habana
 *
 */
public class CommandScreen extends JComponent{

	
	private BufferedImage screen;
	private BufferedImage triangle;
	private Player player;
	private Player opponent;
	private Pokemon[] playerPoke;
	private Pokemon[] opponentPoke;
	
	private int position;
	
	private String sideText1;
	private String sideText2;
	private String playerMaxHP;
	private String playerRemHP;
	

	private CommandListener cl;
	private GameFrame gf;

	/**
	 * Constructs an instance of the CommandScreen with player, opponenet and GameFrame parameters
	 * @param p the player who's pokemon's details are to be displayed
	 * @param o the opponent who's pokemon's details are to be displayed
	 * @param gf the GameFrame wherein the instance of CommandScreen is drawn
	 */
	public CommandScreen(Player p, Player o, GameFrame gf)
	{	
	
		this.gf = gf;
		
		cl = new CommandListener();
		
		gf.getContentPane().setFocusable(true);
		gf.getContentPane().addKeyListener(cl);
		
		player = p;
		opponent = o;
		
		playerPoke = player.getParty();
		opponentPoke = opponent.getParty();
		
		position = 1;
		sideText1 = "What will " + playerPoke[0].getName() + " do?";
		sideText2 = "";
		
		try{
			triangle = ImageIO.read(new File("Triangle.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		try{
			screen = ImageIO.read(new File("BattleScreen.png"));
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
        
        playerMaxHP = Integer.toString(playerPoke[0].getMaxHP());
		playerRemHP = Integer.toString(playerPoke[0].getMaxHP());
        
        
        g2d.drawImage(screen,0,0,null);
        g2d.drawImage(playerPoke[0].getBackImage(), 70, 135, null);
        g2d.drawImage(opponentPoke[0].getFrontImage(), 275, 60, null);
        
        Rectangle2D.Double oppHealth = new Rectangle2D.Double(92,59,82*opponentPoke[0].getPercentHP() ,2.5);
        g2d.setColor(new Color(119,199,157));
        g2d.fill(oppHealth);
        
        Rectangle2D.Double playerHealth = new Rectangle2D.Double(305,158,82*playerPoke[0].getPercentHP(),2.5);
        g2d.fill(playerHealth);
        
        g2d.setFont(new Font("Pokemon FireLeaf",Font.PLAIN, 16));
        g2d.setColor(Color.BLACK);
        g2d.drawString(opponentPoke[0].getName(),40,50);
        g2d.drawString(playerPoke[0].getName(),250,150);
        
        
        
        g2d.setColor(Color.WHITE);
        g2d.drawString(sideText1, 30, 230);
        g2d.drawString(sideText2, 30,250);
        
        g2d.setFont(new Font("Pokemon FireLeaf",Font.PLAIN, 14));
        g2d.setColor(Color.BLACK);
        g2d.drawString(playerMaxHP, 365, 180);
        g2d.drawString(playerRemHP, 330, 180);
        
        if(position == 1)
        {
        	g2d.drawImage(triangle, 229, 213, null);
        }
        else if(position == 2)
        {
        	g2d.drawImage(triangle, 229, 238, null);
        }
        else if(position == 3)
        {
        	g2d.drawImage(triangle, 324, 213, null);
        }
        else if(position == 4)
        {
        	g2d.drawImage(triangle, 324, 238, null);
        }
	}
	
	/**
	 * sets the position of the  triangle
	 * @param p corresponding position of the triangle
	 */
	public void setPosition(int p)
	{
		if(p >= 1 && p <= 4)
			position = p;
	}
	
	/**
	 * gets the position of the triangle
	 * @return	the position of the triangle
	 */
	public int getPosition()
	{
		return position;
	}
	
	/**
	 * sets the 1st line of text
	 * @param s the text to be displayed
	 */
	public void setSideText1(String s)
	{
		sideText1 = s;
	}
	
	/**
	 * sets the 2nd line of text
	 * @param s the text to be displayed
	 */
	public void setSideText2(String s)
	{
		sideText2 = s;
	}
	
	/**
	 * The KeyListener for the command screen to manipulate the position of the triangle as well as alter the side text
	 * @author Migue909
	 *
	 */
	public class CommandListener implements KeyListener
	{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_UP)
			{
				if(position == 2)
				{
					position = 1;
				}
				else if(position == 4)
				{
					position = 3;
				}	
				repaint();
			}
			else if(e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				if(position == 1)
				{
					position = 2;
				}
				else if(position == 3)
				{
					position = 4;
				}
				repaint();
			}
			else if(e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				if(position == 3)
				{
					position = 1;
				}
				else if(position == 4)
				{
					position = 2;
				}
				repaint();
			}
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				if(position == 1)
				{
					position = 3;
				}
				else if(position == 2)
				{
					position = 4;
				}
				repaint();
			}
			
			else if(e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				if(position == 3)
				{
					sideText1 = "Items can't be used in";
					sideText2 = "this battle.";
				}
				else if(position == 4)
				{
					sideText1 = "You can't run away from";
					sideText2 = "trainer battles.";
				}
				
				repaint();
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
