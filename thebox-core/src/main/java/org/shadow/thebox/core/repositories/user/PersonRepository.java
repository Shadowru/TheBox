package org.shadow.thebox.core.repositories.user;

import org.shadow.thebox.core.entities.users.UserOfTheBox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<UserOfTheBox, Integer> {
}
