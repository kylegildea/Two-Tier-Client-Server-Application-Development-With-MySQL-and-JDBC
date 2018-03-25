import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 * @Name: Kyle Gildea
 * Course: CNT 4714 Spring 2017  
 * Assignment title: “Project Three: Two-Tier Client-Server Application Development With MySQL and JDBC”
 * Date:  March 3, 2017  
 * Class:  MainPanel.java
 * MainPanel
 */
public class MainPanel extends JPanel 
{
	JTable test;
	JScrollPane scroll;
	LoginPanel login;
	SQLCommandPanel sql;
	ButtonPanel buttons;
	GridBagLayout gridBagLayoutMain;
	public Connection c;
	
	public MainPanel()
	{
        setupGui();
    }
	private void setupGui()
	{
		gridBagLayoutMain = new GridBagLayout();
		login = new LoginPanel();
		sql = new SQLCommandPanel();
		buttons = new ButtonPanel();
		test = new JTable();
		test.setAutoCreateRowSorter(true);
		this.add(login, new GridBagConstraints(0, 0, 1, 1, 0.0, 1.0, GridBagConstraints.NORTHWEST, 
				GridBagConstraints.BOTH, new Insets(0, 0 , 0, 0), 0, 0));
		this.add(sql, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHEAST, 
				GridBagConstraints.BOTH, new Insets(0, 0 , 0, 0), 0, 0));
		this.add(buttons, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, 
					GridBagConstraints.NONE, new Insets(0, 0 , 0, 0), 0, 0));
		//this.buttons.connect.addActionListener(bh);
		//this.buttons.execute.addActionListener(bh);
		scroll = new JScrollPane(test);
		scroll.setPreferredSize(new Dimension(1150, 130));
		this.add(scroll, new GridBagConstraints(0, 3, 0, 0, 0.0, 0.0, GridBagConstraints.PAGE_END, 
				GridBagConstraints.NONE, new Insets(0, 0 , 0, 0), 0, 0));
		test.setVisible(false);
		scroll.setVisible(false);
	}
}
