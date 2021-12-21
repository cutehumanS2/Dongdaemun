package com.dongdaemun.dongdaemun.service.comments;

import com.dongdaemun.dongdaemun.domain.comments.ActivityComments;
import com.dongdaemun.dongdaemun.domain.comments.ActivityCommentsRepository;
import com.dongdaemun.dongdaemun.domain.comments.NoticeComments;
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
public class ActivityCommentsService {

    private final ActivityCommentsRepository activityCommentsRepository;

    @Transactional
    public ActivityComments save(CommentsSaveRequestDto requestDto){ //Long -> Posts로 바꾸면 되나.. getId() 지우고?
        return activityCommentsRepository.save(requestDto.toEntityActivity());
    }

    @Transactional
    public ActivityComments update(Long id, CommentsUpdateRequestDto requestDto){
        ActivityComments comments = activityCommentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id=" + id));

        return comments.update(requestDto.getCmt_content());
    }

    public CommentsResponseDto findById (Long id){
        ActivityComments comments = activityCommentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id="+id));
        return new CommentsResponseDto(comments);
    }

    // 전체 조회
    @Transactional
    public List<CommentsListResponseDto> findAllDesc(Long pid){
        return activityCommentsRepository.findAllByPid(pid).stream()
                .map(CommentsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        ActivityComments comments = activityCommentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id=" + id));
        activityCommentsRepository.delete(comments);
    }
}
