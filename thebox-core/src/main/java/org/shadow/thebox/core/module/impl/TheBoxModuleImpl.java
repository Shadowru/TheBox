package org.shadow.thebox.core.module.impl;

import org.shadow.thebox.core.db.entities.modules.ModuleEntity;
import org.shadow.thebox.core.module.intf.TheBoxModule;
import org.shadow.thebox.core.module.repository.TheBoxModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public abstract class TheBoxModuleImpl implements TheBoxModule {

    private ModuleEntity moduleInfo;

    public TheBoxModuleImpl(ModuleEntity moduleInfo) {
        this.moduleInfo = moduleInfo;
    }

    protected TheBoxModuleImpl() {
        this.moduleInfo = null;
    }

    @Override
    public String getModuleName() {
        return moduleInfo.getModuleName();
    }

    @Override
    public String moduleDescription() {
        return moduleInfo.getModuleDescription();
    }

    @Override
    public int getModuleMajorVersion() {
        return moduleInfo.getMajorVersion();
    }

    @Override
    public int getModuleMinorVersion() {
        return moduleInfo.getMinorVersion();
    }

    @Override
    public String getModuleAuthor() {
        return moduleInfo.getModuleAuthor();
    }

    @Override
    public String getModuleCommentary() {
        return moduleInfo.getCommentary();
    }

}
