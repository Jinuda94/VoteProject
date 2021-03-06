package pack01.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pack01.beans.Person;
import pack01.beans.Vote;
import pack01.dao.MysqlConnect;
import pack01.dao.VoteDao;

@Controller
@RequestMapping(value = "/vote")
public class VoteController {

	@RequestMapping(value = "/votecheck")
	public String votecheck(HttpServletRequest request, HttpServletResponse response, HttpSession session, Person a) {
		System.out.println("votecheck 옴");
		VoteDao vd = new VoteDao(new MysqlConnect());
		int checkFlag = vd.votecheck(a);
		System.out.println(checkFlag);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		if (checkFlag == 3) {
			session = request.getSession();
			session.setAttribute("se_num", a.getSe_num());
			session.setAttribute("name", a.getName());
			return "Vote";
		} else {
			request.setAttribute("alertflag", checkFlag);
			try {
				request.getRequestDispatcher("/vote/index").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "main";
		}
	}

	@RequestMapping(value = "/voteinsert")
	public void voteinsert(HttpServletRequest request, HttpServletResponse response, int voteRadio) {
		HttpSession session = request.getSession();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		VoteDao votedao = new VoteDao(new MysqlConnect());
		Person person = new Person();
		person.setVote(voteRadio);
		person.setName((String) session.getAttribute("name"));
		person.setSe_num((String) session.getAttribute("se_num"));
		
		int voteflag = 0;
		voteflag = votedao.voteselect(person);
		System.out.println("voteflag:"+voteflag);
		int result = 0;
		if(voteflag == 0) {
			result = votedao.voteinsert(person);
		}
		
		if (result == 1) {
			System.out.println("투표 정상적 입력성공.");
			request.setAttribute("alertflag", 10);
		} else {
			System.out.println("투표 비정상적 경로 or DB오류");
		}

		System.out.println("voteinsert 완료");
		session.invalidate();
		try {
			request.getRequestDispatcher("/vote/index").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "index")
	public String mainpage(Model model) {
		VoteDao votedao = new VoteDao(new MysqlConnect());
		Vote vote = votedao.voteresult();
		model.addAttribute("test",1);
		model.addAttribute("vt",vote);
		
		return "main";
	}

}
