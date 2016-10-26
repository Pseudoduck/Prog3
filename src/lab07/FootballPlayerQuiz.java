package lab07;

import java.io.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;


public class FootballPlayerQuiz extends JFrame
{
	
	private static final long serialVersionUID = 3794059922116115530L;
	
	public static String[] JERSEY_NUMBERS =
		{"7","84","26","12","12","1","18","10","18","83","59","58","13"};
	
	public static String [] PLAYER_NAMES = 
		{	"Ben Roethlisberger","Antonio Brown", "LeVeon Bell","Tom Brady", "Aaron Rogers",
			"Cam Newton", "Payton Manning","Eli Manning","A.J.Green", "Heath Miller",
			"Luke Kuechly","Von Miller", "Kevin Benjamin"	};
      
	static int index = new Random().nextInt(PLAYER_NAMES.length);
   
	double correct = 0;
	double wrong = 0;
     
  
	private JTextArea showQuestion = new JTextArea();
	private JTextArea timer = new JTextArea();
	private JTextField answerFromUser = new JTextField();
	private JButton submitMyAnswer = new JButton();
	private JButton quitButton  = new JButton();
	
	private boolean check = false;
	
	private ArrayList<String> userQ = new ArrayList<String>();
	private ArrayList<String> userA = new ArrayList<String>();	
	private String userS = "";
	
	private JCheckBox enableCheatItem;
    	
	public class Timer implements Runnable 
	{
    	
    	 private ActionListener enter;
    	 private ActionListener quit;
    	 private int time;
    	 
 		public Timer (int time, ActionListener quit, ActionListener enter) 
 		{
			this.quit = quit;
			this.enter = enter;
			this.time = time;
		}
    	 
		@Override
		public void run()
		{
			while (time > 0)
			{
				if (check == true)
				{
					timer.setText(" ");
					return;
				}
				
				try 
				{
					Thread.sleep(1000);
				}
				
				catch(InterruptedException e) 
				{
					e.printStackTrace();
				}
				timer.setText(Integer.toString(time-1));
				time--;
			}
			wrapUp(enter, quit);
		}
    	
    }
    
    public void start()
    {
    	check = true;
    	
		String startDisplay = "Please Tell Me The Jersey Numbers Of These Players!"+"\n"+"\n"+"Begin?"+"\n"+"(Click Yes or No)";
		
		int reply = JOptionPane.showConfirmDialog(null,startDisplay, "Choose One", JOptionPane.YES_NO_OPTION);
	
		if (reply == JOptionPane.YES_OPTION)
		{;}
		else if (reply == JOptionPane.NO_OPTION)
		{
			JOptionPane.showMessageDialog(null,"Ok, please try again later."); 
			System.exit(0);
		} 
		
		String timeSelection = "Please Type In Game Time In Seconds!";
		
		int time_reply = Integer.parseInt(JOptionPane.showInputDialog(timeSelection));
				
		runQuiz(time_reply);
    	
    }
    
    public void runQuiz(int inputTime)
    {
		setLocationRelativeTo(null);
		setSize(500,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		showQuestion.setEditable(false);
		timer.setEditable(false);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(showQuestion, BorderLayout.NORTH);
		getContentPane().add(timer, BorderLayout.EAST);
		getContentPane().add(answerFromUser, BorderLayout.CENTER);
		getContentPane().add(submitMyAnswer, BorderLayout.WEST);
		getContentPane().add(quitButton, BorderLayout.SOUTH);
		setJMenuBar(getMyMenuBar());

    	timer.setText(String.valueOf(inputTime));
		showQuestion.setText("What Is The Jersey Number For : "+ PLAYER_NAMES[index]+"?");
		answerFromUser.setText("");
		submitMyAnswer.setText("submitMyAnswer");
		quitButton.setText("quit Game");
		
		final ActionListener submit = new ActionListener()
		{			
			public void actionPerformed(ActionEvent e)
			{
				String questionNow = showQuestion.getText();
				userS += answerFromUser.getText().toUpperCase();
				userQ.add(questionNow);
				userA.add(userS);			
				
        		
        		if ( userS.equals(JERSEY_NUMBERS[index]))
        			{
        				JOptionPane.showMessageDialog(null, "Good!");
        				correct++;
                        
                        index = new Random().nextInt(PLAYER_NAMES.length);                  
                        showQuestion.setText("What is the jersey number for: "+PLAYER_NAMES[index]+"?");
                        answerFromUser.setText("");
        				userS = "";
        				
        			} 
        		else if ( userS != JERSEY_NUMBERS[index])
        			{
        				JOptionPane.showMessageDialog(null, "Wrong! The Right Number Of "+PLAYER_NAMES[index]+" Is "+JERSEY_NUMBERS[index]);
        				wrong++;
        				
                        index = new Random().nextInt(PLAYER_NAMES.length);                  
                        showQuestion.setText("What Is The Jersey Number For : "+PLAYER_NAMES[index]+"?");
                        answerFromUser.setText("");
        				userS = "";
        			}
			}
		};
				
		ActionListener quit = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String quitDisplay = "Thank You! Another Round?";
				int reply = JOptionPane.showConfirmDialog(null, quitDisplay, "Choose One", JOptionPane.YES_NO_OPTION);
			
				if (reply == JOptionPane.YES_OPTION)
				{
					start();
				}
				else if (reply == JOptionPane.NO_OPTION)
				{
					JOptionPane.showMessageDialog(null,"Bye!"); 
					System.exit(0);
				} 
			}
		};
		
