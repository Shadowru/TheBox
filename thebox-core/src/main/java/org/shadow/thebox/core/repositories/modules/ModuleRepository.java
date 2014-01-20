package org.shadow.thebox.core.repositories.modules;

import org.shadow.thebox.core.entities.modules.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, String> {

}
