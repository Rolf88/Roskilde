package domain.exceptions;

public class TicketNotFoundException extends Exception {

    public TicketNotFoundException(String ticketCode) {
        super("Ticket with code {" + ticketCode + "} was not found");
    }

}
