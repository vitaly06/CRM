package sadikov.crm.CRM.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import sadikov.crm.CRM.Mappers.AdminMapper;
import sadikov.crm.CRM.Models.Admin;

@Component
public class AdminDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AdminDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public AdminDAO(){
        jdbcTemplate = null;
    }

    public Admin adminLogin(Admin admin){
        return jdbcTemplate.query("SELECT * FROM admins WHERE login = ? AND password = ?",
                new Object[]{admin.getLogin(), admin.getPassword()},  new AdminMapper())
                .stream().findAny().orElse(null);
    }

}
