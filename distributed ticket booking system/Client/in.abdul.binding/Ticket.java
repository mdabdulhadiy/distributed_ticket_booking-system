import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // Enables XML binding
@Data           // Getters and Setters and tostring()
public class Ticket {
    private String ticketId;
    private String from;
    private String to;
    private String trainnum;
    private String status;
    private double ticketCost;
}
