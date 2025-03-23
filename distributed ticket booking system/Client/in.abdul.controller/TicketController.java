import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.Optional;

@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/")
    public string index(){
     return "index";
    }
    
    

    @PostMapping("/bookTicket")
    public Ticket bookTicket(@RequestBody Customer customer, Model model) {
        Ticket ticketInfo = ticketService.processbookTicket(customer); 
        model.addAtribute("ticket",ticketInfo);
        return "search";
    }

    
    @GetMapping("/getTicket/{ticketId}")
    public string getTicket(@PathVariable Long ticketId, Model model) {
       Ticket ticketInfo =  ticketService.getTicketDetails(ticketId);
       model.addAtribute("ticket",ticketInfo);
       return "search";
    }
}
