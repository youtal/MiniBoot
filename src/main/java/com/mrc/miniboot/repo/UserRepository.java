package com.mrc.miniboot.repo;

import com.mrc.miniboot.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
