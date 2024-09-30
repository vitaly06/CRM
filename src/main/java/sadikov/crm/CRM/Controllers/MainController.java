package sadikov.crm.CRM.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sadikov.crm.CRM.DAO.AdminDAO;
import sadikov.crm.CRM.DAO.PeopleDAO;
import sadikov.crm.CRM.Models.Admin;
import sadikov.crm.CRM.Models.People;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    AdminDAO adminDAO;
    @Autowired
    PeopleDAO peopleDAO;
    public boolean isAuth = false;

    // Логин
    @GetMapping("/")
    public String login() {
        return "login";
    }
     // Логика входа
    @PostMapping("/")
    public String loginPost(Admin admin) {
        Admin check = adminDAO.adminLogin(admin);
        try{
        if (check.getLogin() != null && check.getPassword() != null) {
            isAuth = true;
            return "redirect:/main";
        }
        }
        catch (Exception e) {
            System.out.println(0);
        }
        return "login";
    }
    // Выбор с кнопками
    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }

    // Все пользователи
    @GetMapping("/allPeople")
    public String allPeople(Model model) {
        model.addAttribute("peoples", peopleDAO.getAllPeople());
        return "allPeople";
    }

    // Добавление ученика
    @GetMapping("/addPeople")
    public String addPeople() {
        return "addPeople";
    }

    @PostMapping("/addPeople")
    public String addPeoplePost(@ModelAttribute("people") People people) {
        peopleDAO.addPeople(people);
        return "redirect:/allPeople";
    }

    // Редактирование ученика
    @GetMapping("/editUser/{id}")
    public String editUser(@PathVariable int id, Model model) {
        model.addAttribute("student", peopleDAO.getPeopleById(id));
        model.addAttribute("id", id);
        return "editUser";
    }

    @PostMapping("/editPeople")
    public String editPeoplePost(@ModelAttribute("people") People people) {
        peopleDAO.editPeople(people);
        return "redirect:/allPeople";
    }
}
