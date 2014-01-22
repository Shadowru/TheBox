package org.shadow.thebox.core.module.repository;

import org.shadow.thebox.core.db.entities.modules.ModuleEntity;
import org.shadow.thebox.core.db.repositories.modules.ModuleRepository;
import org.shadow.thebox.core.module.intf.TheBoxModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TheBoxModuleRepository {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ModuleRepository moduleRepository;

    public TheBoxModule getModule(String moduleID) {

        ModuleEntity me = moduleRepository.findByID(moduleID);

        //TODO: Init modules

        return null;
    }

    public TheBoxModuleRepository() {

    }


    public void initModules(){

        List<ModuleEntity> me = moduleRepository.findAll();

        for (ModuleEntity moduleEntity : me) {
            //moduleEntity
        }


    }

}
