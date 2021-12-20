package com.dongdaemun.dongdaemun.service.posts;


import com.dongdaemun.dongdaemun.domain.comments.NoticeComments;
import com.dongdaemun.dongdaemun.domain.comments.NoticeCommentsRepository;
import com.dongdaemun.dongdaemun.web.dto.posts.*;
import com.dongdaemun.dongdaemun.domain.posts.NoticePosts;
import com.dongdaemun.dongdaemun.domain.posts.NoticePostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticePostsService {
    private final NoticePostsRepository noticePostsRepository;
    private final NoticeCommentsRepository noticeCommentsRepository;

    @Transactional
    public NoticePosts save(PostsSaveRequestDto requestDto){
        return noticePostsRepository.save(requestDto.toEntityNotice());
    }

    @Transactional
    public NoticePosts update(Long id, PostsUpdateRequestDto requestDto){
        NoticePosts posts = noticePostsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return posts.update(requestDto.getTitle(), requestDto.getContent());
    }

    // 조회 : 게시글과 전체 댓글
    @Transactional
    public PostsAndCommentsResponseDto findPostAndCommentsById(Long id){
        NoticePosts postsEntity = noticePostsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        List<NoticeComments> commentsEntity = noticeCommentsRepository.findAllByPid(id);

        return new PostsAndCommentsResponseDto(postsEntity, commentsEntity);
    }

    // 조회 : 게시글과 페이징 처리 댓글
    @Transactional
    public PostsAndCommentsPageResponseDto findPostsAndCommentsWithPageById(Long id, int page){
        NoticePosts postsEntity = noticePostsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        Page<NoticeComments> commentsPageEntity = listComments(page);
        return new PostsAndCommentsPageResponseDto(postsEntity, commentsPageEntity);
    }

    @Transactional
    public PostsResponseDto findById(Long id){
        NoticePosts postsEntity = noticePostsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(postsEntity);
    }

    /*
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }*/

    // 게시판 페이징 조회
    @Transactional
    public Page<NoticePosts> list(int page){
        return noticePostsRepository.findAll(PageRequest.of(page,10,Sort.by(Sort.Direction.DESC, "id")));
    }

    // 댓글 페이징 조회
    @Transactional
    public Page<NoticeComments> listComments(int page){
        return noticeCommentsRepository.findAll(PageRequest.of(page,10, Sort.by(Sort.Direction.DESC, "cmtId")));
    }

    @Transactional
    public void delete (Long id) {
        NoticePosts posts = noticePostsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        noticePostsRepository.delete(posts);
    }
}