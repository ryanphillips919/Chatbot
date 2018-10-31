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
//		String userInput = JOptionPane.showInputDialog(null, "Chatbot says: Hello, how are you?");
//		JOptionPane.showMessageDialog(null,"You said: " + userInput);
//		while (!userInput.equalsIgnoreCase("quit"));
//		{
//			userInput = JOptionPane.showInputDialog(null, "Type quit if you are done");
//		}
		
//		interactWithChatbot(userInput);
		
		JOptionPane.showMessageDialog(null, Chatbot.processText("What is the meaning of life?"));
		
	}
	
	
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\
	
	
	public String interactWithChatbot(String userInput)
	{
		String output = "";
		if (userInput == null)
		{
			output = "It returned null";
		}
		
		else
		{
			output = userInput;
		}
		
		return output;
	}


//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\ 

	
	public Chatbot getChatbot()
	{
		return simpleBot;
	}
	
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\
	
	
	public String useChatbotCheckers()
	{
		String thing = "";
		
		return thing;
	}
	
}