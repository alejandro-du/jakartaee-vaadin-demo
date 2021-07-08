package com.example.app;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;

@Repository
public interface UserRepository extends EntityRepository<User, Integer> {

    List<User> findByEmailLike(String email);

}
