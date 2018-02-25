import javax.imageio.*;
import javax.swing.*;

import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.*;
import java.io.*;

public class PartyScreen extends JComponent{

	
	private Player player;
	private Pokemon[] playerParty;
	private Pokemon pokemon1;
	private Pokemon pokemon2;
	private Pokemon pokemon3;
	private int position;
	
	private BufferedImage screen1_1;
	private BufferedImage screen1_2;
	private BufferedImage screen1_3;
	private BufferedImage screen1_4;
	
	private boolean isSwitch;
	private int switchHolder;
	
	private PartyListener pl;
	private GameFrame gf;
	private TalkToServerThread ttst;
	private TalkToClientThread ttct;
	private boolean isServer;
	
	public PartyScreen(Player p, TalkToServerThread ttst, TalkToClientThread ttct, GameFrame gf)
	{
		isServer = false;
		if(ttct != null){
			this.ttct = ttct;
			this.ttct.partySwitch = true;
			isServer = true;
		}
		if(ttst != null){
			this.ttst = ttst;
			this.ttst.partySwitch = true;
		}
			
		
		this.gf = gf;
		
		pl = new PartyListener();
		
		gf.getContentPane().setFocusable(true);
		gf.getContentPane().addKeyListener(pl);
		
		player = p;
		
		playerParty = player.getParty();
				
		
		
		position = 1;
		
		try
		{
			screen1_1 = ImageIO.read(new File("PartyScreen1_1.png"));
			screen1_2 = ImageIO.read(new File("PartyScreen1_2.png"));
			screen1_3 = ImageIO.read(new File("PartyScreen1_3.png"));
			screen1_4 = ImageIO.read(new File("PartyScreen1_4.png"));
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
		
	}
	
	public int getPosition()
	{
		return position;
	}
	
	public void setPosition(int p)
	{
		position = p;
	}
	
	public void removePL()
	{
		this.removeKeyListener(pl);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
        
        pokemon1 = playerParty[0];
		pokemon2 = playerParty[1];
		pokemon3 = playerParty[2];
		
        if(position == 1) {
        	g2d.drawImage(screen1_1,0,0,null);
        }
       	else if(position == 2){
       		g2d.drawImage(screen1_2,0,0,null);
        }
       	else if(position == 3){
       		g2d.drawImage(screen1_3, 0, 0, null);
       	}
       	else if(position == 4){
       		g2d.drawImage(screen1_4, 0, 0, null);
       	}
        
        
        g2d.drawImage(pokemon1.getMiniImage(), 20, 100, null);
        g2d.drawImage(pokemon2.getMiniImage(), 170, 18, null);
        g2d.drawImage(pokemon3.getMiniImage(), 170, 63, null);
        
        g2d.setFont(new Font("Pokemon FireLeaf", Font.PLAIN, 12));
        g2d.setColor(Color.WHITE);
        g2d.drawString(pokemon1.getName(), 80, 135);
        g2d.drawString(pokemon2.getName(), 205, 43);
        g2d.drawString(pokemon3.getName(), 205, 87);
        
        g2d.drawString(Integer.toString(pokemon1.getRemHP()), 95, 170);
        g2d.drawString(Integer.toString(pokemon1.getMaxHP()), 125, 170);
        g2d.drawString(Integer.toString(pokemon2.getRemHP()), 340, 45);
        g2d.drawString(Integer.toString(pokemon2.getMaxHP()), 370, 45);
        g2d.drawString(Integer.toString(pokemon3.getRemHP()), 340, 90);
        g2d.drawString(Integer.toString(pokemon3.getMaxHP()), 370, 90);
        
        Rectangle2D.Double poke1HP = new Rectangle2D.Double(58,151,83*pokemon1.getPercentHP(),4);
        Rectangle2D.Double poke2HP = new Rectangle2D.Double(313,28,83*pokemon2.getPercentHP(),4);
        Rectangle2D.Double poke3HP = new Rectangle2D.Double(313,71,83*pokemon3.getPercentHP(),4);
        g2d.setColor(new Color(119,199,157));
        g2d.fill(poke1HP);
        g2d.fill(poke2HP);
        g2d.fill(poke3HP);
	}
	
	
	public class PartyListener implements KeyListener
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
				else if(position == 3)
				{
					position = 2;
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
				else if(position == 2)
				{
					position = 3;
				}
				else if(position == 3)
				{
					position = 4;
				}
				
				repaint();
			}
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				if(position == 1)
				{
					position = 2;
				}
				
				repaint();
			}
			else if(e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				if(position != 1)
				{
					position = 1;
				}
				
				repaint();
			}
			else if(e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				if(!isSwitch)
				{
					if(position != 4){
						switchHolder = position;
						isSwitch = true;
						
						//System.out.println(Boolean.toString(isSwitch) + playerParty[switchHolder - 1]);
					}
				}
				else
				{
					if(position == 1)
					{
						Pokemon temp = pokemon1;
						playerParty[position-1] = playerParty[switchHolder - 1];
						playerParty[switchHolder-1] = temp;
						
						if(isServer){
							try {
								ttct.objOut.writeBoolean(true);
								ttct.objOut.flush();
								ttct.objOut.writeObject(player.getParty());
								ttct.objOut.flush();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else{
							
							try {
								ttst.objOut.writeBoolean(true);
								ttst.objOut.flush();
								ttst.objOut.writeObject(player.getParty());
								ttst.objOut.flush();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
					}
					else if(position == 2)
					{
						Pokemon temp = pokemon2;
						playerParty[position-1] = playerParty[switchHolder -1];
						playerParty[switchHolder-1] = temp;
						
						if(isServer){
							try {
								ttct.objOut.writeBoolean(true);
								ttct.objOut.flush();
								ttct.objOut.writeObject(player.getParty());
								ttct.objOut.flush();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						}
						else{
							
							try {
								ttst.objOut.writeBoolean(true);
								ttst.objOut.flush();
								ttst.objOut.writeObject(player.getParty());
								ttst.objOut.flush();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
						
					}
					else if(position == 3)
					{
						Pokemon temp = pokemon3;
						playerParty[position-1] = playerParty[switchHolder-1];
						playerParty[switchHolder-1] = temp;
						
						if(isServer){
							
							
							
							try {
								ttct.objOut.writeBoolean(true);
								ttct.objOut.flush();
								ttct.objOut.writeObject(player.getParty());
								ttct.objOut.flush();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
						}
						else{
							
							try {
								ttst.objOut.writeBoolean(true);
								ttst.objOut.flush();
								ttst.objOut.writeObject(player.getParty());
								ttst.objOut.flush();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
						
					}
					isSwitch = false;
					repaint();
					
					
					
				}
				
			}
			
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
