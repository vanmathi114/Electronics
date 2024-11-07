package Online.Shopping.Platform.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Smartphone extends Product {
    public Smartphone(String id, String name, int stock, double cost, String model) {
        super(id, name, stock, cost, model);
    }
}
