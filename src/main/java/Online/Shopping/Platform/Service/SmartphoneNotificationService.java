package Online.Shopping.Platform.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SmartphoneNotificationService {

    @KafkaListener(topics = "BuyNotification", groupId = "csdmb2ui97cvlh2mip1g")
    public void listenToPurchaseNotifications(String message) {
        System.out.println("Received notification: " + message);
        // Handle notification (e.g., update inventory, alert user)
    }
}
