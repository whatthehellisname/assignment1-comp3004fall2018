package core;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class SimpleTest extends TestCase{
	
	public void testPoker()
	{
		Card a = new Card("19","Apple");
		assertTrue(a.iSPoker() == false);
				
	}

	public void testTheValueOfEightOfHeart()
	{
		Card cardEightOfHeart = new Card("8","Hearts");
		assertTrue(cardEightOfHeart.getValue()==8);
	}
	public void testIfAceOfHeartIsAce()
	{
		Card aceOfHeart = new Card ("Ace","Hearts");
		assertTrue(aceOfHeart.isAce());
	}
	public void testTheValueOfAceOfHeart()
	{
		Card aceOfHeart = new Card ("Ace","Hearts");
		assertTrue(aceOfHeart.getValue()==11);
	}
	
	public void testBuildDeck()
	{
		Deck d = new Deck();
		d.buildDeck();
		assertTrue(d.getSize()==52);		
	} 
	public void testShuffleDeck()
	{
		List<Card> exampleCards = new ArrayList<Card>(); 
		Deck d = new Deck();
		d.buildDeck();
		d.shuffleDeck();
		Card newCard = d.drawCard(exampleCards);
		assertTrue(d.getSize()==51 && d.cards!=null && newCard.getValue()!=11);	
	}
	public void testDrawACard()
	{
		Deck d = new Deck();
		d.buildDeck();
		List<Card> playersCards = new ArrayList<Card>();
		assertTrue(d.getSize()==52);
		assertTrue(d.drawCard(playersCards).getValue()== 11 && d.getSize()==51);	
		assertTrue(playersCards.size()==1);
	}
	public void testValueOfTenOfHeart()
	{
		Card tenOfHeart = new Card("10","Heart");
		assertTrue(tenOfHeart.getValue()==10);
		
	}
	

	


	


}
