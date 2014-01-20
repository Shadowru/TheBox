package org.shadow.thebox.core.repositories;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shadow.thebox.core.entities.modules.Module;
import org.shadow.thebox.core.entities.users.Role;
import org.shadow.thebox.core.entities.users.UserOfTheBox;
import org.shadow.thebox.core.repositories.modules.ModuleRepository;
import org.shadow.thebox.core.repositories.user.PersonRepository;
import org.shadow.thebox.core.repositories.user.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.history.Revision;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-repositories-tests.xml")

public class RespositoriesTests {

    @Autowired
    protected ApplicationContext ac;


    @Test
    public void testRepositories() {

        Object testObject = ac.getBean("personRepository");

        Assert.assertNotNull("Person repository bean not null", testObject);

        PersonRepository personRepository = (PersonRepository) testObject;

        testObject = ac.getBean("roleRepository");

        Assert.assertNotNull("Role repository bean not null", testObject);

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

        Role role1 = new Role();
        role1.setRoleName("admin");

        Role role2 = new Role();
        role2.setRoleName("user");

        Role role3 = new Role();
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

        ArrayList<Role> roles = new ArrayList<Role>();

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

        for (Role role : user.getRoles()) {
            System.out.println(role.getRoleID() + " : " +  role.getRoleName());
        }

        Assert.assertEquals("Check for saved roles" ,2,  user.getRoles().size());

        /*
        Revision<Integer, UserOfTheBox> revision = personRepository.findLastChangeRevision(userID);

        System.out.println("revision = " + revision);
        System.out.println("revision.getRevisionNumber() = " + revision.getRevisionNumber());
        System.out.println("revision.getRevisionDate() = " + revision.getRevisionDate());
        */
        testObject = ac.getBean("moduleRepository");

        Assert.assertNotNull("Module repository bean not null", testObject);

        ModuleRepository moduleRepository = (ModuleRepository) testObject;

        Module m = new Module();

        m.setModuleID("userModule");
        m.setModuleName("");

        moduleRepository.saveAndFlush(m);

        Assert.assertEquals("Check for module", 1, moduleRepository.findAll().size());


    }

}
