package org.shadow.thebox.core.entities.modules;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *  Base class for TheBox Modules
 */
@Entity
public class Module {

    @Id
    String moduleID;

    String parentModuleID;
    int  parentModuleMinimalMajorVersion;
    int parentModuleMinimalMinorVersion;

    @Column(nullable = false, unique = true)
    String moduleName;

    String moduleDescription;

    boolean active = false;

    int majorVersion;
    int minorVersion;

    String moduleAuthor;
    String comment;

    public String getModuleID() {
        return moduleID;
    }

    public void setModuleID(String moduleID) {
        this.moduleID = moduleID;
    }

    public String getParentModuleID() {
        return parentModuleID;
    }

    public void setParentModuleID(String parentModuleID) {
        this.parentModuleID = parentModuleID;
    }

    public int getParentModuleMinimalMajorVersion() {
        return parentModuleMinimalMajorVersion;
    }

    public void setParentModuleMinimalMajorVersion(int parentModuleMinimalMajorVersion) {
        this.parentModuleMinimalMajorVersion = parentModuleMinimalMajorVersion;
    }

    public int getParentModuleMinimalMinorVersion() {
        return parentModuleMinimalMinorVersion;
    }

    public void setParentModuleMinimalMinorVersion(int parentModuleMinimalMinorVersion) {
        this.parentModuleMinimalMinorVersion = parentModuleMinimalMinorVersion;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setModuleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }

    public String getModuleAuthor() {
        return moduleAuthor;
    }

    public void setModuleAuthor(String moduleAuthor) {
        this.moduleAuthor = moduleAuthor;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
