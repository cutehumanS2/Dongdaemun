package com.dongdaemun.dongdaemun.web;

import com.dongdaemun.dongdaemun.config.auth.LoginUser;
import com.dongdaemun.dongdaemun.domain.posts.AnonyPosts;
import com.dongdaemun.dongdaemun.domain.posts.NoticePosts;
import com.dongdaemun.dongdaemun.service.ActivityPostsService;
import com.dongdaemun.dongdaemun.service.AnonyPostsService;
import com.dongdaemun.dongdaemun.web.dto.PostsSaveRequestDto;
import com.dongdaemun.dongdaemun.web.dto.PhotosSaveRequestDto;

import com.dongdaemun.dongdaemun.config.auth.dto.SessionUser;
import com.dongdaemun.dongdaemun.service.NoticePostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
public class PostsEditApiController {

    private final NoticePostsService noticePostsService;
    private final AnonyPostsService anonyPostsService;
    private final ActivityPostsService activityPostsService;

    @GetMapping("/write/{category}")
    public ModelAndView insertEditor(ModelMap model, @LoginUser SessionUser user, @PathVariable String category) throws Exception {
        if (user != null) {
            model.addAttribute("userEmail", user.getEmail());
            model.addAttribute("category", category);
        }
        ModelAndView mav = new ModelAndView("smarteditor/newPost");

        return mav;
    }

    @ResponseBody
    @PostMapping("/save/{category}")
    public ResponseEntity<?> savePost(@RequestBody PostsSaveRequestDto requestDto, @PathVariable String category) throws Exception{
        if(category.compareTo("notice")==0){
            return ResponseEntity.ok()
                    .body(noticePostsService.save(requestDto));}
        else if(category.compareTo("anony")==0){
            return ResponseEntity.ok()
                    .body(anonyPostsService.save(requestDto));}
        else if(category.compareTo("activity")==0){
            return ResponseEntity.ok()
                    .body(activityPostsService.save(requestDto));}
        else return null;
    }

    //단일 파일 업로드
    @RequestMapping("/singlePhotoUpload")
    public String singlePhotoUploader(HttpServletRequest request, PhotosSaveRequestDto requestDto) throws UnsupportedEncodingException {
        String callback = requestDto.getCallback();
        String callback_func = requestDto.getCallback_func();
        String file_result = "";
        MultipartFile multipartFile = requestDto.getFiledata();
        try {
            if(requestDto.getFiledata() != null && requestDto.getFiledata().getOriginalFilename() != null && !requestDto.getFiledata().getOriginalFilename().equals("")){
                //파일이 존재하면
                String original_name = requestDto.getFiledata().getOriginalFilename();
                String ext = original_name.substring(original_name.lastIndexOf(".")+1);
                //파일 기본경로
                String defaultPath = request.getSession().getServletContext().getRealPath("/");
                //파일 기본경로 _ 상세경로
                String path = defaultPath + "resource" + File.separator + "photo_upload" + File.separator;
                File file = new File(path);
                System.out.println("path:"+path);
                //디렉토리 존재하지 않을경우 디렉토리 생성
                if(!file.exists()) {
                    file.mkdirs();
                }
                //서버에 업로드 할 파일명(한글문제로 인해 원본파일은 올리지 않는것이 좋음)
                String realname = UUID.randomUUID().toString() + "." + ext;
                ///////////////// 서버에 파일쓰기 /////////////////
                requestDto.getFiledata().transferTo(new File(path+realname));
                file_result += "&bNewLine=true&sFileName="+original_name+"&sFileURL=/resource/photo_upload/"+realname;
            } else {
                file_result += "&errstr=error";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:" + callback + "?callback_func="+callback_func+file_result;
    }

    //다중 파일 업로드
    @RequestMapping("/multiplePhotoUpload")
    public void multiplePhotoUploader(HttpServletRequest request, HttpServletResponse response){
        try {
            //파일정보
            String sFileInfo = "";
            //파일명을 받는다 - 일반 원본파일명
            String filename = request.getHeader("file-name");
            //파일 확장자
            String filename_ext = filename.substring(filename.lastIndexOf(".")+1);
            //확장자를소문자로 변경
            filename_ext = filename_ext.toLowerCase();
            //파일 기본경로
            String dftFilePath = request.getSession().getServletContext().getRealPath("/");
            //파일 기본경로 _ 상세경로
            String filePath = dftFilePath + "resource" + File.separator + "photo_upload" + File.separator;
            File file = new File(filePath);
            if(!file.exists()) {
                file.mkdirs();
            }
            String realFileNm = "";
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            String today= formatter.format(new java.util.Date());
            realFileNm = today+UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
            String rlFileNm = filePath + realFileNm;
            ///////////////// 서버에 파일쓰기 /////////////////
            InputStream is = request.getInputStream();
            OutputStream os=new FileOutputStream(rlFileNm);
            int numRead;
            byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
            while((numRead = is.read(b,0,b.length)) != -1){
                os.write(b,0,numRead);
            }
            if(is != null) {
                is.close();
            }
            os.flush();
            os.close();
            ///////////////// 서버에 파일쓰기 /////////////////
            // 정보 출력
            sFileInfo += "&bNewLine=true";
            // img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
            sFileInfo += "&sFileName="+ filename;;
            sFileInfo += "&sFileURL="+"/resource/photo_upload/"+realFileNm;
            PrintWriter print = response.getWriter();
            print.print(sFileInfo);
            print.flush();
            print.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}