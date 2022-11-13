package com.jiwoo1.web;

import com.jiwoo1.domain.post.Post;
import com.jiwoo1.service.PostService;
import com.jiwoo1.web.dto.PostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@RequiredArgsConstructor //
@Controller
//Controller that links to templates
public class IndexController {
    private final PostService postService;

    @GetMapping("/")
    //if we input "/", automatically redirect to "/board/list"
    public RedirectView index() {
        return new RedirectView("/board/list");
    }

    @GetMapping("/board/list")
    //link "list.mustache" with "/board/list"
    public String list(Model model,
                       @RequestParam(required = false, defaultValue = "0", value = "page") int page) {
        Page<Post> listpage = postService.list(page); //Page<Post> that contains every post
        int totalpage = listpage.getTotalPages(); //total page of list
        ArrayList pageNum = new ArrayList(); //each page number
        for(int i=0; i<listpage.getTotalPages(); i++){
            pageNum.add(i);
        }

        //add attribute to model to use in templates
        model.addAttribute("post", listpage.getContent());
        model.addAttribute("totalpage", totalpage);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("TotalData", listpage.getTotalElements());
        model.addAttribute("size", listpage.getSize());
        model.addAttribute("number", listpage.getNumber());

        return "list";
    }

    @GetMapping("/board/write")
    //link "write.mustache" with "/board/write"
    public String write() {
        return "write";
    }

    @GetMapping("/board/view/{id}")
    //link "view.mustache" with "/board/view/{id}"
    public String view(@PathVariable Long id, Model model) {
        PostResponseDTO response = postService.findById(id);
        //add attribute to model to use in template
        model.addAttribute("post", response);
        return "view";
    }

    @GetMapping("/board/modify/{id}")
    //link "update.mustache" with "board/modify/{id}"
    public String update(@PathVariable Long id, Model model) {
        PostResponseDTO response = postService.findById(id);
        //add attribute to model to use in template
        model.addAttribute("post", response);

        return "update";
    }
}
