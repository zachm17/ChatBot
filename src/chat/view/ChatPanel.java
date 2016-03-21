package chat.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;

import chat.controller.ChatbotController;




public class ChatPanel extends JPanel
{
	private ChatbotController baseController;
	private JButton submitButton;
	private JTextField typingField;
	//private JTextField typingField_1;
	//private JTextField typingField_1;
	private SpringLayout baseLayout;
	private JLabel chatTextField;
	private JTextArea chatArea;
	private JLabel promptLabel;
	private JButton tweetButton;
	private JButton saveButton;
	private JButton loadButton;
	private JScrollPane textPane;
	//private JScrollPane textPane_1;
	private JButton analyzeTwitterButton;
	
	
	
	public ChatPanel(ChatbotController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		submitButton = new JButton("Submit chat");
		
		typingField = new JTextField("words can be typed here bruv");
		chatTextField = new JLabel("LETS FREAKIN CHAT");
		//typingField_1 = new JTextField(30);
		tweetButton = new JButton("tweet here");
		textPane = new JScrollPane();
		saveButton = new JButton("save something");
		loadButton = new JButton("load stuff");
		promptLabel = new JLabel();
		analyzeTwitterButton = new JButton("ANALYZE TWEETS FAM");
		chatArea = new JTextArea(10,20);
		
		
	
		
		
	
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
		textPane = new JScrollPane();
		
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
		this.add(tweetButton);
		this.add(textPane);
		this.add(saveButton);
		this.add(loadButton);
		this.add(promptLabel);
		this.add(analyzeTwitterButton);
		typingField.setToolTipText("Type here to talk to Chatbot");
		this.setPreferredSize(new Dimension(825, 540));
		//chatArea = new JTextArea(10,20);
	
		
		
		add(chatArea);
		chatArea.setEnabled(false);
		
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -89, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, textPane);
		baseLayout.putConstraint(SpringLayout.SOUTH, analyzeTwitterButton, -24, SpringLayout.NORTH, saveButton);
		baseLayout.putConstraint(SpringLayout.EAST, analyzeTwitterButton, 0, SpringLayout.EAST, saveButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, loadButton, -21, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, loadButton, -36, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, saveButton, -49, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, saveButton, -59, SpringLayout.WEST, tweetButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, tweetButton, -37, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, tweetButton, -263, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, typingField, -6, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.EAST, typingField, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatTextField, -145, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 271, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, typingField, 136, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatTextField, -45, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, typingField, -19, SpringLayout.NORTH, analyzeTwitterButton);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 39, SpringLayout.SOUTH, chatTextField);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 214, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -59, SpringLayout.EAST, this);
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
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.sendTweet("no text to send");
			}
		});
		analyzeTwitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String user = typingField.getText(); //This grabs whatever the user typed
				String results = baseController.analyze(user); //This gets what the user wanted
				chatArea.setText(results); //This displays the results of the tweet
			}
		});
	}
	public JTextField getTextField()
	{
		return typingField;
	}
	
}