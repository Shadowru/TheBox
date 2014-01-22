package org.shadow.thebox.core.db.entities.security;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class PersistableEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Version
    private Long version;
}