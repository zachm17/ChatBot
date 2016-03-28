package chat.controller;

import twitter4j.TwitterException;
import chat.model.CTECTwitter;
import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.ChatbotView;


/**
 * Application controller for the Chatbot project.
 * @author zmoy8227
 *@version 1.13 12/2/15 Completed ;D
 */

public class ChatbotController
{
	private CTECTwitter chatTwitter;
	private ChatbotView myDisplay;
	private Chatbot myBot;
	private ChatFrame baseFrame;
	
	public ChatbotController()
	{
		myDisplay = new ChatbotView();
		String userName = myDisplay.chatInput("Hey man what's your name?");
		myBot = new Chatbot(userName);
		baseFrame = new ChatFrame(this);
		chatTwitter = new CTECTwitter(this);
	}
	
	public void start()
	{
		 myDisplay.showResponse("Hi " + myBot.getUserName());
		 chat();
	}
	
	private void chat()
	{
		//String conversation = myDisplay.chatInput("What would you like to talk about today?");
		//while(myBot.lengthChecker(conversation))
		//{ 
		//	conversation = myDisplay.chatInput(myBot.processConversation(conversation));
		//}
	}

	
	public String userToChatbot(String conversation)
	{
		String response = "";
		
		if(myBot.quitChecker(conversation))
		{
			shutDown();
		}
		
		response = myBot.processConversation(conversation);
		
		return response;
	}
	
	private void shutDown()
	{
		myDisplay.displayText("Bych, " + myBot.getUserName() + " it has been a pleasure to talk fam");
		System.exit(0);
	}
	
	public void sendTweet(String tweetText)
	{
		chatTwitter.sendTweet(tweetText);
	}
	
	public String analyze(String userName)
	{
		String userAnalysis = "The Twitter user " + userName + " has many tweets. "; 
		
		try
		{
			chatTwitter.loadTweets(userName);
		}
		catch (TwitterException error)
		{
			handleErrors(error.getErrorMessage());
		}
		userAnalysis += chatTwitter.topResults();
		
		return userAnalysis;
	}
	
	public String investigation()
	{
		String twitterResults = chatTwitter.sampleInvestigation();
		
		return twitterResults;
	}
	
	
	
	public void handleErrors (String errorMessage)
	{
		myDisplay.displayText(errorMessage);
	}
	
	public Chatbot getChatbot()
	{
		return myBot;
	}
	
	public ChatbotView getChatView()
	{
		return myDisplay;
	}
	
	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}
	
	
}
