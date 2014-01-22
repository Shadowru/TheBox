package org.shadow.thebox.core.db.entities.modules;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Base class for TheBox Modules
 */

@Entity
public class ModuleEntity {

    @Id
    String moduleID;
    String parentModuleID;

    int parentModuleMinimalMajorVersion;
    int parentModuleMinimalMinorVersion;

    @Column(nullable = false, unique = true)
    String moduleName;

    String moduleDescription;

    boolean active = false;

    int majorVersion;
    int minorVersion;

    String moduleAuthor;
    String commentary;

    @Column(unique = true)
    String className;
    @Column(unique = true)
    String modulePackage;

    boolean installed = false;

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

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getModulePackage() {
        return modulePackage;
    }

    public void setModulePackage(String modulePackage) {
        this.modulePackage = modulePackage;
    }

    public boolean isInstalled() {
        return installed;
    }

    public void setInstalled(boolean installed) {
        this.installed = installed;
    }
}
