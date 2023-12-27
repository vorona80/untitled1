package ru.vorona.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vorona.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{
}
