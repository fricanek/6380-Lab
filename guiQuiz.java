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
import javax.swing.JTextField;
import java.util.Timer;
import java.util.TimerTask;



public class guiQuiz extends JFrame {
	Random random = new Random();

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
				System.exit(0);

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

	public JPanel getCorrect() {

		JPanel aPanel = new JPanel(new GridLayout(4, 2));
		int rand = random.nextInt(FULL_NAMES.length);
		JLabel question = new JLabel(FULL_NAMES[rand]);
		question.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		JPanel qSubPanel = new JPanel(new GridLayout(3, 2));
		JLabel ansLabel = new JLabel(" Enter the AA short name:");
		ansLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		JTextField textfield = new JTextField();
		
		JLabel correct = new JLabel("Correct:");
		JLabel wrong = new JLabel("Wrong:");
		textfield.addActionListener(new ActionListener() {
			int numC = 0;
			int numW = 0;

			@Override
			public void actionPerformed(ActionEvent e) {

				int rand = random.nextInt(FULL_NAMES.length);

				String input = textfield.getText();
				
				//If the answer is correct add q to numC
				if (SHORT_NAMES[rand].equalsIgnoreCase(input)) {
					numC++;
					correct.setText("Correct: " + numC);
					textfield.setText("");
					qSubPanel.add(textfield);
					question.setText(FULL_NAMES[rand]);

				} else {
					//If the answer is wrong add 1 to the "wrong"
					numW--;
					wrong.setText("Wrong: " + numW);
					textfield.setText("");
					qSubPanel.add(textfield);
					question.setText(FULL_NAMES[rand]);

					// TODO Auto-generated method stub

				}

				//adding to the panels
				  qSubPanel.add(ansLabel); 
				  qSubPanel.add(textfield);
				  qSubPanel.add(correct);
				  qSubPanel.add(wrong);
				  aPanel.add(question);
				  
				  aPanel.add(qSubPanel);
				 
			}

		});
		//adding to the panels
		qSubPanel.add(ansLabel);
		qSubPanel.add(textfield);
		qSubPanel.add(correct);
		qSubPanel.add(wrong);
		aPanel.add(question);

		aPanel.add(qSubPanel);

		return aPanel;

	}

	public guiQuiz() {

		
		JFrame aFrame = new JFrame("Quiz");

		aFrame.setSize(600, 500);

		aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aFrame.getContentPane().setLayout(new BorderLayout());
		aFrame.getContentPane().add(getBottomPanel(), BorderLayout.SOUTH);
		aFrame.getContentPane().add(getStartButton(), BorderLayout.NORTH);

		aFrame.getContentPane().add(getCorrect(), BorderLayout.CENTER);

		aFrame.setVisible(true);

	}

	public static void main(String[] args) {

		new guiQuiz();

	}

}
