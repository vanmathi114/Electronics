package Online.Shopping.Platform.Service;

import Online.Shopping.Platform.Entity.Payment;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "payment-service", url = "http://localhost:8084/api/payments")
public interface PaymentClient {

    @PostMapping
    @CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")
    @Retry(name = "paymentRetry", fallbackMethod = "paymentFallback")
    Payment makePayment(@RequestParam double amount, @RequestParam String currency);

    @GetMapping("/{paymentId}")
    @CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")
    @Retry(name = "paymentRetry", fallbackMethod = "paymentFallback")
    Payment getPayment(@PathVariable("paymentId") String paymentId);

    default Payment paymentFallback(double amount, String currency, Throwable throwable) {
        return fallbackResponse();
    }

    default Payment paymentFallback(String paymentId, Throwable throwable) {
        return fallbackResponse();
    }

    private Payment fallbackResponse() {
        Payment fallbackPayment = new Payment();
        fallbackPayment.setStatus("Some issues with payment service");
        return fallbackPayment;
    }
}
