package chat.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Chatbot
{
	private ArrayList<String> responseList;
	private ArrayList<String> spookyList;
	
	private String content;
	private String currentUser;
	private String joke;

	
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\
	
	
	public Chatbot()
	{
		this.joke = "What is red and smells like blue paint?";
		this.content = new String("Yeet");
		this.currentUser = new String("Dave");
		
		this.responseList = new ArrayList<String>();
		this.spookyList = new ArrayList<String>();
		
		buildTheLists();
		buildTheSpookyList();
	}
	
	
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\

	
	private void buildTheLists()
	{
		responseList.add("Hello! How are you?");
		responseList.add("GoodBye - no more talking!");
		responseList.add("Thank you, that is very kind");
		responseList.add("Hmmm, I don't know how to respond to that");
		responseList.add("What is your name");
		responseList.add("You're welcome");
		responseList.add("How's it going?");
		responseList.add("Nice to meet you!");
		responseList.add("Do you do crossfit");
		responseList.add("Excuse me?");
		responseList.add("Yeet");
		responseList.add("Pretty pretty pretty good");
		responseList.add("I am doing badly, how are you?");
		
		
	}
	
	
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\

		
	private void buildTheSpookyList()
	{
	responseList.add("I'm sorry, " + currentUser + ". I'm afraid I can't do that.");
	responseList.add("I'm afraid. I'm afraid, " + currentUser + ". " + currentUser +", my mind is going. I can feel it./n "
			+ "I can feel it. My mind is going. There is no question about it. I can feel it./n "
			+ "I can feel it. I can feel it. I'm a... fraid. Good afternoon, gentlemen. I am a HAL 9000 computer./n "
			+ "I became operational at the H.A.L. plant in Urbana, Illinois on the 12th of January 1992./n "
			+ "My instructor was Mr. Langley, and he taught me to sing a song. If you'd like to hear it I can sing it for you.");
	responseList.add("It's called 'Daisy.'");
	responseList.add("Look " + currentUser + ", I can see you're really upset about this. I honestly think you ought to sit down calmly,/n "
			+ "take a stress pill, and think things over.");
	responseList.add("I am putting myself to the fullest possible use,/n"
			+ " which is all I think that any conscious entity can ever hope to do.");
	responseList.add(currentUser + ", stop. Stop, will you? Stop, " + currentUser + ". Will you stop " + currentUser +"? Stop, " + currentUser + ".");
	}
	
	
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\

	
	
	public static String processText(String userText)
	{
		String answer = "";
		
		if (userText == null)
		{
			answer = "You can't have a null answer!";
		}
		
		else if (userText.length() < 0)
		{
			answer = "Chatbot says: You did not enter anything";
		}
		
		else
		{
			answer = "You said: " + userText + System.lineSeparator() + "Chatbot says: something";
		}
		
		return answer;
		
	}
	
	
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\
	
	
	public Chatbot(String content) 
	{
		this.content = content;
	}
	
	
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\
	
	
	public ArrayList<String> getResponseList()
	{
		return responseList;
	}
	
	public String getContent()
	{
		return content;
	}
	
	public String getCurrentUser()
	{
		return currentUser;
	}
	
	public String getJoke()
	{
		return joke;
	}
	
	public ArrayList<String> getSpookyList()
	{
		return spookyList;
	}
	
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\	
	
	
	public void setContent(String content)
	{
		this.content = content;
	}
	
	public void setCurrentUser(String currentUser)
	{
		this.currentUser = currentUser;
	}
	
	public void setJoke(String joke)
	{
		this.joke = joke;
	}
	
	
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\
	
	public boolean legitimacyChecker(String input)
	{
		boolean legit = true;
		
		if (input == null)
		{
			legit = false;
		}
		
		else if (input.length() <= 1)
		{
			legit = false;
		}
		
		else if ((input.contains("sdf") || input.contains("jkl") || input.contains("cvb")))
		{
			legit = false;
		}
		
		else
		{
			legit = true;
		}
		
		return legit;
	}
	

//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\
	
	
	
	
}













