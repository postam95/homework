package homeworkProject.view;

import homeworkProject.MainFX;
import homeworkProject.businessLogic.TicketHandling;
import homeworkProject.model.Person;
import homeworkProject.model.Ticket;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Class for controlling the scene that is represented by StartView.fxml.
 * 
 * @author Mario Posta
 */
public class StartViewController {
	
	/**
	 * Tableview for representing the content of the shopping cart.
	 */
    @FXML
    private TableView<Ticket> shoppingCartTable;
    
    /**
     * First column of the table for the type of the ticket.
     */
    @FXML
    private TableColumn<Ticket, String> typeColumn;
    
    /**
     * Second column of the table for the price of the ticket.
     */
    @FXML
    private TableColumn<Ticket, Integer> priceColumn;
    
    /**
     * Third column of the table for the amount of the ticket.
     */
    @FXML
    private TableColumn<Ticket, Integer> amountColumn;
    
    /**
     * Textfield for the amount of the Super Gold tickets.
     */
    @FXML
    private TextField superGoldField;
    
    /**
     * Textfield for the amount of the Gold 1 tickets.
     */
    @FXML
    private TextField gold1Field;
    
    /**
     * Textfield for the amount of the Gold 2 tickets.
     */
    @FXML
    private TextField gold2Field;
    
    /**
     * Textfield for the amount of the Silver 1 tickets.
     */
    @FXML
    private TextField silver1Field;
    
    /**
     * Textfield for the amount of the Silver 2 tickets.
     */
    @FXML
    private TextField silver2Field;
    
    /**
     * Textfield for the amount of the Bronze 1 tickets.
     */
    @FXML
    private TextField bronze1Field;
    
    /**
     * Textfield for the amount of the Bronze 2 tickets.
     */
    @FXML
    private TextField bronze2Field;
    
    /**
     * Instance of the MainFX class to handle the calls to open another stage.
     */
	private MainFX mainFX;
    
	
    /**
     * Initializes the controller class. Sets the label of the tables and calls
     * {@link initStartView()} to initialize the shopping cart and the amount
     * of the tickets.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        amountColumn.setCellValueFactory(cellData -> cellData.getValue().amountProperty().asObject());
        
        MainFX.logger.debug("Shopping cart has been initialized");
        
        initStartView();
    }
    
    /**
     * Initializes the shopping cart and the amount of the tickets.
     */
    private void initStartView(){
        superGoldField.setText("1");
        gold1Field.setText("1");
        gold2Field.setText("1");
        silver1Field.setText("1");
        silver2Field.setText("1");
        bronze1Field.setText("1");
        bronze2Field.setText("1");
        TicketHandling.getShoppingCart().clear();
        shoppingCartTable.setItems(TicketHandling.getShoppingCart());
        
        MainFX.logger.debug("StartView has been initialized");
    }

    /**
     * Gives the controll to this controller class.
     */
	public void setMainFX(MainFX mainFX) {
		this.mainFX = mainFX;
	}	
    
	/**
	 * Handles the actions after the user clicks on the Next button of the StartView.
	 */
    @FXML
    private void handleNext() {
    	Person tempPerson = new Person();
    	boolean orderClicked = mainFX.showOrderView(tempPerson);
    	if (orderClicked)	{
    		MainFX.logger.debug("Next button has been clicked on the StartView");
    		mainFX.showAckView(tempPerson);
    		initStartView();
    	}
    }
	
    /**
     * Opens the map when the user clicks on the CircuitMap button of the StartView.
     */
    @FXML
    private void openMap() {
        mainFX.showMapView();
    }
    
