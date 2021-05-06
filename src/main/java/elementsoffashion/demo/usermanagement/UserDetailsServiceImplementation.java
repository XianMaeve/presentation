package elementsoffashion.demo.usermanagement;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;


import javax.annotation.Resource;
import java.util.Optional;

public class UserDetailsServiceImplementation implements UserDetailsService {

    @Resource
    UserRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user;
        Optional<User> existingUser = userRepo.findByUsername(username);
        if (!existingUser.isPresent()) {
            throw new UsernameNotFoundException("Could not find that dripper");
        }
        user = existingUser.get();

        UserBuilder builder;
        builder = org.springframework.security.core.userdetails.User.withUsername(username);
        builder.password(user.getPassword());
        builder.roles(user.getRole());

        return builder.build();
    }
}
