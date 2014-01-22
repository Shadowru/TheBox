package org.shadow.thebox.modules.users;

import org.shadow.thebox.core.db.entities.modules.ModuleEntity;
import org.shadow.thebox.core.module.impl.TheBoxModuleImpl;

/**
 * Created by Shadow on 22.01.14.
 */
public class UsersModule extends TheBoxModuleImpl {

    public UsersModule(ModuleEntity moduleInfo) {
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
