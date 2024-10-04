package sadikov.crm.CRM.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import sadikov.crm.CRM.Mappers.PeopleMapper;
import sadikov.crm.CRM.Models.People;

import java.util.List;

@Component
public class PeopleDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PeopleDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public PeopleDAO(){
        jdbcTemplate = null;
    }

    public List<People> getAllPeople(){
        return jdbcTemplate.query("SELECT * FROM users", new PeopleMapper());
    }

    public void addPeople(People people){
        people.setFactTicket(Integer.parseInt(people.getTicket()));
        people.setFactMoney(people.getSumm());
        jdbcTemplate.update("INSERT INTO users(fio, dateOfBirth, parentFio, ticket, summ, paymentMethod, factTicket, factMoney)" +
                " VALUES(?, ?, ?, ?, ?, ?,)", people.getFio(), people.getDateOfBirth(), people.getParentFio(),
                people.getTicket(), people.getSumm(), people.getPaymentMethod(), people.getFactTicket(), people.getFactMoney());
    }

    public People getPeopleById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", new PeopleMapper(), id);
    }

    public int editPeople(People people){
        assert jdbcTemplate != null;
        return jdbcTemplate.update("UPDATE users SET fio =?, dateOfBirth =?, parentFio =?, ticket =?, summ =?, " +
                        "paymentMethod =?, factTicket = ?, factMoney = ? WHERE id = ?",
                people.getFio(), people.getDateOfBirth(), people.getParentFio(), people.getTicket(), people.getSumm(),
                people.getPaymentMethod(), Integer.parseInt(people.getTicket()), people.getSumm(), people.getId());
    }

    public int editCountLessons(People people){
        assert jdbcTemplate != null;
        return jdbcTemplate.update("UPDATE users SET factTicket = ?, factMoney = ? WHERE id = ?",
                people.getFactTicket(), people.getFactMoney(), people.getId());
    }
}
