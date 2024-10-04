package sadikov.crm.CRM.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import sadikov.crm.CRM.Models.LessonsReport;


@Component
public class LessonsReportDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LessonsReportDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public LessonsReportDAO(){
        jdbcTemplate = null;
    }

    public void addLessonsReport(LessonsReport lessonsReport){
        jdbcTemplate.update("INSERT INTO lessonsReport(lessonType, date, time, kid) VALUES (?, ?, ?, ?)",
                lessonsReport.getLessonType(), lessonsReport.getDate(), lessonsReport.getTime(), lessonsReport.getKidId());
    }

}
