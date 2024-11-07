package Online.Shopping.Platform.Service;

import Online.Shopping.Platform.Entity.Payment;
import Online.Shopping.Platform.Exception.ProductNotFound;
import Online.Shopping.Platform.Exception.DatabaseOperationException;
import Online.Shopping.Platform.Repository.SmartphoneRepository;
import Online.Shopping.Platform.Entity.Smartphone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private SmartphoneRepository smartphoneRepository;
    private final PaymentClient paymentClient;

    @Autowired
    public ProductService(PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    public Payment purchaseSmartphone(Double amount, String currency) {
        Payment payment = paymentClient.makePayment(amount, currency);
        return payment;
    }

    public Payment getPayment(String paymentId) {
        return paymentClient.getPayment(paymentId);
    }


    public Smartphone addSmartphone(Smartphone smartphone) {
        try {
            return smartphoneRepository.save(smartphone);
        } catch (Exception e) {
            throw new DatabaseOperationException("Unexpected error occurred while saving the smartphone", e);
        }
    }

    public List<Smartphone> getAllSmartphone() {
        return smartphoneRepository.findAll();
    }

    public Smartphone findSmartPhoneById(String Id) {

        return smartphoneRepository.findById(Id).
                orElseThrow(() -> new ProductNotFound("Smartphone with ID " + Id + " not found"));
    }

    public void updateCost(String id, double newCost) {
        Smartphone smartphone = smartphoneRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));
        smartphone.setCost(newCost);
        try {
            smartphoneRepository.save(smartphone);
        } catch (Exception e) {
            throw new DatabaseOperationException("Unexpected error occurred while saving the smartphone", e);
        }
    }
}
