package com.dongdaemun.dongdaemun.service.comments;

import com.dongdaemun.dongdaemun.domain.comments.AnonyComments;
import com.dongdaemun.dongdaemun.domain.comments.AnonyCommentsRepository;
import com.dongdaemun.dongdaemun.domain.comments.NoticeComments;
import com.dongdaemun.dongdaemun.domain.comments.NoticeCommentsRepository;
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
public class AnonyCommentsService {
    private final AnonyCommentsRepository anonyCommentsRepository;

    @Transactional
    public AnonyComments save(CommentsSaveRequestDto requestDto){ //Long -> Posts로 바꾸면 되나.. getId() 지우고?
        return anonyCommentsRepository.save(requestDto.toEntityAnony());
    }

    @Transactional
    public AnonyComments update(Long id, CommentsUpdateRequestDto requestDto){
        AnonyComments comments = anonyCommentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id=" + id));

        return comments.update(requestDto.getCmt_content());
    }

    public CommentsResponseDto findById (Long id){
        AnonyComments comments = anonyCommentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id="+id));
        return new CommentsResponseDto(comments);
    }

    // 전체 조회
    @Transactional
    public List<CommentsListResponseDto> findAllDesc(Long pid){
        return anonyCommentsRepository.findAllByPid(pid).stream()
                .map(CommentsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        AnonyComments comments = anonyCommentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id=" + id));
        anonyCommentsRepository.delete(comments);
    }
}
