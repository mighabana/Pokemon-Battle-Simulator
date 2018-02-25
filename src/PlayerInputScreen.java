import javax.imageio.*;
import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

/**
 * This class represents the JPanel where in the player can alter his details
 * @author Miguel Habana
 *
 */
public class PlayerInputScreen extends JPanel {

	private Player player;
	
	private JPanel leftPanel;
	
	private JComboBox box;
	private JLabel picture;
	private BufferedImage image;
	
	private JPanel inputPanel;
	private JLabel text;
	private JTextField name;
	
	private JPanel bottomPanel;
	private JButton back;
	private JButton finish;
	
	private boolean isFinished;
	
	/**
	 * Constructs an instance of the PlayerInputScreen with parameter player
	 * @param p the player who's details are going to be altered
	 */
	public PlayerInputScreen(Player p)
	{
		this.setLayout(new BorderLayout());
		player = p;
		isFinished = false;
		
		String[] trainers = {"", "Ace Trainer F", "Ace Trainer M", "Agatha", "Aromalady", "Beauty", "Biker", "Bird Keeper", "Blackbelt",
				"Blaine", "Blue1", "Blue2", "Brock", "Bruno", "Bug Catcher", "Burglar", "Camper", "Champion Blue", "Channeler", 
				"Cool Couple", "Crush Girl","Crush Kin","Engineer","Erika", "Fisherman", "Gamer","Gentleman", "Giovanni", "Hiker",
				"Juggler", "Koga", "Lady", "Lance","Lass","Leaf", "Lorelei", "Lt Surge", "Misty","Painter", "Picknicker", "Pokemaniac", 
				"Pokemon Breeder", "Pokemon Ranger F", "Pokemon Ranger M", "Professor Oak", "Psychic F", "Psychic M", "Red", "Rocker",
				"Roughneck", "Ruinmaniac", "Sabrina", "Sailor", "Scientist", "Sis and Bro", "Super Nerd", "Swimmer F", "Swimmer M",
				"Tamer", "Team Rocket Grunt F", "Team Rocket Grunt M", "Tuber F", "Tuber M", "Twins", "Young Couple", "Youngster"};
	
		leftPanel= new JPanel(new BorderLayout());
		box = new JComboBox<String> (trainers);
		box.setSelectedIndex(0);
		box.setMaximumRowCount(5);
		box.addActionListener(new SelectionListener());
		picture = new JLabel();
		
		leftPanel.add(new JLabel("                "),"West");
		leftPanel.add(picture,"Center");
		leftPanel.add(box,"South");
		
		inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,110));
		text = new JLabel("Player Name: ");
		text.setForeground(Color.WHITE);
		name = new JTextField(10);
		name.setDocument(new JTextFieldLimit(10));
		inputPanel.add(text);
		inputPanel.add(name);
		
		bottomPanel = new JPanel(new BorderLayout());
		back = new JButton("Back");
		finish = new JButton("Finished");
		finish.addActionListener(new FinishListener());
		bottomPanel.add(back, "West");
		bottomPanel.add(finish,"East");
		
		inputPanel.setBackground(new Color(20,31,74));
		bottomPanel.setBackground(new Color(20,31,74));
		leftPanel.setBackground(new Color(20,31,74));
		
		add(leftPanel,"West");
		add(inputPanel,"Center");
		add(bottomPanel,"South");
		
	}
	/**
	 * returns the back button, this is used so that the GameFrame can add an action listener into the button
	 * @return the JButton back
	 */
	public JButton getBackButton()
	{
		return back;
	}
	
	/**
	 * returns whether or not the the player is finished properly editing his details
	 * @return the boolean value representing if the player is finished or not
	 */
	public boolean getFinished()
	{
		return isFinished;
	}
	
	/**
	 * returns the finished button, this is used so that the GameFrame can add an action listener into the button
	 * @return the JButton finished
	 */
	public JButton getFinishedButton()
	{
		return finish;
	}
	
	/**
	 * This class is used to limit the number of characters that is input within the JTextField
	 *
	 */
	public class JTextFieldLimit extends PlainDocument {
		  private int limit;

		  JTextFieldLimit(int limit) {
		   super();
		   this.limit = limit;
		   }

		  public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
		    if (str == null) return;

		    if ((getLength() + str.length()) <= limit && image != null) {
		      super.insertString(offset, str, attr);
		    }
		  }
		}
	
	/**
	 * This is the ActionListener for the finished button and augments isFinished if the the image and the JTextField are not blank
	 *
	 */
	public class FinishListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			player.setName(name.getText());
			player.setSprite(image);
			if(!name.getText().trim().equals("") && image != null)
				isFinished = true;
			
			//System.out.println(Boolean.toString(isFinished));
		}
	}
	
	
	public class SelectionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			JComboBox cb = (JComboBox) ae.getSource();
			String spriteName = (String) cb.getSelectedItem();
			try
			{
				if(!spriteName.equals(""))
					image = ImageIO.read(new File(spriteName + ".png"));
			}
			catch(IOException ie)
			{
				ie.printStackTrace();
			}
			if(image != null)
			picture.setIcon(new ImageIcon(image));
			
		}
	}
	
}
