package ac.za.cput.adp3.xyzcongolmerate.repository.misc.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.misc.Role;
import ac.za.cput.adp3.xyzcongolmerate.repository.misc.RoleRepository;

import java.util.HashSet;
import java.util.Set;

public class RoleRepositoryImpl implements RoleRepository {

    private Set<Role> roleDB;
    private static RoleRepository roleRepository = null;

    private RoleRepositoryImpl() {
        this.roleDB = new HashSet<>();
    }

    public static RoleRepository getRoleRepository() {
        if (roleRepository == null) roleRepository = new RoleRepositoryImpl();
        return roleRepository;
    }

    //TODO: Implement body
    @Override
    public Role create(Role role) {
        this.roleDB.add(role);
        return role;
    }

    //TODO: Implement body
    @Override
    public Role read(String roleId) {
        for(Role role: this.roleDB){
            if(role.getRoleId().equals(roleId))
                return role;
        }
        return null;
    }

    //TODO: Implement body
    @Override
    public Role update(Role role) {
        Role oldRole = read(role.getRoleId());
        if(oldRole != null){
            Role newRole = new Role.Builder().copy(role).build();

            return newRole;
        }
        return null;
    }

    //TODO: Implement body
    @Override
    public void delete(String roleId) {
        this.roleDB.remove(read(roleId));
    }

    //TODO: Implement body
    @Override
    public Set<Role> getAll() {
        return this.roleDB;
    }
}
