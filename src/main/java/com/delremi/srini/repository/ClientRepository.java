package com.delremi.srini.repository;

import com.delremi.srini.model.Client;
import com.delremi.srini.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findAllByCreatedBy(User user);
}
