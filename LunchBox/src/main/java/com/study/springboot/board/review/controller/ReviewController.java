package com.study.springboot.board.review.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.board.notice.spring.ModifyRequest;
import com.study.springboot.board.notice.spring.WriteRequest;
import com.study.springboot.board.proposal.spring.Article;
import com.study.springboot.board.review.service.ReviewService;
import com.study.springboot.board.review.spring.ReviewArticlePage;
import com.study.springboot.log.spring.AuthInfo;


@Controller
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/delete")
	public String reviewDeleteArticle(@RequestParam int articleNo) {
		reviewService.reviewDelete(articleNo);
		return "/review/list";
	}
	
	@GetMapping("/list")
	public String listArticle(Model model, @RequestParam(value = "pageNo", required = false) String pageNoVal) {
		int pageNo = 1;
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal); 
		}
		ReviewArticlePage reviewArticlePage = reviewService.getReviewArticlePage(pageNo);
		model.addAttribute("reviewArticlePage", reviewArticlePage);
		return "review/reviewList";
	}
	

	@GetMapping("/modify")
	public String reviewModiftArticleGet(ModifyRequest modReq, Model model) {
		Article article = reviewService.getArticle(modReq.getArticleNo(), false);
		model.addAttribute("article",article);
		return "review/reviewModifyForm";
	}
		
	@PostMapping("/modify")
		public String reviewModifyArticlePost(Model model, ModifyRequest modReq) {
			reviewService.reviewModify(modReq);	
			Article article = reviewService.getArticle(modReq.getArticleNo(),false);
			model.addAttribute("article", article);
			model.addAttribute("articleNo", modReq.getArticleNo());
			
//			Map<String, Boolean> errors = new HashMap<>();
//			if (!errors.isEmpty()) {
//				return "notice/noticeModifyForm";
//			}
			
			
			return "review/reviewView";
	}
	
	@GetMapping("/view")
	public String reviewViewArticle(@RequestParam int articleNo, Model model,HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");	
		model.addAttribute("authInfo", authInfo);
			Article article = reviewService.getArticle(articleNo, true);
			model.addAttribute("article", article);
			model.addAttribute("articleNo", articleNo);
			return "review/reviewView";
		
	}
	
	@GetMapping("/write")
	public String writeArticle1Get() {
		return "review/newReviewArticleForm";
	}
	
	@PostMapping("/write")
	public String writeArticle1Post(Model model, WriteRequest writeRequest, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		int newArticleNo =  reviewService.reviewInsert(writeRequest, authInfo);
		model.addAttribute("newArticleNo", newArticleNo);
		

		return "review/newArticleSuccess";
		
		
	}
}
