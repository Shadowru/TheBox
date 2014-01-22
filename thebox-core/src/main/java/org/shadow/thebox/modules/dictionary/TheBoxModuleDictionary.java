package org.shadow.thebox.modules.dictionary;

import org.shadow.thebox.core.db.entities.modules.ModuleEntity;
import org.shadow.thebox.core.module.impl.TheBoxModuleImpl;

public class TheBoxModuleDictionary extends TheBoxModuleImpl {

    public TheBoxModuleDictionary(ModuleEntity moduleInfo) {
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

        return true;

    }
}
