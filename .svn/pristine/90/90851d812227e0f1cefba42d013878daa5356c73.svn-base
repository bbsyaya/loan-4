package com.hrbb.loan.web.security.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hrbb.loan.web.security.entity.HrbbUserDetails;

import java.util.List;
import java.util.Map;

/**
 * Provides user information for user role verification
 */
public interface HrbbUserDetailsService {

    /**
     * Check if the user has administrative role assigned in UUMS
     *
     * @return true/false
     */
    boolean isUserAdmin(String userName);

    /**
     * Return user with details
     * @param userName the name of user
     * @return user preference
     * @throws IrisUsernameNotFoundException
     */
    HrbbUserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;

    /**
     * Print out all users available in UUMS
     */
    Map<String,String> listUsers();
    
    /**
     * Print out list of privileges granted to the user
     *
     * @param userName   Owner of privileges
     * @param type       Type of privilege (UUMS/UACN)
     * @throws IrisUsernameNotFoundException
     */
    List<String> listPrivilegesByUser(String userName, String type) throws UsernameNotFoundException;

    /**
     * Print out list of classmarks granted to the user
     *
     * @param userName   Owner of classmarks
     * @throws IrisUsernameNotFoundException
     */
    List<String> listClassmarksByUser(String userName) throws UsernameNotFoundException;

    /**
     * Print out list of roles in the UUMS assigned to the user
     *
     * @param userName  Unique login name
     * @param type      Role type (UUMS/UACN)
     * @throws IrisUsernameNotFoundException
     */
    List<String> listRolesByUser(String userName, String type) throws UsernameNotFoundException;
    
    /**
     * Print out list of all roles in the UUMS
     *
     * @param type   Role type (UUMS/UACN)
     */
    List<String> listAllRoles(String type);

    /**
     * Print out list of users in the UUMS with the specified role
     *
     * @param userRole  Role name
     * @param type      Role type (UUMS/UACN)
     */
    List<String> listUsersByRole(String userRole, String type);
    /**
     * Remove user from the UUMS
     *
     * @param userName   Unique login name
     * @return result
     */
    String removeUser(String userName);
    
    /**
     * Add user to the UUMS
     * User will be disabled and have no roles.
     *
     * @param userName   Unique login name
     * @param password   User password
     * @param givenName  User first name
     * @param lastName   User last name
     * @param email      User email
     * @return result
     */
    String addUser(String userName, String password, String givenName, String lastName, String email);
    
    /**
     * Update user details in the UUMS
     *
     * @param userName   Unique login name
     * @param givenName  User first name
     * @param lastName   User last name
     * @param email      User email
     * @return result
     */
    String updateUser(String userName, String givenName, String lastName, String email);

    /**
     * Set status for the supplied system
     *
     * @param userName   Unique login name
     * @param enabled    Status (true/false)
     * @param system     IRIS/UACN/GEO system name
     * @return result
     */    
    String updateUserStatus(String userName, boolean enabled, String system);
    
    /**
     * Add specified role to the user in the UUMS
     *
     * @param userName   Unique login name
     * @param userRole   Role name
     * @param type       Role type (UUMS/UACN)
     * @return result
     */
    String addRoleToUser(String userName, String userRole, String type);
    
    /**
     * Removed specified role for the user in the UUMS
     *
     * @param userName   Unique login name
     * @param userRole   Role name
     * @param type       Role type (UUMS/UACN)
     * @return result
     */
    String removeRoleFromUser(String userName, String userRole, String type);

    /**
     * Set new password for the user
     *
     * @param userName   Unique login name
     * @param password   New password
     * @return result
     */
    String resetPassword(String userName, String password);

    /**
     * Reactivate user.
     *
     * @param userName Unique login name.
     * @return String containing the result of the operation
     */
    String reactivateUser(String userName);

    /**
    *  Get an existing Users according to params
    * @param  params containing the following keys and values:
    *         String sortCol - sorted column's name
    *         String sortDir - sorted column's direction
    *         int start - start record
    *         int pageSize - page size
    *         int showField - index of users to be showing
    *         int filterBy - index column to filter by
    *         String filterContain - text to filter by
    *         List<String> restrictedPrivileges -  privileges which user should need
    *         boolean shouldContainsUsers - true if only this users are presented in result, false - if not presented
    *         List<String> listContainedUsers - list of users which should be included or deleted from list
    * @return Map of users selected by params criteria with total number of users
    */
    Map getUsersWithParams(Map params);

    /**
     * Check for deleted users in UUMS
     * @param users contains the list of checking user names
     * @return list of users which were removed from initial list
     */
    List<String> checkDeletedUsers(List<String> users);
    
    /**
     * Get user details by user name
     * @param username the name of user in UUMS
     * @return map contains user firstName, lastName, enable, active parameters
     */
    Map getUserDetails(String username);

    /**
     * Get list of user which have one of the following privileges
     * @param userPrivileges names of privileges
     * @return list of users
     */
    List<String> getUsersWithPrivileges(List<String> userPrivileges);

    /**
     * Get a map of users who have one of the following privileges 
     *
     * @param userPrivileges target user privileges
     * @param start  start index of entry to return
     * @param limit  maximum number of entries to return
     * @param filterByName flag to indicate if results are to be filtered by name
     * @return map contains user firstName, lastName, enable, active parameters , email
     */
    Map getUserDetailsWithPrivileges(List<String> userPrivileges, int start, int limit, String filterByName);

    /**
     * Get a map of users who have one of the following privileges
     *
     * @param userPrivileges names of privileges
     * @return map contains user firstName, lastName, enable, active parameters , email
     */
    Map getUserDetailsWithPrivileges(List<String> userPrivileges);

    /**
     * This method tries to authenticate user with provided credentials. 
     * 
     * @param username user name
     * @param password user password
     * @return true, if credentials are valid, false otherwise.
     */
    boolean authenticateUser(String username, String password);

    /**
     * Retrieve a list of role members for the roles that user belongs to and that have the one of the
     * target privileges
     *
     * @param  username   Target user name
     * @param  privileges Target privileges (e.g. ROLE_ISA_GROUP)
     * @return Map of role members grouped by each matching role. Otherwise, an empty map is returned
     */
    Map<String, List<String>> listRoleMembersByUserAndPrivileges(String username, List<String> privileges);

    /**
     * Retrieve a list of role members that have one of the target usage
     *
     * @param  privileges Target privileges (e.g. ROLE_ISA_GROUP)
     * @return Map of role members grouped by matching privilege. Otherwise, an empty map is returned
     */
    Map<String, List<String>> listRoleMembersByPrivileges(List<String> privileges);

    /**
     * Retrieve a list of roles that user belongs to and that have one of the target privilege
     *
     * @param  username   Target user name
     * @param  privileges Target privileges (e.g. ROLE_ISA_GROUP)
     * @return list of matching roles. Otherwise, an empty list is returned
     */
    List<String> listRolesByUserAndPrivileges(String username, List<String> privileges);

    /**
     * Retrieve a list of roles that have one of the target privileges
     *
     * @param  privileges Target privileges (e.g. ROLE_ISA_GROUP)
     * @return list of matching roles. Otherwise, an empty list is returned
     */
    List<String> listRolesByPrivileges(List<String> privileges);

}
