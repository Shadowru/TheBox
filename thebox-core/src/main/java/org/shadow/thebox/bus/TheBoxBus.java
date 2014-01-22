package org.shadow.thebox.bus;

import org.shadow.thebox.core.db.repositories.user.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class TheBoxBus {

    private static TheBoxBus boxBus;

    @Autowired
    private ApplicationContext applicationContext;

    public TheBoxBus() {

        boxBus = this;

    }

    public static void sendMessage(String repositoryId, String command, Object entity) {

        JpaRepository asd = (JpaRepository)boxBus.applicationContext.getBean(repositoryId);

        if("save".equals(command))
        {
            asd.saveAndFlush(entity);
        }

    }

}
