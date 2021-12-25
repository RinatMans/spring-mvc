package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;

import javax.servlet.http.HttpServletRequest;


@Controller
public class CarController {

    private final CarDao carDao;

    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping("/cars")
    public String index(HttpServletRequest request, Model model) {
        String count = request.getParameter("count");
        if (count == null) {
            model.addAttribute("car",carDao.getCars());
             }
        else {
            model.addAttribute("car",carDao.show(Integer.parseInt(count)));
        }
        return "cars";
    }

}