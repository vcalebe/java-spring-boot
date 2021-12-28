package br.com.springboot.repository;

import br.com.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByIdGreaterThan(Long id);

    public List<User> removeById(Long id);
}