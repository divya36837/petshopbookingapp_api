package com.petshop.petshopbookingapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.petshop.petshopbookingapi.model.User;




@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	void deleteById(Integer id);

	

}
