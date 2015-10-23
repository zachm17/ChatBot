package chat.controller;

import chat.view.ChatbotView; 
import chat.model.Chatbot;

/**
 * Application controller for the Chatbot project.
 * @author zmoy8227
 *@version 1.11 10/21/15 fixed error ;D
 */

public class ChatbotController
{
	private ChatbotView myDisplay;
	private Chatbot myBot;
	
	public ChatbotController()
	{
		myDisplay = new ChatbotView();
		String userName = myDisplay.chatInput("Hey man what's your name?");
		myBot = new Chatbot(userName);
		
		
	}
	
	public void start()
	{
		 myDisplay.showResponse("Hi " + myBot.getUserName());
	}
}
