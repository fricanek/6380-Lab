package lab6;




import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class practiGui extends JFrame {
	static JLabel time = new JLabel();
	JButton btnStart = new JButton("Start");
	static JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	private static AtomicInteger count = new AtomicInteger(0);
	
	
	private JPanel getBottomPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);

			}

		});
		panel.add(btnExit);
		return panel;

	}

	

	private static boolean isPrime(int x) {
	
		for (int i = 2; i < x  ; i++) {
			
			if (x % i == 0 || x == 0 || x == 1) {
				
				return false;
			}
			
			
		}
		return true;

	}
	static int threads;
	private static List<Integer> l1 = Collections.synchronizedList(new ArrayList<Integer>());

	
	private static class MyWorker implements Runnable  {
		 int min;
		 int max;
		private final Semaphore s;
		
		public MyWorker(Semaphore s, int min, int max)
		
		{
			this.min = min;
			this.max = max;
			this.s = s;
		}
		
		 @Override 
		 	public void run() {
	
	
				
				long start2 = System.currentTimeMillis();
				
				
			
				for (int n = min; n <= max; n++) {
					
					
					// check if this number is prime
					try {
						if (isPrime(n)) {
						
							count.getAndIncrement();
							l1.add(n);
							
							
						}
						
						
					        
						        
							
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			
			        
				
				
				long end2 = System.currentTimeMillis();
			
					
				
				
			
				time.setText("Elapsed time: " + (end2 - start2) / 1000f + "\n" + "The number of prime numbers found: "
						+ count);
				
				
					
				
				
			 
			 s.release();
		
			 Collections.sort(l1);
			 textArea.append(l1 + "\n");
		 }
		
	        
		
	}
	
	



	private JPanel topLayout() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0));
		panel.add(btnStart);
		
		
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int threadCount = Integer.parseInt(JOptionPane.showInputDialog("Enter a number 1-5 for threads"));
				int num = Integer.parseInt(JOptionPane.showInputDialog("Enter a large number"));

				//thread to tell the other threads what to do 
				
				threadStarter ts  = new threadStarter(threadCount, num);
				Thread t2 = new Thread(ts);
				t2.start();
				
				
		
			
				
			}
		});
		return panel;

	}
	
	private class threadStarter implements Runnable{
		int thread;
		int num;
		//constructor
		public threadStarter(int thread, int num) {
			this.thread = thread;
			this.num = num; 

			
		}
		
			@Override
		 	public void run() {
			 Semaphore sc  = new Semaphore(thread);
			 //min, max, sc 
			 int inter = num/thread;
			 int min = 2;
			 int max = inter;
			 for(int i = 0; i < thread; i++) {
				 try {
					sc.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.print("NO");
					
				}
				MyWorker mw = new MyWorker(sc, min, max);
				Thread t1 = new Thread(mw);
				t1.start();
				min = max;
				max = min + inter;
			 
			 
			 }
			 
		 }
		
		
	}
	

	private JPanel centerLayout() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 0));
		panel.add(scrollPane);
		panel.add(time);
		return panel;

	}

	private JPanel getCancelButton() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		JButton btnCancel = new JButton("Cancel");
		JLabel cancel = new JLabel();

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cancel.setText("The operation was canceled");
				panel.add(time);

			}
		});
		panel.add(cancel);
		panel.add(btnCancel);

		return panel;
	}

	public practiGui() {
		JFrame aFrame = new JFrame("Prime Number Finder");

		aFrame.setSize(600, 500);
		aFrame.getContentPane().add(getBottomPanel(), BorderLayout.SOUTH);
		aFrame.getContentPane().add(topLayout(), BorderLayout.NORTH);
		aFrame.getContentPane().add(centerLayout(), BorderLayout.CENTER);
		aFrame.getContentPane().add(getCancelButton(), BorderLayout.EAST);

		aFrame.setVisible(true);
	}

	public static void main(String[] args) {
		new practiGui();
	}

}
