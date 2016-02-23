package chat.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import chat.controller.ChatbotController;




public class ChatPanel extends JPanel
{
	private ChatbotController baseController;
	private JButton submitButton;
	private JTextField typingField;
	private SpringLayout baseLayout;
	private JLabel chatTextField;
	private JTextArea chatArea;
	private JLabel promptLabel;
	private JButton tweetButton;
	private JButton saveButton;
	private JButton loadButton;
	private JScrollPane textPane;
	
	
	
	public ChatPanel(ChatbotController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		submitButton = new JButton("Submit chat");
		typingField = new JTextField("words can be typed here bruv");
		chatTextField = new JLabel("LETS FREAKIN CHAT");
		chatArea = new JTextArea(10,20);
		typingField = new JTextField(30);
		
	
		
		
	
		setupChatPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	/**
	 * Helper method to load all GUI Components into the panel
	 */
	
	private void setupChatPane()
	{
		textPane = new JScrollPane(chatArea);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
		textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.BLUE);
		this.add(submitButton);
		this.add(typingField);
		this.add(chatTextField);
		this.add(chatArea);
		typingField.setToolTipText("Type here to talk to Chatbot");
		chatArea.setEnabled(false);
		
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -89, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 84, SpringLayout.SOUTH, typingField);
		baseLayout.putConstraint(SpringLayout.NORTH, typingField, 87, SpringLayout.SOUTH, chatTextField);
		baseLayout.putConstraint(SpringLayout.EAST, typingField, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatTextField, 56, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatTextField, -144, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 42, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 42, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
	}
	
	private void changeRandomColor()
	{
		int red, green, blue;
		
		red = (int) (Math.random() * 256);
		green = (int) (Math.random() * 256);
		blue = (int) (Math.random() * 256);
		
		this.setBackground(new Color(red, green, blue));
	}
	
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = typingField.getText(); //Grab user typed answer
				chatArea.append("\nUSER: " + userText); //display typed answer
				typingField.setText(" "); 
				String response = baseController.userToChatbot(userText); //send the text to chatbot //chatbot will process
				chatArea.append("\nChatbot: " + response); //display the response
			}
		});
	}
	public JTextField getTextField()
	{
		return typingField;
	}
	
}