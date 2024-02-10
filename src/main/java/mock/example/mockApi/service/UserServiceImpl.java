package mock.example.mockApi.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mock.example.mockApi.model.User;
import mock.example.mockApi.repository.UserDb;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDb userDb;

    @Override
    public User setDataUser(User user) {
        // Directly return the saved user
        return userDb.save(user);
    }

    @Override
    public List<User> getDataUser(String userid) {
        if ("all".equalsIgnoreCase(userid)) {
            return userDb.findAll();
        } else {
            try {
                int id = Integer.parseInt(userid);
                Optional<User> user = userDb.findById(id);
                return user.map(List::of).orElseGet(List::of); // Returns a list containing the user or an empty list
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("User ID must be a valid integer", e);
            }
        }
    }

    @Override
    public void delDataUser(String userid) {
        if (userid != null && userid.matches("\\d+")) {
            int id = Integer.parseInt(userid);
            userDb.deleteById(id);
        } else {
            throw new IllegalArgumentException("Invalid userid: " + userid);
        }
    }
}
