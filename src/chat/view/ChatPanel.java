package chat.view;

import chat.controller.ChatController;
import chat.controller.IOController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class ChatPanel extends JPanel
{
	private ChatController appController;
	private SpringLayout appLayout;
	private JButton chatButton;
	private JButton checkerButton;
	private JButton loadButton;
	private JButton saveButton;
	
	private JButton tweetButton;
	private JButton searchTwitterButton;
	
	private JTextField chatField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private JButton resetButton;
	
	private JPanel buttonPanel;
	
	private ImageIcon loadIcon;
	private ImageIcon saveIcon;
	private ImageIcon twitterIcon;
	private ImageIcon chatIcon;
	private ImageIcon checkIcon;
	private ImageIcon searchIcon;
	
	public ChatPanel(ChatController appController)
	{
		super();
		setForeground(Color.WHITE);
		
		this.appController = appController;
		
		
		saveIcon = new ImageIcon(getClass().getResource("/chat/view/images/save.png"));
		loadIcon = new ImageIcon(getClass().getResource("/chat/view/images/load.png"));
		twitterIcon = new ImageIcon(getClass().getResource("/chat/view/images/tweet.png"));
		chatIcon = new ImageIcon(getClass().getResource("/chat/view/images/chat.png"));
		searchIcon = new ImageIcon(getClass().getResource("/chat/view/images/searchTwitter.png"));
		checkIcon = new ImageIcon(getClass().getResource("/chat/view/images/search.png"));
		
		
		appLayout = new SpringLayout();
		
		chatButton = new JButton("Chat", chatIcon);
		checkerButton = new JButton("Check Text", checkIcon);
		loadButton = new JButton("Load", loadIcon);
		saveButton = new JButton("Save", saveIcon);
		resetButton = new JButton("Clear");
		tweetButton = new JButton("Send tweet", twitterIcon);
		searchTwitterButton = new JButton("Search Twitter", searchIcon);
		
		buttonPanel = new JPanel(new GridLayout(1, 0));
		appLayout.putConstraint(SpringLayout.NORTH, buttonPanel, 548, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, buttonPanel, -74, SpringLayout.EAST, this);

		chatArea = new JTextArea("Chat Area", 20, 25);
		chatArea.setFont(new Font("Futura", Font.PLAIN, 16));

		chatField = new JTextField("Talk to the bot here", 50);

		chatField.setForeground(new Color(0, 0, 0));
		chatField.setBackground(new Color(255, 255, 240));
;
		
		chatPane = new JScrollPane();


			
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
		setupButtons();
		
	}
	
	private void setupButtons()
	{
		buttonPanel.add(saveButton);
		buttonPanel.add(loadButton);
		buttonPanel.add(chatButton);
		buttonPanel.add(checkerButton);
		buttonPanel.add(tweetButton);
		buttonPanel.add(searchTwitterButton);
	}
	
	private void setupScrollPane()
	{
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatPane.setColumnHeaderView(chatArea);
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(1024, 768));
		buttonPanel.setPreferredSize(new Dimension(900, 150));
		buttonPanel.setBackground(Color.DARK_GRAY);
		this.setBackground(new Color(30, 144, 255));
		this.add(buttonPanel);
		this.add(chatField);
		this.add(chatPane);
	}
	
	private String getPath(String choice)
	{
		String path = ".";
		int result = -99;
		JFileChooser fileChooser = new JFileChooser();
		if (choice.equals("save"))
		{
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			result = fileChooser.showSaveDialog(this);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getCurrentDirectory().getAbsolutePath();
			}
		}
		else
		{
			result = fileChooser.showOpenDialog(this);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getSelectedFile().getAbsolutePath();
			}
		}
		System.out.println(path);
		return path;
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatField, 53, SpringLayout.SOUTH, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, chatPane, 0, SpringLayout.EAST, buttonPanel);
		appLayout.putConstraint(SpringLayout.SOUTH, chatPane, 330, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatPane, 30, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatPane, 0, SpringLayout.WEST, buttonPanel);
		appLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, buttonPanel);
		appLayout.putConstraint(SpringLayout.SOUTH, chatField, -67, SpringLayout.NORTH, buttonPanel);
		appLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, buttonPanel);
		chatField.setFont(new Font("Futura", Font.PLAIN, 16));
		chatArea.setForeground(new Color(0, 0, 0));
		chatArea.setBackground(new Color(255, 255, 240));
		
		
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				if (chatArea.getText().equals("ChatArea"))
				{
					chatArea.setText("");
				}
				String input = chatField.getText();
				String output = "";
				output = appController.interactWithChatbot(input);
				chatArea.append(output);
				chatField.setText("output");
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				String path = getPath("load");
				String chatText = IOController.loadFile(appController, path);
				chatArea.setText(chatText);
			}
			
		});
		
		saveButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent mouseClick) 
			{
				String chatText = chatArea.getText();
				String path = getPath("save");
				IOController.saveText(appController, path, chatText);
				chatArea.setText("Chat saved!");
			}
		});
		
		checkerButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				
			}
		});
		
		resetButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent mouseClick) 
			{
				chatArea.setText("");
			}
		});
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String textToTweet = chatField.getText().trim();
				appController.tweet(textToTweet);
			}
		});
		
		searchTwitterButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent searchClick)
			{
				String username = chatField.getText().trim();
				String display = appController.findWords(username);
				chatArea.append("\n\n" + display);
			}
		});
	}
	
	
	
	
	
	
	
	
	
	
	
}
