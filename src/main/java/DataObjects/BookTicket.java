package DataObjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookTicket {
    private String departDate;
    private String departFrom;
    private String arriveAt;
    private String seatType;
    private int ticketAmount;
}