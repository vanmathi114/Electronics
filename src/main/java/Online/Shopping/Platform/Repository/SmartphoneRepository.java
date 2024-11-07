package Online.Shopping.Platform.Repository;

import Online.Shopping.Platform.Entity.Smartphone;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SmartphoneRepository extends MongoRepository<Smartphone, String> {}
