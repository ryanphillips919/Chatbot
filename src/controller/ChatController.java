package controller;

import javax.swing.JOptionPane;

import model.Chatbot;

public class ChatController
{
//	private Chatbot simpleBot;
	
	
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\
	
	
	public ChatController()
	{
//		simpleBot = new Chatbot();
	}
	
	
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\
	
	
	public void start()
	{
		String userInput = JOptionPane.showInputDialog(null, "Hello, how are you?");
		JOptionPane.showMessageDialog(null, userInput);
		while (!userInput.equalsIgnoreCase("quit"));
		{
			userInput = JOptionPane.showInputDialog(null, "Type quit if you are done");
		}
	}
	
	
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\
	
	
	public String interactWithChatbot(String userInput)
	{
		return null;
	}
}


//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\