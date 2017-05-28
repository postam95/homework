package homeworkProject.businessLogic;

import homeworkProject.MainFX;
import homeworkProject.model.Ticket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Class for representing the business logic of this application
 * and controlling the Ticket System.
 * 
 * @author Mario Posta
 */
public class TicketHandling {
	
	/**
	 * List to representing the shopping cart.
	 */
    private static ObservableList<Ticket> shoppingCart = FXCollections.observableArrayList();
    
    /**
     * Instance of the MainFX class to handle the calls to open another stage.
     */
    private static MainFX mainFX;
    
    /**
     * Returns a List which contains the tickets which were added to the shopping cart.
     * @return a List that represents the shopping cart
     */
    public static ObservableList<Ticket> getShoppingCart() {
        return shoppingCart;
    }
	
    /**
     * Validates the ticket input in the text field.
     * Returns {@code true} if the amount of the ticket is valid,
     * {@code false} otherwise and calls
     * @return {@code true} if the amount of the ticket is valid and
     * {@code false} otherwise
     */
    public static boolean isInputValidTickets(String textfield) {
        MainFX.logger.debug("Ticket validation is in progress");
        String errorMessage = "";

        if (textfield == null || textfield.length() == 0) {
            errorMessage += "No valid amount of tickets!\n"; 
        }

        if (errorMessage.length() == 0 && Integer.parseInt(textfield) > 0) {
        	MainFX.logger.debug("Ticket amount has been given properly");
        	
            return true;
        } else {
        	MainFX.logger.warn("Ticket amount has not been given properly");
        	
            return false;
        }
    }
    
    /**
     * Validates the user input in the text fields.
     * Returns {@code true} if all inputs are valid,
     * {@code false} otherwise
     * @return {@code true} if all inputs are valid and
     * {@code false} otherwise
     */
    public static boolean isInputValidPerson(String name, String email, String telephone,
    		String postalCode, String city, String street) {
        String errorMessage = "";
        if (name == null || name.length() == 0) {
            errorMessage += "No valid first name!\n"; 
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
        	MainFX.logger.debug("Personal infos has been given correctly");
        	
            return true;
        } else {
        	MainFX.logger.warn("Personal infos has not been added properly");
        	
        	handleWarning("Invalid Fields", "Please correct invalid fields", errorMessage);
            return false;
        }
    }
    
    /**
     * Adds tickets to the shopping cart.
     * Called when the user clicks on the Add to Cart button of the Start View;
     * @param ticket the ticket is going to be added to the shopping cart
     */
    public static void addToCart(Ticket ticket){
    	boolean ticketExisted = false;
    	for (Ticket ticketIterator : shoppingCart) {
			if (ticketIterator.getType().equals(ticket.getType()))	{
				ticketIterator.setPrice(ticketIterator.getPrice() + ticket.getPrice());
				ticketIterator.setAmount(ticketIterator.getAmount() + ticket.getAmount());
				ticketExisted = true;
				
				MainFX.logger.debug("Ticket has been overwritten in the shopping cart");
			}
		}
		if (!ticketExisted)	{
			shoppingCart.add(ticket);
			
			MainFX.logger.debug("A new ticket has been added to the shopping cart");
		}		
    }
    
    /**
     * Handles the warning messages if something went wrong during the order.
     * @param title the title of the message
     * @param header the header of the message
     * @param content the content of the message
     */
    public static void handleWarning(String title, String header, String content)	{
        Alert alert = new Alert(AlertType.WARNING);
        alert.initOwner(mainFX.getPrimaryStage());
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
        
        MainFX.logger.debug("Warning window has been opened");
    }

}
