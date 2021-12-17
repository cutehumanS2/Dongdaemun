package com.dongdaemun.dongdaemun.web;

import com.dongdaemun.dongdaemun.config.auth.LoginUser;
import com.dongdaemun.dongdaemun.config.auth.dto.PostsSaveRequestDto;
import com.dongdaemun.dongdaemun.config.auth.dto.SessionUser;
import com.dongdaemun.dongdaemun.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


@Controller
public class EditorController {

    @Autowired
    PostsService postService;


    @RequestMapping("/smarteditor")
    public ModelAndView insertEditor(ModelMap model, @LoginUser SessionUser user) throws Exception {
        if (user != null) {
            model.addAttribute("userEmail", user.getEmail());
        }
        ModelAndView mav = new ModelAndView("smarteditor/newPost");

        return mav;
    }

    @ResponseBody
    @RequestMapping(value="/smarteditor/savePost", method = RequestMethod.POST)
    public View savePost(@RequestBody PostsSaveRequestDto requestDto) throws Exception {
        ModelMap model = new ModelMap();
        model.addAttribute("result", HttpStatus.OK);

        postService.save(requestDto);

        return new MappingJackson2JsonView();
    }
}