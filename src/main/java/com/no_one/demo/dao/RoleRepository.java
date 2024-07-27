package com.no_one.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.no_one.demo.model.Role;
import com.no_one.demo.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
