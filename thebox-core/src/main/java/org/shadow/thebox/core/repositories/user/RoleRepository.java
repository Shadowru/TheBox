package org.shadow.thebox.core.repositories.user;

import org.shadow.thebox.core.entities.users.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
