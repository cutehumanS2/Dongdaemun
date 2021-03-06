package com.dongdaemun.dongdaemun.web;

import com.dongdaemun.dongdaemun.config.auth.LoginUser;
import com.dongdaemun.dongdaemun.service.posts.PostsService;
import com.dongdaemun.dongdaemun.web.dto.posts.PostsSaveRequestDto;
import com.dongdaemun.dongdaemun.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@Controller
public class PostsEditApiController {

    private final PostsService postsService;

    @ResponseBody
    @GetMapping("/write")
    public ResponseEntity<?> insertEditor(ModelMap model, @RequestParam("email") String email,
            /* @LoginUser SessionUser user, */ @RequestParam("category") String category) throws Exception {
        // if (user != null) {
        // model.addAttribute("userEmail", user.getEmail());
        // model.addAttribute("category", category);
        // }
        // ModelAndView mav = new ModelAndView("smarteditor/newPost");
        // return mav;
        model.addAttribute(email);
        model.addAttribute(category);

        return new ResponseEntity<>(model, HttpStatus.OK);
    }
    /*
     * @GetMapping("/ckWrite")
     * public ModelAndView insertEditor( @LoginUser SessionUser
     * user, @RequestParam("category") String category) throws Exception {
     * 
     * ModelAndView mav = new ModelAndView("/ckPost");
     * return mav;
     * 
     * }
     */

    @ResponseBody
    @PostMapping("/save")
    public ResponseEntity<?> savePost(@RequestBody PostsSaveRequestDto requestDto,
            @RequestParam("category") String category) throws Exception {
        return ResponseEntity.ok()
                .body(postsService.save(requestDto));
    }

    // ????????? ?????????
    @RequestMapping(value = "/imageUpload.do", method = RequestMethod.POST)
    public void imageUpload(HttpServletRequest request,
            HttpServletResponse response, MultipartHttpServletRequest multiFile, @RequestParam MultipartFile upload)
            throws Exception {
        // ?????? ?????? ??????
        UUID uid = UUID.randomUUID();

        OutputStream out = null;
        PrintWriter printWriter = null;

        // ?????????
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        try {
            // ?????? ?????? ????????????
            String fileName = upload.getOriginalFilename();
            byte[] bytes = upload.getBytes();

            // ????????? ?????? ??????
            String path = "C:\\DongdaemunImg\\";
            String ckUploadPath = path + uid + "_" + fileName;
            File folder = new File(path);
            System.out.println("path:" + path); // ????????? ???????????? console??? ??????
            // ?????? ???????????? ??????
            if (!folder.exists()) {
                try {
                    folder.mkdirs(); // ?????? ??????
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }

            out = new FileOutputStream(new File(ckUploadPath));
            out.write(bytes);
            out.flush(); // outputStram??? ????????? ???????????? ???????????? ?????????

            String callback = request.getParameter("CKEditorFuncNum");
            printWriter = response.getWriter();
            String fileUrl = "/ckImgSubmit.do?uid=" + uid + "&fileName=" + fileName; // ????????????

            // ???????????? ????????? ??????
            printWriter.println("{\"filename\" : \"" + fileName + "\", \"uploaded\" : 1, \"url\":\"" + fileUrl + "\"}");
            printWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return;
    }

    // ????????? ????????? ????????? ????????????
    @RequestMapping(value = "/ckImgSubmit.do")
    public void ckSubmit(@RequestParam(value = "uid") String uid, @RequestParam(value = "fileName") String fileName,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ????????? ????????? ????????? ??????
        String path = "C:\\DongdaemunImg\\"; // ????????? ????????? ??????
        System.out.println("path:" + path);
        String sDirPath = path + uid + "_" + fileName;

        File imgFile = new File(sDirPath);

        // ?????? ????????? ?????? ????????? ?????? ??????????????? ??? ????????? ????????? ????????????.
        if (imgFile.isFile()) {
            byte[] buf = new byte[1024];
            int readByte = 0;
            int length = 0;
            byte[] imgBuf = null;

            FileInputStream fileInputStream = null;
            ByteArrayOutputStream outputStream = null;
            ServletOutputStream out = null;

            try {
                fileInputStream = new FileInputStream(imgFile);
                outputStream = new ByteArrayOutputStream();
                out = response.getOutputStream();

                while ((readByte = fileInputStream.read(buf)) != -1) {
                    outputStream.write(buf, 0, readByte);
                }

                imgBuf = outputStream.toByteArray();
                length = imgBuf.length;
                out.write(imgBuf, 0, length);
                out.flush();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                outputStream.close();
                fileInputStream.close();
                out.close();
            }
        }
    }
}