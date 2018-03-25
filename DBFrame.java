import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
/**
 * @Name: Kyle Gildea
 * Course: CNT 4714 Spring 2017  
 * Assignment title: “Project Three: Two-Tier Client-Server Application Development With MySQL and JDBC”
 * Date:  March 3, 2017  
 * Class:  DBFrame.java
 * 
 * Main Frame
 */
public class DBFrame extends QueryFrameSettings 
{
	public static DBFrame appFrame = null;
	MainPanel mainPanel;
	public GridBagLayout gridBagLayoutAppFrame;
	ButtonHandler bh = new ButtonHandler(this);
	public Connection c;
	ResultSetTableModel rstm;

	private DBFrame()
	{
		setupGUI();
	}
	public static DBFrame getInstance()
	{
		if(appFrame == null)
		{
			appFrame = new DBFrame();
		}
		return appFrame;
	}
	
	public void setupGUI()
	{
		this.setTitle("Project 3");
		this.setPreferredSize(new Dimension(1170,260));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gridBagLayoutAppFrame = new GridBagLayout();
		mainPanel = new MainPanel();
		this.setLayout(gridBagLayoutAppFrame);
		this.getContentPane().add(mainPanel, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0, 0, 0, 0),0,0));
		mainPanel.buttons.getConnect().addActionListener(bh);
		mainPanel.buttons.getExecute().addActionListener(bh);
		mainPanel.buttons.getClear().addActionListener(bh);
		pack();
	}
	
	//Button Handlers
	
	class ButtonHandler implements ActionListener
	{
		DBFrame frame;
		
		public ButtonHandler(DBFrame frame) 
		{
			this.frame = frame;
		}

		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getActionCommand().equalsIgnoreCase(mainPanel.buttons.getConnectbuttontext()))
			{
				try 
				{
					c = DriverManager.getConnection(mainPanel.login.getDbURL(), mainPanel.login.getUserField(), mainPanel.login.getPassField());
					
					mainPanel.buttons.connectionStatus.setText("Connected to " + c.getCatalog());
					mainPanel.buttons.setConnectEnabled();
					mainPanel.buttons.setClearEnabled();
					mainPanel.buttons.setExecuteEnabled();
					mainPanel.login.turnOffFields();
					mainPanel.sql.setEditable();
					//rstm = new ResultSetTableModel(c);
					
					
				} catch (SQLException e) 
				{
						new OptionPaneDisplay("Error","Please Enter A Valid Username & Password",1);
				}
			}
			if(ae.getActionCommand().equalsIgnoreCase(mainPanel.buttons.getExecutebuttontext()))
			{
				
				try 
				{
					StringBuilder firstLetter = new StringBuilder();
				    firstLetter.append(mainPanel.sql.getSQLCommand().charAt(0));
				    if(firstLetter.toString().equalsIgnoreCase("s"))
					{
						mainPanel.test.setModel(new ResultSetTableModel(c, mainPanel.sql.getSQLCommand()));
						if(mainPanel.test.getRowCount() == 0)
						{
							throw new SQLException("No Results Found!");
						}
						mainPanel.test.setVisible(true);
						mainPanel.scroll.setVisible(true);
						frame.setPreferredSize(new Dimension(1170, 390));
						frame.pack();
						//frame.setResizable(false);
					}
					else
					{
						new ResultSetTableModel(c, mainPanel.sql.getSQLCommand());
					}
				} 
				catch (ClassNotFoundException | SQLException | StringIndexOutOfBoundsException e)
				{
					if(e.getMessage().contains("String index out of range"))
						new OptionPaneDisplay("Error", "Please Enter a Query", 1);
					else
						new OptionPaneDisplay("Error", e.getMessage(),1);
				}
			}
			if(ae.getActionCommand().equalsIgnoreCase(mainPanel.buttons.getClearbuttontext()))
			{
				mainPanel.sql.setSQLCommand();
			}
		}
	}
}
