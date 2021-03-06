package dto;

import exception.ServerException;
import static utility.Validator.validateDate;
import static utility.Validator.validateTickets;

public class SearchRequestDTO {
    
    private String origin;
    private String destination;
    private String date;
    private int numberOfTickets;

    public SearchRequestDTO() {
    }

    public SearchRequestDTO(String origin, String date, String numberOfTickets) throws ServerException {
        this.origin = origin;
        this.destination = "";
        this.date = validateDate(date);
        this.numberOfTickets = validateTickets(numberOfTickets);
    }

    public SearchRequestDTO(String origin, String destination, String date, String numberOfTickets) throws ServerException {
        this.origin = origin;
        this.destination = destination;
        this.date = validateDate(date);
        this.numberOfTickets = validateTickets(numberOfTickets);
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
