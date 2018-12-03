package chat.view;

import chat.controller.ChatController;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatPanel extends JPanel
{
	private ChatController appController;
	private SpringLayout appLayout;
	private JButton enterButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	
	public ChatPanel(ChatController appController)
	{
		super();
		
		this.appController = appController;
		enterButton = new JButton("Enter");
		appLayout = new SpringLayout();
		inputField = new JTextField();
		chatArea = new JTextArea();
		chatPane = new JScrollPane();
			
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.add(enterButton);
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.SOUTH, enterButton, -30, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, enterButton, -30, SpringLayout.EAST, this);
	}
	
	private void setupListeners()
	{
		enterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				
			}
		});
	}

}
