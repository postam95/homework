package homeworkProject.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import homeworkProject.MainFX;
import homeworkProject.model.TicketData;

/**
 * Class for managing the database.
 * 
 * @author Mario Posta
 */
public class TicketService {
	/**
	 * EntityManager for controll the database.
	 */
	public EntityManager entityManager;

	/**
	 * Contsructor for Ticket Service.
	 * Initializes the Entity Manager
	 * @param entityManager the only Entity Manager of the application
	 */
	public TicketService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	/**
	 * Initializes the database with initial ticket amounts.
	 */
	public void initializeDatabase()	{
        MainFX.logger.debug("Database initialization is in progress");

		entityManager.getTransaction().begin();
		@SuppressWarnings("unused")
		TicketData TicketData = this.createTicket("Super Gold", 100);
		TicketData = this.createTicket("Gold 1", 100);
		TicketData = this.createTicket("Gold 2", 100);
		TicketData = this.createTicket("Silver 1", 100);
		TicketData = this.createTicket("Silver 2", 100);
		TicketData = this.createTicket("Bronze 1", 100);
		TicketData = this.createTicket("Bronze 2", 100);
		entityManager.getTransaction().commit();
	}
	
	/**
	 * Returns the content of the database.
	 * @return the content of the database
	 */
	public List<TicketData> getAvailableTickets() {
        MainFX.logger.debug("Database qeury is in progress");

		TypedQuery<TicketData> query = entityManager.createQuery(
				"select t from homeworkProject.model.TicketData t", TicketData.class
				);
		return query.getResultList();
	}
	
	/**
	 * Method for creating a new TicketData object, and persisting to the database.
	 * @param type the type of the ticket
	 * @param amount the amount of the ticket
	 * @return a new TicketData object which has been added to the database
	 */
	public TicketData createTicket(String type, Integer amount) {
        MainFX.logger.debug("Ticket creating is in progress");

		TicketData TicketData = new TicketData(type, amount);
		entityManager.persist(TicketData);
		return TicketData;
	}
	
	/**
	 * Method for modifying the content of the database.
	 * @param type the type of the ticket that will be modified in the database
	 * @param amount the amount of the ticket to subtract from the proper ticket amount
	 */
	public void modifyTicketData(String type, Integer amount)	{
		MainFX.logger.debug("Ticket modifying is in progress");

		TicketData TicketData = entityManager.find(TicketData.class, type);
		  
		entityManager.getTransaction().begin();
		TicketData.setAmount(TicketData.getAmount()-amount);
		entityManager.getTransaction().commit();
	}
	
	/**
	 * Method for checking how many tickets are available.
	 * @param type the type of the ticket
	 * @param amount the amount of the ticket
	 * @return {@code true} if there is enough ticket,
	 * {@code false} otherwise
	 */
	public boolean checkAvailableTickets(String type, Integer amount){
        MainFX.logger.debug("Ticket availability check is in progress");

		TicketData TicketData = entityManager.find(TicketData.class, type);
		if (TicketData != null && TicketData.getAmount()-amount >= 0)
			return true;
		return false;
	}
}