package ru.vorona.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vorona.entity.Bill;

@Repository
public interface BillRepository extends CrudRepository<Bill,Long> {
}
