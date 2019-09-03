package ac.za.cput.adp3.xyzcongolmerate.repository.org.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.Organisation;
import ac.za.cput.adp3.xyzcongolmerate.repository.org.OrganisationRepository;

import java.util.HashSet;
import java.util.Set;

public class OrganisationRepositoryImpl implements OrganisationRepository {

    private Set<Organisation> organisationDB;
    private static OrganisationRepository organisationRepository = null;

    private OrganisationRepositoryImpl() {
        this.organisationDB = new HashSet<>();
    }

    public static OrganisationRepository getOrganisationRepository() {
        if (organisationRepository == null) organisationRepository = new OrganisationRepositoryImpl();
        return organisationRepository;
    }

    //TODO: Implement body
    @Override
    public Organisation create(Organisation organisation) {
        this.organisationDB.add(organisation);
        return organisation;
    }

    //TODO: Implement body
    @Override
    public Organisation read(String orgCode) {
        for(Organisation organisation: this.organisationDB){
            if(organisation.getOrgCode().equals(orgCode))
                return organisation;
        }
        return null;
    }

    //TODO: Implement body
    @Override
    public Organisation update(Organisation organisation) {
        Organisation oldOrg = read(organisation.getOrgCode());
        if(oldOrg != null){
            Organisation newOrg = new Organisation.Builder().copy(organisation).build();

            return newOrg;
        }
        return null;
    }

    //TODO: Implement body
    @Override
    public void delete(String orgCode) {
        this.organisationDB.remove(read(orgCode));
    }

    //TODO: Implement body
    @Override
    public Set<Organisation> getAll() {
        return this.organisationDB;
    }
}
