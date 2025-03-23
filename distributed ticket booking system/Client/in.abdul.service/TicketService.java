import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TicketService {

  private static final PROVIDER_ENDPOINT_1 = "url";
  private static final PROVIDER_ENDPOINT_2 = "url/{ticketId}";

  public Ticket processBookTicket(Customer customer) {

    RestTemplate rt = new RestTemplate();
    
    ResponseEntity<Ticket> responseEntity = 
                     rt.postForEntity(PROVIDER_ENDPOINT,passenger,Ticket.class);

    int statuscode = responseEntity.getStatusCodeValue();
    
   if(statuscode == 200){
        Ticket ticket =  responseEntity.getBody();
        return ticket;
   }
   return null;
  }


  public Ticket getTicket(string ticketId) {

        RestTemplate restTemplate = new RestTemplate();
        
        ResponseEntity<Ticket> responseEntity 
                        = rt.getForEntity(PROVIDER_ENDPOINT_2, Ticket.class, ticketId);

        if (responseEntity.getStatusCodeValue() == 200) {
           Ticket ticket =  responseEntity.getBody();
           return ticket;
        }
        
        return null; 
    }
   
}
