package chat.view;

import javax.swing.JOptionPane;

/**
 * Code to input popups and to output popups.
 * @author Zach Moyes
 * 1.0 10/21/15
 */

public class ChatbotView
{
	public void showResponse(String wordsFromSomewhere)
	{
		JOptionPane.showMessageDialog(null, wordsFromSomewhere);
		
	}
	
	public String chatInput(String displayText)
	{
		String returnedAnswer = "";
		
		returnedAnswer = JOptionPane.showInputDialog(null, displayText);
		
		return returnedAnswer;
	}
}
