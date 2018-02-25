import javax.imageio.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.BadLocationException;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

/**
 * This is the class that represents the JPanel for altering the players party and corresponding pokemon
 * @author Migue909
 *
 */
public class PokemonInputScreen extends JPanel {

	private Player player;
	private Pokemon pokemon;
	private Pokemon[] pokedex;
	private String[] list;
	private int partyNum;
	
	private JPanel selectionPanel;
	private JComboBox<String> pokemonSelection;
	private JLabel picture;
	private BufferedImage image;
	
	private JPanel statsPanel;
	private JPanel baseStats;
	private JPanel evInputs;
	private JLabel hp;
	private JLabel attack;
	private JLabel defense;
	private JLabel spAttack;
	private JLabel spDefense;
	private JLabel speed;
	private JTextField hpEVsInput;
	private JTextField attackEVsInput;
	private JTextField defenseEVsInput;
	private JTextField spAttackEVsInput;
	private JTextField spDefenseEVsInput;
	private JTextField speedEVsInput;
	
	private JPanel movesPanel;
	private JComboBox<String> move1;
	private JComboBox<String> move2;
	private JComboBox<String> move3;
	private JComboBox<String> move4;
	
	private JPanel bottomPanel;
	private JButton finish;
	private JLabel pokemonNum;
	private JLabel evCount;
	
	private JPanel topPanel;
	private JButton back;
	private JLabel msg;
	
	
	private boolean isFinished;

