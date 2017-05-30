package homeworkProject.businessLogic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import homeworkProject.MainFX;
import homeworkProject.model.Ticket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Class for representing the business logic of this application
 * and controlling the Ticket System.
 * 
 * @author Mario Posta
 */
public class TicketHandling {
	
    /**
     * Logger for tracking the application.
     */
    private Logger logger = LoggerFactory.getLogger(MainFX.class);
    
	/**
	 * List to representing the shopping cart.
	 */
    private ObservableList<Ticket> shoppingCart = FXCollections.observableArrayList();

	/**
     * Returns a List which contains the tickets which were added to the shopping cart.
     * @return a List that represents the shopping cart
     */
    public ObservableList<Ticket> getShoppingCart() {
        return shoppingCart;
    }
	
    /**
     * Validates the ticket input in the text field.
     * Returns {@code true} if the amount of the ticket is valid,
     * @param textfield text for checking 
     * {@code false} otherwise and calls
     * @return {@code true} if the amount of the ticket is valid and
     * {@code false} otherwise
     */
    public boolean isInputValidTickets(String textfield) {
        logger.debug("TicketInputValidation is in progress");
        
        if (textfield == null || textfield.length() == 0) {
            return false;
        }

        try {
        	Integer.parseInt(textfield);
		} catch (NumberFormatException e) {
			return false;
		}
        
        if (Integer.parseInt(textfield) < 1)
        	return false;
        	
        return true;
    }
    
    /**
     * Validates the user input in the text fields.
     * Returns {@code true} if all inputs are valid,
     * {@code false} otherwise
     * @param name the name of the person
     * @param email the e-mail address of the person
     * @param telephone the telephone number of the person
     * @param postalCode the postal code of the person
     * @param city the city of the person
     * @param street the street of the person
     * @return {@code true} if all inputs are valid and
     * {@code false} otherwise
     */
    public String isInputValidPerson(String name, String email, String telephone,
    		String postalCode, String city, String street) {
        logger.debug("PersonInputValidation is in progress");

        String errorMessage = "";
        if (name == null || name.length() == 0) {
            errorMessage += "No valid name!\n"; 
        }
        if (email == null || email.length() == 0) {
            errorMessage += "No valid e-mail address!\n"; 
        }
        if (telephone == null || telephone.length() == 0) {
            errorMessage += "No valid telephone number!\n"; 
        }

        if (postalCode == null || postalCode.length() == 0) {
            errorMessage += "No valid postal code!\n"; 
        }

        if (city == null || city.length() == 0) {
            errorMessage += "No valid city!\n"; 
        }
        
        if (street == null || street.length() == 0) {
            errorMessage += "No valid street!\n"; 
        }

        if (errorMessage.length() == 0) {
        	logger.debug("Personal infos has been given correctly");
        	
            return null;
        } else {
        	logger.warn("Personal infos has not been added properly");
            return errorMessage;
        }
    }
    
    /**
     * Adds tickets to the shopping cart.
     * Called when the user clicks on the Add to Cart button of the Start View;
     * @param ticket the ticket is going to be added to the shopping cart
     */
    public void addToCart(Ticket ticket){
        logger.debug("Adding to cart is in progress");

    	boolean ticketExisted = false;
    	for (Ticket ticketIterator : shoppingCart) {
			if (ticketIterator.getType().equals(ticket.getType()))	{
				ticketIterator.setPrice(ticketIterator.getPrice() + ticket.getPrice());
				ticketIterator.setAmount(ticketIterator.getAmount() + ticket.getAmount());
				ticketExisted = true;
				
				logger.debug("Ticket has been overwritten in the shopping cart");
			}
		}
		if (!ticketExisted)	{
			shoppingCart.add(ticket);
			
			logger.debug("A new ticket has been added to the shopping cart");
		}		
    }
    
    
    /**
     * Method for removing ticket from the shopping cart.
     * @param ticketToRemove the ticket to remove from the shopping cart
     */
    public void removeFromCart(Ticket ticketToRemove){
    	for (Ticket ticket : shoppingCart) {
			if (ticketToRemove.getType() == ticket.getType())	{
				shoppingCart.remove(ticket);
				break;
			}
		}
    }
    
    /**
     * Decides whether the shopping cart is empty or not.
     * @return {@code true} if the shopping cart empty,
     * {@code false} otherwise
     */
    public boolean isShoppingCartEmpty() {
        logger.debug("Shopping cart checking is in progress");

    	return shoppingCart.isEmpty();
    }
}
