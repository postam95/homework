package homeworkProject.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import homeworkProject.MainFX;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Class for controlling the scene that is represented by MapView.fxml.
 * 
 * @author Mario Posta
 */
public class MapViewController {
	
    /**
     * Logger for tracking the application.
     */
    private Logger logger = LoggerFactory.getLogger(MainFX.class);
    
	/**
	 * ImageView for the map of Hungaroring.
	 */
	@FXML
	private ImageView imageView;
	
	/**
	 * Stage for the map of Hungaroring.
	 */
	@SuppressWarnings("unused")
	private Stage dialogStage;

    /**
     * Sets the stage of the scene of the map.
     * @param dialogStage the stage that represents the dialog
     */
    public void setDialogStage(Stage dialogStage) {
    	this.dialogStage = dialogStage;
    	setImageView();
        logger.debug("DialogeStage has been set in the MapView");

    }
    
    /**
     * Sets the proper image of the Hungaroring and binds it to the stage.
     * It uses the Hungaroring.jpg from the resources map.
     */
    private void setImageView(){
        imageView.setImage(new Image(MapViewController.class.getClassLoader().getResource("Hungaroring.jpg").toString()));
        logger.debug("Circuit map has been loaded.");
    }
}