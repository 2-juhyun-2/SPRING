package upload.data;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {

	@GetMapping("/upload/uploadform")
	public String uploadform()
	{
		return "upload/uploadForm"; //jsp주소
	}
	
	@PostMapping("/upload/upload")
	public ModelAndView upload(@RequestParam MultipartFile photo,
			@RequestParam String msg, HttpServletRequest request)
	{
		
		//이미지를 업로드할 경로구하기
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		System.out.println(path);
		
		//파일명
		String fileName=photo.getOriginalFilename();
		
		//이미지 저장에 필요한 fileUpload에 관한 사용자 지정클래스
		SpringFileWriter fileWriter=new SpringFileWriter();
		
		//이미지 저장 메소드 호출
		fileWriter.writeFile(photo, path, fileName);
		
		ModelAndView model=new ModelAndView();
		model.addObject("msg", msg);
		model.addObject("fileName", fileName);
		model.setViewName("upload/uploadResult");
		
		return model;
	}
}
