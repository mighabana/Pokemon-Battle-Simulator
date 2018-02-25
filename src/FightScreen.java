import javax.imageio.*;
import javax.swing.*;

import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.*;
import java.io.*;

/**
 * This class is the JComponent that represents the screen wherein the player selects the move of the pokemon.
 * 
 * @author Miguel Habana
 *
 */
public class FightScreen extends JComponent{

	
	protected BufferedImage screen;
	private BufferedImage triangle;
	private Player player;
	private Player opponent;
	private Pokemon[] playerPoke;
	private Pokemon[] opponentPoke;
	
	int position;

	private String playerMaxHP;
	private String playerRemHP;
	
	private String move1Text;
	private String move2Text;
	private String move3Text;
	private String move4Text;
	
	protected String sideText;
	private double x;
	private int timer;
	
	private String remPP;
	private String maxPP;
	private String moveType;
	
	private FightListener fl;
	private GameFrame gf;
	private TalkToServerThread ttst;
	private TalkToClientThread ttct;
	
	private boolean finishedAnimating;
	
	private boolean isServer;
	
	/**
	 * constructs the instance of FightScreen with player, opponent, TalkToServerThread, TalkToClientThread and GameFrame parameters
	 * @param p the player who's details are to be displayed
	 * @param o the opponent who's details are to be displayed
	 * @param ttst the TalkToServerThread which sends the information regarding the attacks of the pokemon. May be null if the player is the server.
	 * @param ttct the TalkToClientThread which sends the information regarding the attacks of the pokemon. May be null if the player is the client.
	 * @param gf the GameFrame where the instance of FightScreen is drawn.
	 */
	public FightScreen(Player p, Player o,TalkToServerThread ttst, TalkToClientThread ttct, GameFrame gf)
	{	
		this.gf = gf;
		isServer = false;
		
		if(ttct != null){
			this.ttct = ttct;
			isServer = true;
		}
		if(ttst != null)
		{
			this.ttst = ttst;
		}
		
		x = 0;
		timer = 0;
		position = 1;
		
		
		gf.getContentPane().setFocusable(true);
		fl = new FightListener();
		gf.getContentPane().addKeyListener(fl);
		
		player = p;
		
		opponent = o;
		
		playerPoke = player.getParty();
		opponentPoke = opponent.getParty();
		
		
		move1Text = playerPoke[0].getMove1().getName();
		move2Text = playerPoke[0].getMove2().getName();
		move3Text = playerPoke[0].getMove3().getName();
		move4Text = playerPoke[0].getMove4().getName();
		
		maxPP = Integer.toString(playerPoke[0].getMove1().getMaxPP());
		remPP = Integer.toString(playerPoke[0].getMove1().getRemPP());
		moveType = playerPoke[0].getMove1().getType();
	
		
		try{
			triangle = ImageIO.read(new File("Triangle.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		try{
			screen = ImageIO.read(new File("FightScreen.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
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
        
        g2d.setFont(new Font("Pokemon FireLeaf", Font.PLAIN, 14));
        g2d.drawString(playerMaxHP, 365, 180);
	    g2d.drawString(playerRemHP,330,180);
	    
        if(position != 0){
        	
        	g2d.setFont(new Font("Pokemon FireLeaf",Font.PLAIN, 16));
	        g2d.drawString(move1Text, 40,231);
	        g2d.drawString(move2Text, 40, 256);
	        g2d.drawString(move3Text, 160, 231);
	        g2d.drawString(move4Text, 160, 256);
	        
	        g2d.drawString(remPP + "/" + maxPP, 360, 231);
	        g2d.drawString(moveType, 350, 256);
	        
	        if(position == 1)
	        {
	        	g2d.drawImage(triangle, 19, 213, null);
	        }
	        else if(position == 2)
	        {
	        	g2d.drawImage(triangle, 19, 238, null);
	        }
	        else if(position ==  3)
	        {
	        	g2d.drawImage(triangle,139,213,null);
	        }
	        else if(position == 4)
	        {
	        	g2d.drawImage(triangle,139,238,null);	
	        }
        }
        else{
        	g2d.setFont(new Font("Pokemon FireLeaf",Font.PLAIN, 16));
        	g2d.setColor(Color.WHITE);
        	g2d.drawString(sideText, 30, 230);
        	Rectangle2D.Double textBar = new Rectangle2D.Double(30 + x,216,200 -x,17);
        	g2d.setColor(new Color(82,145,153));
	        g2d.fill(textBar);
        }
	}

	/**
	 * sets the position of the triangle
	 * @param p the position of the triangle
	 */
	public void setPosition(int p)
	{
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
	 * this method is called in order to animate the contents of the JComponent
	 */
	public void animate()
	{
		
		x = (2 * timer);
		timer ++;
		if(timer >= 150){
			timer = 150;
			finishedAnimating = true;
		}
	}
	
	/**
	 * gets the boolean value that corresponds to whether or not the component is finished animating or not
	 * @return whether the component is finished animating or not
	 */
	public boolean getAnimating()
	{
		return finishedAnimating;
	}
	
	/**
	 * sets the value of the boolean that corresponds to whether or not the component is finished animating or not
	 * @param b boolean value that corresponds to finishedAnimating
	 */
	public void setAnimating(boolean b)
	{
		finishedAnimating = b;
	}

	/**
	 * KeyListener for the FightScreen that alters the position of the triangle as well as sends the corresponding details about the pokeomon's attack
	 * @author Miguel Habana
	 *
	 */
	public class FightListener implements KeyListener
	{

		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_UP)
			{
				if(position == 2)
				{
					position = 1;
					maxPP = Integer.toString(playerPoke[0].getMove1().getMaxPP());
					remPP = Integer.toString(playerPoke[0].getMove1().getRemPP());
					moveType = playerPoke[0].getMove1().getType();
				}
				else if(position == 4)
				{
					position = 3;
					maxPP = Integer.toString(playerPoke[0].getMove3().getMaxPP());
					remPP = Integer.toString(playerPoke[0].getMove3().getRemPP());
					moveType = playerPoke[0].getMove3().getType();
				}		
				repaint();
			}
			else if(e.getKeyCode() == KeyEvent.VK_DOWN)
			{	
				if(position == 1)
				{
					position = 2;
					maxPP = Integer.toString(playerPoke[0].getMove2().getMaxPP());
					remPP = Integer.toString(playerPoke[0].getMove2().getRemPP());
					moveType = playerPoke[0].getMove2().getType();
				}
				else if(position == 3)
				{
					position = 4;
					maxPP = Integer.toString(playerPoke[0].getMove4().getMaxPP());
					remPP = Integer.toString(playerPoke[0].getMove4().getRemPP());
					moveType = playerPoke[0].getMove4().getType();
				}
				repaint();
			}
			else if(e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				if(position == 3)
				{
					position = 1;
					maxPP = Integer.toString(playerPoke[0].getMove1().getMaxPP());
					remPP = Integer.toString(playerPoke[0].getMove1().getRemPP());
					moveType = playerPoke[0].getMove1().getType();
				}
				else if(position == 4)
				{
					position = 2;
					maxPP = Integer.toString(playerPoke[0].getMove2().getMaxPP());
					remPP = Integer.toString(playerPoke[0].getMove2().getRemPP());
					moveType = playerPoke[0].getMove2().getType();
				}
				repaint();
			}
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				if(position == 1)
				{
					position = 3;
					maxPP = Integer.toString(playerPoke[0].getMove3().getMaxPP());
					remPP = Integer.toString(playerPoke[0].getMove3().getRemPP());
					moveType = playerPoke[0].getMove3().getType();
				}
				else if(position == 2)
				{
					position = 4;
					maxPP = Integer.toString(playerPoke[0].getMove3().getMaxPP());
					remPP = Integer.toString(playerPoke[0].getMove3().getRemPP());
					moveType = playerPoke[0].getMove3().getType();
				}
				repaint();
			}		
			
			else if(e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				if(position == 1)
				{
					
					int damage = playerPoke[0].getMove1().use(playerPoke[0], opponentPoke[0]);
					try {
						screen = ImageIO.read(new File("WaitScreen.png"));
						sideText = playerPoke[0].getName() + " used " + playerPoke[0].getMove1().getName() +"!";  
						position = 0;
						x = 0;
						timer = 0;
						gf.getContentPane().removeKeyListener(gf.fsl);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
						if(isServer){
							try {
								ttct.isAttacking = true;
								ttct.objOut.writeBoolean(true);
								//ttct.objOut.flush();
								ttct.clientDamage = damage;
								ttct.objOut.writeInt(damage);
								ttct.objOut.flush();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
						}
						else{
							try {
								ttst.isAttacking = true;
								ttst.objOut.writeBoolean(true);
								//ttst.objOut.flush();
								ttst.serverDamage = damage;
								ttst.objOut.writeInt(damage);
								ttst.objOut.flush();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
						
											
				}
				else if(position == 2)
				{
					int damage = playerPoke[0].getMove2().use(playerPoke[0], opponentPoke[0]);
					try {
						screen = ImageIO.read(new File("WaitScreen.png"));
						sideText = playerPoke[0].getName() + " used " + playerPoke[0].getMove2().getName() +"!";
						position = 0;
						x = 0;
						timer = 0;
						gf.getContentPane().removeKeyListener(gf.fsl);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					

					if(isServer){
						try {
							ttct.isAttacking = true;
							ttct.objOut.writeBoolean(true);
							//ttct.objOut.flush();
							ttct.clientDamage = damage;
							ttct.objOut.writeInt(damage);
							ttct.objOut.flush();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
					else{
						try {
							ttst.isAttacking = true;
							ttst.objOut.writeBoolean(true);
							//ttst.objOut.flush();
							ttst.serverDamage = damage;
							ttst.objOut.writeInt(damage);
							ttst.objOut.flush();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
				else if(position == 3)
				{
					int damage = playerPoke[0].getMove3().use(playerPoke[0], opponentPoke[0]);
					try {
						screen = ImageIO.read(new File("WaitScreen.png"));
						sideText = playerPoke[0].getName() + " used " + playerPoke[0].getMove3().getName() +"!";
						position = 0;
						x = 0;
						timer = 0;
						gf.getContentPane().removeKeyListener(gf.fsl);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					

					if(isServer){
						try {
							ttct.isAttacking = true;
							ttct.objOut.writeBoolean(true);
							//ttct.objOut.flush();
							ttct.clientDamage = damage;
							ttct.objOut.writeInt(damage);
							ttct.objOut.flush();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
					else{
						try {
							ttst.isAttacking = true;
							ttst.objOut.writeBoolean(true);
							//ttst.objOut.flush();
							ttst.serverDamage = damage;
							ttst.objOut.writeInt(damage);
							ttst.objOut.flush();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
				else if(position == 4)
				{
					int damage = playerPoke[0].getMove4().use(playerPoke[0], opponentPoke[0]);
					try {
						screen = ImageIO.read(new File("WaitScreen.png"));
						sideText = playerPoke[0].getName() + " used " + playerPoke[0].getMove4().getName() +"!";
						position = 0;
						x = 0;
						timer = 0;
						gf.getContentPane().removeKeyListener(gf.fsl);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					

					if(isServer){
						try {
							ttct.isAttacking = true;
							ttct.objOut.writeBoolean(true);
							//ttct.objOut.flush();
							ttct.clientDamage = damage;
							ttct.objOut.writeInt(damage);
							ttct.objOut.flush();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
					else{
						try {
							ttst.isAttacking = true;
							ttst.objOut.writeBoolean(true);
							//ttst.objOut.flush();
							ttst.serverDamage = damage;
							ttst.objOut.writeInt(damage);
							ttst.objOut.flush();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
				repaint();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}
		
	}
}
