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
	
	public ChatPanel(ChatController appController)
	{
		super();
		setForeground(Color.WHITE);
		
		this.appController = appController;
		
		chatButton = new JButton("Chat");
		checkerButton = new JButton("Check Text");
		loadButton = new JButton("Load");
		saveButton = new JButton("Save");
		resetButton = new JButton("Clear");
		resetButton.setForeground(Color.BLACK);
		resetButton.setBackground(Color.WHITE);
		
		appLayout = new SpringLayout();
		
		tweetButton = new JButton("Send tweet");
		searchTwitterButton = new JButton("Search Twitter");
		
		buttonPanel = new JPanel(new GridLayout(1, 0));

		chatArea = new JTextArea("Chat Area", 20, 25);
		chatArea.setFont(new Font("Courier New", Font.PLAIN, 13));
		chatArea.setForeground(Color.GREEN);
		chatArea.setBackground(Color.BLACK);
		chatField = new JTextField("Talk to the bot here", 50);
		chatField.setFont(new Font("Courier New", Font.PLAIN, 13));
		chatField.setForeground(Color.GREEN);
		chatField.setBackground(Color.BLACK);
;
		
		chatPane = new JScrollPane();

			
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
		
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
		this.setBackground(Color.BLACK);
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
	}
	
	
	
	
	
	
	
	
	
	
	
}
