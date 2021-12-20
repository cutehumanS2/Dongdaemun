package com.dongdaemun.dongdaemun.web;

import com.dongdaemun.dongdaemun.service.posts.ActivityPostsService;
import com.dongdaemun.dongdaemun.service.posts.AnonyPostsService;
import com.dongdaemun.dongdaemun.service.posts.NoticePostsService;
import com.dongdaemun.dongdaemun.web.dto.posts.PostsAndCommentsPageResponseDto;
import com.dongdaemun.dongdaemun.web.dto.posts.PostsAndCommentsResponseDto;
import com.dongdaemun.dongdaemun.web.dto.posts.PostsResponseDto;
import com.dongdaemun.dongdaemun.web.dto.posts.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final NoticePostsService noticePostsService;
    private final AnonyPostsService anonyPostsService;
    private final ActivityPostsService activityPostsService;


    /* 게시글 수정 */
    // 조회와 같은 기능. 단, 댓글은 안가져오고 게시글만 가져옴
    // 프론트가 제이슨 데이터를 받아서 뿌려줘야함
    @GetMapping("/update/{category}/{id}")
    public ResponseEntity<PostsResponseDto> update(@PathVariable String category, @PathVariable Long id){
        if(category.compareTo("notice")==0){
            return ResponseEntity.ok()
                    .body(noticePostsService.findById(id));}
        /*
        else if(category.compareTo("anony")==0){
            return ResponseEntity.ok()
                    .body(anonyPostsService.findById(id));}
        else if(category.compareTo("activity")==0){
            return ResponseEntity.ok()
                    .body(activityPostsService.findById(id));}

         */
        else return null;
    }

    /* 게시글 수정 */
    // 게시글 저장(savepost)와 같은 기능. 변경된 내용을 프론트가 받아서 전송하면
    // 그 내용을 db에 저장함
    @PutMapping("/update/{category}/{id}")
    public ResponseEntity<?> update(@PathVariable String category, @PathVariable Long id, @RequestBody PostsUpdateRequestDto updateRequestDto){
        if(category.compareTo("notice")==0){
            return ResponseEntity.ok()
                    .body(noticePostsService.update(id, updateRequestDto));}
        else if(category.compareTo("anony")==0){
            return ResponseEntity.ok()
                    .body(anonyPostsService.update(id, updateRequestDto));}
        else if(category.compareTo("activity")==0){
            return ResponseEntity.ok()
                    .body(activityPostsService.update(id, updateRequestDto));}
        else return null;
    }

    /* 게시글 조회 */
    // 댓글 전체 조회
    @GetMapping("/view/{category}/{id}/scroll")
    public ResponseEntity<PostsAndCommentsResponseDto> postview(@PathVariable String category, @PathVariable Long id){
        if(category.compareTo("notice")==0){
            return ResponseEntity.ok()
                    .body(noticePostsService.findPostAndCommentsById(id));}
        /*
        else if(category.compareTo("anony")==0){
            return ResponseEntity.ok()
                    .body(anonyPostsService.findById(id));}
        else if(category.compareTo("activity")==0){
            return ResponseEntity.ok()
                    .body(activityPostsService.findById(id));}

         */
        else return null;
    }

    /* 게시글 조회 */
    // 댓글 페이징 조회
    @GetMapping("/view/{category}/{id}")
    public ResponseEntity<PostsAndCommentsPageResponseDto> postview(@PathVariable String category, @PathVariable Long id
    , @RequestParam(required = false, defaultValue = "0", value = "commentPage") int page){
        if(category.compareTo("notice")==0){
            return ResponseEntity.ok()
                    .body(noticePostsService.findPostsAndCommentsWithPageById(id, page));}
        /*
        else if(category.compareTo("anony")==0){
            return ResponseEntity.ok()
                    .body(anonyPostsService.findById(id));}
        else if(category.compareTo("activity")==0){
            return ResponseEntity.ok()
                    .body(activityPostsService.findById(id));}

         */
        else return null;
    }

    // board/notice?page=0
    @GetMapping("/list/{category}")
    public ResponseEntity<?> list(Model model, @PathVariable String category, @RequestParam(required = false, defaultValue = "0", value = "page") int page){

        Page<?> listPage = null; int totalPage;
        if(category.compareTo("notice")==0){
            listPage = noticePostsService.list(page);
        }
        else if(category.compareTo("anony")==0){
            listPage = anonyPostsService.list(page);
        }
        else if(category.compareTo("activity")==0){
            listPage = activityPostsService.list(page);
        }

        totalPage = listPage.getTotalPages();

        model.addAttribute("posts", listPage.getContent());
        model.addAttribute("totalPage", totalPage);

        //ModelAndView mav = new ModelAndView("list");
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    /* 게시글 삭제 */
    @DeleteMapping("/delete/{category}/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id, @PathVariable String category){

        if(category.compareTo("notice")==0) {
            noticePostsService.delete(id);
        }
        else if(category.compareTo("anony")==0) {
            anonyPostsService.delete(id);
        }
        else if(category.compareTo("activity")==0) {
            activityPostsService.delete(id);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}