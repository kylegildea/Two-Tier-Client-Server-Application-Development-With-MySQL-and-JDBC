import javax.swing.*;
import java.awt.*;
/**
 * @Name: Kyle Gildea
 * Course: CNT 4714 Spring 2017  
 * Assignment title: “Project Three: Two-Tier Client-Server Application Development With MySQL and JDBC”
 * Date:  March 3, 2017  
 * Class:  LoginPanel.java
 * 
 * Panel Containing Login Fields
 */
public class LoginPanel extends JPanel
{
	private JLabel driverLabel, urlLabel, 
		userLabel, passLabel;
	private JComboBox<String> driver, dbURL;
	private JTextField userField, passField;
	private final int rows = 4;
	private final int cols = 2;
	private final int vGap = 7;
	private final int hGap = 1;
	private GridLayout gridLayoutLogin;
	private final String title = "Enter Database Information";
	private final String jdbcDriver = "JDBC Driver:";
	private final static String driverText = "com.mysql.jdbc.Driver";
	private final String dbURLString = "Database URL:";
	private final String dbURLBoxString = "jdbc:mysql://localhost:3310/project3";
	private final String userString = "Username:";
	private final String passString = "Password:";
	private final int fieldLength = 27;
	Dimension fieldDim = new Dimension(300, 20);
	Dimension labelDim = new Dimension(90, 20);
	
	public LoginPanel()
	{
		setupPanel();
	}
	
	private void setupPanel()
	{
		driverLabel = new JLabel(jdbcDriver);
		driverLabel.setPreferredSize(labelDim);
		urlLabel = new JLabel(dbURLString);
		urlLabel.setPreferredSize(labelDim);
		userLabel = new JLabel(userString);
		passLabel = new JLabel(passString);
		driver = new JComboBox<String>();
		driver.addItem(driverText);
		driver.setPreferredSize(fieldDim);
		dbURL = new JComboBox<String>();
		dbURL.addItem(dbURLBoxString);
		dbURL.setPreferredSize(fieldDim);
		userField = new JTextField(fieldLength);
		passField = new JTextField(fieldLength);
		
		gridLayoutLogin = new GridLayout(rows, cols);
		this.setBorder(BorderFactory.createTitledBorder(title));
		
		this.setLayout(gridLayoutLogin);
		
		//new GridBagConstraints();
		
		this.add(driverLabel);
		this.add(driver);
		this.add(urlLabel);
		this.add(dbURL);
		this.add(userLabel);
		this.add(userField);
		this.add(passLabel);
		this.add(passField);
		gridLayoutLogin.setVgap(vGap);
		gridLayoutLogin.setHgap(hGap);
	}


	public static String getDriver() 
	{
		return driverText;
	}

	public String getDbURL() 
	{
		return dbURLBoxString;
	}

	public String getUserField() 
	{
		return userField.getText();
	}

	public String getPassField() 
	{
		return passField.getText();
	}
	public void turnOffFields()
	{
		userField.setEditable(false);
		passField.setEditable(false);
	}
}