package valent.com.springboot.service;

import valent.com.springboot.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    public  void change(User user);

    List<User> listUsers();

    User getUserById(long id);

    void delete(long id);

}
