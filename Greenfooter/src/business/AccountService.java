package business;

import data.AccountRepository;
import data.TicketRepository;
import domain.Account;
import domain.exceptions.TicketNotFoundException;

public class AccountService {

    private final AccountRepository accountRepository;
    private final TicketRepository ticketRepository;

    public AccountService() {
        this.accountRepository = new AccountRepository();
        this.ticketRepository = new TicketRepository();
    }

    public void add(Account account) throws TicketNotFoundException {
        if (!this.ticketRepository.containsTicket(account.getTicketCode())) {
            throw new TicketNotFoundException(account.getTicketCode());
        }

        this.accountRepository.add(account);
    }
}
