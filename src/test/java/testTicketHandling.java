

import homeworkProject.businessLogic.TicketHandling;
import homeworkProject.model.Ticket;

import static org.junit.Assert.*;

import org.junit.Test;

public class testTicketHandling {
	
	/**
	 * Tests whether the shopping is empty or not.
	 */
	@Test
	public void testIsShoppingCartEmpty()	{
		TicketHandling ticketHandling = new TicketHandling();
		Ticket ticket = new Ticket("SG", 45, 45);
		assertEquals(true, ticketHandling.isShoppingCartEmpty());
		ticketHandling.addToCart(ticket);
		assertEquals(false, ticketHandling.isShoppingCartEmpty());
		ticketHandling.getShoppingCart().clear();
		assertEquals(true, ticketHandling.isShoppingCartEmpty());
	}
	
	/**
	 * Tests whether the ticket amount is a valid number or not.
	 */
	@Test
	public void testIsInputValidTickets(){
		TicketHandling ticketHandling = new TicketHandling();
		assertEquals(true, ticketHandling.isInputValidTickets("1"));
		assertEquals(false, ticketHandling.isInputValidTickets(null));
		assertEquals(false, ticketHandling.isInputValidTickets("0"));
		assertEquals(false, ticketHandling.isInputValidTickets("-1"));
		assertEquals(false, ticketHandling.isInputValidTickets("-100"));
		assertEquals(true, ticketHandling.isInputValidTickets("100"));
		assertEquals(false, ticketHandling.isInputValidTickets("ewf"));

	}
	
	
	/**
	 * Test whether the personal informations are valid or not.
	 */
	@Test
	public void testIsInputValidPerson(){
		TicketHandling ticketHandling = new TicketHandling();
		assertEquals(null, ticketHandling.isInputValidPerson("fd", "fd", "fd", "fd", "fd", "fd"));
		assertEquals("No valid name!\n", ticketHandling.isInputValidPerson("", "fd", "fd", "fd", "fd", "fd"));
		assertEquals("No valid name!\n", ticketHandling.isInputValidPerson(null, "fd", "fd", "fd", "fd", "fd"));
		assertEquals("No valid e-mail address!\n", ticketHandling.isInputValidPerson("dd", "", "fd", "fd", "fd", "fd"));
		assertEquals("No valid e-mail address!\n", ticketHandling.isInputValidPerson("sdf", null, "fd", "fd", "fd", "fd"));
		assertEquals("No valid telephone number!\n", ticketHandling.isInputValidPerson("dsf", "fd", "", "fd", "fd", "fd"));
		assertEquals("No valid telephone number!\n", ticketHandling.isInputValidPerson("sdf", "fd", null, "fd", "fd", "fd"));
		assertEquals("No valid postal code!\n", ticketHandling.isInputValidPerson("asd", "fd", "fd", "", "fd", "fd"));
		assertEquals("No valid postal code!\n", ticketHandling.isInputValidPerson("sdf", "fd", "fd", null, "fd", "fd"));
		assertEquals("No valid city!\n", ticketHandling.isInputValidPerson("asdf", "fd", "fd", "fd", "", "fd"));
		assertEquals("No valid city!\n", ticketHandling.isInputValidPerson("dsf", "fd", "fd", "fd", null, "fd"));
		assertEquals("No valid street!\n", ticketHandling.isInputValidPerson("dsf", "fd", "fd", "fd", "fd", ""));
		assertEquals("No valid street!\n", ticketHandling.isInputValidPerson("sdfsd", "fd", "fd", "fd", "fd", null));
	}
	
	/**
	 * Tests whether the shopping cart addition is successfull or not.
	 */
	@Test
	public void testAddToCart()	{
		TicketHandling ticketHandling = new TicketHandling();
		Ticket ticketFirst = new Ticket("Super Gold", 45, 45);
		
		int sizeBeforeAdding = ticketHandling.getShoppingCart().size();
		ticketHandling.addToCart(ticketFirst);
		int sizeAfterAdding = ticketHandling.getShoppingCart().size();
		assertEquals(sizeBeforeAdding+1, sizeAfterAdding);
		
		Ticket ticketSecond = new Ticket("Super Gold", 45, 45);
		Integer sumOfAmounts = ticketFirst.getAmount() + ticketSecond.getAmount();
		int sizeBeforAddingTheSameType = ticketHandling.getShoppingCart().size();
		ticketHandling.addToCart(ticketSecond);
		int sizeAfterAddingTheSameType = ticketHandling.getShoppingCart().size();
		assertEquals(sizeBeforAddingTheSameType, sizeAfterAddingTheSameType);
		assertEquals(ticketFirst.getAmount(), sumOfAmounts);
	}
}
