package com.dongdaemun.dongdaemun.web;

import com.dongdaemun.dongdaemun.service.comments.ActivityCommentsService;
import com.dongdaemun.dongdaemun.service.comments.AnonyCommentsService;
import com.dongdaemun.dongdaemun.service.comments.NoticeCommentsService;
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
    private final NoticeCommentsService noticeCommentsService;
    private final ActivityCommentsService activityCommentsService;
    private final AnonyCommentsService anonyCommentsService;

    /* 댓글 등록 */
    @PostMapping("/saveCmt/{category}/{pid}")
    public ResponseEntity<?> savePost(@RequestBody CommentsSaveRequestDto requestDto, @PathVariable String category, @PathVariable Long pid) throws Exception{
        if(category.compareTo("notice")==0){
            return ResponseEntity.ok()
                    .body(noticeCommentsService.save(requestDto));}
        else if(category.compareTo("anony")==0){
            return ResponseEntity.ok()
                    .body(anonyCommentsService.save(requestDto));}
        else if(category.compareTo("activity")==0){
            return ResponseEntity.ok()
                    .body(activityCommentsService.save(requestDto));}
        else return null;
    }

    /* 댓글 수정 */
    // 이거 어차피 수정할 때 조회하는거로만 쓰이는데 getmapping updateCmt로 바꾸는건 어떄
    @GetMapping("/updateCmt/{category}/{pid}/{cid}")
    public ResponseEntity<CommentsResponseDto> postview(@PathVariable String category, @PathVariable Long pid, @PathVariable Long cid){
        if(category.compareTo("notice")==0){
            return ResponseEntity.ok()
                    .body(noticeCommentsService.findById(cid));}
        else if(category.compareTo("anony")==0){
            return ResponseEntity.ok()
                    .body(anonyCommentsService.findById(cid));}
        else if(category.compareTo("activity")==0){
            return ResponseEntity.ok()
                    .body(activityCommentsService.findById(cid));}
        else return null;
    }

    /* 댓글 수정 */
    @PutMapping("/updateCmt/{category}/{pid}/{cid}")
    public ResponseEntity<?> update(@PathVariable String category, @PathVariable Long pid, @PathVariable Long cid, @RequestBody CommentsUpdateRequestDto
            updateRequestDto){
        if(category.compareTo("notice")==0){
            return ResponseEntity.ok()
                    .body(noticeCommentsService.update(cid, updateRequestDto));}
        else if(category.compareTo("anony")==0){
            return ResponseEntity.ok()
                    .body(anonyCommentsService.update(cid, updateRequestDto));}
        else if(category.compareTo("activity")==0){
            return ResponseEntity.ok()
                    .body(activityCommentsService.update(cid, updateRequestDto));}
        else return null;
    }

    /* 댓글 삭제 */
    @DeleteMapping("/deleteCmt/{category}/{pid}/{cid}")
    public ResponseEntity<?> delete(@PathVariable String category, @PathVariable Long pid, @PathVariable Long cid){

        if(category.compareTo("notice")==0) {
            noticeCommentsService.delete(cid);
        }
        else if(category.compareTo("anony")==0) {
            anonyCommentsService.delete(cid);
        }
        else if(category.compareTo("activity")==0) {
            activityCommentsService.delete(cid);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
