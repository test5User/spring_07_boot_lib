package by.itclass.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LibraryController {
    private LibraryRepository repository;

    @Autowired
    public void setRepository(LibraryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String getAll(Model model) {
        var libraries = repository.findAll();
        model.addAttribute("libraries", libraries);
        return "index";
    }

    @GetMapping("/view/{id}")
    public String view(
            @PathVariable(name = "id") int id,
            Model model) {
       var library = repository.findById(id).get();
       model.addAttribute("library", library);
       return "library";
    }
}
