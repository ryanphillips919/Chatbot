package chat.view;

import chat.controller.ChatController;
import chat.controller.IOController;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class ChatPanel extends JPanel
{
	private ChatController appController;
	private SpringLayout appLayout;
	private JButton chatButton;
	private JButton checkerButton;
	private JButton loadButton;
	private JButton saveButton;
	private JTextField chatField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private JButton resetButton;
	
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
		appLayout.putConstraint(SpringLayout.SOUTH, resetButton, -6, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, resetButton, 0, SpringLayout.EAST, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 575, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 400, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, loadButton, -245, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 225, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, -420, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, -595, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -50, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 500, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 500, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 500, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 500, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, loadButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -10, SpringLayout.SOUTH, this);
		
		chatArea = new JTextArea("Chat Area", 20, 25);
		chatArea.setFont(new Font("Courier New", Font.PLAIN, 13));
		chatArea.setForeground(Color.GREEN);
		chatArea.setBackground(Color.BLACK);
		chatField = new JTextField("Talk to the bot here", 50);
		chatField.setFont(new Font("Courier New", Font.PLAIN, 13));
		chatField.setForeground(Color.GREEN);
		chatField.setBackground(Color.BLACK);
		appLayout.putConstraint(SpringLayout.NORTH, resetButton, 0, SpringLayout.NORTH, chatField);
		appLayout.putConstraint(SpringLayout.WEST, resetButton, 18, SpringLayout.EAST, chatField);
		appLayout.putConstraint(SpringLayout.NORTH, chatField, 430, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatField, -175, SpringLayout.EAST, this);
		
		chatPane = new JScrollPane();
		appLayout.putConstraint(SpringLayout.NORTH, chatPane, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatPane, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatPane, -180, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatPane, -50, SpringLayout.EAST, this);
			
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
		chatPane.setViewportView(chatArea);
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(800, 600));
		this.setBackground(Color.BLACK);
		this.add(chatButton);
		this.add(loadButton);
		this.add(saveButton);
		this.add(checkerButton);
		this.add(chatField);
		this.add(chatPane);
		this.add(resetButton);
	}
	
	private void setupLayout()
	{
		
		appLayout.putConstraint(SpringLayout.WEST, chatField, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatField, -105, SpringLayout.SOUTH, this);
		
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -50, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatArea, 411, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 20, SpringLayout.NORTH, this);
		
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

			}
			
		});
		
		saveButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent mouseClick) 
			{
				String chatText = chatArea.getText();
				String path = ".";
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
