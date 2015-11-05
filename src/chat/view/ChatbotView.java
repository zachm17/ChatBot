package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 * Code to input popups and to output popups.
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
		chatIcon = new ImageIcon(getClass().getResource("Images/lovato.jpeg"));
	}
	
	public String chatInput(String displayText)
	{
		String returnedAnswer = ""; 
		
		returnedAnswer = JOptionPane.showInputDialog(null, displayText, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon, null, "Asnswer here :D").toString();
		
		return returnedAnswer;
	}




	public void showResponse(String displayText)
	{
		JOptionPane.showMessageDialog(null, displayText, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon);
		
	}
}