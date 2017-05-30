package homeworkProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Class for representing a ticket.
 * 
 * @author Mario Posta
 */

@Entity
public class TicketData {
	
	/**
	 * Type for the ticket.
	 */
	@Id
	private String type;
	/**
	 * Price for the ticket.
	 */
	private Integer amount;
	
    /**
     * Default constructor for this class.
     */
	public TicketData() {
		this(null, null);
	}
	
	/**
	 * Constructor for this class.
	 * @param type the type of the ticket
	 * @param amount the amount of the ticket
	 */
	public TicketData(String type, Integer amount) {
		super();
		this.type = type;
		this.amount = amount;
	}
	
	/**
	 * Returns the type of the ticket.
	 * @return the type of the ticket
	 */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the ticket.
     * @param type the type of the ticket
     */
    public void setName(String type) {
        this.type = type;
    }
    
    /**
     * Returns the amount of the ticket.
     * @return the amount of the ticket
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the ticket.
     * @param amount the amount of the ticket
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}