    /**
     * Called when the user clicks on the Delete button.
     * Removes the selected item from the shopping cart.
     */
    @FXML
    private void handleDeleteTicket() {
        int selectedIndex = shoppingCartTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
        	shoppingCartTable.getItems().remove(selectedIndex);
        	
        	MainFX.logger.debug("A ticket has been deleted from the shopping cart");
        } else {
        	TicketHandling.handleWarning("Warning", "No Selection", "Please select a ticket to remove");
        	
        	MainFX.logger.warn("A ticket has not been selected, but Delete button has been clicked");
        }
    }
    
    /**
     * Called when the user clicks on the first Add to Cart button.
     * Gives the selected amount of ticket to the shopping cart,
     * with the proper, Super Gold type.
     */
    @FXML
    private void handleSuperGoldAddToCart() {
        if (TicketHandling.isInputValidTickets(superGoldField.getText())) {
        	Ticket ticket = new Ticket("Super Gold", 450*Integer.parseInt(superGoldField.getText()), Integer.parseInt(superGoldField.getText()));
        	TicketHandling.addToCart(ticket);
        	
        	MainFX.logger.debug("Super Gold ticket(s) has been added to the shopping cart");
        } else	{
        	TicketHandling.handleWarning("Warning", "Bad amount", "Please give an integer which is greater than 0");
        	
        	MainFX.logger.warn("Bad amount of Super Gold tickets");
        }
    }
    
    /**
     * Called when the user clicks on the second Add to Cart button.
     * Gives the selected amount of ticket to the shopping cart,
     * with the proper, Gold 1 type.
     */
    @FXML
    private void handleGold1AddToCart() {
        if (TicketHandling.isInputValidTickets(gold1Field.getText())) {
        	Ticket ticket = new Ticket("Gold 1", 300*Integer.parseInt(gold1Field.getText()), Integer.parseInt(gold1Field.getText()));
        	TicketHandling.addToCart(ticket);
        	
        	MainFX.logger.debug("Gold 1 ticket(s) has been added to the shopping cart");
        } else	{
        	TicketHandling.handleWarning("Warning", "Bad amount", "Please give an integer which is greater than 0");
        
        	MainFX.logger.warn("Bad amount of Gold 1 tickets");
        }
    }
    
    /**
     * Called when the user clicks on the third Add to Cart button.
     * Gives the selected amount of ticket to the shopping cart,
     * with the proper, Gold 2 type.
     */
    @FXML
    private void handleGold2AddToCart() {
        if (TicketHandling.isInputValidTickets(gold2Field.getText())) {
        	Ticket ticket = new Ticket("Gold 2", 300*Integer.parseInt(gold2Field.getText()), Integer.parseInt(gold2Field.getText()));
        	TicketHandling.addToCart(ticket);
        	
        	MainFX.logger.debug("Gold 2 ticket(s) has been added to the shopping cart");
        } else	{
        	TicketHandling.handleWarning("Warning", "Bad amount", "Please give an integer which is greater than 0");
        
        	MainFX.logger.warn("Bad amount of Gold 2 tickets");
        }
    }
    
    /**
     * Called when the user clicks on the fourth Add to Cart button.
     * Gives the selected amount of ticket to the shopping cart,
     * with the proper, Silver 1 type.
     */
    @FXML
    private void handleSilver1AddToCart() {
        if (TicketHandling.isInputValidTickets(silver1Field.getText())) {
        	Ticket ticket = new Ticket("Silver 1", 250*Integer.parseInt(silver1Field.getText()), Integer.parseInt(silver1Field.getText()));
        	TicketHandling.addToCart(ticket);
        	
        	MainFX.logger.debug("Silver 1 ticket(s) has been added to the shopping cart");
        } else	{
        	TicketHandling.handleWarning("Warning", "Bad amount", "Please give an integer which is greater than 0");
        
        	MainFX.logger.warn("Bad amount of Silver 1 tickets");
        }
    }
    
    /**
     * Called when the user clicks on the fifth Add to Cart button.
     * Gives the selected amount of ticket to the shopping cart,
     * with the proper, Silver 2 type.
     */
    @FXML
    private void handleSilver2AddToCart() {
        if (TicketHandling.isInputValidTickets(silver2Field.getText())) {
        	Ticket ticket = new Ticket("Silver 2", 250*Integer.parseInt(silver2Field.getText()), Integer.parseInt(silver2Field.getText()));
        	TicketHandling.addToCart(ticket);
        	
        	MainFX.logger.debug("Silver 2 ticket(s) has been added to the shopping cart");
        } else	{
        	TicketHandling.handleWarning("Warning", "Bad amount", "Please give an integer which is greater than 0");
        
        	MainFX.logger.warn("Bad amount of Silver 2 tickets");
        }
    }
    
    /**
     * Called when the user clicks on the sixth Add to Cart button.
     * Gives the selected amount of ticket to the shopping cart,
     * with the proper, Bronze 1 type.
     */
    @FXML
    private void handleBronze1AddToCart() {
        if (TicketHandling.isInputValidTickets(bronze1Field.getText())) {
        	Ticket ticket = new Ticket("Bronze 1", 100*Integer.parseInt(bronze1Field.getText()), Integer.parseInt(bronze1Field.getText()));
        	TicketHandling.addToCart(ticket);
        	
        	MainFX.logger.debug("Bronze 1 ticket(s) has been added to the shopping cart");
        } else	{
        	TicketHandling.handleWarning("Warning", "Bad amount",  "Please give an integer which is greater than 0");
        
        	MainFX.logger.warn("Bad amount of Bronze 1 tickets");
        }
    }
    
    /**
     * Called when the user clicks on the seventh Add to Cart button.
     * Gives the selected amount of ticket to the shopping cart,
     * with the proper, Bronze 2 type.
     */
    @FXML
    private void handleBronze2AddToCart() {
        if (TicketHandling.isInputValidTickets(bronze2Field.getText())) {
        	Ticket ticket = new Ticket("Bronze 2", 100*Integer.parseInt(bronze2Field.getText()), Integer.parseInt(bronze2Field.getText()));
        	TicketHandling.addToCart(ticket);
        	
        	MainFX.logger.debug("Bronze 2 ticket(s) has been added to the shopping cart");
        } else	{
        	TicketHandling.handleWarning("Warning", "Bad amount", "Please give an integer which is greater than 0");
        
        	MainFX.logger.warn("Bad amount of Bronze 2 tickets");
        }
    }
}
