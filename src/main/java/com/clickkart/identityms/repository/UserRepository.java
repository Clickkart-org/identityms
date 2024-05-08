package com.clickkart.identityms.repository;

import com.clickkart.identityms.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
