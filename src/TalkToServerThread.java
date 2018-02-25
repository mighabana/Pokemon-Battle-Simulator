import java.awt.event.KeyListener;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;

import javafx.scene.media.*;

/**
 * This class allows for the client to communicate with the server for the networking of the game
 * 
 * @author Miguel Habana
 *
 */
public class TalkToServerThread implements Runnable {

	
    private Socket socket;
    protected ObjectInputStream objIn;
    protected ObjectOutputStream objOut;
    protected int serverDamage; 
    protected int clientDamage;
    private boolean isRunning;
    protected boolean isAttacking;
    private boolean clientWin;
    private boolean serverWin;
    private GameFrame gf;

    
    /**
     * Constructs an instance of TalkToServerThread with an instance of the GameFrame attached to it
     * @param gf the GameFrame that is linked to the TalkToServerThread.
     */
    public TalkToServerThread(GameFrame gf) {
    	
    	isRunning = true;
    	
    	this.gf = gf;
        System.out.println("===== CLIENT CREATED =====");
    }

    /**
     * Calls the connectToServer method when the class is run through a thread.
     */
    
    public void run() {
        connectToServer();
    }

    /**
     * The connectToServer method requests connection to a specified server and utilizes Object Output/Input Streams 
     * to send data to the server. Once a connection is made the method then calls the startReadWriteToServer method.
     */
    
    private void connectToServer() {
        try {
        	Scanner ip = new Scanner(System.in);
            System.out.print("Enter your IP Adress: ");

        	
            socket = new Socket(ip.nextLine(), 9099); 
            objOut = new ObjectOutputStream(socket.getOutputStream());
            objOut.flush();
            objIn = new ObjectInputStream(socket.getInputStream());
          
            startReadWriteToServer();
        } catch (IOException ex) {
            System.out.println("Error in connectToServer() method.");
        }
    }
    
    /**
     * The startReadWriteToServer is where the communication between the client and the server occurs 
     */

    private void startReadWriteToServer(){
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
            while(isRunning){
            	System.out.println("SLOW DOWN");
            	if(isAttacking && objIn.readBoolean()){
            		
            		gf.isWaiting = true;
            		clientDamage = objIn.readInt();
            		int x = 0;
            		while(!gf.fs.getAnimating()){
            			
            			x++;
            			System.out.println(x);
	            		if(gf.fs.getAnimating()){
	            			gf.isWaiting = false;
	            			gf.fs.setAnimating(false);
		            		
			            	if(gf.player.getPokemon1().getSpeed() > gf.opponent.getPokemon1().getSpeed())
			            	{
			            		
			            		gf.opponent.getPokemon1().damage(serverDamage);
			            		clientWin = gf.opponent.getPokemon1().getFainted();
			            		if(!clientWin)
			            		{
			            			gf.player.getPokemon1().damage(clientDamage);
			            			serverWin = gf.player.getPokemon1().getFainted();
			            			if(serverWin)
			            			{
			            				gf.isLose = true;
			        					gf.drawInitialScreen(gf.fs);
			        					break;
			            			}
			            			else
			            			{
			            				
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
			            		gf.player.getPokemon1().damage(clientDamage);
			            		serverWin = gf.player.getPokemon1().getFainted();
			            		if(!serverWin)
			            		{
			            			gf.opponent.getPokemon1().damage(serverDamage);
			            			clientWin = gf.opponent.getPokemon1().getFainted();
			            			if(clientWin)
			            			{
			            				gf.isWin = true;
			        					gf.drawInitialScreen(gf.fs);
			        					break;
			            			}
			            			else
			            			{
			            			
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
            System.out.println("Error in startReadWriteToServer() method.");
        }
        
       
        
        closeSocket();
    }
   
    /**
     * The closeSocket method closes the connection between the server and the client
     */
    public void closeSocket() {
        try {
            socket.close();
            System.out.println("Socket Closed (Client).");
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("Error in closeSocket() method of TalkToServerThread.");
        }
    }

}