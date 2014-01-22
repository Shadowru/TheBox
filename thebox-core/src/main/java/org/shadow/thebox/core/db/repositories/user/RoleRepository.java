package org.shadow.thebox.core.db.repositories.user;

import org.shadow.thebox.core.db.entities.users.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
}
