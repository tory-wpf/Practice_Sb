package hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookStorage library;

    @Autowired
    public BookController(BookStorage library) {
        this.library = library;
    }

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("booksList", library.index());
        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("Book",library.show(id));
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(Model model){
        model.addAttribute("Book", new Book());
        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("Book") Book book ){
        library.save(book);
        return "redirect:/books";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        library.delete(id);
        return "redirect:/books";
    }


}
