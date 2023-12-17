package com.study.springboot.board.notice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.study.springboot.board.notice.service.NoticeService;

import com.study.springboot.board.notice.spring.ModifyRequest;
import com.study.springboot.board.notice.spring.NoticeArticlePage;
import com.study.springboot.board.notice.spring.WriteRequest;
import com.study.springboot.board.proposal.spring.Article;
import com.study.springboot.log.spring.AuthInfo;

@Controller
@RequestMapping("/notice")
public class NoitceController {
	
	@Autowired
	private NoticeService noticeService;
	

	@GetMapping("/list")
	public String listArticle(Model model, @RequestParam(value = "pageNo", required = false) String pageNoVal) {
		int pageNo = 1;
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal); 
		}
		NoticeArticlePage noticeArticlePage = noticeService.getNoticeArticlePage(pageNo);
		model.addAttribute("noticeArticlePage", noticeArticlePage);
		return "notice/noticeList";
	}
	
	@GetMapping("/view")
	public String noticeViewArticle(@RequestParam int articleNo, Model model) {
		
			Article article = noticeService.getArticle(articleNo, true);
			model.addAttribute("article", article);
			model.addAttribute("articleNo", articleNo);
			return "notice/noticeView";
		
	}
	
	@GetMapping("/delete")
	public String noticeDeleteArticle(@RequestParam int articleNo) {
		noticeService.noticeDelete(articleNo);
		return "/";
	}
	
	
	@GetMapping("/modify")
	public String noticeModiftArticleGet(ModifyRequest modReq, Model model) {
		Article article = noticeService.getArticle(modReq.getArticleNo(), false);
		model.addAttribute("article",article);
		return "notice/noticeModifyForm";
	}
		
	@PostMapping("/modify")
		public String noticeModifyArticlePost(Model model, ModifyRequest modReq) {
			noticeService.noticeModify(modReq);	
			Article article = noticeService.getArticle(modReq.getArticleNo(),false);
			model.addAttribute("article", article);
			model.addAttribute("articleNo", modReq.getArticleNo());			
			return "notice/noticeView";
	}
	
	@GetMapping("/write")
	public String writeArticle1Get() {
		return "notice/newNoticeArticleForm";
	}
	
	@PostMapping("/write")
	public String writeArticle1Post(Model model, WriteRequest writeRequest, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		int newArticleNo =  noticeService.noticeInsert(writeRequest, authInfo);
		model.addAttribute("newArticleNo", newArticleNo);
		
//		Map<String, Boolean> errors = new HashMap<>();
//		model.addAttribute("errors", errors);
//		writeRequest.validate(errors);
//		
//		
//		if (!errors.isEmpty()) {
//			return "notice/newNoticeArticleForm";
//		}
//
//		
//		int newArticleNo = noticeWriteService.noticeInsert(writeRequest, authInfo);
//		model.addAttribute("newArticleNo", newArticleNo);
		
		return "/main";
		
		
	}
}
