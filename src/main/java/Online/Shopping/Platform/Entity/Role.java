package Online.Shopping.Platform.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Set;

@Document(collection = "roles")
@Setter
@Getter
@AllArgsConstructor
public class Role {
    @Id
    private String id;
    private String name;

}
