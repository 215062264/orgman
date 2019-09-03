package ac.za.cput.adp3.xyzcongolmerate.repository.demography.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Gender;
import ac.za.cput.adp3.xyzcongolmerate.factory.demography.GenderFactory;
import ac.za.cput.adp3.xyzcongolmerate.repository.demography.GenderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderRepositoryImplTest {

    private GenderRepository repository;
    private Gender gender;

    private Gender getSavedGender(){
        Set<Gender> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository = GenderRepositoryImpl.genderRepository();
        this.gender = GenderFactory.buildGender( "Male");
    }

    @Test
    public void a_create() {
        Gender created = this.repository.create(this.gender);
        System.out.println("Create =" + created);
        Assert.assertEquals(created, this.gender);
        d_getAll();
    }

    @Test
    public void b_read() {
        Gender savedGender = getSavedGender();
        System.out.println("GenderId = "+ savedGender.getGenderId());
        Gender read = this.repository.read(savedGender.getGenderId());
        System.out.println("GenderId  = " + read);
        Assert.assertEquals(savedGender, read);
    }

    @Test
    public void c_update() {
        String newName = "Female";
        Gender gender = new Gender.Builder().copy(getSavedGender()).genderDescription(newName).build();
        System.out.println("Updating gender = " + gender);
        Gender updated = this.repository.update(gender);
        System.out.println("Updated gender = " + updated);
        Assert.assertEquals(newName, updated.getGenderDescription());
    }

    @Test
    public void e_delete() {
        Gender savedGender = getSavedGender();
        this.repository.delete(savedGender.getGenderId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Gender> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
        Assert.assertNotNull(gender);
    }
}