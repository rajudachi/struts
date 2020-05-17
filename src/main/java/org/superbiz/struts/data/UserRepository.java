package org.superbiz.struts.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.superbiz.struts.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
