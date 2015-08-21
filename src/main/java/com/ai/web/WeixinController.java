package com.ai.web;

import java.io.File;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ai.service.IWeixinService;
import com.ai.util.ImageUtil;
import com.ai.util.PhotoUtil;
import com.ai.web.model.CheckResultModel;
import com.ai.web.model.IdCardModel;
import com.ai.web.model.JSONResultModel;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/wx")
public class WeixinController {

	private static final Logger logger = LoggerFactory.getLogger(WeixinController.class);
	@Autowired
	IWeixinService weixinService;

	@RequestMapping(value = "/entrance",method=RequestMethod.GET)
	public String entrance() throws Exception{
		return "entrance";
	}
	@RequestMapping(value = "/promise", method = RequestMethod.GET)
	public String getPromise(String vin,String carSeries ,Locale locale, Model model,RedirectAttributes attributes) {
		System.out.println("promise-get:"+vin);
		model.addAttribute("carSeries", carSeries);
		model.addAttribute("vin", vin);
		return "promise";
	}
	
	@RequestMapping(value = "/promise", method = RequestMethod.POST)
	public String postPromise(String vin,String carSeries,Locale locale, Model model,RedirectAttributes attributes) {

		attributes.addAttribute("vin", vin);
		attributes.addAttribute("carSeries", carSeries);
		System.out.println("promise-post:"+vin);
		return "redirect:idcard";
	}

	@RequestMapping(value = "/vin", method = RequestMethod.GET)
	public String getCar(Locale locale, Model model, HttpServletRequest request) {

		return "vin";
	}

	@RequestMapping(value = "/vin", method = RequestMethod.POST)
	public String postCar(String vin,String carSeries, Locale locale, Model model,RedirectAttributes attributes) {
		
		attributes.addAttribute("vin", vin);
		attributes.addAttribute("carSeries", carSeries);
		System.out.println("vin-post:"+vin);
		return "redirect:promise";
	}

	@RequestMapping(value = "/checkVin", method = RequestMethod.GET)
	public @ResponseBody CheckResultModel checkVin(String carSeries, String vin, Model model) throws Exception {
		System.out.println("checkVin:"+vin);
		CheckResultModel result = weixinService.getVin(vin);
		if (vin.equals("www")) {
			result.setResult("0");;
		}
		
		return result;

	}

	@RequestMapping(value = "/checkIdcard", method = RequestMethod.GET)
	public @ResponseBody CheckResultModel checkId(IdCardModel idcard, Model model) throws Exception {
		System.out.println(idcard.getIdNo());
		CheckResultModel result = weixinService.getIdCard(idcard);
		if (idcard.getIdNo().equals("123")) {
			result.setResult("0");;
		}
		return result;

	}

	@RequestMapping(value = "/idcard", method = RequestMethod.GET)
	public String getIdCheck(String carSeries, String vin,IdCardModel id, Locale locale, Model model, HttpServletRequest request) throws Exception {
		System.out.println("idcard:get:"+vin);
		model.addAttribute("carSeries", carSeries);
		model.addAttribute("vin", vin);
		return "idcard";
	}

	@RequestMapping(value = "/idcard", method = RequestMethod.POST)
	public String postIdCheck(String carSeries, String vin,IdCardModel id,Locale locale, Model model,RedirectAttributes attributes) {
		System.out.println("idcard:post:"+vin);
		attributes.addAttribute("vin", vin);
		attributes.addAttribute("carSeries", carSeries);
//		attributes.addAttribute("idcard", id);
		attributes.addAttribute("idName",id.getIdName());
		attributes.addAttribute("idNo",id.getIdNo());
		attributes.addAttribute("idStartDate",id.getIdStartDate());
		attributes.addAttribute("idEndDate",id.getIdEndDate());
		attributes.addAttribute("contactTel",id.getContactTel());
		return "redirect:photo";
	}

	@RequestMapping(value = "/photo", method = RequestMethod.GET)
	public String getPhoto(String carSeries, String vin,IdCardModel id,Locale locale, Model model) {
		model.addAttribute("carSeries", carSeries);
		model.addAttribute("vin", vin);
		model.addAttribute("idName",id.getIdName());
		model.addAttribute("idNo",id.getIdNo());
		model.addAttribute("idStartDate",id.getIdStartDate());
		model.addAttribute("idEndDate",id.getIdEndDate());
		model.addAttribute("contactTel",id.getContactTel());
		System.out.println("photo:get:"+vin);
		return "photo";
	}

	@RequestMapping(value = "/photo", method = RequestMethod.POST)
	public String postPhoto(@RequestParam(value = "photo1", required = true) String photo1, HttpServletRequest request, ModelMap model,
			@RequestParam(value = "photo2", required = true) String photo2, @RequestParam(value = "photo3", required = true) String photo3,IdCardModel idcard) throws Exception{
		
		String path = request.getSession().getServletContext().getRealPath("upload");
		System.out.println(path+":"+photo1+":"+photo2+":"+photo3);
		System.out.println(idcard.getContactTel());
		//生成订单,路径及三个photo的文件名,身份证信息、车架号信息
		weixinService.insertOrder();
		
		return "redirect:entrance";
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String query(Locale locale, Model model) {

		return "query";
	}

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public String postQuery(Locale locale, Model model) {

		return "queryresult";
	}

	@RequestMapping(value = "/fileupload")
	public @ResponseBody JSONResultModel upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) throws Exception{
		String path = request.getSession().getServletContext().getRealPath("upload");
		String fileName = file.getOriginalFilename();
		// String fileName = new Date().getTime()+".jpg";
		System.out.println(path);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String destImageName = new Date().getTime()+".jpg";
		ImageUtil.imgWatermark(path, fileName, destImageName);
//		System.out.println(destImageName);
//		System.out.println(path+"/"+destImageName);
		
		System.out.println(request.getContextPath() + "/upload/" + destImageName);

		JSONResultModel result = new JSONResultModel();
		result.setKey("url");
		result.setValue(request.getContextPath() + "/upload/" + destImageName);
		return result;
	}
	@RequestMapping(value="photoupload")
	public @ResponseBody JSONResultModel photo(@RequestParam("photo") String photo,HttpServletRequest request) throws Exception{
		String path = request.getSession().getServletContext().getRealPath("upload");
		String time = new Date().getTime()+"";
//		String originPhotoName = time+".jpg";
//		String watermarkPhotoName = "watermark_"+time+".jpg";
//		System.out.println(path);
		PhotoUtil.GenerateImage(photo.split(",")[1],path+"/"+time+".jpg");
		ImageUtil.imgWatermark(path, time+".jpg", "watermark_"+time+".jpg");
		
		
		JSONResultModel result = new JSONResultModel();
		result.setKey(time);
		result.setValue(request.getContextPath() + "/upload/" + "watermark_"+time+".jpg");
		return result;
	}
}
