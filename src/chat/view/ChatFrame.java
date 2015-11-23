package chat.view;


import javax.swing.*;
import java.awt.*;
import chat.controller.ChatbotController;


public class ChatFrame extends JFrame
{
	private ChatbotController baseController;
	private ChatPanel basePanel;
	
	public ChatFrame(ChatbotController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		setupFrame();
	}
	
	
	private void setupFrame()
	{
		this.setContentPane(basePanel); //Must be first line of setupFrame! - Installs the panel in the frame.
		this.setSize(800,800);		//Find a good size for the app.	
		this.setTitle("YEEEEEEE!!!");
		this.setResizable(false);	//Advisable not required.
		this.setVisible(true);		//Must be last line of setupFrame!
	}
	
	public ChatbotController getBaseController()
	{
		return baseController;
	}

}

