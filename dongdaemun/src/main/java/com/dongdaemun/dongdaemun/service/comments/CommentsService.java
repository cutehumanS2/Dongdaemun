package com.dongdaemun.dongdaemun.service.comments;

import com.dongdaemun.dongdaemun.domain.comments.Comments;
import com.dongdaemun.dongdaemun.domain.comments.CommentsRepository;
import com.dongdaemun.dongdaemun.web.dto.comments.CommentsListResponseDto;
import com.dongdaemun.dongdaemun.web.dto.comments.CommentsResponseDto;
import com.dongdaemun.dongdaemun.web.dto.comments.CommentsSaveRequestDto;
import com.dongdaemun.dongdaemun.web.dto.comments.CommentsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentsService {
    private final CommentsRepository commentsRepository;

    @Transactional
    public Comments save(CommentsSaveRequestDto requestDto){
        return commentsRepository.save(requestDto.toEntity());
    }

    @Transactional
    public Comments update(Long id, CommentsUpdateRequestDto requestDto){
        Comments comments = commentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id=" + id));

        return comments.update(requestDto.getCmt_content());
    }

    public CommentsResponseDto findById (Long id){
        Comments comments = commentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id="+id));
        return new CommentsResponseDto(comments);
    }

    // 전체 조회
    @Transactional
    public List<CommentsListResponseDto> findAllDesc(Long pid){
        return commentsRepository.findAllByPid(pid).stream()
                .map(CommentsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Comments comments = commentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id=" + id));
        commentsRepository.delete(comments);
    }
}
