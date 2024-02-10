package mock.example.mockApi.repository;

import org.springframework.stereotype.Repository;

import mock.example.mockApi.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserDb extends JpaRepository<User, Integer> {
    List<User> findAll();
    Optional<User> findById(Integer userId);
}
