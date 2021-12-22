package com.dongdaemun.dongdaemun.web;

import com.dongdaemun.dongdaemun.config.auth.LoginUser;
import com.dongdaemun.dongdaemun.config.auth.dto.SessionUser;
import com.dongdaemun.dongdaemun.service.myPage.MyPageService;
import com.dongdaemun.dongdaemun.web.dto.myPage.MyProfileAndMyPostsAndMyCommentsResponseDto;
import com.dongdaemun.dongdaemun.web.dto.myPage.MyProfileResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MyPageController {
    private final MyPageService myPageService;

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



    // 내가 작성한 댓글의 글 더보기



}