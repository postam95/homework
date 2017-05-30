package homeworkProject.view;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import homeworkProject.MainFX;
import homeworkProject.data.TicketService;
import homeworkProject.model.TicketData;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Class for controlling the TicketView.
 * @author Mario Posta
 */
public class TicketViewController {
	
    /**
     * Logger for tracking the application.
     */
    private Logger logger = LoggerFactory.getLogger(MainFX.class);
    
    /**
     * TextLabel for the amount of the Super Gold TicketDatas.
     */
    @FXML
    private Label superGoldLabel;
    
    /**
     * TextLabel for the amount of the Gold 1 TicketDatas.
     */
    @FXML
    private Label gold1Label;
    
    /**
     * TextLabel for the amount of the Gold 2 TicketDatas.
     */
    @FXML
    private Label gold2Label;
    
    /**
     * TextLabel for the amount of the Silver 1 TicketDatas.
     */
    @FXML
    private Label silver1Label;
    
    /**
     * TextLabel for the amount of the Silver 2 TicketDatas.
     */
    @FXML
    private Label silver2Label;
    
    /**
     * TextLabel for the amount of the Bronze 1 TicketDatas.
     */
    @FXML
    private Label bronze1Label;
    
    /**
     * TextLabel for the amount of the Bronze 2 TicketDatas.
     */
    @FXML
    private Label bronze2Label;
    
	/**
	 * Instance of the TicketService class to control ticket transactions.
	 */
	private TicketService ticketService;
    
    /**
     * DialogerStage for the stage of this scene.
     */
	@SuppressWarnings("unused")
	private Stage dialogStage;

	/**
	 * Sets the stage of this scene.
	 * @param dialogStage the dialogStage of this scene
	 */
    public void setDialogStage(Stage dialogStage) {
    	this.dialogStage = dialogStage;
    	showAvailableTicketData();
    }
    	
	/**
	 * Sets TicketService for transactions.
	 * @param ticketService the ticketService object to control ticket transactions
	 */
	public void setTicketService(TicketService ticketService){
		this.ticketService = ticketService;
	}
	
	/**
	 * Method for showing available tickets.
	 */
    private void showAvailableTicketData()	{
        logger.debug("Ticket query has been reveived");

    	List<TicketData> TicketDatas = ticketService.getAvailableTickets();
    	for (TicketData TicketData : TicketDatas) {
			if (TicketData.getType().equals("Super Gold"))
				superGoldLabel.setText(TicketData.getAmount().toString());
			if (TicketData.getType().equals("Gold 1"))
				gold1Label.setText(TicketData.getAmount().toString());
			if (TicketData.getType().equals("Gold 2"))
				gold2Label.setText(TicketData.getAmount().toString());
			if (TicketData.getType().equals("Silver 1"))
				silver1Label.setText(TicketData.getAmount().toString());
			if (TicketData.getType().equals("Silver 2"))
				silver2Label.setText(TicketData.getAmount().toString());
			if (TicketData.getType().equals("Bronze 1"))
				bronze1Label.setText(TicketData.getAmount().toString());
			if (TicketData.getType().equals("Bronze 2"))
				bronze2Label.setText(TicketData.getAmount().toString());
    	}
    	
    }
}
