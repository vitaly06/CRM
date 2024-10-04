package sadikov.crm.CRM.Mappers;

import org.springframework.jdbc.core.RowMapper;
import sadikov.crm.CRM.Models.LessonsReport;

import java.sql.ResultSet;
import java.sql.SQLException;

public class lessonsReportMapper implements RowMapper<LessonsReport> {
    @Override
    public LessonsReport mapRow(ResultSet resultSet, int i) throws SQLException {
        LessonsReport lp = new LessonsReport();
        try {
            lp.setId(resultSet.getInt("id"));
            lp.setLessonType(resultSet.getString("lesson_type"));
            lp.setDate(resultSet.getString("date"));
            lp.setTime(resultSet.getString("time"));
            lp.setKidId(resultSet.getInt("kidId"));
        }
        catch (Exception e){
            return new LessonsReport();
        }
        return lp;
    }
}
