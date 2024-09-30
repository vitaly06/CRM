package sadikov.crm.CRM.Mappers;

import org.springframework.jdbc.core.RowMapper;
import sadikov.crm.CRM.Models.Admin;
import sadikov.crm.CRM.Models.People;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleMapper implements RowMapper<People> {
    @Override
    public People mapRow(ResultSet resultSet, int i) throws SQLException {
        People people = new People();
        try {
            people.setId(resultSet.getInt("id"));
            people.setFio(resultSet.getString("fio"));
            people.setDateOfBirth(resultSet.getString("dateOfBirth"));
            people.setParentFio(resultSet.getString("parentFio"));
            people.setTicket(resultSet.getString("ticket"));
            people.setSumm(resultSet.getInt("summ"));
            people.setPaymentMethod(resultSet.getString("paymentMethod"));
        }
        catch (Exception e){
            return new People();
        }
        return people;
    }
}
