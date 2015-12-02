package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * @author Zach Moyes
 * @version 1.2 12/2/15 Completed everything.
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private ArrayList<String> keyboardMash;
	private String userName;
	private String content;
	
public Chatbot()
{
	memesList = new ArrayList<String>();
	politicalTopicList = new ArrayList<String>();
	
	userName = new String();
	content = new String();
}
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * @param userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.userName = userName;
		this.content = "Greyson";
		
		buildMemesList();
		buildPoliticalTopicsList();
	}
	
	public boolean quitChecker(String currentInput)
	{
		boolean hasQuit = false;
	
		if (currentInput.equals("quit"))
		{
			hasQuit = true;
		}
	
		
		return hasQuit;
}
		
	
	
	private void buildMemesList()
	{
		this.memesList.add("cute animals");
		this.memesList.add("doge");
		this.memesList.add("rare pepe");
		this.memesList.add("unhelpful high school teacher");
		this.memesList.add("aliens");
		this.memesList.add("spoderman");
		this.memesList.add("troll");
		this.memesList.add("bad luck brian");
		this.memesList.add("me gusta");
		this.memesList.add("what if I told you");
	}
	
	private void buildPoliticalTopicsList()
	{
		this.politicalTopicList.add("election");
		this.politicalTopicList.add("Democrat");
		this.politicalTopicList.add("Republican");
		this.politicalTopicList.add("liberal");
		this.politicalTopicList.add("conservative");
		this.politicalTopicList.add("Trump");
		this.politicalTopicList.add("Clinton");
		this.politicalTopicList.add("Biden");
		this.politicalTopicList.add("Carson");
		this.politicalTopicList.add("Rubio");
		this.politicalTopicList.add("Fiorina");
		this.politicalTopicList.add("Sanders");
		this.politicalTopicList.add("vote");
		this.politicalTopicList.add("11/4/16");
	}
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		
		if(currentInput != null)
		{
			if(currentInput.length() >= 1)
			{
				hasLength = true;
			}
		}
		
		if(currentInput !=null  && currentInput.length() > 0)
		{
			hasLength = true;   
		}
		
		return hasLength;
	}
	
	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
		{
				hasContent = true;
		}
		
		return hasContent;
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
{
	boolean hasTopic = false;
	
	for(String currentTopic:politicalTopicList)
	{
		if(currentInput.toLowerCase().contains(currentTopic.toLowerCase()))
		{
			hasTopic = true;
		}
	
	}
	return hasTopic;
}
	
	
		
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean mashTyping = false;
		
		if(currentInput != null)
		
		if(currentInput.equals("sdf")||currentInput.equals("dfg")||currentInput.equals("cvb")||currentInput.equals(",./"))
	
	
	{
		mashTyping = true;
	}
	
	return mashTyping;
}

	
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		
		for(String currentMeme:memesList)
		{
			if(currentInput.toLowerCase().contains(currentMeme.toLowerCase()))
			{
				hasMeme = true;
			}
		}
		return hasMeme;
	}
	
	public String processConversation(String currentInput)
	{
		String nextConversation = "OHHH, what else would you want to talk about? brub";
		int randomTopic = (int) (Math.random() * 5); //Generates a random number between 0 and 4.
		
		if(keyboardMashChecker(currentInput))
		{
			return "stop mashing the freaking keyboard bruv!!!!!";
		}
		
		switch (randomTopic)
		{
			case 0:
				if(memeChecker(currentInput))
				{
					nextConversation = "That is a very popular meme this year and last. What else are you" + " wanting to talk about?";
				}
				break;
			case 1:
				if(politicalTopicChecker(currentInput))
				{
					nextConversation = " WOW you want to talk about politics? Let's talk bruv";
				}
				else
				{
					nextConversation = "Sorry man it failed politics";
				}
				break;
			case 2:
				if(contentChecker(currentInput))
				{
					nextConversation = " Great. Greyson is great.";
				}
				break;
			case 3:
				if(currentInput.length() > 40)
				{
					nextConversation = "What else would you like to talk about? You too fast bruv";
				}
				break;
			case 4:
				nextConversation = "How was that conversation? TTYL Hun";
				break;
			default:
				nextConversation = "Hey bruv, what's up or down?";
				break;
		}
		
		return nextConversation;
	}
	
	
	/**
	 * Returns the username of this Chatbot instance.
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Returns the content area for this Chatbot instance.
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * @param content The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
}