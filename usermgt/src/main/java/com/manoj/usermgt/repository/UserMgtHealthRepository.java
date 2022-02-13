package com.manoj.usermgt.repository;

import com.manoj.usermgt.model.UserMgtHealth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMgtHealthRepository extends CrudRepository<UserMgtHealth, Long> {

	UserMgtHealth findByHealthId(long healthId);

}
