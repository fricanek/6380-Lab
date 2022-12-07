package lab5;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.Timer;
import java.util.TimerTask;



public class guiQuiz extends JFrame {
	Random random = new Random();
	int numC;
	int numW;
	JLabel correct = new JLabel();
	JLabel wrong  = new JLabel();

	public static String[] SHORT_NAMES = { "A", "R", "N", "D", "C", "Q", "E", "G", "H", "I", "L", "K", "M", "F", "P",
			"S", "T", "W", "Y", "V" };
	public static String[] FULL_NAMES = { "alanine", "arginine", "asparagine", "aspartic acid", "cysteine", "glutamine",
			"glutamic acid", "glycine", "histidine", "isoleucine", "leucine", "lysine", "methionine", "phenylalanine",
			"proline", "serine", "threoninef", "tryptophan", "tyrosine", "valine" };

	//getting the cancel button
	private JPanel getBottomPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new guiQuiz();

			}

		});
		panel.add(btnCancel);
		return panel;

	}

//getting the start button and timer 
	private JPanel getStartButton() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		JButton btnStart = new JButton("Start");
		JLabel jlabel = new JLabel();
		
		btnStart.addActionListener(new ActionListener() {
		 
			@Override
			public void actionPerformed(ActionEvent e) {
				 correct.setText("Correct:");
				 wrong.setText("Wrong:");
				 numC = 0;
				 numW = 0;
				 Timer timer = new Timer();
				 timer.scheduleAtFixedRate(new TimerTask() {
					 int i = 30;
					 public void run() {

				            jlabel.setText("Time left: " + i);
				            i--;

				            if (i < 0) {
				                timer.cancel();
				                //jlabel.setText("Time Over");
				                System.exit(0);
				            	
				            }
				
					 }
					 
				
					 
				 },0,1000);
				 
				 
				 
			} });
				
	
		
		panel.add(jlabel);
		panel.add(btnStart);
		return panel;

	
	}
	
	//Printing out the full names and checking to see if they are right or wrong
	int rand; 
	JLabel question = new JLabel();
	String input;
	
	public JPanel getQuestion() {
		JPanel aPanel = new JPanel(new GridLayout(4, 2));
		 rand = random.nextInt(FULL_NAMES.length);
		question.setText(FULL_NAMES[rand]);
		question.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		JLabel ansLabel = new JLabel(" Enter the AA short name:");
		ansLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		//adding to the panels
		aPanel.add(ansLabel);

		return aPanel;


	}
	
	
	  public JPanel getAnswer() { 
		  JPanel qSubPanel = new JPanel(new GridLayout(3,3));
		  JTextField text = new JTextField();

	 
		
	 
	text.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				input = text.getText();
		

				if (SHORT_NAMES[rand].equalsIgnoreCase(input)) {
					numC++;
					correct.setText("Correct: " + numC);
					text.setText("");
					qSubPanel.add(text);
					 rand = random.nextInt(FULL_NAMES.length);
					question.setText(FULL_NAMES[rand]);

				} else {
					//If the answer is wrong add -1 to the "wrong"
					numW++;
					wrong.setText("Wrong: " + numW);
					text.setText("");
					qSubPanel.add(text);
					 rand = random.nextInt(FULL_NAMES.length);
					question.setText(FULL_NAMES[rand]);

					// TODO Auto-generated method stub

				}
			}
	});
	
	  
	  //adding to the panels
	
	qSubPanel.add(question);
	 qSubPanel.add(text);
	  qSubPanel.add(correct);
	  qSubPanel.add(wrong);
	 
	 
	  return qSubPanel;
	  
	  }
	 

	public guiQuiz() {

		
		JFrame aFrame = new JFrame("Quiz");

		aFrame.setSize(600, 500);

		aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aFrame.getContentPane().setLayout(new BorderLayout());
		aFrame.getContentPane().add(getBottomPanel(), BorderLayout.EAST);
		aFrame.getContentPane().add(getStartButton(), BorderLayout.NORTH);

		aFrame.getContentPane().add(getQuestion(), BorderLayout.CENTER);
		aFrame.getContentPane().add(getAnswer(), BorderLayout.AFTER_LAST_LINE);

		aFrame.setVisible(true);

	}

	public static void main(String[] args) {

		new guiQuiz();

	}

}
