package org.shadow.thebox.core.db.repositories.modules;

import org.shadow.thebox.core.db.entities.modules.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<ModuleEntity, String> {

    ModuleEntity findByModuleID(String moduleID);

}
