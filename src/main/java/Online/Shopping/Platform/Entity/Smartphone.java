package Online.Shopping.Platform.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@Document(collection = "Smartphones")
public class Smartphone extends Product {
    public Smartphone(String id, String name, int stock, double cost, String model) {
        super(id, name, stock, cost, model);
    }
}
