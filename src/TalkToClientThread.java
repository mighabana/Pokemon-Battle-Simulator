import java.awt.event.KeyListener;
import java.io.*;
import java.net.*;

import javax.imageio.ImageIO;

/**
 * This class allows for the server to communicate with the client for the networking of the game
 * @author Migue909
 *
 */
public class TalkToClientThread implements Runnable {

	private ServerSocket serverSocket;
	private Socket socket;
	protected ObjectInputStream objIn;
	protected ObjectOutputStream objOut;
	protected int serverDamage;
	protected int clientDamage;
	private boolean isRunning;
	protected boolean isAttacking;
	protected boolean serverWin;
	protected boolean clientWin;
	private GameFrame gf;
	
	
	/**
	 * Constructs an instance of the TalkToClientThread with an instance of the GameFrame attatched to it
	 * @param gf the GameFrame that is linked to the TalkToClientThread
	 */
	public TalkToClientThread(GameFrame gf)
	{
		this.gf = gf;
		
		
		System.out.println("===== SERVER CREATED =====");
		isRunning = true;
		
		try
		{
			serverSocket = new ServerSocket(9099);
		}
		catch(IOException ie)
		{
			System.out.println("Error in ServerSocket instantiation");
		}
	}
	
	/**
	 * Calls the acceptConnection method
	 */
	public void run()
	{
		acceptConnection();
	}
	
	/**
	 * the acceptConnection method waits for a request for connection to be made and utilizes Object Input/Output Streams
	 * to send data to the client. Once a connection is made the method then calls the startReadWriteToClient method
	 */
	public void acceptConnection()
	{
	       try {
	    	   
	            socket = serverSocket.accept();
	            objOut = new ObjectOutputStream(socket.getOutputStream());
	            objOut.flush();
	            objIn = new ObjectInputStream(socket.getInputStream());
	            
	           
	            startReadWriteToClient();
	        } catch (IOException ex) {
	            System.out.println("Error in acceptConnection() method.");
	        }
	}
	
	/**
	 * The startReadWriteToClient method is where the communication between the server and the client occurs
	 */
	private void startReadWriteToClient() {
        try {
        	gf.isLoading = false;
        	
            objOut.writeBoolean(true);
            objOut.flush();
           
           
            if(objIn.readBoolean())
            {
            	
            	objOut.writeObject(gf.player);
            	objOut.flush();
            	try {
            		
					gf.opponent = (Player) objIn.readObject();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
            	gf.drawInitialScreen(gf.ls);
            	gf.isInitial = true;
            }
            
            while (isRunning) {
            	System.out.println("SLOW DOWN");
            	if(isAttacking && objIn.readBoolean()){
            		
            		gf.isWaiting = true;
            		serverDamage = objIn.readInt();
            		int x = 0;
            		while(!gf.fs.getAnimating()){
            			
            			x++;
            			System.out.println(x);
	            		if(gf.fs.getAnimating()){
	            			gf.isWaiting = false;
	            			gf.fs.setAnimating(false);
		            		
		            		
		            		if(gf.player.getPokemon1().getSpeed() > gf.opponent.getPokemon1().getSpeed())
		            		{
		            			gf.opponent.getPokemon1().damage(clientDamage);
		            			serverWin = gf.opponent.getPokemon1().getFainted();
		            			if(!serverWin)
		            			{
		            				gf.player.getPokemon1().damage(serverDamage);
		            				clientWin = gf.player.getPokemon1().getFainted();
		            				if(clientWin)
		            				{
		            					gf.isLose = true;
		            					gf.drawInitialScreen(gf.fs);
		            					break;
		            				}
		            				else{
		            					
			            				gf.fs.screen = ImageIO.read(new File("FightScreen.png"));
			        					gf.fs.position = 1;
			        					gf.getContentPane().addKeyListener(gf.fsl);
			        					isAttacking = false;
			        					
		            					break;
		            				}
		            			}
		            			else
		            			{
		            				gf.isWin = true;
		        					gf.drawInitialScreen(gf.fs);
		        					break;
		            			}
		            		}
		            		else
		            		{
		            			gf.player.getPokemon1().damage(serverDamage);
		            			clientWin = gf.player.getPokemon1().getFainted();
		            			
		            			if(!clientWin)
		            			{
		            				gf.opponent.getPokemon1().damage(clientDamage);
		            				serverWin = gf.opponent.getPokemon1().getFainted();
		            				if(serverWin)
		            				{
		            					gf.isWin = true;
		            					gf.drawInitialScreen(gf.fs);
		            					break;
		            				}
		            				else{
		            					
			            				gf.fs.screen = ImageIO.read(new File("FightScreen.png"));
			        					gf.fs.position = 1;
			        					gf.getContentPane().addKeyListener(gf.fsl);
			        					isAttacking = false;
			        					
		            					break;
		            				}
		            			}
		            			else
		            			{
		            				gf.isLose = true;
		            				gf.drawInitialScreen(gf.fs);
		            				break;
		            			}
		            	
		            		}
	            		}
            		}
            	}
            }
        	
        } catch (IOException ex) {
        	ex.printStackTrace();
            System.out.println("Error in startReadWriteToClient() method.");
        }

        closeSocket();
    }

	/**
	 * The closeSocket method closes the connection between the client and the server
	 */
    private void closeSocket() {
        try {
            socket.close();
            System.out.println("Socket Closed (Server).");
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("Error in closeSocket() method of TalkToClientThread.");
        }
    }

}

