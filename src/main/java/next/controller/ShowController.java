package next.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import next.model.Question;
import core.mvc.Controller;
import core.mvc.JstlView;
import core.mvc.ModelAndView;
import core.utils.ServletRequestUtils;

public class ShowController implements Controller {
	private static final Logger logger = LoggerFactory.getLogger(ShowController.class);
	
	private QuestionDao questionDao = new QuestionDao();
	private AnswerDao answerDao = new AnswerDao();
	private Question question;
	private List<Answer> answers;
	
	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		long questionId = ServletRequestUtils.getRequiredLongParameter(request, "questionId");
		logger.debug("questionId : {}", questionId);
		question = questionDao.findById(questionId);
		answers = answerDao.findAllByQuestionId(questionId);
		ModelAndView mav = new ModelAndView(new JstlView("show.jsp"));
		mav.addObject("question", question);
		mav.addObject("answers", answers);
		return mav;
	}
}
