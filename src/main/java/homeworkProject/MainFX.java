package homeworkProject;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import homeworkProject.model.Person;
import homeworkProject.view.AckViewController;
import homeworkProject.view.MapViewController;
import homeworkProject.view.OrderViewController;
import homeworkProject.view.StartViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Main class for initializing the JavaFX application and the stages.
 * 
 * @author Mario Posta
 */
public class MainFX extends Application {
	
    /**
     * Logger for tracking the application.
     */
    public static Logger logger = LoggerFactory.getLogger(MainFX.class);

	/**
	 * Stage for starting the application and loading the initial content.
	 */
    private Stage primaryStage;
    
    /**
     * Pane for organizing the content of the stage.
     */
    private BorderPane rootLayout;    
    
    /**
     * Start method of the application.
     * Loads the initial stage and scene.
     */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Welcome to the Ticket System!");
        
        logger.debug("Initial stage has been opened");
        
        initRootLayout();

        showStartView();
    }

    /**
     * Initializes the basic scene with loading the proper fxml file
     * which describes the layout of the root scene.
     */
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFX.class.getClassLoader().getResource("RootView.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            logger.debug("InitRoot has been opened");
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Opens a new stage with an image of the track map,
     * that helps the user to utilize the application.
     */
    public void showMapView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFX.class.getClassLoader().getResource("MapView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Choose the proper grandstand!");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            logger.debug("Circuit map window has been opened");

            MapViewController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Opens a new stage when the user clicks on the Next button of the StartView
     * to ask for personal informations and finalize the order.
     * Shows the OrderView fxml file.
     * @param person the person who gives personal informations to order
     * @return {@code true} if the user clicked on the Order button of the OrderView,
     * {@code false} otherwise
     */
    public boolean showOrderView(Person person) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFX.class.getClassLoader().getResource("OrderView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Finalize your order!");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            logger.debug("Order window has been opened");

            OrderViewController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            dialogStage.showAndWait();
            return controller.isOrderClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Opens a new stage when the user clicks on the Order button of the OrderView
     * to finalize the order. Shows the AckView fxml file.
     * @param person the person who has been sent the order and whose informations
     * is displayed on the AckView
     */
    public void showAckView(Person person) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFX.class.getClassLoader().getResource("AckView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Ack");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            logger.debug("Acknowledge window has been opened");

            AckViewController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Shows the initial view of this application. Materalizes the start point of
     * this application with the StartView fxml.
     */
    public void showStartView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFX.class.getClassLoader().getResource("StartView.fxml"));
            AnchorPane startView = (AnchorPane) loader.load();
            
            logger.debug("Start window has been opened");
            
            StartViewController controller = loader.getController();
            controller.setMainFX(this);

            rootLayout.setCenter(startView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage of the application
     * @return the main stage of the application
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
}