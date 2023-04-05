package com.example.register.repository;

import com.example.register.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRepository extends PagingAndSortingRepository<User, Integer> {
}
