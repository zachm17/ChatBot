package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 * Popup display class for GUI interaction in the Chatbot project.
 * @author Zach Moyes
 * 1.3 11/5/15 Added Icons to popup windows!
 */

public class ChatbotView
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatbotView()
	{
		windowMessage = "Hello from your friendly chatbot :D";
		chatIcon = new ImageIcon(getClass().getResource("Images/yee.jpg"));
	}
	
	public String chatInput(String displayText)
	{
		String returnedAnswer = ""; 
		
		returnedAnswer = JOptionPane.showInputDialog(null, displayText, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon, null, "Asnswer here :D") + " ";
		
		return returnedAnswer;
	}




	public void showResponse(String displayText)
	{
		JOptionPane.showMessageDialog(null, displayText, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon);
		
	}
	
	public void displayText(String displayText)
	{
		JOptionPane.showMessageDialog(null, displayText);
	}
}