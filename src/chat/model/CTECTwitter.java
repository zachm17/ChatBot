package chat.model;

import twitter4j.*;
import java.util.ArrayList;
import chat.controller.ChatbotController;


/**
 * 
 * @author Zach Moyes
 * @version 0.5 added try catch method 
 * @description CTEC TWITTER BABAY
 */
public class CTECTwitter
{
	//Declaration
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatbotTwitter;
	private ChatbotController baseController;
	
	public CTECTwitter(ChatbotController baseController)
	{
		this.baseController = baseController;
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
		chatbotTwitter = TwitterFactory.getSingleton();
		
	}
	
	public void sendTweet(String tweet)
	{	
		try
		{
			chatbotTwitter.updateStatus("<Hey its zach> I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		}
		catch (TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
	
	}
}