package com.qf.hrm.controll;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.qf.hrm.pojo.Document;
import com.qf.hrm.service.IDocumentService;

@Controller
public class DocumentControll {
	
	@Resource
	private IDocumentService documnetService;
	
	/**
	 * 查询文件
	 * @param document
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("document/selectDocument.action")
	public ModelAndView queryDocument(Document document) throws Exception{
		List<Document> listByTitle = documnetService.queryByTitle(document.getTitle());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("documents", listByTitle);
		modelAndView.setViewName("document/document");
		return modelAndView;
	}
	/**
	 * 跳转至上传文件
	 * @param document
	 * @return
	 */
	@RequestMapping("document/addDocument.action")
	public ModelAndView toAddDocumnet(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("document/showAddDocument");
		return modelAndView;
	}
	/**
	 * 上传文件
	 * @param document
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="document/addDocument1.action",method=RequestMethod.POST)
	public ModelAndView addDocumnet(HttpServletRequest request, Document document,
		@RequestParam(name="file",required=false)MultipartFile file) throws Exception{
		File file1 = new File("F:/UplodDocment/"+file.getOriginalFilename());
		file.transferTo(file1);
		document.setFileName(file.getOriginalFilename());
		ModelAndView modelAndView = new ModelAndView();
		documnetService.addDocument(request, document);
		//查询所有
		List<Document> listAll=documnetService.listAll();
		modelAndView.addObject("documents", listAll);
		modelAndView.setViewName("document/document");
		return modelAndView;
	}
	
	/**
	 * 删除文件
	 * @param document
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("document/removeDocument.action")
	public ModelAndView removeDocumnet(int[] ids) throws Exception{
		System.out.println("删除文件");
		ModelAndView modelAndView = new ModelAndView();
		for(int id:ids){
			documnetService.deleteDocument(id);
		}
		List<Document> listAll=documnetService.listAll();
		modelAndView.addObject("documents", listAll);
		modelAndView.setViewName("document/document");
		return modelAndView;
	}
	
	/**
	 * 修改文件
	 * @param document
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="document/updateDocument.action")
	public ModelAndView updateDocumnet(Document document,String flag,Integer dId,
			@RequestParam(name="file",required=false)MultipartFile file) throws Exception{
		if (flag != null) {
			ModelAndView modelAndView = new ModelAndView();
			Document document2 = documnetService.queryDocumentById(dId);
			modelAndView.addObject("document", document2);
			modelAndView.setViewName("document/showUpdateDocument");
			return modelAndView;
		} else {
			System.out.println("修改文件");
			System.out.println("document.getdId()"+document.getdId());
			ModelAndView modelAndView = new ModelAndView();
			System.out.println("fiel.getOriginalFilename()"+file.getOriginalFilename());
			File file1 = new File("F:/UplodDocment/"+file.getOriginalFilename());
			file.transferTo(file1);
			document.setFileName(file.getOriginalFilename());
			documnetService.updateDocument(document);
			List<Document> listAll=documnetService.listAll();
			modelAndView.addObject("documents", listAll);
			modelAndView.setViewName("document/document");
			return modelAndView;
		}
		
	}


	/**
	 * 文件的下载
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("document/downLoad.action")
	public ResponseEntity<byte[]> download(int id) throws Exception{
		Document document = documnetService.queryDocumentById(id);
		String fileName = document.getFileName();
		System.out.println("fileName="+fileName);
		File file=new File("F:/UplodDocment/"+fileName);
		InputStream in=new FileInputStream(file);
		byte[] buf=new byte[in.available()];
		in.read(buf);
		HttpHeaders headers=new HttpHeaders();
		headers.add("content-disposition","attachment;filename="+fileName);
		HttpStatus status=HttpStatus.OK;
		return new ResponseEntity<byte[]>(buf, headers, status);
	}
}
