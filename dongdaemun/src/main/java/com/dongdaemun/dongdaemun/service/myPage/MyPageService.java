package com.dongdaemun.dongdaemun.service.myPage;

import com.dongdaemun.dongdaemun.domain.comments.Comments;
import com.dongdaemun.dongdaemun.domain.comments.CommentsRepository;
import com.dongdaemun.dongdaemun.domain.posts.Posts;
import com.dongdaemun.dongdaemun.domain.posts.PostsRepository;
import com.dongdaemun.dongdaemun.domain.user.User;
import com.dongdaemun.dongdaemun.domain.user.UserRepository;
import com.dongdaemun.dongdaemun.service.comments.CommentsService;
import com.dongdaemun.dongdaemun.web.dto.myPage.MyCommentsResponseDto;
import com.dongdaemun.dongdaemun.web.dto.myPage.MyProfileAndMyPostsAndMyCommentsResponseDto;
import com.dongdaemun.dongdaemun.web.dto.myPage.MyProfileResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MyPageService {

    private final UserRepository userRepository;
    private final PostsRepository postsRepository;
    private final CommentsRepository commentsRepository;
    private final CommentsService commentsService;

    // 유저 정보 조회 : 이름, 소속 동아리
    // 내가 작성한 글, 내가 작성한 댓글의 글
    public MyProfileAndMyPostsAndMyCommentsResponseDto findByEmail(String email){
        Optional<User> user = userRepository.findByEmail(email);
        MyProfileResponseDto userProfile = new MyProfileResponseDto(user);

        // 내가 작성한 글을 최근 3개만
        Pageable paging_post = PageRequest.of(0,3, Sort.by(Sort.Direction.DESC, "id"));
        Page<Posts> posts = postsRepository.findAllByUid(email, paging_post);

        // 내가 작성한 댓글 최근 3개만
        Pageable paging_cmt = PageRequest.of(0,3, Sort.by(Sort.Direction.DESC, "cmtId"));
        Page<Comments> comments = commentsRepository.findAllByUid(email, paging_cmt);

        if(posts==null && comments==null) return new MyProfileAndMyPostsAndMyCommentsResponseDto(userProfile);
        else if(posts==null && comments!=null) return new MyProfileAndMyPostsAndMyCommentsResponseDto(userProfile, comments);
        else if(posts!=null && comments==null) return new MyProfileAndMyPostsAndMyCommentsResponseDto(userProfile, posts, true);
        return new MyProfileAndMyPostsAndMyCommentsResponseDto(userProfile, posts, comments);
    }

    // 내가 작성한 글 조회
    @Transactional
    public Page<Posts> myPostsList(String email, int page){
        Pageable paging = PageRequest.of(page,10, Sort.by(Sort.Direction.DESC, "id"));
        return postsRepository.findAllByUid(email, paging);
    }

    // 내가 작성한 댓글 조회
    // 각 게시판에서 uid로 select하고 join한 다음 글 작성 시간 기준으로 sort
    @Transactional
    public Page<Posts> myCommentsList(String email, int page){
        Pageable paging = PageRequest.of(page,10, Sort.by(Sort.Direction.DESC, "id"));

        //return commentsRepository.findAllByUid(email, paging);
        return postsRepository.findAllWithMyComments(email, paging);
    }



}