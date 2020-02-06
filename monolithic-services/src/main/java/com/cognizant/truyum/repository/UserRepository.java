package com.cognizant.truyum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	
	@Query("From Users u where u.userName like :userName")
	 Users findByUserName(String userName);
	

	@Query("select u.menuItemList from Users u where u.userName=:userName")
	List<MenuItem> getMenuItems(String userName)  throws CartEmptyException;
	
	@Query("select sum(m.price) from Users u join u.menuItemList m where u.userName=:userName")
	Double getCartTotal(String userName)throws CartEmptyException;

}
