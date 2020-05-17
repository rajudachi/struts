package org.superbiz.struts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.superbiz.struts.data.UserRepository;
import org.superbiz.struts.model.User;

@SpringBootApplication
@EntityScan("org.superbiz.struts.model")
@EnableJpaRepositories("org.superbiz.struts.data")
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner checkDB(UserRepository repository) {
        return (args) -> {
            // save a few customers
            log.info("Customers Save default");
            repository.save(new User(9999,"Jack", "Bauer"));
        };
    }

//    @Bean
//    public UserRepository userRepository() {
//        return new UserRepository() {
//            @Override
//            public <S extends User> S save(S s) {
//
//                return save(s);
//            }
//
//            @Override
//            public <S extends User> Iterable<S> saveAll(Iterable<S> iterable) {
//                return saveAll(iterable);
//            }
//
//            @Override
//            public Optional<User> findById(Long aLong) {
//
//                return findById(aLong);
//            }
//
//            @Override
//            public boolean existsById(Long aLong) {
//                return existsById(aLong);
//            }
//
//            @Override
//            public Iterable<User> findAll() {
//
//                return findAll();
//            }
//
//            @Override
//            public Iterable<User> findAllById(Iterable<Long> iterable) {
//
//                return findAllById(iterable);
//            }
//
//            @Override
//            public long count() {
//
//                return count();
//            }
//
//            @Override
//            public void deleteById(Long aLong) {
//                deleteById(aLong);
//            }
//
//            @Override
//            public void delete(User user) {
//                delete(user);
//            }
//
//            @Override
//            public void deleteAll(Iterable<? extends User> iterable) {
//                deleteAll(iterable);
//            }
//
//            @Override
//            public void deleteAll() {
//                deleteAll();
//            }
//        };
//    }

}


