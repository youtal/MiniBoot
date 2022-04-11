package com.mrc.miniboot.repo;

import com.mrc.miniboot.entity.users.Keeper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeeperRepository extends JpaRepository<Keeper, String> {
}
