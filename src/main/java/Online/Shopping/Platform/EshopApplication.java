package Online.Shopping.Platform;

import Online.Shopping.Platform.Entity.Role;
import Online.Shopping.Platform.Entity.User;
import Online.Shopping.Platform.Repository.RoleRepository;
import Online.Shopping.Platform.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class EshopApplication {
	public static void main(String[] args) {
		SpringApplication.run(EshopApplication.class, args);

	}

}
