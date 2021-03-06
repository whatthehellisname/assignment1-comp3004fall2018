package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
	

	public static String[] names = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
	public static String[] suites = {"Hearts","Spades","Cubes","Diamonds"};
	public static List<Card> cards;

	public void add(Card c)
	{
		cards.add(c);
	}
	public int getSize()
	{
		return cards.size();
	}

	
	public void buildDeck(){
		List<Card> deck = new ArrayList<Card>();
		for (int i = 0; i < suites.length; i++){
			for (int j = 0; j < names.length; j++){
				Card k = new Card(names[j], suites[i]);
				deck.add(k);
			}
		}
		cards = deck;
	}
	
	public void shuffleDeck(){
		List<Card> shuffledDeck = new ArrayList<Card>();
		int r = 0;
		while (cards.size() > 0){
			Random card = new Random();
			r = card.nextInt(cards.size());
			Card temp = cards.remove(r);
			shuffledDeck.add(temp);
		}
		cards = shuffledDeck;
	}
	
	public static Card drawCard(List<Card> playersCards){
		int total = 0;
		Card playerCard1 = cards.remove(0);
		total += playerCard1.getValue();
		playersCards.add(playerCard1);
		return playerCard1;
	}
	public Card drawTheCardFromDeckAndCheck(String name, String suite)
	{
		Card aCard = new Card(name,suite);
		aCard = aCard.readCard(name, suite);
		boolean notFound = true;
		for(int i = 0; i<cards.size();i++)
		{
			if(cards.get(i).getName().equals(aCard.getName()) && cards.get(i).getSuite().equals(aCard.getSuite()))
			{
				notFound = false;
				cards.remove(i);
			}
//			else
//			{
//				System.out.println("CARD ALREASY USED");
//				System.exit(0);
//			}
		 }
		if(notFound)
		{
			System.out.println("Input file is not correct(card already used)");
			System.exit(0);
		}
		
		return aCard;
		
	}

	
}
