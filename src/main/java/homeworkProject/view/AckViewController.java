package homeworkProject.view;

import homeworkProject.MainFX;
import homeworkProject.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Class for controlling the scene that is represented by AckView.fxml.
 * 
 * @author Mario Posta
 */
public class AckViewController {
	
	/**
	 * Label for the name of the person who orders.
	 */
	@FXML
	private Label nameLabel;
	
	/**
	 * Label for the e-mail address of the person who orders.
	 */
	@FXML
	private Label emailLabel;
	
	/**
	 * Label for the telephone number of the person who orders.
	 */
	@FXML
	private Label telephoneLabel;
	
	/**
	 * Label for the postal code of the person who orders.
	 */
	@FXML
	private Label postalCodeLabel;
	
	/**
	 * Label for the city of the person who orders.
	 */
	@FXML
	private Label cityLabel;
	
	/**
	 * Label for the street address of the person who orders.
	 */
	@FXML
	private Label streetLabel;
	
	/**
	 * Stage for the acknowledgement.
	 */
    @SuppressWarnings("unused")
	private Stage dialogStage;
    
    /**
     * Person object for store and display the information
     * about the person who orders.
     */
    @SuppressWarnings("unused")
	private Person person;

    /**
     * Sets the stage of the scene of acknowledgement.
     * @param dialogStage the stage that represents the dialog
     */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	/**
	 * Sets the labels with the proper informations about the person who orders.
	 * @param person the person who has ordered and
	 * whose informations is displayed on this scene
	 */
    public void setPerson(Person person) {
        this.person = person;

        nameLabel.setText(person.getName());
        emailLabel.setText(person.getEmail());
        telephoneLabel.setText(person.getTelephone());
        postalCodeLabel.setText(person.getPostalCode());
        cityLabel.setText(person.getCity());
        streetLabel.setText(person.getStreet());
        
        MainFX.logger.debug("Person details has been set on the AckView");
    }

}
