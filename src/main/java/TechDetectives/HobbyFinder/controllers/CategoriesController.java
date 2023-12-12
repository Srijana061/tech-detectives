package TechDetectives.HobbyFinder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hobbies")
//@ResponseBody
public class CategoriesController {
    private static int nextId = 9;
    private static final Map<Integer, String> hobbies = new HashMap<>() {{
        put(1, "Arts and Crafts");
        put(2, "Home and Garden");
        put(3, "Sports");
        put(4, "Indoor Recreation");
        put(5, "Needle crafts and Textiles");
        put(6, "Collections");
        put(7, "Outdoor Recreation");
        put(8, "Model Building");

    }};

    @GetMapping("")

    public String renderHobbiesHomePage(Model model) {
        List<String> hobbyList = new ArrayList<>(hobbies.values());
        model.addAttribute("hobbyList", hobbyList);

        return "hobbies/index";
    }


    @GetMapping("/add")
    public String displayAddHobbyForm() {
        return "hobbies/add";
    }


    @PostMapping("/add")
    public String processAddHobbyForm(@RequestParam String hobby) {
        hobbies.put(nextId, hobby);
        nextId++;
        return "redirect:/hobbies";
    }


    @GetMapping("/details/{hobbyId}")
    @ResponseBody
    public String displayHobbyDetails(@PathVariable int hobbyId) {
        return "<html>" +
                "<body>" +
                "<h3>Hobbies</h3>" +
                "<p><b>ID:</b>" + hobbyId +"</p>" +
                "<p><b>Hobby Category:</b> " + hobbies.get(hobbyId) + "</p>" +
                "<p><b>Hobby Name:</b> </p>" +
                "<p><b>Details:</b> </p>" +
                "</body>" +
                "</html>";

    }

}


