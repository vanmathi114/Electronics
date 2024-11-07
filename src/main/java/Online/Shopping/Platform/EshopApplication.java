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
//	@Bean
//	CommandLineRunner run(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
//		return args -> {
//			Role adminRole = roleRepository.save(new Role("1","admin" ));
//			Role customerRole = roleRepository.save(new Role("2","customer"));
//
//			User admin = new User();
//			admin.setUsername("admin");
//			admin.setPassword(passwordEncoder.encode("password"));
//			admin.setRoles(Set.of(adminRole));
//			userRepository.save(admin);
//
//			User customer = new User();
//			customer.setUsername("customer");
//			customer.setPassword(passwordEncoder.encode("password"));
//			customer.setRoles(Set.of(customerRole));
//			userRepository.save(customer);
//		};
//	}

}
