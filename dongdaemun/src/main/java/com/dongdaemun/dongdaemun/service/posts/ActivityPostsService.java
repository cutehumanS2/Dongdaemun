package com.dongdaemun.dongdaemun.service.posts;

import com.dongdaemun.dongdaemun.domain.comments.ActivityComments;
import com.dongdaemun.dongdaemun.domain.comments.ActivityCommentsRepository;
import com.dongdaemun.dongdaemun.domain.comments.NoticeComments;
import com.dongdaemun.dongdaemun.domain.posts.ActivityPosts;
import com.dongdaemun.dongdaemun.domain.posts.ActivityPostsRepository;
import com.dongdaemun.dongdaemun.domain.posts.AnonyPosts;
import com.dongdaemun.dongdaemun.domain.posts.NoticePosts;
import com.dongdaemun.dongdaemun.web.dto.posts.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ActivityPostsService {
    private final ActivityPostsRepository activityPostsRepository;
    private final ActivityCommentsRepository activityCommentsRepository;

    @Transactional
    public ActivityPosts save(PostsSaveRequestDto requestDto){
        return activityPostsRepository.save(requestDto.toEntityActivity());
    }

    @Transactional
    public ActivityPosts update(Long id, PostsUpdateRequestDto requestDto){
        ActivityPosts posts = activityPostsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return posts.update(requestDto.getTitle(), requestDto.getContent());
    }

    // 조회 : 게시글과 전체 댓글
    @Transactional
    public PostsAndCommentsResponseDto findPostAndCommentsById(Long id){
        ActivityPosts postsEntity = activityPostsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        List<ActivityComments> commentsEntity = activityCommentsRepository.findAllByPid(id);

        return new PostsAndCommentsResponseDto(postsEntity, commentsEntity);
    }

    // 조회 : 게시글과 페이징 처리 댓글
    @Transactional
    public PostsAndCommentsPageResponseDto findPostsAndCommentsWithPageById(Long id, int page){
        ActivityPosts postsEntity = activityPostsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        Page<ActivityComments> commentsPageEntity = listComments(page);

        return new PostsAndCommentsPageResponseDto(postsEntity, commentsPageEntity);
    }

    @Transactional
    public PostsResponseDto findById(Long id){
        ActivityPosts postsEntity = activityPostsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(postsEntity);
    }

    // 게시판 페이징 조회
    @Transactional
    public Page<ActivityPosts> list(int page){
        return activityPostsRepository.findAll(PageRequest.of(page,10, Sort.by(Sort.Direction.DESC, "id")));
    }

    // 댓글 페이징 조회
    @Transactional
    public Page<ActivityComments> listComments(int page){
        return activityCommentsRepository.findAll(PageRequest.of(page,10, Sort.by(Sort.Direction.DESC, "cmtId")));
    }

    @Transactional
    public void delete (Long id) {
        ActivityPosts posts = activityPostsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        activityPostsRepository.delete(posts);
    }
}
