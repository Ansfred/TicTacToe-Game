import java.awt.*;			// **awt** - Abstract Window ToolKit
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

// **implements ActionListener** -> We are implementing ActionListener interface
public class TicTacToe implements ActionListener {

	Random random = new Random();
	JFrame frame = new JFrame(); 				// JFrame -> Foundation for creating GUI applications
	JPanel title_panel = new JPanel();			// JPanel -> Part of the Java Swing package, is a container that can store a group
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel(); 	// JLabel is used to display a short string or an image icon
	JButton[] buttons = new JButton[9]; 
	boolean player1_turn;				// *true*, if player1 turn :: *false*, if player2 turn

	TicTacToe() {			// Constructor
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);					// Size of Window
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(new Color(200, 200, 25));		//For color of background
		textfield.setForeground(new Color(20, 55, 170));		//For color of upper text
		textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true); 							//setOpaque -> Will increase Opacity

		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 800, 100);
		
		button_panel.setLayout(new GridLayout(3, 3));
		button_panel.setBackground(new Color(0, 0, 100));
		
		for(int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			// setFocusable() ->  A focus manager looks for special keystrokes that change the focus (usually the Tab and Shift-Tab keys), and then decides which component will next get the focus.
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
	}

	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 9; i++) {
			if(e.getSource() == buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(255, 100, 50));
						buttons[i].setText("X");
						player1_turn = false;
						textfield.setText("O turn");
						check();
					}
				}
				else {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(128, 0, 128));
						buttons[i].setText("O");
						player1_turn = true;
						textfield.setText("X turn");
						check();
					}
				}
			}			
		}
	}
	
	public void firstTurn() {
		
		try {
			Thread.sleep(2000);			// Sleep for 2 secs, that is TICTACTOE GAME title will show for 2 seconds after running and then it will show either X turn or O turn
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(random.nextInt(2) == 0) {
			player1_turn = true;
			textfield.setText("X turn");
		}
		else {
			player1_turn = false;
			textfield.setText("O turn");
		}
	}
	
	public void check() {
		// Check X win conditions
		if(
				(buttons[0].getText() == "X") &&
				(buttons[1].getText() == "X") &&
				(buttons[2].getText() == "X")
				) {
			xWins(0, 1, 2);
		}
		if(
				(buttons[3].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[5].getText() == "X")
				) {
			xWins(3, 4, 5);
		}
		if(
				(buttons[6].getText() == "X") &&
				(buttons[7].getText() == "X") &&
				(buttons[8].getText() == "X")
				) {
			xWins(6, 7, 8);
		}
		if(
				(buttons[0].getText() == "X") &&
				(buttons[3].getText() == "X") &&
				(buttons[6].getText() == "X")
				) {
			xWins(0, 3, 6);
		}
		if(
				(buttons[1].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[7].getText() == "X")
				) {
			xWins(1, 4, 7);
		}
		if(
				(buttons[2].getText() == "X") &&
				(buttons[5].getText() == "X") &&
				(buttons[8].getText() == "X")
				) {
			xWins(2, 5, 8);
		}
		if(
				(buttons[0].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[8].getText() == "X")
				) {
			xWins(0, 4, 8);
		}
		if(
				(buttons[2].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[6].getText() == "X")
				) {
			xWins(2, 4, 6);
		}

		// Check O win conditions
		if(
				(buttons[0].getText() == "O") &&
				(buttons[1].getText() == "O") &&
				(buttons[2].getText() == "O")
				) {
			oWins(0, 1, 2);
		}
		if(
				(buttons[3].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[5].getText() == "O")
				) {
			oWins(3, 4, 5);
		}
		if(
				(buttons[6].getText() == "O") &&
				(buttons[7].getText() == "O") &&
				(buttons[8].getText() == "O")
				) {
			oWins(6, 7, 8);
		}
		if(
				(buttons[0].getText() == "O") &&
				(buttons[3].getText() == "O") &&
				(buttons[6].getText() == "O")
				) {
			oWins(0, 3, 6);
		}
		if(
				(buttons[1].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[7].getText() == "O")
				) {
			oWins(1, 4, 7);
		}
		if(
				(buttons[2].getText() == "O") &&
				(buttons[5].getText() == "O") &&
				(buttons[8].getText() == "O")
				) {
			oWins(2, 5, 8);
		}
		if(
				(buttons[0].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[8].getText() == "O")
				) {
			oWins(0, 4, 8);
		}
		if(
				(buttons[2].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[6].getText() == "O")
				) {
			oWins(2, 4, 6);
		}
	}
	
	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(new Color(0, 100, 0));
		buttons[b].setBackground(new Color(0, 100, 0));
		buttons[c].setBackground(new Color(0, 100, 0));
		
		for(int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X wins");
	}

	public void oWins(int a,int b,int c) {
		buttons[a].setBackground(new Color(0, 100, 0));
		buttons[b].setBackground(new Color(0, 100, 0));
		buttons[c].setBackground(new Color(0, 100, 0));
		
		for(int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O wins");
	}
}
