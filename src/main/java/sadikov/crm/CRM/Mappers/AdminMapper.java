package sadikov.crm.CRM.Mappers;

import org.springframework.jdbc.core.RowMapper;
import sadikov.crm.CRM.Models.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMapper implements RowMapper<Admin> {
    @Override
    public Admin mapRow(ResultSet resultSet, int i) throws SQLException {
        Admin admin = new Admin();
        try {
            admin.setLogin(resultSet.getString("login"));
            admin.setPassword(resultSet.getString("password"));
        }
        catch (Exception e){
            return new Admin();
        }
        return admin;
    }
}
