import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

/**
 * This class represents the frame of the entire game
 * @author Migue909
 *
 */

public class GameFrame extends JFrame implements Runnable {

	protected MenuScreen ms;
	protected PlayerInputScreen playIS;
	protected PokemonInputScreen pokeIS1;
	protected PokemonInputScreen pokeIS2;
	protected PokemonInputScreen pokeIS3;
	protected LoadingScreen ls;
	protected InitialScreen is;
	protected CommandScreen cs;
	protected FightScreen fs;
	
	protected Player player;
	protected Player opponent;
	
	private TalkToClientThread ttct;
	private TalkToServerThread ttst;
	
	private int delay;
	
	private MSListener msl;
	private CommandScreenListener csl;
	protected FightScreenListener fsl;
	//private PartyScreenListener psl;
	
	private boolean isRunning;
	protected boolean isLoading;
	protected boolean isInitial;
	protected boolean isWaiting;
	protected boolean isWin;
	protected boolean isLose;
	
	/**
	 * Constructs the initial screen of the game with the parameter for the player and the delay of the thread
	 * @param p the player
	 * @param d the delay
	 */
	
	public GameFrame(Player p, int d)
	{	
		isRunning = true;
		isLose = false;
		delay = d;
		player = p;
		drawMenuScreen(null);
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try{
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("pkmnfl.ttf")));
        }
        catch (IOException | FontFormatException e) {

        }
		
	}
	
	/**
	 * draws the menu screen with a parameter to remove a component from the frame
	 * @param c the component to be removed
	 */
	public void drawMenuScreen(Component c)
	{
		if(c!=null)
		this.remove(c);
		
		ms = new MenuScreen(player);
		msl = new MSListener();
		
		this.getContentPane().addKeyListener(msl);
		this.getContentPane().setFocusable(true);
		this.add(ms);
		this.validate();
		
		this.getContentPane().requestFocus();
	}

	/**
	 * draws the PlayerInputScreen with a parameter to remove a component from the frame
	 * @param c the component to be removed
	 */
	public void drawPlayerInputScreen(JComponent c)
	{
		if(c != null)
		remove(c);
		
		playIS = new PlayerInputScreen(player);
		playIS.getFinishedButton().addActionListener(new PlayISListener());
		playIS.getBackButton().addActionListener(new PlayISBackListener());
		this.add(playIS);
		this.validate();
		
	}
	
	/**
	 * draws the PokemonInputScreen with a parameter to remove a component from the frame
	 * @param c the component to be removed
	 */
	public void drawPokemonInputScreen1(JComponent c)
	{
		if(c != null)
		remove(c);
		
		pokeIS1 = new PokemonInputScreen(player,1);
		pokeIS1.getFinishedButton().addActionListener(new PokeISListener1());
		pokeIS1.getBackButton().addActionListener(new PokeISBackListener());
		this.add(pokeIS1);
		this.validate();
	}
	/*
	public void drawPokemonInputScreen2(JComponent c)
	{
		if(c != null)
		remove(pokeIS1);
		
		pokeIS2 = new PokemonInputScreen(player,2);
		pokeIS2.getFinishedButton().addActionListener(new PokeISListener2());
		pokeIS2.getBackButton().addActionListener(new BackListener2());
		this.add(pokeIS2);
		this.validate();
	}
	
	public void drawPokemonInputScreen3(JComponent c)
	{
		if(c != null)
		remove(pokeIS2);
		
		pokeIS3 = new PokemonInputScreen(player,3);
		pokeIS3.getFinishedButton().addActionListener(new PokeISListener3());
		pokeIS3.getBackButton().addActionListener(new BackListener3());
		this.add(pokeIS3);
		this.validate();
	}
	 */
	
	/**
	 * draws the LoadingScreen with a parameter to remove a component from the frame
	 * @param c the component to be removed
	 */
	public void drawLoadingScreen(Component c)
	{
		if(c != null)
			this.remove(c);
		
		ls = new LoadingScreen();
		this.add(ls);
		this.validate();
	}
	
	/**
	 * draws the InitialScreen with a parameter to remove a component from the frame
	 * @param c the component to be removed
	 */
	public void drawInitialScreen(Component c)
	{
		if(c!=null)
			this.remove(c);
		
		is = new InitialScreen(player,opponent, this);
		
		this.add(is);
		this.validate();
	}
	
	/**
	 * draws the CommandScreen with a parameter to remove a component from the frame
	 * @param c the component to be removed
	 */
	public void drawCommandScreen(Component c)
	{
		if(c!= null)
			this.remove(c);
		
		cs = new CommandScreen(player, opponent, this);
		csl = new CommandScreenListener();
		this.getContentPane().addKeyListener(csl);
		
		this.add(cs);
		this.validate();
		
		this.getContentPane().requestFocus();
		
	}
	
	/**
	 * draws the FightScreen with a parameter to remove a component from the frame
	 * @param c the component to be removed
	 */
	public void drawFightScreen()
	{
		remove(cs);
		
		fs = new FightScreen(player, opponent, ttst, ttct, this);
		fsl = new FightScreenListener();
		
		this.getContentPane().addKeyListener(fsl);
		
		this.add(fs);
		this.validate();
		
		this.getContentPane().requestFocus();
	}
	
	/*
	public void drawPartyScreen()
	{
		remove(cs);
	
		ps = new PartyScreen(player, ttst, ttct, this);
		psl = new PartyScreenListener();
		this.getContentPane().addKeyListener(psl);
		
		this.add(ps);
		this.validate();
	
		this.getContentPane().requestFocus();
	}
	
	*/
	

	/**
	 * the run method of the GameFrame this is where the different components are animated
	 */
	public void run() {
		try{
			while(isRunning){
				
				if(isLoading)
					ls.animate();
				
				if(isInitial)
					is.animate();
				
				if(isWaiting)
					fs.animate();
				
				
				if(isLose || isWin)
					is.animate();
				
				repaint();
					
				Thread.sleep(delay);
			}
			
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * The KeyListener for the MenuScreen which augments the location of the triangle as well as which screen will be drawn from the MenuScreen
	 * @author Miguel Habana
	 *
	 */
	public class MSListener implements KeyListener
	{
	
		@Override
		public void keyTyped(KeyEvent e) {
			
		}
	
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_UP)
			{
				if(ms.getPosition() == 2)
				{
					ms.setPosition(1);
				}
				else if(ms.getPosition() == 3)
				{
					ms.setPosition(2);
				}
				else if(ms.getPosition() == 4)
				{
					ms.setPosition(3);
				}
				
			}
			else if(e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				if(ms.getPosition() == 1)
				{
					ms.setPosition(2);
				}
				else if(ms.getPosition() == 2)
				{
					ms.setPosition(3);
				}
				else if(ms.getPosition() == 3)
				{
					ms.setPosition(4);
				}
				 
			}
			else if(e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				if(ms.getPosition() == 1)
				{
					
					 ttct = new TalkToClientThread(GameFrame.this);
					 Thread t = new Thread(ttct);
					 t.start();
					 
					 drawLoadingScreen(ms);
					 isLoading = true;
					 GameFrame.this.getContentPane().removeKeyListener(msl);
					

				}
				else if(ms.getPosition() == 2)
				{
					
					 ttst = new TalkToServerThread(GameFrame.this);
					 Thread t = new Thread(ttst);
					 t.start();
					 
					 drawLoadingScreen(ms);
					 isLoading = true;
					 GameFrame.this.getContentPane().removeKeyListener(msl);
				}
				else if(ms.getPosition() == 3){
					drawPokemonInputScreen1(ms);
					GameFrame.this.getContentPane().removeKeyListener(msl);
				}
				
				else if(ms.getPosition() == 4){
					drawPlayerInputScreen(ms);
					GameFrame.this.getContentPane().removeKeyListener(msl);
				}
			}
			
			
		}
	
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	/**
	 * ActionListener that is inserted into the finished button of the PlayerInputScreen in order to go back to the MenuScreen when the player is finished
	 * @author Miguel Habana
	 *
	 */
	
	public class PlayISListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			boolean b = playIS.getFinished();
			if(b)
			{
				drawMenuScreen(playIS);
				
			}
			
		}
	}
	
	/**
	 * ActionListener for the player to go back to the MenuScreen from the PlayerInputScreen without making any changes
	 * @author Miguel Habana
	 *
	 */
	public class PlayISBackListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e){
			drawMenuScreen(playIS);
		}
	}
	
	/**
	 * ActionListener for the finished button of the PokemonInputScreen in order to go back to the MenuScreen when the player is finished making changes to his party
	 * @author Miguel Habana
	 *
	 */
	public class PokeISListener1 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{			
			boolean b = pokeIS1.getFinished();
			
			if(b)
			{
				drawMenuScreen(pokeIS1);
			}
				
		}
	}

	/*
	public class PokeISListener2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			boolean b = pokeIS2.getFinished();
			if(b)
			{
				drawPokemonInputScreen3(pokeIS2);
			}
		}
	}
	public class PokeISListener3 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			boolean b = pokeIS3.getFinished();
			if(b)
			{
				drawMenuScreen(pokeIS3);
			}
		}
	}
	*/
	
	/**
	 * ActionListener for the back button of the PokemonInputScreen to go back to the MenuScreen without making any changes to the player's party
	 * @author Migue909
	 *
	 */
	public class PokeISBackListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			drawMenuScreen(pokeIS1);
		}
	}
	
	/*
	public class BackListener2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			drawPokemonInputScreen1(pokeIS2);
		}
	}
	
	public class BackListener3 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			drawPokemonInputScreen2(pokeIS3);
		}
	}
	
	*/
	
	/**
	 * The KeyListener for the CommandScreen to change the position of the triangle as well as change between the screens
	 * @author Miguel Habana
	 *
	 */
	public class CommandScreenListener implements KeyListener
	{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_UP)
			{
				if(cs.getPosition() == 2)
				{
					cs.setPosition(1);
				}
				else if(cs.getPosition() == 4)
				{
					cs.setPosition(3);
				}	
				 
			}
			else if(e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				if(cs.getPosition() == 1)
				{
					cs.setPosition(2);
				}
				else if(cs.getPosition() == 3)
				{
					cs.setPosition(4);
				}
				 
			}
			else if(e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				if(cs.getPosition() == 3)
				{
					cs.setPosition(1);
				}
				else if(cs.getPosition() == 4)
				{
					cs.setPosition(2);
				}
				 
			}
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				if(cs.getPosition() == 1)
				{
					cs.setPosition(3);
				}
				else if(cs.getPosition() == 2)
				{
					cs.setPosition(4);
				}
				 
			}
			
			else if(e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				if(cs.getPosition() == 1)
				{

					KeyListener[] kl = getContentPane().getKeyListeners();
					
					for(int i = 0; i < kl.length; i ++)
					GameFrame.this.getContentPane().removeKeyListener(kl[i]);
					
					GameFrame.this.drawFightScreen();
				}
				/*
				else if(cs.getPosition() == 2)
				{
					KeyListener[] kl = getContentPane().getKeyListeners();
					
					for(int i = 0; i < kl.length; i ++)
					GameFrame.this.getContentPane().removeKeyListener(kl[i]);
					
					drawPartyScreen();
				}
				*/
				else if(cs.getPosition() == 3)
				{
					cs.setSideText1("Items can't be used in");
					cs.setSideText2("this battle.");
				}
				else if(cs.getPosition() == 4)
				{
					cs.setSideText1("You can't run away from");
					cs.setSideText2("trainer battles.");
				}
				
				 
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * KeyListener for the FightScreen so that the player is able to go back to the MenuScreen
	 * @author Miguel Habana
	 *
	 */
	public class FightScreenListener implements KeyListener
	{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_SHIFT )
			{
				
				KeyListener[] kl = getContentPane().getKeyListeners();
				
				for(int i = 0; i < kl.length; i ++)
				GameFrame.this.getContentPane().removeKeyListener(kl[i]);
				
				drawCommandScreen(fs);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/*
	
	public class PartyScreenListener implements KeyListener
	{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			
			
			if(e.getKeyCode() == KeyEvent.VK_SHIFT)
			{
				
				KeyListener[] kl = getContentPane().getKeyListeners();
				
				for(int i = 0; i < kl.length; i ++)
				GameFrame.this.getContentPane().removeKeyListener(kl[i]);
				
				drawCommandScreen(ps);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	*/
	
}
