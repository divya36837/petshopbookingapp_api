package com.petshop.petshopbookingapi.controller;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.petshopbookingapi.dao.UserRepository;
import com.petshop.petshopbookingapi.model.User;










@RestController
public class Usercontroller {
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("users/save") //Insert User
	public User save(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}
	
	@DeleteMapping("users/{id}") //Delete User
	public void delete(@PathVariable("id") Integer id) {
		userRepository.deleteById(id);
	}
	@PutMapping("users/{id}")//Update User Data
	public void update(@PathVariable("id")Integer id,@RequestBody User user){
			user.setId(id);
	        userRepository.save(user);
	}
          
    @GetMapping("users/listUser") //list user
    public List<User>findAll(){
    	List<User> listUser=userRepository.findAll();
    	return listUser;
    }
    @GetMapping("User/{id}")
	 public User findById(@PathVariable("id") Integer id) {
		 Optional<User>  user=userRepository.findById(id);
		 if(user.isPresent()) {
			 User obj=user.get();
			 return obj;
		 }
		 else {
			 return null;
			
		 }
	 }
	
	
	
}
    
	
	
	
	
	
	
	
	


