package org.shadow.thebox.core.db.entities.security;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditEntityListener {

    @PrePersist
    public void prePersist(Object object){

        System.out.println("PrePersist object = " + object);

    }

    @PreUpdate
    public void preUpdate(Object object){

        System.out.println("PreUpdate object = " + object);

    }

}
