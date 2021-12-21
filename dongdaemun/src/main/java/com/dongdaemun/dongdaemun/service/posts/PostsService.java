package com.dongdaemun.dongdaemun.service.posts;

import com.dongdaemun.dongdaemun.domain.posts.Posts;
import com.dongdaemun.dongdaemun.domain.posts.PostsRepository;
import com.dongdaemun.dongdaemun.web.dto.posts.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;
    //private final CommentsRepository commentsRepository;

    @Transactional
    public Posts save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity());
    }

    @Transactional
    public Posts update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return posts.update(requestDto.getTitle(), requestDto.getContent());
    }

    // 조회 : 게시글과 전체 댓글
    /*
    @Transactional
    public PostsAndCommentsResponseDto findPostAndCommentsById(Long id){
        Posts postsEntity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        List<Comments> commentsEntity = commentsRepository.findAllByPid(id);

        return new PostsAndCommentsResponseDto(postsEntity, commentsEntity);
    }

     */


    // 조회 : 게시글과 페이징 처리 댓글
    /*
    @Transactional
    public PostsAndCommentsPageResponseDto findPostsAndCommentsWithPageById(Long id, int page){
        Posts postsEntity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        Page<Comments> commentsPageEntity = listComments(page);
        return new PostsAndCommentsPageResponseDto(postsEntity, commentsPageEntity);
    }

     */

    @Transactional
    public PostsResponseDto findById(Long id){
        Posts postsEntity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(postsEntity);
    }



    // 게시판 페이징 조회
    @Transactional
    public Page<Posts> list(String category, int page){
        Pageable paging = PageRequest.of(page,10, Sort.by(Sort.Direction.DESC, "id")
        return postsRepository.findAllByCategory(category, paging));
    }

    // 댓글 페이징 조회
    /*
    @Transactional
    public Page<Comments> listComments(int page){
        return commentsRepository.findAll(PageRequest.of(page,10, Sort.by(Sort.Direction.DESC, "cmtId")));
    }

     */


    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        postsRepository.delete(posts);
    }

}
