package org.shadow.thebox.core.module.coremodule;

import org.shadow.thebox.core.db.entities.modules.ModuleEntity;
import org.shadow.thebox.core.module.impl.TheBoxModuleImpl;

public class CoreModule extends TheBoxModuleImpl {

    public CoreModule(ModuleEntity moduleInfo) {
        super(moduleInfo);
    }

    @Override
    public boolean installModule() {
       return false;
    }

    @Override
    public boolean upgradeModule() {
        return false;
    }

    @Override
    public boolean init() {
        return false;
    }
}
