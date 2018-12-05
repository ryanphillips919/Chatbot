package chat.view;

import chat.controller.ChatController;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	public ChatPanel(ChatController appController)
	{
		super();
		
		this.appController = appController;
		
		chatButton = new JButton("Chat");
		checkerButton = new JButton("Check Text");
		loadButton = new JButton("Load");
		saveButton = new JButton("Save");
		
		appLayout = new SpringLayout();
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -50, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, -406, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 6, SpringLayout.EAST, saveButton);
		appLayout.putConstraint(SpringLayout.EAST, loadButton, -6, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, -587, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 6, SpringLayout.EAST, checkerButton);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 589, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 500, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 500, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 500, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 500, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, loadButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -10, SpringLayout.SOUTH, this);
		
		chatArea = new JTextArea("Chat Area", 20, 25);
		chatField = new JTextField("Talk to the bot here", 50);
		appLayout.putConstraint(SpringLayout.NORTH, chatField, 430, SpringLayout.NORTH, this);
		
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
		this.setBackground(new Color(51, 102, 204));
		this.add(chatButton);
		this.add(loadButton);
		this.add(saveButton);
		this.add(checkerButton);
		this.add(chatField);
		this.add(chatPane);
	}
	
	private void setupLayout()
	{
		
		appLayout.putConstraint(SpringLayout.WEST, chatField, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatField, -50, SpringLayout.EAST, this);
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
				String input = chatField.getText();
				String output = "";
				output = appController.interactWithChatbot(input);
				chatArea.append(output);
				chatField.setText("output");
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
			}
		});
	}

}
