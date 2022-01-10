package br.com.springboot.controller;

import br.com.springboot.model.User;
import br.com.springboot.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Api("value=API REST Users")
@CrossOrigin(origins = "*")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna usuario referente ao id passado como parametro")
    public User user(@PathVariable("id") Long id){

        Optional<User> userFind = this.userRepository.findById(id);

        if (userFind.isPresent()){
            return userFind.get();
        }
        return null;
    }

    @GetMapping("/list")
    @ApiOperation(value = "Retorna uma lista de usuarios")
    public List<User> list(){
        return this.userRepository.findAll();
    }

    @GetMapping("/list/{id}")
    @ApiOperation(value = "Retorna uma lista de usuario em que o id seja maior que o passado como parametro")
    public List<User> listMoreThan(@PathVariable("id") Long id){
        return this.userRepository.findByIdGreaterThan(id);
    }

    @PostMapping("/")
    @ApiOperation(value = "Cadastra um novo usuario")
    public User user(@RequestBody User user){
        return this.userRepository.save(user);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Atualiza um usuario")
    public User userUpdate(@RequestBody User user){
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um usuario")
    public ResponseEntity deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
