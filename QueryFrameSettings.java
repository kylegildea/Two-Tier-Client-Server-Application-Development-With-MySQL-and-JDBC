/**
 * @Name: Kyle Gildea
 * Course: CNT 4714 Spring 2017  
 * Assignment title: “Project Three: Two-Tier Client-Server Application Development With MySQL and JDBC”
 * Date:  March 3, 2017  
 * Class:  QueryFrameSettings.java
 */
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class QueryFrameSettings extends JFrame 
{
	private static final long serialVersionUID = 7336748332948474910L;

	/**
	 * Used to maintain const ant UI across frames
	 */
	public QueryFrameSettings() 
    {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if("Nimbus".equals(info.getName())) 
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (Exception e) 
        {
            
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
