package org.shadow.thebox.core.module.coremodule;

import org.shadow.thebox.bus.TheBoxBus;
import org.shadow.thebox.core.db.entities.modules.ModuleEntity;
import org.shadow.thebox.core.module.impl.TheBoxModuleImpl;

public class CoreModule extends TheBoxModuleImpl {

    public static final int majorVersion = 1;
    public static final int minorVersion = 0;


    public CoreModule(){

    }

    public CoreModule(ModuleEntity moduleInfo) {
        super(moduleInfo);
    }

    @Override
    public boolean installModule() {

        ModuleEntity coreModuleEntity = new ModuleEntity();

        coreModuleEntity.setClassName(this.getClass().getCanonicalName());
        coreModuleEntity.setModulePackage("org.shadow.thebox.core.module.coremodule");

        coreModuleEntity.setMajorVersion(majorVersion);
        coreModuleEntity.setMinorVersion(minorVersion);

        coreModuleEntity.setInstalled(false);

        coreModuleEntity.setModuleID("coremodule");
        coreModuleEntity.setModuleName("Core Module");
        coreModuleEntity.setModuleDescription("Core module for The BOX framework");
        coreModuleEntity.setModuleAuthor("Shadow");

        TheBoxBus.sendMessage("moduleRepository", "save", coreModuleEntity);

        //TODO: Install

        coreModuleEntity.setInstalled(true);
        TheBoxBus.sendMessage("moduleRepository", "save", coreModuleEntity);

        return true;
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
