package chat.controller;

import javax.swing.JOptionPane;

import chat.model.Chatbot;

public class ChatController
{
	private Chatbot simpleBot;
	
	
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\
	
	
	public ChatController()
	{
		simpleBot = new Chatbot();
	}
	
	
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\
	
	
	public void start()
	{
		String userInput = JOptionPane.showInputDialog(null, "Chatbot says: Hello, how are you?");
		JOptionPane.showMessageDialog(null,"You said: " + userInput);
		while (!userInput.equalsIgnoreCase("quit"));
		{
			userInput = JOptionPane.showInputDialog(null, "Type quit if you are done");
		}
		
		interactWithChatbot(userInput);
	}
	
	
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\
	
	
	public String interactWithChatbot(String userInput)
	{
		int randomResponse = (int) (Math.random() * 16);
		String output = "";
		String userResponse = JOptionPane.showInputDialog(null, "Chatbot says: Hi whats up?");
		output = simpleBot.processText(userResponse + "/n Chatbot says: " + responseList(randomResponse));
		
		
		return output;
	}


//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\ 

	
	public Chatbot getChatbot()
	{
		return simpleBot;
	}
}