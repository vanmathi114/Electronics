package Online.Shopping.Platform.Service;

import Online.Shopping.Platform.Entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "payment-service")//
// , url = "http://localhost:8084/api/payments")
public interface PaymentClient {
    @PostMapping
    Payment makePayment(@RequestParam double amount, @RequestParam String currency);

    @GetMapping("/{paymentId}")
    Payment getPayment(@PathVariable("paymentId") String paymentId);
}
