package Online.Shopping.Platform.Controller;

import Online.Shopping.Platform.Entity.Payment;
import Online.Shopping.Platform.Entity.Smartphone;
import Online.Shopping.Platform.Service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class SmartPhoneControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductService smartPhoneService;

    @InjectMocks
    private SmartPhoneController smartPhoneController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(smartPhoneController).build();
    }

    @Test
    void testGetAllSmartphones() throws Exception {
        Smartphone smartphone1 = new Smartphone("1", "Vivi", 5,20000, "v5" );
        Smartphone smartphone2 = new Smartphone("2", "Samsung", 2, 35000, "S7");
        List<Smartphone> smartphones = Arrays.asList(smartphone1, smartphone2);

        when(smartPhoneService.getAllSmartphone()).thenReturn(smartphones);

        ResponseEntity<List<Smartphone>> response = smartPhoneController.getAllSmartphones();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(smartphones, response.getBody());
    }

    @Test
    void testGetSmartphoneById() throws Exception {
        Smartphone smartphone = new Smartphone("1", "Vivi", 5,20000, "v5" );
        when(smartPhoneService.findSmartPhoneById("1")).thenReturn(smartphone);

        ResponseEntity<Smartphone> response = smartPhoneController.getSmartphoneById("1");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(smartphone, response.getBody());
    }

    @Test
    void testGetSmartphoneByIdNotFound() throws Exception {
        when(smartPhoneService.findSmartPhoneById("nonexistent")).thenReturn(null);

        ResponseEntity<Smartphone> response = smartPhoneController.getSmartphoneById("nonexistent");
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testAddSmartphone() throws Exception {
        Smartphone smartphone = new Smartphone("1", "Vivi", 5,20000, "v5" );
        when(smartPhoneService.addSmartphone(any(Smartphone.class))).thenReturn(smartphone);

        ResponseEntity<Smartphone> response = smartPhoneController.addSmartphone(smartphone);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(smartphone, response.getBody());
    }

    @Test
    void testUpdateSmartphoneCost() throws Exception {
        doNothing().when(smartPhoneService).updateCost(anyString(), anyDouble());
        smartPhoneController.updateSmartphoneCost("1", 79900.0);
    }

    @Test
    void testPurchaseSmartphone() throws Exception {
        String purchaseResponse = "Purchase successful";
        Payment payment=new Payment(10000.0,"INR", "COMPLETE");
        when(smartPhoneService.purchaseSmartphone(anyDouble(), anyString())).thenReturn(payment);
        ResponseEntity<String> response = smartPhoneController.purchaseSmartphone(699.99, "USD");
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
