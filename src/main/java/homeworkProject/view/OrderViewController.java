package homeworkProject.view;


import homeworkProject.MainFX;
import homeworkProject.businessLogic.TicketHandling;
import homeworkProject.data.TicketService;
import homeworkProject.model.Person;
import homeworkProject.model.Ticket;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * Class for controlling the scene that is represented by OrderView.fxml.
 * 
 * @author Mario Posta
 */
public class OrderViewController {

	/**
	 * Textfield for the name of the person who orders.
	 */
    @FXML
    private TextField nameField;
    
	/**
	 * Textfield for the e-mail address of the person who orders.
	 */
    @FXML
    private TextField emailField;
    
	/**
	 * Textfield for the telephone number of the person who orders.
	 */
    @FXML
    private TextField telephoneField;
    
	/**
	 * Textfield for the postal code of the person who orders.
	 */
    @FXML
    private TextField postalCodeField;
    
	/**
	 * Textfield for the city of the person who orders.
	 */
    @FXML
    private TextField cityField;
    
	/**
	 * Textfield for the street address of the person who orders.
	 */
    @FXML
    private TextField streetField;

    /**
     * Person object for store and display the information
     * about the person who orders.
     */
    private Person person;
    
    /**
     * Instance of the MainFX class to control stages.
     */
    private MainFX mainFX;
    
	/**
	 * Stage for the order.
	 */
    private Stage dialogStage;
    
	/**
	 * Instance of the TicketService class to control ticket transactions.
	 */
	private TicketService ticketService;
    
    /**
     * Indicates whether the user clicked on the Order button.
     */
    private boolean orderClicked = false;

    /**
     * Sets the person to be edited in the dialog.
     * @param person the person who orders
     */
    public void setPerson(Person person) {
        this.person = person;

        nameField.setText(person.getName());
        emailField.setText(person.getEmail());
        telephoneField.setText(person.getTelephone());
        postalCodeField.setText(person.getPostalCode());
        cityField.setText(person.getCity());
        streetField.setText(person.getStreet());
        
        MainFX.logger.debug("Person data has been read");

    }
    
    /**
     * Gives the control to this controller class.
     * @param mainFX the mainFX instance to control the stage
     */
	public void setMainFX(MainFX mainFX) {
		this.mainFX = mainFX;
	}
	
	/**
	 * Sets TicketService for transactions.
	 * @param ticketService the ticketService object to control ticket transactions
	 */
	public void setTicketService(TicketService ticketService){
		this.ticketService = ticketService;
	}

    /**
     * Sets the stage of this dialog.
     * @param dialogStage the stage of this scene
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Returns {@code true} if the user clicked on the Order button,
     * {@code false} otherwise.
     * @return {@code true} if the user clicked on the Order button,
     * {@code false} otherwise
     */
    public boolean isOrderClicked() {
        return orderClicked;
    }

    /**
     * Called when the user clicks on the Order button.
     * Binds the person object fields with datas from the Textfields.
     */
    @FXML
    private void handleOrder() {
    	String errorMessage = TicketHandling.isInputValidPerson(nameField.getText(), emailField.getText(), telephoneField.getText(),
    			postalCodeField.getText(), cityField.getText(), streetField.getText());
    	if (errorMessage == null)	{
            MainFX.logger.debug("Person input data is correct");

            person.setName(nameField.getText());
            person.setEmail(emailField.getText());
            person.setTelephone(telephoneField.getText());
            person.setPostalCode(postalCodeField.getText());
            person.setCity(cityField.getText());
            person.setStreet(streetField.getText());
        	orderClicked = true;
    		dialogStage.close();
    		
    		for (Ticket ticket : TicketHandling.getShoppingCart()) {
				ticketService.modifyTicketData(ticket.getType(), ticket.getAmount());
			}
    		
    		MainFX.logger.debug("Person datas has been read from the OrderView");
    	}
    	else	{
    		handleWarning("Warning", "Bad inputs", errorMessage);
            MainFX.logger.warn("Person input data is not correct");
    	}
    }
    
    /**
     * Handles the warning messages if something went wrong during the order.
     * @param title the title of the message
     * @param header the header of the message
     * @param content the content of the message
     */
    public void handleWarning(String title, String header, String content)	{
        Alert alert = new Alert(AlertType.WARNING);
        alert.initOwner(mainFX.getPrimaryStage());
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
        
        MainFX.logger.debug("Warning window has been opened");
    }

    /**
     * Called when the user clicks on the Cancel button.
     * Closes is the stage of the order.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
        
        MainFX.logger.debug("Cancel button has been clicked on the OrderView");
    }
}