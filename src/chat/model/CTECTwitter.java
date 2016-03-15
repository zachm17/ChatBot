package chat.model;

import twitter4j.*;
import java.util.ArrayList;
import chat.controller.ChatbotController;
import java.util.List;


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
			chatbotTwitter.updateStatus("Hey its zach I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		}
		catch (TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
	
	}
	
	public void loadTweets(String twitterHandle) throws TwitterException
	{
		Paging statusPage = new Paging(1,200);
		int page = 1;
		while (page <= 10)
		{
			statusPage.setPage(page);
			statusList.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
			page++;
			
		}
		
		for (Status currentStatus : statusList)
		{
			String[] tweetText = currentStatus.getText().split(" ");
			for (String word : tweetText)
			{
				wordList.add(removePunctuation(word).toLowerCase());
			}
		}
		removeCommonEnglishWords(wordList);
		removeEmptyText();
	
		
		}
	
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?!:;\"(){}^[]<>-"; // think about adding hashtag and @
		
		String scrubbedString = "";
		for(int i = 0; i < currentString.length(); i++)
		{
			if (punctuation.indexOf(currentString.charAt(i)) == -1) //SO BASICALLY THIS LINE TAKES THE WORD AND CHECKS IF ANY LETTERS OR SYMBOLS ARE IN STRING PUNCTUATION AND YEAH
			{
				scrubbedString += currentString.charAt(i); //Puts this into scrubbedString
			}
		}
		return scrubbedString; //Returns the string boooooyyyyy
	}
	
	private void removeEmptyText()
	{
		
	}
	
	private List removeCommonEnglishWords(List<String> wordList)
	{
		return null;
	}
}




