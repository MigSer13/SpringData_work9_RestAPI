package ru.geekbrains.market.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.market.model.User;


@Repository
public interface RoleRepository extends CrudRepository<User, Long> {

}
