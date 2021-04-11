package Dao;

import Classes.Admin;

public interface AdminDao {
    void save(Admin admin);
    void delete(Admin admin);

    Admin authorizeAdmin(String login, String password);
}