	/**
	 * constructs the pokemonInputScreen
	 * @param p the player who's party is going to be altered
	 * @param n was used to represent which order in the pokemon party was being altered but since the multiple pokemon functionality was depreciated, 1 is usally passed into it
	 */
	public PokemonInputScreen(Player p, int n)
	{
		this.setLayout(new BorderLayout());
		
		Pokemon[] temp = {new Venusaur(), new Charizard(), new Blastoise(), new Butterfree(), new Beedrill(),  new Raichu(), new Nidoqueen(), new Nidoking(),
				new Golduck(), new Arcanine(), new Alakazam(), new Machamp(), new Tentacruel(), new Golem(), new Magneton(), new Dewgong(), new Muk(),
				new Cloyster(), new Gengar(), new Marowak(), new Rhydon(), new Kangaskhan(),
				new Gyarados(), new Vaporeon(), new Jolteon(), new Flareon(), new Snorlax(), new Dragonite(), new Meganium(), new Typhlosion(), new Feraligatr(),
				new Crobat(), new Ampharos(), new Espeon(), new Umbreon(), new Scizor(), new Heracross(), new Skarmory(), new Houndoom(),
				new Kingdra(), new Blissey(), new Tyranitar()};
		pokedex = temp;
		
		list = new String[pokedex.length +1];
		
		list[0] = "Pokemon";
		for(int i = 1; i < pokedex.length + 1; i++){
			list[i] = pokedex[i-1].getName();
		}
		
		player = p;
		partyNum = n;
		
		selectionPanel = new JPanel(new BorderLayout());
		pokemonSelection = new JComboBox<String>(list);
		pokemonSelection.setSelectedIndex(0);
		pokemonSelection.addActionListener(new PokemonListener());
		picture = new JLabel();
		selectionPanel.add(new JLabel("     "),"West");
		selectionPanel.add(picture, "Center");
		selectionPanel.add(pokemonSelection,"South");
		
		statsPanel = new JPanel(new GridLayout(1,2));
		baseStats = new JPanel(new GridLayout(7,1));
		evInputs = new JPanel(new GridLayout(7,1));
		
		hp = new JLabel("HP: 0");
		hp.setForeground(Color.WHITE);
		attack = new JLabel("Atk: 0");
		attack.setForeground(Color.WHITE);
		defense = new JLabel("Def: 0");
		defense.setForeground(Color.WHITE);
		spAttack = new JLabel("SpAtk: 0");
		spAttack.setForeground(Color.WHITE);
		spDefense = new JLabel("SpDef: 0");
		spDefense.setForeground(Color.WHITE);
		speed = new JLabel("Spd: 0");
		speed.setForeground(Color.WHITE);
		
		hpEVsInput = new JTextField("0");
		hpEVsInput.getDocument().addDocumentListener(new EVListener());
		attackEVsInput = new JTextField("0");
		attackEVsInput.getDocument().addDocumentListener(new EVListener());
		defenseEVsInput = new JTextField("0");
		defenseEVsInput.getDocument().addDocumentListener(new EVListener());
		spAttackEVsInput = new JTextField("0");
		spAttackEVsInput.getDocument().addDocumentListener(new EVListener());
		spDefenseEVsInput = new JTextField("0");
		spDefenseEVsInput.getDocument().addDocumentListener(new EVListener());
		speedEVsInput = new JTextField("0");	
		speedEVsInput.getDocument().addDocumentListener(new EVListener());
		
		baseStats.add(new JLabel());
		baseStats.add(hp);
		
		JLabel label = new JLabel("EVs");
		label.setForeground(Color.WHITE);
		evInputs.add(label);
		evInputs.add(hpEVsInput);
		
		baseStats.add(attack);
		evInputs.add(attackEVsInput);
		
		baseStats.add(defense);
		evInputs.add(defenseEVsInput);
		
		baseStats.add(spAttack);
		evInputs.add(spAttackEVsInput);
		
		baseStats.add(spDefense);
		evInputs.add(spDefenseEVsInput);
		
		baseStats.add(speed);
		evInputs.add(speedEVsInput);
		
		statsPanel.add(baseStats);
		statsPanel.add(evInputs);
		
		movesPanel = new JPanel(new GridLayout(4,1));
		MutableComboBoxModel<String> model1 = new DefaultComboBoxModel<String>();
		model1.addElement("");
		move1 = new JComboBox<String>(model1);
		move1.addActionListener(new Move1Listener());
		MutableComboBoxModel<String> model2 = new DefaultComboBoxModel<String>();
		model2.addElement("");
		move2 = new JComboBox<String>(model2);
		move2.addActionListener(new Move2Listener());
		MutableComboBoxModel<String> model3 = new DefaultComboBoxModel<String>();
		model3.addElement("");
		move3 = new JComboBox<String>(model3);
		move3.addActionListener(new Move3Listener());
		MutableComboBoxModel<String> model4 = new DefaultComboBoxModel<String>();
		model4.addElement("");
		move4 = new JComboBox<String>(model4);
		move4.addActionListener(new Move4Listener());
		movesPanel.add(move1);
		movesPanel.add(move2);
		movesPanel.add(move3);
		movesPanel.add(move4);
		
		bottomPanel = new JPanel(new BorderLayout());
		finish = new JButton("Finished");
		finish.addActionListener(new FinishListener());
		pokemonNum = new JLabel("Pokemon #" + partyNum);
		pokemonNum.setForeground(Color.WHITE);
		evCount = new JLabel("EVs Left: 508");
		evCount.setForeground(Color.WHITE);
		bottomPanel.add(pokemonNum, "West");
		bottomPanel.add(finish, "Center");
		bottomPanel.add(evCount, "East");
		
		topPanel = new JPanel();
		back = new JButton("Back");
		msg = new JLabel("Max EVs/stat = 252 & Max total EVs = 508");
		msg.setForeground(Color.WHITE);
		
		topPanel.add(back);
		topPanel.add(msg);
		
		selectionPanel.setBackground(new Color(20,31,74));
		baseStats.setBackground(new Color(20,31,74));
		evInputs.setBackground(new Color(20,31,74));
		movesPanel.setBackground(new Color(20,31,74));
		bottomPanel.setBackground(new Color(20,31,74));
		topPanel.setBackground(new Color(20,31,74));
		
		add(topPanel, "North");
		add(selectionPanel,"West");
		add(statsPanel, "East");
		add(movesPanel, "Center");
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
	 * returns whether or not the the player is finished properly editing his pokemon party
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
	 * This is the actionListener for the JComboBox that selects the pokemon to be used. 
	 * The selected pokemon's sprite will be desplayed as well as its corresponding possible moves and stats
	 * @author Miguel Habana
	 *
	 */
	public class PokemonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(pokemonSelection.getSelectedIndex() != 0)
			{
				int pokeIndex = pokemonSelection.getSelectedIndex();
				pokemon = pokedex[pokeIndex-1];
				image = pokemon.getFrontImage();
				picture.setIcon(new ImageIcon(image));
				hp.setText("HP: " +pokemon.getMaxHP());
				attack.setText("Atk: " + pokemon.getAttack());
				defense.setText("Def: " + pokemon.getDefense());
				spAttack.setText("SpAtk: " + pokemon.getSpAttack());
				spDefense.setText("SpDef: " + pokemon.getSpDefense());
				speed.setText("Spd: " + pokemon.getSpeed());
				
				Moves[] posMov = pokemon.getPossibleMoves();
				
				if(move1.getItemCount() >1){
					for(int i = 1; i < move1.getItemCount();)
					{
						move1.removeItemAt(i);
						move2.removeItemAt(i);
						move3.removeItemAt(i);
						move4.removeItemAt(i);
					}
				}
					
				for(int x = 0; x < posMov.length; x++)
				{
					move1.addItem(posMov[x].getName());
					move2.addItem(posMov[x].getName());
					move3.addItem(posMov[x].getName());
					move4.addItem(posMov[x].getName());
				}
			}
		}
	}
	
	/**
	 * this is an ActionListener for the JComboBox of the pokemon's 1st move
	 * @author Miguel Habana
	 *
	 */
	public class Move1Listener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(move1.getSelectedIndex() != 0)
			{
				int moveIndex = move1.getSelectedIndex();
				Moves[] moves = pokemon.getPossibleMoves();
				Moves move = moves[moveIndex-1];
				
				pokemon.setMove1(move);
			}
			
		}
		
	}
	
	/**
	 * this is an ActionListener for the JComboBox of the pokemon's 2nd move
	 * @author Miguel Habana
	 *
	 */
	public class Move2Listener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(move2.getSelectedIndex() != 0)
			{
				int moveIndex = move2.getSelectedIndex();
				Moves[] moves = pokemon.getPossibleMoves();
				Moves move = moves[moveIndex-1];
				
				pokemon.setMove2(move);
			}
			
		}
		
	}
	
	/**
	 * this is an ActionListener for the JComboBox of the pokemon's 3rd move
	 * @author Miguel Habana
	 *
	 */
	public class Move3Listener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(move3.getSelectedIndex() != 0)
			{
				int moveIndex = move3.getSelectedIndex();
				Moves[] moves = pokemon.getPossibleMoves();
				Moves move = moves[moveIndex-1];
				
				pokemon.setMove3(move);
			}
			
		}
		
	}
	
	/**
	 * This is the ActionListener for the JComboBox of the pokemon's 4th move
	 * @author Miguel Habana
	 *
	 */
	public class Move4Listener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(move4.getSelectedIndex() != 0)
			{
				int moveIndex = move4.getSelectedIndex();
				Moves[] moves = pokemon.getPossibleMoves();
				Moves move = moves[moveIndex-1];
				
				pokemon.setMove4(move);
			}
			
		}
		
	}
	
	/**
	 * This is the DoccumentListener for the JTextFields wherein the input for the pokemon's EVs are read
	 * This updates the pokemon's stats based on the values input within the JTextFields
	 * 
	 * Although a error in updating the stats occurs if one of the JTextFields before the one being updated
	 * is not an int value or is blank.
	 * @author Miguel Habana
	 *
	 */
	public class EVListener implements DocumentListener
	{
		@Override
		public void insertUpdate(DocumentEvent de) {
			
			if(pokemonSelection.getSelectedIndex() != 0){
				int hpEVs = 0;
				int attackEVs = 0;
				int defenseEVs = 0;
				int spAttackEVs = 0;
				int spDefenseEVs = 0;
				int speedEVs = 0;
				
				
				try{
				hpEVs = Integer.parseInt(hpEVsInput.getText());
				attackEVs = Integer.parseInt(attackEVsInput.getText());
				defenseEVs = Integer.parseInt(defenseEVsInput.getText());
				spAttackEVs = Integer.parseInt(spAttackEVsInput.getText());
				spDefenseEVs = Integer.parseInt(spDefenseEVsInput.getText());
				speedEVs = Integer.parseInt(speedEVsInput.getText());
				}
				catch(NumberFormatException e)
				{
					
				}
				
				int totalEVs = hpEVs + attackEVs + defenseEVs + spAttackEVs + spDefenseEVs + speedEVs;
				
				if(totalEVs <= 508)
					pokemon.addHPEVs(hpEVs);
				if(totalEVs <= 508)
					pokemon.addAttackEVs(attackEVs);
				if(totalEVs <= 508)
					pokemon.addDefenseEVs(defenseEVs);
				if(totalEVs <= 508)
					pokemon.addSpAttackEVs(spAttackEVs);
				if(totalEVs <= 508)
					pokemon.addSpDefenseEVs(spDefenseEVs);
				if(totalEVs <= 508)
					pokemon.addSpeedEVs(speedEVs);
				
				hp.setText("HP: " +pokemon.getMaxHP());
				attack.setText("Atk: " + pokemon.getAttack());
				defense.setText("Def: " + pokemon.getDefense());
				spAttack.setText("SpAtk: " + pokemon.getSpAttack());
				spDefense.setText("SpDef: " + pokemon.getSpDefense());
				speed.setText("Spd: " + pokemon.getSpeed());
				
				evCount.setText("EVs Left: " + (508-totalEVs));
			}
			
		}

		@Override
		public void removeUpdate(DocumentEvent de) {
			if(pokemonSelection.getSelectedIndex() != 0){
				int hpEVs = 0;
				int attackEVs = 0;
				int defenseEVs = 0;
				int spAttackEVs = 0;
				int spDefenseEVs = 0;
				int speedEVs = 0;
				
				
				try{
				hpEVs = Integer.parseInt(hpEVsInput.getText());
				attackEVs = Integer.parseInt(attackEVsInput.getText());
				defenseEVs = Integer.parseInt(defenseEVsInput.getText());
				spAttackEVs = Integer.parseInt(spAttackEVsInput.getText());
				spDefenseEVs = Integer.parseInt(spDefenseEVsInput.getText());
				speedEVs = Integer.parseInt(speedEVsInput.getText());
				}
				catch(NumberFormatException e)
				{
					
				}
				
				int totalEVs = hpEVs + attackEVs + defenseEVs + spAttackEVs + spDefenseEVs + speedEVs;
				
				if(totalEVs <= 508)
					pokemon.addHPEVs(hpEVs);
				if(totalEVs <= 508)
					pokemon.addAttackEVs(attackEVs);
				if(totalEVs <= 508)
					pokemon.addDefenseEVs(defenseEVs);
				if(totalEVs <= 508)
					pokemon.addSpAttackEVs(spAttackEVs);
				if(totalEVs <= 508)
					pokemon.addSpDefenseEVs(spDefenseEVs);
				if(totalEVs <= 508)
					pokemon.addSpeedEVs(speedEVs);
				
				hp.setText("HP: " +pokemon.getMaxHP());
				attack.setText("Atk: " + pokemon.getAttack());
				defense.setText("Def: " + pokemon.getDefense());
				spAttack.setText("SpAtk: " + pokemon.getSpAttack());
				spDefense.setText("SpDef: " + pokemon.getSpDefense());
				speed.setText("Spd: " + pokemon.getSpeed());
				
				
				evCount.setText("EVs Left: " + (508-totalEVs));
			}
			
		}

		@Override
		public void changedUpdate(DocumentEvent de) {
			
		}
	}
	
	/**
	 * The ActionListener for the finished button
	 * Augments the boolean value of finished depending on the state of the JPanel
	 * @author Miguel Habana
	 *
	 */
	public class FinishListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae){
			
			if(pokemon != null && move1.getSelectedIndex() != 0 && move2.getSelectedIndex() != 0 && move3.getSelectedIndex() != 0 && move4.getSelectedIndex() != 0){	
				if(partyNum == 1)
				{
					player.setPokemon1(pokemon);
				}
				
				/*
				else if(partyNum == 2)
				{
					player.setPokemon2(pokemon);
				}
				else if(partyNum == 3)
				{
					player.setPokemon3(pokemon);
				}
				*/
				isFinished = true;
				System.out.print(isFinished);
				
			}
			
		}
		
	}
	
	
	
}
