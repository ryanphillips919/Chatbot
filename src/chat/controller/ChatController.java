package chat.controller;

import javax.swing.JOptionPane;
import chat.model.Chatbot;
import chat.view.ChatFrame;

public class ChatController
{
	private Chatbot simpleBot;
	private ChatFrame appFrame;

	// _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\

	public ChatController()
	{
		simpleBot = new Chatbot();
		appFrame = new ChatFrame(this);
	}

	// _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\

	public void start()
	{
		String userInput = JOptionPane.showInputDialog(null, "Ya wanna chat? (type quit if you want to quit)");
		while (!(userInput.contains("quit") || userInput.contains("Quit")))
		{
			userInput = JOptionPane.showInputDialog(simpleBot.processText(userInput));
			useChatbotCheckers(userInput);
		}
	}

	// _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\

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

	// _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\

	public Chatbot getChatbot()
	{
		return simpleBot;
	}

	// _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\

	public String useChatbotCheckers(String userInput)
	{
		String response = "";
		if (simpleBot.spookyChecker(userInput))
		{
			response = "OOO you said a spooky word. That is pretty spooky. You are 2spooky4Halloween.";
		}
		return response;
	}

}