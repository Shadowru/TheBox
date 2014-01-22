package org.shadow.thebox.core.db.repositories.user;

import org.shadow.thebox.core.db.entities.users.UserOfTheBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface PersonRepository extends JpaRepository<UserOfTheBox, Integer> {
}
