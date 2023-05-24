package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.makery.address.MainApp;
import ch.makery.address.model.Person;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PersonOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	// Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());
    }
    
    /**
    * Rellena todos los campos de la persona para mostrar detalles de la persona.
    * Si, la persona especificada es nula, se borran todos los campos del texto
    * 
    * @param person la persona o nula
    */
   private void showPersonDetails(Person person) {
       if (person != null) {
           // Fill the labels with info from the person object.
           firstNameLabel.setText(person.getFirstName());
           lastNameLabel.setText(person.getLastName());
           streetLabel.setText(person.getStreet());
           postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
           cityLabel.setText(person.getCity());

           // TODO: Necesitamos una forma de convertir el cumpleaños en una cadena! 
           // EtiquetaDeCumpleaños.setText(...);
       } else {
           // Person is null, remove all the text.
           firstNameLabel.setText("");
           lastNameLabel.setText("");
           streetLabel.setText("");
           postalCodeLabel.setText("");
           cityLabel.setText("");
           birthdayLabel.setText("");
       }
   }
}