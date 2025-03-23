import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class TicketController {

    private Map<String, Ticket> ticketDatabase = new HashMap<>();

 
    @PostMapping(
                  value = "/book",
                  consumes = {"application/json","application/xml"}, 
                  produces = { "application/json","application/xml"}
    )
    public Ticket bookTicket(@RequestBody Customer customer) {
        
        Random r = new Random();
        int ticketId = r.nextInt();
        
        Ticket ticket = new Ticket();

        ticket.setTicketId(ticketId);
        ticket.setFrom(customer.getFrom());
        ticket.setTo(customer.getTo());
        ticket.setTrainnum(customer.getTrainnum());
        ticket.setStatus("Confirmed");
        ticket.setTicketCost(500.0);  // Example cost, could be dynamically calculated

      
        ticketDatabase.put(ticketId, ticket);
        
        return ticket;
    }

    
    @GetMapping(
                value    = "/ticket/{ticketId}",
                produces = {"application/json","application/xml"}
    )
    public ResponseEntity<Ticket> getTicket(@PathVariable String ticketId) {
        Ticket ticket = ticketDatabase.get(ticketId);
        
        if (ticket != null) {
            return ResponseEntity.ok(ticket,HttpStatus.OK);  
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  
        }
    }
}
