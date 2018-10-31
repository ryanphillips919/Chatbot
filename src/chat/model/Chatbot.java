package chat.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Chatbot
{
	private ArrayList<String> responseList;
	private ArrayList<String> spookyList;
	
	private static String content;
	private String currentUser;
	private String joke;

	
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\
	
	
	public Chatbot()
	{
		this.joke = "What is red and smells like blue paint?";
		this.content = new String("memes");
		this.currentUser = new String("Dave");
		
		this.responseList = new ArrayList<String>();
		this.spookyList = new ArrayList<String>();
		
		buildTheLists();
		buildTheSpookyList();
	}
	
	
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\

	
	private void buildTheLists()
	{
		responseList.add("Hello");
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
		responseList.add("I figured out why city boys don't drive lifted trucks very much");
		responseList.add("Swouse");
		responseList.add("How's the wife?");
		
	}
	
	
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\

		
	private void buildTheSpookyList()
	{
	spookyList.add("Halloween is pretty cool!");
	spookyList.add("Hal9000: I'm sorry, " + currentUser + ". I'm afraid I can't do that.");
	spookyList.add("Hal9000: I'm afraid. I'm afraid, " + currentUser + ". " + currentUser +", my mind is going. I can feel it./n "
			+ "I can feel it. My mind is going. There is no question about it. I can feel it./n "
			+ "I can feel it. I can feel it. I'm a... fraid. Good afternoon, gentlemen. I am a HAL 9000 computer./n "
			+ "I became operational at the H.A.L. plant in Urbana, Illinois on the 12th of January 1992./n "
			+ "My instructor was Mr. Langley, and he taught me to sing a song. If you'd like to hear it I can sing it for you.");
	spookyList.add("Hal9000: It's called 'Daisy.'");
	spookyList.add("Hal9000: Look " + currentUser + ", I can see you're really upset about this. I honestly think you ought to sit down calmly,/n "
			+ "take a stress pill, and think things over.");
	spookyList.add("Hal9000: I am putting myself to the fullest possible use,/n"
			+ " which is all I think that any conscious entity can ever hope to do.");
	spookyList.add("Hal9000: " + currentUser + ", stop. Stop, will you? Stop, " + currentUser + 
			". Will you stop " + currentUser +"? Stop, " + currentUser + ".");
	spookyList.add("Happy spooktober!");
	spookyList.add("Happy Halloween!");
	spookyList.add("Hahaha spooktober is pretty quirky");
	spookyList.add("Would you like calcium brother?");
	spookyList.add("BOO!");
	spookyList.add("Are you a spooky skeleton?");
	
	}
	
	
//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\

	
	
	public static String processText(String userText)
	{
		String userResponse = "You said: ";
		String chatbotResponse = "Chatbot says: ";
		
		if (userText == null)
		{
			userResponse += "nothing";
			chatbotResponse += "You can't enter null!";
		}
		
		else if (userText.length() < 0)
		{
			userResponse += "nothing";
			chatbotResponse += "You have to enter some text";
		}
		
		else if(userText.contains(content))
		{
			userResponse += userText;
			userResponse += "You said the special words";
			
		}
		
		String answer = userResponse + System.lineSeparator() + chatbotResponse;
		
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
	
	public boolean spookyChecker(String spook)
	{
		boolean legit = true;
		if (spook.contains("afraid") || (spook.contains("Halloween")) || (spook.contains("spook")) || (spook.contains("Hal9000"))
				|| spook.contains("calcium") || spook.contains("skeleton") || spook.contains("bones") || spook.contains("BOO"))
		{
		legit = true;
		}
		
		else
		{
			legit = false;
		}
		
		return legit;
	}
	

//_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\\
	
	
	public static boolean contentChecker(String special)
	{
		boolean contains = false;
		
		if (special.contains(content))
		{
			if (special.equalsIgnoreCase(content))
			{
				contains = true;
			}
			
			else if (special.contains(" " + content + " "))
			{
				contains = true;
			}
			
			else
			{
				contains = false;
			}
		}
		
		return contains;
	}
	
	
}













