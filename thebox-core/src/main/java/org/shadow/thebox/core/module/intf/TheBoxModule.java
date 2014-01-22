package org.shadow.thebox.core.module.intf;

public interface TheBoxModule {

    public String getModuleName();

    public String moduleDescription();

    public int getModuleMajorVersion();

    public int getModuleMinorVersion();

    public String getModuleAuthor();

    public String getModuleCommentary();

    public boolean installModule();

    public boolean upgradeModule();

    public boolean init();

}
