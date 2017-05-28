package homeworkProject.view;

import homeworkProject.MainFX;
import homeworkProject.businessLogic.TicketHandling;
import homeworkProject.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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
	 * Stage for the order.
	 */
    private Stage dialogStage;
    
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
    }

    /**
     * Sets the stage of this dialog.
     * @param dialogStage
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
    	if (TicketHandling.isInputValidPerson(nameField.getText(), emailField.getText(), telephoneField.getText(),
    			postalCodeField.getText(), cityField.getText(), streetField.getText()))	{
            person.setName(nameField.getText());
            person.setEmail(emailField.getText());
            person.setTelephone(telephoneField.getText());
            person.setPostalCode(postalCodeField.getText());
            person.setCity(cityField.getText());
            person.setStreet(streetField.getText());
        	orderClicked = true;
    		dialogStage.close();
    		
    		MainFX.logger.debug("Person datas has been read from the OrderView");
    	}
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