package com.dongdaemun.dongdaemun.web;

import com.dongdaemun.dongdaemun.domain.posts.Posts;
import com.dongdaemun.dongdaemun.service.PostsService;
import com.dongdaemun.dongdaemun.web.dto.PostsResponseDto;
import com.dongdaemun.dongdaemun.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    /*게시글 수정*/
    // 조회와 같은 기능. 프론트가 제이슨 데이터를 받아서 뿌려줘야함
    @GetMapping("/postupdate/{category}/{id}")
    public ResponseEntity<PostsResponseDto> update(@PathVariable String category, @PathVariable Long id){
        if(category.compareTo("notice")==0){
            return ResponseEntity.ok()
                    .body(postsService.findById(id));}
        else return null;
    }

    /* 게시글 수정 */
    // 게시글 저장(savepost)와 같은 기능. 변경된 내용을 프론트가 받아서 전송하면
    // 그 내용을 db에 저장함
    @PutMapping("/postupdate/{category}/{id}")
    public ResponseEntity<Posts> update(@PathVariable String category, @PathVariable Long id, @RequestBody PostsUpdateRequestDto updateRequestDto){
        if(category.compareTo("notice")==0){
            return ResponseEntity.ok()
                    .body(postsService.update(id, updateRequestDto));}//서비스에서 Long을 리턴함... 바꿔줘야 하는디 ..
        else return null;
        //return postsService.update(id, requestDto);
    }

    /*게시글 조회*/
    @GetMapping("/postview/{category}/{id}")
    public ResponseEntity<PostsResponseDto> postview(@PathVariable String category, @PathVariable Long id){
        if(category.compareTo("notice")==0){
            return ResponseEntity.ok()
                    .body(postsService.findById(id));}
        else return null;
    }

    // board/notice?page=0
    @GetMapping("/board/{category}")
    public ResponseEntity<?> list(Model model, @RequestParam(required = false, defaultValue = "0", value = "page") int page){
        Page<Posts> listPage = postsService.list(page);

        int totalPage = listPage.getTotalPages();

        model.addAttribute("posts", listPage.getContent());
        model.addAttribute("totalPage", totalPage);

        //ModelAndView mav = new ModelAndView("list");
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
/*
    @GetMapping("/board/{category}")
    public ModelAndView list(Model model, @RequestParam(required = false, defaultValue = "0", value = "page") int page){
        Page<Posts> listPage = postsService.list(page);

        int totalPage = listPage.getTotalPages();

        model.addAttribute("posts", listPage.getContent());
        model.addAttribute("totalPage", totalPage);

        ModelAndView mav = new ModelAndView("list");
        return mav;
    }

 */

    /*게시글 삭제*/
    @DeleteMapping("/postdelete/{category}/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id, @PathVariable String category){

        if(category.compareTo("notice")==0) {
            postsService.delete(id);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}