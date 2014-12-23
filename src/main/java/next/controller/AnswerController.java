package next.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.model.Answer;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;

public class AnswerController extends AbstractController {
	private AnswerDao answerDao = new AnswerDao();
	private Answer answer;
	//private List<Question> questions;

	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//qna.js에서 멤버를 받아온다.
		long questionId = Long.valueOf(request.getParameter("questionId"));
		String writer = request.getParameter("writer");
		String contents = request.getParameter("contents");
	
		//question 생성하여 save(insert)
		answer = new Answer (writer, contents, questionId);
		answerDao.insert(answer);
		
		//question insert가 끝나면 show를 보여준다. 
		ModelAndView mav = jsonView();
		//mav.addObject("questions", answer);
		return mav;
	}
}
