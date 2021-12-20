package com.dongdaemun.dongdaemun.service.posts;

import com.dongdaemun.dongdaemun.domain.comments.AnonyComments;
import com.dongdaemun.dongdaemun.domain.comments.AnonyCommentsRepository;
import com.dongdaemun.dongdaemun.domain.comments.NoticeComments;
import com.dongdaemun.dongdaemun.domain.posts.AnonyPosts;
import com.dongdaemun.dongdaemun.domain.posts.AnonyPostsRepository;
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
public class AnonyPostsService {

    private final AnonyPostsRepository anonyPostsRepository;
    //private final AnonyCommentsRepository anonyCommentsRepository;

    @Transactional
    public AnonyPosts save(PostsSaveRequestDto requestDto){
        return anonyPostsRepository.save(requestDto.toEntityAnony());
    }

    @Transactional
    public AnonyPosts update(Long id, PostsUpdateRequestDto requestDto){
        AnonyPosts posts = anonyPostsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return posts.update(requestDto.getTitle(), requestDto.getContent());
    }

    // 조회 : 게시글과 전체 댓글
    /*
    @Transactional
    public PostsAndCommentsResponseDto findPostAndCommentsById(Long id){
        AnonyPosts postsEntity = anonyPostsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        List<AnonyComments> commentsEntity = anonyCommentsRepository.findAllByPid(id);

        return new PostsAndCommentsResponseDto(postsEntity, commentsEntity);
    }
     */


    // 조회 : 게시글과 페이징 처리 댓글
        /*
    @Transactional
    public PostsAndCommentsPageResponseDto findPostsAndCommentsWithPageById(Long id, int page){
        AnonyPosts postsEntity = anonyPostsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        Page<AnonyComments> commentsPageEntity = listComments(page);

        return new PostsAndCommentsPageResponseDto(postsEntity, commentsPageEntity);
    }
         */

    // 게시판 페이징 조회
    @Transactional
    public Page<AnonyPosts> list(int page){
        return anonyPostsRepository.findAll(PageRequest.of(page,10, Sort.by(Sort.Direction.DESC, "id")));
    }

    // 댓글 페이징 조회
    /*
    @Transactional
    public Page<AnonyComments> listComments(int page){
        return anonyCommentsRepository.findAll(PageRequest.of(page,10, Sort.by(Sort.Direction.DESC, "cmtId")));
    }
     */

    @Transactional
    public void delete (Long id) {
        AnonyPosts posts = anonyPostsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        anonyPostsRepository.delete(posts);
    }

}