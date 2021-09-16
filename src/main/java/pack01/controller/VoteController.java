package pack01.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pack01.beans.Person;
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

		if (checkFlag == 1) {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>alert('정보가 일치하지 않습니다.'); location.href='/VoteProject/index.jsp';</script>");
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "redirect:/index.jsp";
		} else if (checkFlag == 2) {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>alert('이미 투표를 완료하였습니다.'); location.href='/VoteProject/index.jsp';</script>");
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "redirect:/index.jsp";
		} else {
			session = request.getSession();
			session.setAttribute("se_num", a.getSe_num());
			session.setAttribute("name", a.getName());
			return "Vote";
		}
	}

	@RequestMapping(value = "/voteinsert")
	public String voteinsert(HttpServletRequest request, HttpServletResponse response, int voteRadio) {
		HttpSession session = request.getSession();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		VoteDao votedao = new VoteDao(new MysqlConnect());
		Person person = new Person();
		person.setVote(voteRadio);
		person.setSe_num((String) session.getAttribute("se_num"));

		int result = votedao.voteinsert(person);

		if (result == 1) {
			try {
				PrintWriter pw = response.getWriter();
				pw.println("<script> " + "alert('투표가 완료되었습니다.'); " + "location.href='/VoteProject/index.jsp';"
						+ "</script>");
				pw.flush();
				pw.close();
				System.out.println("insert 완료");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			System.out.println("DB 오류");
		}

		System.out.println("voteinsert 완료");

		return "redirect:/index.jsp";
	}

}
