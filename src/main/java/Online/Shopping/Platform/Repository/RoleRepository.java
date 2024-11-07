package Online.Shopping.Platform.Repository;

import Online.Shopping.Platform.Entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByName(String name);
}
