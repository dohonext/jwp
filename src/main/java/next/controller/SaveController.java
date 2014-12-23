package next.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Question;

public class SaveController extends AbstractController {
	

	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		QuestionDao questionDao = new QuestionDao();
		Question question;
		List<Question> questions;
		
		
		//form.jsp에서 멤버를 받아온다.
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
	
		//question 생성하여 save(insert)
		question = new Question (writer, title, contents);
		questionDao.insert(question);
		
		//question insert가 끝나면 list를 보여준다. 
		questions = questionDao.findAll();
		ModelAndView mav = jstlView("list.jsp");
		mav.addObject("questions", questions);
		return mav;
	}
}
