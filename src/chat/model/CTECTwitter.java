package chat.model;

import twitter4j.*;
import java.util.ArrayList;


/**
 * 
 * @author Zach Moyes
 * @version 0.4 copy pastad sendtweet method
 * @description CTEC TWITTER BABAY
 */
public class CTECTwitter
{
	//Declaration
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatbotTwitter;
	
	public CTECTwitter()
	{
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
		
	}
	
	public void sendTweet(String tweet)
	{
		chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
	}
	
	
}
