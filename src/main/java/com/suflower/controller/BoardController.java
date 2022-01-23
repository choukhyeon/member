package com.suflower.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.suflower.domain.BoardVO;
import com.suflower.domain.Criteria;
import com.suflower.domain.MemberVO;
import com.suflower.domain.PageMakerDTO;
import com.suflower.service.BoardService;
import com.suflower.service.MemberService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board/*")
// Board Controller는 BoardService에 의존적이므로 
// @AllArgsConstructor를 이용해서 생성자를 만들고 자동으로 주입하게 해줌
@AllArgsConstructor
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	// postwrite에서 받은 게시글을 파라미터부여해서 넘겨줌.
	@Autowired
	private BoardService bservice;

	@Autowired
	MemberService service;

	// 세션 확인용
	@GetMapping("/session")
	public void SessionGet() {
	}

	// 게시글 페이징 조회
	@GetMapping("/blist")
	public void boardListGET(Model model, Criteria cri) {
		log.info("boardListGET");
		model.addAttribute("blist", bservice.getListPaging(cri));
		int total = bservice.getTotal(cri);
		PageMakerDTO pageMake = new PageMakerDTO(cri, total);
		model.addAttribute("pageMaker", pageMake);
	}

	// 게시글 조회
	@GetMapping("/get")
	public String boardGetPageGET(long boardNo, Model model, Criteria cri, HttpServletRequest request,MemberVO vo,RedirectAttributes rttr) {
		if (request.getAttribute("loginID") != null) {
			// request.getSession(false)를 하면 세션 없으면 그냥 null으로 표기
			// 반대로 request.getSession() 을 하면 세션이 없으면 만듦
			if (vo.getMemberId() == null || vo.getMemberId().length() < 1) {
				HttpSession session = request.getSession(false);
				System.out.println("vo=>" + vo.getMemberId());
				if (session != null && session.getAttribute("loginID") != null) {
					vo.setMemberId((String) session.getAttribute("loginID"));
					System.out.println(session.getAttribute("loginID"));
					System.out.println("게시글 진입");
					model.addAttribute("pageInfo", bservice.getPage(boardNo));
					model.addAttribute("cri", cri);
					return "redirect:/board/bwrite";
				}
			}
		}else {
			rttr.addFlashAttribute("result", "login check");}
			return "redirect:/member/login";
	}

	// 게시판 작성폼 (bwrite)
	@GetMapping("/bwrite")
	public void boardbwriteGet() {
		log.info("게시판 작성 페이지 진입!");
	}

	// 수정 페이지로 이동
	@GetMapping("/modify")
	public void boardModifyGET(long boardNo, Model model, Criteria cri) {
		model.addAttribute("pageInfo", bservice.getPage(boardNo));
		model.addAttribute("cri", cri);
	}

	// 페이지 수정
	@PostMapping("/modify")
	public String boardModifyPOST(BoardVO board, RedirectAttributes rttr) {
		bservice.modify(board);
		rttr.addFlashAttribute("result", "modify success");
		return "redirect:/board/blist";
	}

	// 게시판 작성
	@PostMapping("/bwrite")
	public String boardwritePost(BoardVO board, RedirectAttributes rttr) {
		// BoardService에서 게시판 등록을 수행하는 bwrite를 불러옴.
		// 해당 데이터를 전달하기 위해서 인자값으로 뷰로부터 전달받은 BoardVO를 삽입
		bservice.bwrite(board);
		// 작성 완료시 알림창이 뜨게해줌.
		rttr.addFlashAttribute("result", "bwrite success");
		// 끝나고나면 다시 목록페이지로 돌아가게 해줌
		return "redirect:/board/blist";
	}

	// 게시글 삭제
	@PostMapping("/delete")
	public String boardDeletePost(long boardNo, RedirectAttributes rttr) {
		bservice.delete(boardNo);
		rttr.addFlashAttribute("result", "delete success");
		return "redirect:/board/blist";
	}

}

/*
 * // 게시판 리스트 조회 (blist)
 * 
 * @GetMapping("/blist") public void boardListGet(Model model) {
 * log.info("게시판 목록 페이지 진입!"); model.addAttribute("blist", bservice.getList());
 * }
 */
