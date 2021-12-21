package com.dongdaemun.dongdaemun.web;

import com.dongdaemun.dongdaemun.config.auth.LoginUser;
import com.dongdaemun.dongdaemun.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final HttpSession httpSession;
    private final NoticePostsService postsService;
    /*

    @GetMapping("/")
    public ResponseEntity<?> index(Model model, @LoginUser SessionUser user){

        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
     */

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        //model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }


    /*
    @GetMapping("/editor")
    public String editor(Model model) {
        //model.addAttribute("posts", postsService.findAllDesc());

        return "/smarteditor/newPost";
    }*/


}
