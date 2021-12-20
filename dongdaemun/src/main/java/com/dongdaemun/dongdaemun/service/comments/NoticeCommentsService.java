package com.dongdaemun.dongdaemun.service.comments;

import com.dongdaemun.dongdaemun.domain.comments.NoticeComments;
import com.dongdaemun.dongdaemun.domain.comments.NoticeCommentsRepository;
import com.dongdaemun.dongdaemun.web.dto.comments.CommentsListResponseDto;
import com.dongdaemun.dongdaemun.web.dto.comments.CommentsResponseDto;
import com.dongdaemun.dongdaemun.web.dto.comments.CommentsSaveRequestDto;
import com.dongdaemun.dongdaemun.web.dto.comments.CommentsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NoticeCommentsService {

    private final NoticeCommentsRepository noticeCommentsRepository;

    @Transactional
    public NoticeComments save(CommentsSaveRequestDto requestDto){ //Long -> Posts로 바꾸면 되나.. getId() 지우고?
        return noticeCommentsRepository.save(requestDto.toEntityNotice());
    }

    @Transactional
    public NoticeComments update(Long id, CommentsUpdateRequestDto requestDto){
        NoticeComments comments = noticeCommentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id=" + id));

        return comments.update(requestDto.getCmt_content());
    }

    public CommentsResponseDto findById (Long id){
        NoticeComments comments = noticeCommentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id="+id));
        return new CommentsResponseDto(comments);
    }


    
    // 전체 조회
    @Transactional
    public List<CommentsListResponseDto> findAllDesc(Long pid){
        return noticeCommentsRepository.findAllByPid(pid).stream()
                .map(CommentsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        NoticeComments comments = noticeCommentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id=" + id));
        noticeCommentsRepository.delete(comments);
    }

}