		submitMyAnswer.addActionListener(submit);
		quitButton.addActionListener(quit);
		answerFromUser.addActionListener(submit);
		
		try 
		{	
			check = false;
			int time = Integer.parseInt(timer.getText());
			new Thread(new Timer(time, submit, quit)).start();
		} 
		catch (Exception ex) 
		{
		    JOptionPane.showMessageDialog(null, "You Did Not Enter The Jersey Number.");		    
			submitMyAnswer.removeActionListener(submit);
			quitButton.removeActionListener(quit);
			answerFromUser.removeActionListener(submit);
			start();
		}
	} 
    
    public void wrapUp(ActionListener quit, ActionListener submit) 
    {	
    	check = true;		
		submitMyAnswer.removeActionListener(submit);
		quitButton.removeActionListener(quit);
		answerFromUser.removeActionListener(submit);
		
		double score = (correct/(correct+wrong)*100);
		DecimalFormat df = new DecimalFormat("#.00");
		String roundedscore = df.format(score);
		
		String ansr = "Thank You!."+"\n"+"Your Accuracy Rate Is: "+roundedscore+"%"+"\n"+ "Another Round?";
		int reply = JOptionPane.showConfirmDialog(null, ansr, "Choose One", JOptionPane.YES_NO_OPTION);
	
		if (reply == JOptionPane.YES_OPTION)
		{
			start();
		}
		else if (reply == JOptionPane.NO_OPTION)
		{
			JOptionPane.showMessageDialog(null,"Bye!"); 
			System.exit(0);
		}

    } 
	
    //Copied from lecture slides/Dr.Fodor's github page
    private JMenuBar getMyMenuBar()
	{
		JMenuBar jmenuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		jmenuBar.add(fileMenu);
		
		JMenuItem saveItem = new JMenuItem("Save");
		fileMenu.add(saveItem);
		saveItem.setMnemonic('S');
		
		saveItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				saveToFile();
			}
		});
		
		
		JMenu cheatMenu = new JMenu("Cheat");
		cheatMenu.setMnemonic('C');
		jmenuBar.add(cheatMenu);
		
		this.enableCheatItem =new JCheckBox("Enable Cheat");
		enableCheatItem.setMnemonic('E');
		cheatMenu.add(enableCheatItem);
		return jmenuBar;
	}
  
    //Copied from lecture slides/Dr.Fodor's github page
    private void saveToFile()
	{
		JFileChooser jfc = new JFileChooser();
			
		if( jfc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION)
			return;
		
		if( jfc.getSelectedFile() == null)
			return;
			
		File chosenFile = jfc.getSelectedFile();
			
		if( jfc.getSelectedFile().exists())
		{
			String message = "File " + jfc.getSelectedFile().getName() + " exists.  Overwrite?";
				
			if( JOptionPane.showConfirmDialog(this, message) != 
					JOptionPane.YES_OPTION)
					return;			
		}
		
		try
		{
			BufferedWriter writer= new BufferedWriter(new FileWriter(chosenFile));
			writer.write(this + "\n");
			writer.flush();  writer.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Could not write file", JOptionPane.ERROR_MESSAGE);
		}
	}
    
    public FootballPlayerQuiz()
    {
    	start();
    }
    
    public static void main(String[] args) 
	{
    	new FootballPlayerQuiz();    	      			
	}	

}
