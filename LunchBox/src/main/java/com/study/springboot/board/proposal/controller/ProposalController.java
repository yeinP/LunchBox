package com.study.springboot.board.proposal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.board.proposal.service.ProposalService;
import com.study.springboot.board.proposal.spring.Article;
import com.study.springboot.board.proposal.spring.ArticleCommand;
import com.study.springboot.board.proposal.spring.ArticlePage;
import com.study.springboot.board.proposal.spring.ModifyCommand;
import com.study.springboot.log.spring.AuthInfo;

@Controller
@RequestMapping("/board")
public class ProposalController {

	@Autowired
	private ProposalService proposalService;
	
	@GetMapping("/delete")
	public String delete(@RequestParam int articleNo) {
		proposalService.deleteArticle(articleNo);
		return "board/deleteSuccess";
	}
	
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam int articleNo /*, @RequestParam(required=false) int showNo*/) {
		
		model.addAttribute("detailArticle",proposalService.readArticle(articleNo));
		model.addAttribute("articleNo",articleNo);
		return "board/detailArticle";
	}
	
	@GetMapping("/proposal")
	public String proposalList1(Model model, @RequestParam(value="pageNo", required = false) String pageNoVal) {
		
		//건의게시판list를 뽑아서 보낸다.
		model.addAttribute("articles",proposalService.listProposalArticle());
		
		//건의 게시판 페이지처리
		int pageNo = 1;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		ArticlePage articlePage = proposalService.getArticlePage(pageNo);  //pageNo가 있으면 pageNo를 가져온다
		model.addAttribute("articlePage", articlePage);
		
		return "board/listArticle";
	}
	
	@GetMapping("/modify")
	public String modify1(Model model, ModifyCommand modifyCommand) {
		
		Article article = proposalService.readArticle(modifyCommand.getArticleNo());
		model.addAttribute("article",article);
		
		return "board/modifyForm";
	}
	
	@PostMapping("/modify")
	public String modify2(Model model, ModifyCommand modifyCommand) {
		System.out.println(modifyCommand.getArticleNo());
		System.out.println(modifyCommand.getArticleTitle());
		System.out.println(modifyCommand.getArticleContent());
		
		proposalService.updateArticle(modifyCommand);
		
		Article article = proposalService.readArticle(modifyCommand.getArticleNo());
		model.addAttribute("detailArticle",article);
		model.addAttribute("articleNo",modifyCommand.getArticleNo());
		
		return "board/detailArticle";
	}
	
	@GetMapping("/write")
	public String write1(HttpSession session) {
	AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
	if(authInfo == null) {
		
		//로그인 후 사용하도록 인터셉터
		return "redirect:/";
	}
		return "board/newArticleForm";
	}
	
	
	//새글 작성 성공 시 등록을 성공했습니다 페이지로 이동
	@PostMapping("/write")
	public String write2(Model model, ArticleCommand articleCommand, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		int articleNo =  proposalService.insertProposalArticle(articleCommand, authInfo);
		
		int newArticleNo = articleNo;
		
		model.addAttribute("newArticleNo",newArticleNo);
		System.out.println(newArticleNo);
		
		return "board/newArticleSuccess";
	}
}
