package org.shadow.thebox.core.db.repositories;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shadow.thebox.core.db.entities.modules.ModuleEntity;
import org.shadow.thebox.core.db.entities.users.RoleEntity;
import org.shadow.thebox.core.db.entities.users.UserOfTheBox;
import org.shadow.thebox.core.db.repositories.modules.ModuleRepository;
import org.shadow.thebox.core.db.repositories.user.PersonRepository;
import org.shadow.thebox.core.db.repositories.user.RoleRepository;
import org.shadow.thebox.core.module.intf.TheBoxModule;
import org.shadow.thebox.core.module.repository.TheBoxModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-repositories-tests.xml")

public class RespositoriesTests {

    @Autowired
    protected ApplicationContext ac;

    @Autowired
    protected EntityManagerFactory emf;

    protected EntityManager em;

    @Before
    public void init(){

        em = emf.createEntityManager();

    }

    @Test
    @Transactional
    public void testRepositories() {

        Object testObject = ac.getBean("personRepository");

        Assert.assertNotNull("Person repository bean not null", testObject);

        PersonRepository personRepository = (PersonRepository) testObject;

        testObject = ac.getBean("roleRepository");

        Assert.assertNotNull("RoleEntity repository bean not null", testObject);

        RoleRepository roleRepository = (RoleRepository) testObject;

        UserOfTheBox tbu = new UserOfTheBox();

        tbu.setLogin("amber");
        tbu.setPwdHash("123");

        personRepository.save(tbu);

        int userID = tbu.getUserID();

        tbu = new UserOfTheBox();
        tbu.setLogin("amber2");
        tbu.setPwdHash("123");

        personRepository.save(tbu);

        personRepository.flush();


        boolean is_exception = false;

        try {

            tbu = new UserOfTheBox();
            tbu.setLogin("amber2");
            tbu.setPwdHash("123");

            personRepository.save(tbu);

            personRepository.flush();

        } catch (Exception e) {
            is_exception = true;
        }

        Assert.assertTrue("Check for unique user name", is_exception);

        long no_of_user = personRepository.count();

        Assert.assertEquals(2, no_of_user);

        UserOfTheBox user = personRepository.findOne(userID);

        Assert.assertNotNull(user);

        RoleEntity role1 = new RoleEntity();
        role1.setRoleName("admin");

        RoleEntity role2 = new RoleEntity();
        role2.setRoleName("user");

        RoleEntity role3 = new RoleEntity();
        role3.setRoleName("admin");

        roleRepository.save(role1);

        roleRepository.save(role2);

        is_exception = false;

        try {
            roleRepository.save(role3);
        } catch (Exception e) {
            is_exception = true;
        }


        Assert.assertTrue("Check for unique role name", is_exception);

        ArrayList<RoleEntity> roles = new ArrayList<RoleEntity>();

        roles.add(role1);
        roles.add(role2);

        user.setRoles(roles);

        personRepository.saveAndFlush(user);

        roles.add(role3);

        is_exception = false;

        try {
            personRepository.saveAndFlush(user);
        } catch (Exception e) {
            is_exception = true;
        }


        Assert.assertTrue("Check for inexists role name", is_exception);

        user = personRepository.findOne(userID);

        for (RoleEntity role : user.getRoles()) {
            System.out.println(role.getRoleID() + " : " +  role.getRoleName());
        }

        Assert.assertEquals("Check for saved roles" ,2,  user.getRoles().size());

        role3.setRoleName("guest");

        roleRepository.saveAndFlush(role3);

        user.getRoles().add(role3);

        personRepository.saveAndFlush(user);

        testObject = ac.getBean("moduleRepository");

        Assert.assertNotNull("ModuleEntity repository bean not null", testObject);

        ModuleRepository moduleRepository = (ModuleRepository) testObject;

        ModuleEntity m = new ModuleEntity();

        m.setBeanName("rootModule");
        m.setModuleID("rootModule");
        m.setModuleName("");

        moduleRepository.saveAndFlush(m);

        Assert.assertEquals("Check for module", 1, moduleRepository.findAll().size());


        TheBoxModuleRepository tbmr = (TheBoxModuleRepository)ac.getBean("theBoxModuleRepository");

        TheBoxModule tbm = tbmr.getModule("rootModule");

        System.out.println("tbm.getModuleMajorVersion() = " + tbm.getModuleMajorVersion());


    }

}
