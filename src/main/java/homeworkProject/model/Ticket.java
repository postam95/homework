package homeworkProject.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Class for representing a ticket.
 * 
 * @author Mario Posta
 */

public class Ticket {

	/**
	 * Type for the ticket.
	 */
	private final StringProperty type;
	/**
	 * Price for the ticket.
	 */
	private final IntegerProperty price;
	/**
	 * Amount for the ticket.
	 */
	private final IntegerProperty amount;
	
    /**
     * Default constructor for this class.
     */
	public Ticket() {
		this(null, null, null);
	}
	
	/**
	 * Constructor for this class.
	 * @param type the type of the ticket
	 * @param price the price of the ticket
	 * @param amount the amount of the ticket
	 */
	public Ticket(String type, Integer price, Integer amount) {
		super();
		this.type = new SimpleStringProperty(type);
		this.price = new SimpleIntegerProperty(price);
		this.amount = new SimpleIntegerProperty(amount);
	}
	
	/**
	 * Returns the type of the ticket.
	 * @return the type of the ticket
	 */
    public String getType() {
        return type.get();
    }

    /**
     * Sets the type of the ticket.
     * @param type the type of the ticket
     */
    public void setName(String type) {
        this.type.set(type);
    }

    /**
     * Return the type of the ticket as property.
     * @return the tpye of the ticket
     */
    public StringProperty typeProperty() {
        return type;
    }
    
    /**
     * Return the price of the ticket.
     * @return the price of the ticket
     */
    public Integer getPrice() {
        return price.get();
    }

    /**
     * Sets the price of the ticket.
     * @param price the price of the ticket.
     */
    public void setPrice(Integer price) {
        this.price.set(price);
    }

    /**
     * Returns the price of the ticket as property.
     * @return the price of the ticket
     */
    public IntegerProperty priceProperty() {
        return price;
    }
    
    /**
     * Returns the amount of the ticket.
     * @return the amount of the ticket
     */
    public Integer getAmount() {
        return amount.get();
    }

    /**
     * Sets the amount of the ticket.
     * @param amount the amount of the ticket
     */
    public void setAmount(Integer amount) {
        this.amount.set(amount);
    }

    /**
     * Return the amount of the ticket as property.
     * @return the amount of the ticket
     */
    public IntegerProperty amountProperty() {
        return amount;
    }
}