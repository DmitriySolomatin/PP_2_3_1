package ru.dsolo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dsolo.dao.UserDao;
import ru.dsolo.model.User;
import ru.dsolo.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;


    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(long id) {
        return userRepository.getReferenceById(id);
    }

    public List<User> getUserList(int count) {
        return userRepository.findAll(PageRequest.of(0,count)).stream().toList();
    }

    @Transactional
    public void deleteUser(long id) {
        userRepository.delete(getUserById(id));
    }

    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
