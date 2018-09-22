package border.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import border.form.MobamasuForm;
import border.logic.ForecastLogic;

/**
 * Servlet implementation class TopServlet
 * /TopServletでリクエストされるとここに来る
 */
@WebServlet("/TopServlet")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		//int day = logic.getDay();
		MobamasuForm form = new MobamasuForm();
		//日付を元にデータをゲット
		ForecastLogic forecastLogic = new ForecastLogic();
		int eventId = forecastLogic.getCurrentEventId();
		form.setEventName(forecastLogic.getEventName(eventId));
		forecastLogic.forecast(form,eventId);

		request.setAttribute("eventName",form.getEventName());
		request.setAttribute("day1Point_1",form.getDay1Point_1());
		request.setAttribute("day1Point_100",form.getDay1Point_100());
		request.setAttribute("day1Point_200",form.getDay1Point_200());
		request.setAttribute("day1Point_1000",form.getDay1Point_1000());
		request.setAttribute("day1Point_1500",form.getDay1Point_1500());
		request.setAttribute("day1Point_2000",form.getDay1Point_2000());
		request.setAttribute("day2Point_1",form.getDay2Point_1());
		request.setAttribute("day2Point_100",form.getDay2Point_100());
		request.setAttribute("day2Point_200",form.getDay2Point_200());
		request.setAttribute("day2Point_1000",form.getDay2Point_1000());
		request.setAttribute("day2Point_1500",form.getDay2Point_1500());
		request.setAttribute("day2Point_2000",form.getDay2Point_2000());
		request.setAttribute("day3Point_1",form.getDay3Point_1());
		request.setAttribute("day3Point_100",form.getDay3Point_100());
		request.setAttribute("day3Point_200",form.getDay3Point_200());
		request.setAttribute("day3Point_1000",form.getDay3Point_1000());
		request.setAttribute("day3Point_1500",form.getDay3Point_1500());
		request.setAttribute("day3Point_2000",form.getDay3Point_2000());
		request.setAttribute("day4Point_1",form.getDay4Point_1());
		request.setAttribute("day4Point_100",form.getDay4Point_100());
		request.setAttribute("day4Point_200",form.getDay4Point_200());
		request.setAttribute("day4Point_1000",form.getDay4Point_1000());
		request.setAttribute("day4Point_1500",form.getDay4Point_1500());
		request.setAttribute("day4Point_2000",form.getDay4Point_2000());
		request.setAttribute("day5Point_1",form.getDay5Point_1());
		request.setAttribute("day5Point_100",form.getDay5Point_100());
		request.setAttribute("day5Point_200",form.getDay5Point_200());
		request.setAttribute("day5Point_1000",form.getDay5Point_1000());
		request.setAttribute("day5Point_1500",form.getDay5Point_1500());
		request.setAttribute("day5Point_2000",form.getDay5Point_2000());
		request.setAttribute("day6Point_1",form.getDay6Point_1());
		request.setAttribute("day6Point_100",form.getDay6Point_100());
		request.setAttribute("day6Point_200",form.getDay6Point_200());
		request.setAttribute("day6Point_1000",form.getDay6Point_1000());
		request.setAttribute("day6Point_1500",form.getDay6Point_1500());
		request.setAttribute("day6Point_2000",form.getDay6Point_2000());
		request.setAttribute("day7Point_1",form.getDay7Point_1());
		request.setAttribute("day7Point_100",form.getDay7Point_100());
		request.setAttribute("day7Point_200",form.getDay7Point_200());
		request.setAttribute("day7Point_1000",form.getDay7Point_1000());
		request.setAttribute("day7Point_1500",form.getDay7Point_1500());
		request.setAttribute("day7Point_2000",form.getDay7Point_2000());
		request.setAttribute("day8Point_1",form.getDay8Point_1());
		request.setAttribute("day8Point_100",form.getDay8Point_100());
		request.setAttribute("day8Point_200",form.getDay8Point_200());
		request.setAttribute("day8Point_1000",form.getDay8Point_1000());
		request.setAttribute("day8Point_1500",form.getDay8Point_1500());
		request.setAttribute("day8Point_2000",form.getDay8Point_2000());
		request.setAttribute("day9Point_1",form.getDay9Point_1());
		request.setAttribute("day9Point_100",form.getDay9Point_100());
		request.setAttribute("day9Point_200",form.getDay9Point_200());
		request.setAttribute("day9Point_1000",form.getDay9Point_1000());
		request.setAttribute("day9Point_1500",form.getDay9Point_1500());
		request.setAttribute("day9Point_2000",form.getDay9Point_2000());

		// 参照するjspファイルの置き場
		String view = "/WEB-INF/view/index.jsp";
	    RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
