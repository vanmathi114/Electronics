package Online.Shopping.Platform.Controller;

import Online.Shopping.Platform.Entity.Smartphone;
import Online.Shopping.Platform.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.net.URI;

@RestController
@RequestMapping("/api")
public class SmartPhoneController {

    @Autowired
    private ProductService smartPhoneService;

    @GetMapping("/catagories")
    public ResponseEntity<List<String>> getAllCatagory() {
            List<String> catagoryList= Arrays.asList("Electronics", "HomeAppliances", "Smartgadgets");
            return ResponseEntity.ok(catagoryList);
    }

    // Get all smartphones
    @GetMapping("/smartphones")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<List<Smartphone>> getAllSmartphones() {
        try{
            List<Smartphone> smartPhones=smartPhoneService.getAllSmartphone();
            if(smartPhones.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(smartPhones);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get a specific smartphone by ID
    @GetMapping("/smartphones/{id}")
    public ResponseEntity<Smartphone> getSmartphoneById(@PathVariable String id) {
        Smartphone smartphone=smartPhoneService.findSmartPhoneById(id);
        if(smartphone==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(smartphone);
    }


    // Add a new smartphone
    @PostMapping("/smartphones")
    public ResponseEntity<Smartphone> addSmartphone(@RequestBody Smartphone smartPhone) {
        try {
            Smartphone smartphone=smartPhoneService.addSmartphone(smartPhone);
            URI uri = URI.create("/api/smartphones/" + smartphone.getId());
            return ResponseEntity.ok(smartphone);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update the cost of a smartphone (for admin use)
    @PutMapping("/smartphones/{id}/update-cost")
    public void updateSmartphoneCost(@PathVariable String id, @RequestParam Double cost) {
        smartPhoneService.updateCost(id, cost);
    }

    // Purchase a smartphone (this involves making a payment through the Payment microservice)
    @PostMapping("/smartphones/purchase")
    public ResponseEntity<String> purchaseSmartphone(@RequestParam Double amount, @RequestParam String currency) {
        return ResponseEntity.ok(smartPhoneService.purchaseSmartphone(amount, currency).toString());
    }
    
    // Get payment details (test the connection with PaymentService)
    @GetMapping("/smartphones/payment/{id}")
    public ResponseEntity<String> getPayment(@PathVariable String id) {
        return ResponseEntity.ok(smartPhoneService.getPayment(id).toString());
    }
}
