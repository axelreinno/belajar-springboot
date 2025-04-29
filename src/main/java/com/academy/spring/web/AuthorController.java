package com.academy.spring.web;

import com.academy.spring.dtos.AuthorDto;
import com.academy.spring.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("list")
    public String listAuthor(Model model) {
        model.addAttribute("authorDto", authorService.findAuthorList());
        return "author/list";
    }

    @GetMapping("add")
    public String addAuthor(Model model) {
        model.addAttribute("authorDto", new AuthorDto(null, null));
        return "author/add";
    }

    @PostMapping("add")
    public String submitAuthor(@ModelAttribute AuthorDto authorDto, RedirectAttributes attribute) {
        authorService.createAuthor(authorDto);
        attribute.addFlashAttribute("authorDto", authorService.findAuthorList());
        return "redirect:/author/list";
    }
}
