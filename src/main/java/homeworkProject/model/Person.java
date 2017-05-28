package homeworkProject.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Class for representing a person who orders.
 * 
 * @author Mario Posta
 */
public class Person {
	
	/**
	 * Name of the person.
	 */
    private final StringProperty name;
    
	/**
	 * E-mail address of the person.
	 */
    private final StringProperty email;
    
    /**
     * Telephone number of the person.
     */
    private final StringProperty telephone;
    
    /**
     * Postal code of the person.
     */
    private final StringProperty postalCode;
    
    /**
     * City of the person.
     */
    private final StringProperty city;
    
    /**
     * Street of the person.
     */
    private final StringProperty street;
    
    /**
     * Default constructor for this class.
     */
	public Person() {
		this(null, null, null, null, null, null);
	}
	
	/**
	 * Contructor for this class.
	 * @param name the name of the person
	 * @param email the e-mail address of the person
	 * @param telephone the telephone number of the person
	 * @param postalCode the postal code of the person
	 * @param city the city of the person
	 * @param street the street of the person
	 */
	public Person(String name, String email, String telephone, String postalCode,
			String city, String street) {
		this.name = new SimpleStringProperty(name);
		this.email = new SimpleStringProperty(email);
		this.telephone = new SimpleStringProperty(telephone);
		this.postalCode = new SimpleStringProperty(postalCode);
		this.city = new SimpleStringProperty(city);
		this.street = new SimpleStringProperty(street);
	}

	/**
	 * Returns the name of the person.
	 * @return the name of the person
	 */
    public String getName() {
        return name.get();
    }

    /**
     * Sets the name of the person.
     * @param name the name of the person
     */
    public void setName(String name) {
        this.name.set(name);
    }

    /**
     * Returns the name of the person as property.
     * @return the name of the person.
     */
    public StringProperty nameProperty() {
        return name;
    }

	/**
	 * Returns the email of the person.
	 * @return the email of the person
	 */
    public String getEmail() {
        return email.get();
    }

    /**
     * Sets the e-mail address of the person.
     * @param email the e-mail address of the person
     */
    public void setEmail(String email) {
        this.email.set(email);
    }

    /**
     * Returns the e-mail address of the person as property.
     * @return the e-mail address of the person
     */
    public StringProperty emailProperty() {
        return email;
    }
    
	/**
	 * Return the telephone number of the person.
	 * @return the telephone number of the person
	 */
    public String getTelephone() {
        return telephone.get();
    }

    /**
     * Sets the telephone number of the person.
     * @param telephone the telephone number of the person
     */
    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    /**
     * Returns the telephone number of the person as property.
     * @return the telephone number of the person
     */
    public StringProperty telephoneProperty() {
        return telephone;
    }

	/**
	 * Return the postal code of the person.
	 * @return the postal code of the person
	 */
    public String getPostalCode() {
        return postalCode.get();
    }

    /**
     * Sets the postal code of the person.
     * @param postalCode the postal code of the person
     */
    public void setPostalCode (String postalCode) {
        this.postalCode.set(postalCode);
    }

	/**
	 * Return the postal code of the person as property.
	 * @return the postal code of the person
	 */
    public StringProperty postalCodeProperty() {
        return postalCode;
    }

	/**
	 * Return the city of the person.
	 * @return the city of the person
	 */
    public String getCity() {
        return city.get();
    }

    /**
     * Sets the city of the person.
     * @param city the city of the person
     */
    public void setCity(String city) {
        this.city.set(city);
    }

	/**
	 * Return the city of the person as property.
	 * @return the city of the person
	 */
    public StringProperty cityProperty() {
        return city;
    }
    
	/**
	 * Return the street of the person.
	 * @return the street of the person
	 */
    public String getStreet() {
        return street.get();
    }

    /**
     * Sets the street of the person.
     * @param street the street of the person
     */
    public void setStreet(String street) {
        this.street.set(street);
    }

	/**
	 * Return the street of the person as property.
	 * @return the street of the person
	 */
    public StringProperty streetProperty() {
        return street;
    }
 
}
