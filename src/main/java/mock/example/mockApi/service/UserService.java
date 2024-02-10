package mock.example.mockApi.service;

import java.util.List;

import mock.example.mockApi.model.User;

public interface UserService {
    User setDataUser(User user);
    List<User> getDataUser(String userid);
    void delDataUser(String userid);
}
