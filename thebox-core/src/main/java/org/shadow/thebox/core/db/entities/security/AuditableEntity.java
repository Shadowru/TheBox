package org.shadow.thebox.core.db.entities.security;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@EntityListeners({AuditEntityListener.class})
public class AuditableEntity implements Serializable {


}
