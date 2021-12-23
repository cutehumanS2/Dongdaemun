package com.dongdaemun.dongdaemun.web;

import com.dongdaemun.dongdaemun.config.auth.LoginUser;
import com.dongdaemun.dongdaemun.config.auth.dto.SessionUser;
import com.dongdaemun.dongdaemun.domain.comments.Comments;
import com.dongdaemun.dongdaemun.domain.posts.Posts;
import com.dongdaemun.dongdaemun.service.comments.CommentsService;
import com.dongdaemun.dongdaemun.service.myPage.MyPageService;
import com.dongdaemun.dongdaemun.web.dto.myPage.MyCommentsResponseDto;
import com.dongdaemun.dongdaemun.web.dto.myPage.MyProfileAndMyPostsAndMyCommentsResponseDto;
import com.dongdaemun.dongdaemun.web.dto.myPage.MyProfileResponseDto;
import com.dongdaemun.dongdaemun.web.dto.posts.PostsAndCommentsPageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MyPageController {
    private final MyPageService myPageService;
    private final CommentsService myCommentsService;

    // 프로필 정보
    // 내가 작성한 글
    // 내가 작성한 댓글이 포함된 글
    @GetMapping("/mypage")
    public ResponseEntity<MyProfileAndMyPostsAndMyCommentsResponseDto> profileview(@LoginUser SessionUser user){
        String email="";
        if(user!=null) {
            email = user.getEmail();
        }
        return ResponseEntity.ok()
                .body(myPageService.findByEmail(email));
    }

    // 내가 작성한 글 더보기
    @GetMapping("/mypage/myposts")
    public ResponseEntity<?> postsview(@LoginUser SessionUser user
            , @RequestParam(required = false, defaultValue = "0", value = "page") int page){
        String email="";
        if(user!=null) {
            email = user.getEmail();
            System.out.println(email);
        }
        return ResponseEntity.ok().body(myPageService.myPostsList(email, page));
    }


    // 내가 작성한 댓글의 글 더보기
    @GetMapping("/mypage/mycomments")
    public ResponseEntity<?> commentsview(@LoginUser SessionUser user
            , @RequestParam(required = false, defaultValue = "0", value = "commentPage") int page){
        String email="";
        if(user!=null) {
            email = user.getEmail();
            System.out.println(email);
        }

        return ResponseEntity.ok().body(myPageService.myCommentsList(email, page));
    }


}