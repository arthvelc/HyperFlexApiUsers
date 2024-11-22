package com.hyperflex.hyperflex_user_api.persistence.repository;


import com.hyperflex.hyperflex_user_api.persistence.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByUserNameIgnoreCase(String userName);
}
