package com.dongdaemun.dongdaemun.web;

import com.dongdaemun.dongdaemun.config.auth.LoginUser;
import com.dongdaemun.dongdaemun.config.auth.dto.SessionUser;
import com.dongdaemun.dongdaemun.domain.posts.Posts;
import com.dongdaemun.dongdaemun.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("smarteditor")
public class EditorController {

    @Autowired
    PostService postService;


    @RequestMapping("/")
    public ModelAndView insertEditor(HttpServletRequest req, ModelMap model) throws Exception {
        ModelAndView mav = new ModelAndView("smarteditor/newPost");

        return mav;
    }

    @ResponseBody
    @RequestMapping(value="/savePost", method = RequestMethod.POST)
    public View savePost( HttpServletRequest req, @RequestBody Posts post) throws Exception {
        ModelMap model = new ModelMap();
        model.addAttribute("result", HttpStatus.OK);

        postService.savePost(post);

        return new MappingJackson2JsonView();
    }
}