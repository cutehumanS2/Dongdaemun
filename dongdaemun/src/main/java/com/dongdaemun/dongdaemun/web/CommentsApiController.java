package com.dongdaemun.dongdaemun.web;

import com.dongdaemun.dongdaemun.service.comments.CommentsService;
import com.dongdaemun.dongdaemun.web.dto.comments.CommentsResponseDto;
import com.dongdaemun.dongdaemun.web.dto.comments.CommentsSaveRequestDto;
import com.dongdaemun.dongdaemun.web.dto.comments.CommentsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentsApiController {

    private final CommentsService commentsService;

    /* 댓글 등록 */
    @PostMapping("/saveCmt/{category}/{pid}")
    public ResponseEntity<?> saveCmt(@RequestBody CommentsSaveRequestDto requestDto, @PathVariable String category, @PathVariable Long pid) throws Exception{

        return ResponseEntity.ok()
                .body(commentsService.save(requestDto));
    }

    /* 댓글 수정 */
    @GetMapping("/updateCmt")
    public ResponseEntity<CommentsResponseDto> getCmt(@RequestParam("category") String category, @RequestParam("pid") Long pid, @RequestParam("cid") Long cid){
        return ResponseEntity.ok()
                .body(commentsService.findById(cid));
    }


    /* 댓글 수정 */
    @PutMapping("/updateCmt")
    public ResponseEntity<?> update(@RequestParam("category") String category, @RequestParam("pid") Long pid, @RequestParam("cid") Long cid, @RequestBody CommentsUpdateRequestDto
            updateRequestDto){
        return ResponseEntity.ok()
                .body(commentsService.update(cid, updateRequestDto));}


    /* 댓글 삭제 */
    @DeleteMapping("/deleteCmt")
    public ResponseEntity<?> delete(@RequestParam("category") String category, @RequestParam("pid") Long pid, @RequestParam("cid") Long cid){
        commentsService.delete(cid);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
