package Online.Shopping.Platform.Entity;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private double amount;
    private String currency;
    private String status;
}
