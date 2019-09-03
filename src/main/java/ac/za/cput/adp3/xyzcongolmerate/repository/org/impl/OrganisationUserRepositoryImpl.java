package ac.za.cput.adp3.xyzcongolmerate.repository.org.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.OrganisationUser;
import ac.za.cput.adp3.xyzcongolmerate.repository.org.OrganisationUserRepository;

import java.util.HashSet;
import java.util.Set;

public class OrganisationUserRepositoryImpl implements OrganisationUserRepository {

    private Set<OrganisationUser> organisationUserDB;
    private static OrganisationUserRepository organisationUserRepository = null;

    private OrganisationUserRepositoryImpl() {
        this.organisationUserDB = new HashSet<>();
    }

    public static OrganisationUserRepository getOrganisationUserRepository() {
        if (organisationUserRepository == null) organisationUserRepository = new OrganisationUserRepositoryImpl();
        return organisationUserRepository;
    }

    private OrganisationUser findOU(String ou) {
        return this.organisationUserDB.stream()
                .filter(org -> org.getUserEmail().trim().equals(ou))
                .findAny()
                .orElse(null);
    }

    //TODO: Implement body
    @Override
    public OrganisationUser create(OrganisationUser organisationUser) {
        this.organisationUserDB.add(organisationUser);
        return organisationUser;
    }

    //TODO: Implement body
    @Override
    public OrganisationUser read(String orgCode, String userEmail) {
        OrganisationUser organisationUser = findOU(userEmail);
        return organisationUser;
    }

    //TODO: Implement body
    @Override
    public OrganisationUser update(OrganisationUser organisationUser) {
        OrganisationUser toDelete = findOU(organisationUser.getUserEmail());
        if (toDelete != null) {
            this.organisationUserDB.remove(toDelete);
            return create(organisationUser);
        }
        return null;
    }

    //TODO: Implement body
    @Override
    public void delete(String orgCode, String userEmail) {
        OrganisationUser race = findOU(userEmail);
        if (race != null) this.organisationUserDB.remove(race);
    }

    //TODO: Implement body
    @Override
    public Set<OrganisationUser> getAll() {
        return this.organisationUserDB;
    }


}
