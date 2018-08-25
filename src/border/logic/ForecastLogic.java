package border.logic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import border.form.MobamasuForm;
import database.DBConnection;
import database.Day1PointDAO;
import database.Day2PointDAO;
import database.Day3PointDAO;
import database.Day4PointDAO;
import database.Day5PointDAO;
import database.Day6PointDAO;
import database.Day7PointDAO;
import database.Day8PointDAO;
import database.Day9PointDAO;
import database.DayPointDTO;
import database.EventInfoDAO;
import database.EventInfoDTO;

public class ForecastLogic {
	//イベント名を取得する
	public String getEventName(int evetnId) {
		Connection conn = null;
		try {
			// DriverのLoad
			DBConnection.loadDriver();
			// データベースへ接続
			conn = DBConnection.connect();
			EventInfoDAO eventInfoDao = EventInfoDAO.getInstance();
			EventInfoDTO eventInfoDto = eventInfoDao.select(conn, evetnId);
			return eventInfoDto.getEvent_name();
		} catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.disconnect(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	//過去のイベントIDを取得するメソッド
	//引数は現在のイベントID
	//戻り値は過去のイベント
	private List<Integer> getPastEventId(Connection conn, int evetnId) throws IOException, SQLException {
		EventInfoDAO eventInfoDao = EventInfoDAO.getInstance();
		return eventInfoDao.getEventIdListPastThreeEvents(conn, evetnId);
	}

	//過去ポイントを取得するメソッド
	//引数はイベントID
	//戻り値はDTO
	//private
	private DayPointDTO getPastPoint(Connection conn, int eventId,int day) throws IOException, SQLException {
		switch(day) {
		case 1:
			// Day1point
			return Day1PointDAO.getInstance().select(conn, eventId);
		case 2:
			// Day2point
			return Day2PointDAO.getInstance().select(conn, eventId);
		case 3:
			// Day3point
			return Day3PointDAO.getInstance().select(conn, eventId);
		case 4:
			// Day4point
			return Day4PointDAO.getInstance().select(conn, eventId);
		case 5:
			// Day5point
			return Day5PointDAO.getInstance().select(conn, eventId);
		case 6:
			// Day6point
			return Day6PointDAO.getInstance().select(conn, eventId);
		case 7:
			// Day7point
			return Day7PointDAO.getInstance().select(conn, eventId);
		case 8:
			// Day8point
			return Day8PointDAO.getInstance().select(conn, eventId);
		case 9:
			// Day9point
			return Day9PointDAO.getInstance().select(conn, eventId);
		default :
			return null;
		}
	}

	//過去ポイントから直近イベントの平均を算出
	//引数は上記メソッドDTO
	//戻り値はDTO
	//private
	private DayPointDTO calPoint(Connection conn, int eventId1, int eventId2, int eventId3, int day) throws IOException, SQLException {
		DayPointDTO past1 = new DayPointDTO();
		past1 = getPastPoint(conn, eventId1,day);
		DayPointDTO past2 = new DayPointDTO();
		past2 = getPastPoint(conn, eventId2,day);
		DayPointDTO past3 = new DayPointDTO();
		past3 = getPastPoint(conn, eventId3,day);

		DayPointDTO point = new DayPointDTO();
		point.setPoint_place_1st((past1.getPoint_place_1st()+past2.getPoint_place_1st()+past3.getPoint_place_1st())/3);
		point.setPoint_place_100th((past1.getPoint_place_100th()+past2.getPoint_place_100th()+past3.getPoint_place_100th())/3);
		point.setPoint_place_200th((past1.getPoint_place_200th()+past2.getPoint_place_200th()+past3.getPoint_place_200th())/3);
		point.setPoint_place_1000th((past1.getPoint_place_1000th()+past2.getPoint_place_1000th()+past3.getPoint_place_1000th())/3);
		point.setPoint_place_1st((past1.getPoint_place_1500th()+past2.getPoint_place_1500th()+past3.getPoint_place_1500th())/3);
		point.setPoint_place_1st((past1.getPoint_place_2000th()+past2.getPoint_place_2000th()+past3.getPoint_place_2000th())/3);

		return point;
	}

	//平均×アイドルの人気度的係数で予測するメソッド
	//引数はイベントID
	//戻り値はDTOまたはFORM,LIST
	//一日目から必要日数分のポイントを保持し渡す
	//このメソッドはコントローラから呼ばれることを想定しpublic
	//TODO 改修したい（FORMの受け渡しはやめたい）
	public void forecast(MobamasuForm form,int eventId) {
		Connection conn = null;
		try {
			// DriverのLoad
			DBConnection.loadDriver();
			// データベースへ接続
			conn = DBConnection.connect();
			List<Integer> eventList = getPastEventId(conn, eventId);

			int pastEventId1 = eventList.get(0);
			int pastEventId2 = eventList.get(1);
			int pastEventId3 = eventList.get(2);

			DayPointDTO dto = calPoint(conn, pastEventId1, pastEventId2, pastEventId3, 1);
			form.setDay1Point_1(String.valueOf(dto.getPoint_place_1st()));
			form.setDay1Point_100(String.valueOf(dto.getPoint_place_100th()));
			form.setDay1Point_200(String.valueOf(dto.getPoint_place_200th()));
			form.setDay1Point_1000(String.valueOf(dto.getPoint_place_1000th()));
			form.setDay1Point_1500(String.valueOf(dto.getPoint_place_1500th()));
			form.setDay1Point_2000(String.valueOf(dto.getPoint_place_2000th()));

			dto = calPoint(conn, pastEventId1, pastEventId2, pastEventId3, 2);
			form.setDay2Point_1(String.valueOf(dto.getPoint_place_1st()));
			form.setDay2Point_100(String.valueOf(dto.getPoint_place_100th()));
			form.setDay2Point_200(String.valueOf(dto.getPoint_place_200th()));
			form.setDay2Point_1000(String.valueOf(dto.getPoint_place_1000th()));
			form.setDay2Point_1500(String.valueOf(dto.getPoint_place_1500th()));
			form.setDay2Point_2000(String.valueOf(dto.getPoint_place_2000th()));

			dto = calPoint(conn, pastEventId1, pastEventId2, pastEventId3, 3);
			form.setDay3Point_1(String.valueOf(dto.getPoint_place_1st()));
			form.setDay3Point_100(String.valueOf(dto.getPoint_place_100th()));
			form.setDay3Point_200(String.valueOf(dto.getPoint_place_200th()));
			form.setDay3Point_1000(String.valueOf(dto.getPoint_place_1000th()));
			form.setDay3Point_1500(String.valueOf(dto.getPoint_place_1500th()));
			form.setDay3Point_2000(String.valueOf(dto.getPoint_place_2000th()));

			dto = calPoint(conn, pastEventId1, pastEventId2, pastEventId3, 4);
			form.setDay4Point_1(String.valueOf(dto.getPoint_place_1st()));
			form.setDay4Point_100(String.valueOf(dto.getPoint_place_100th()));
			form.setDay4Point_200(String.valueOf(dto.getPoint_place_200th()));
			form.setDay4Point_1000(String.valueOf(dto.getPoint_place_1000th()));
			form.setDay4Point_1500(String.valueOf(dto.getPoint_place_1500th()));
			form.setDay4Point_2000(String.valueOf(dto.getPoint_place_2000th()));

			dto = calPoint(conn, pastEventId1, pastEventId2, pastEventId3, 5);
			form.setDay5Point_1(String.valueOf(dto.getPoint_place_1st()));
			form.setDay5Point_100(String.valueOf(dto.getPoint_place_100th()));
			form.setDay5Point_200(String.valueOf(dto.getPoint_place_200th()));
			form.setDay5Point_1000(String.valueOf(dto.getPoint_place_1000th()));
			form.setDay5Point_1500(String.valueOf(dto.getPoint_place_1500th()));
			form.setDay5Point_2000(String.valueOf(dto.getPoint_place_2000th()));

			dto = calPoint(conn, pastEventId1, pastEventId2, pastEventId3, 6);
			form.setDay6Point_1(String.valueOf(dto.getPoint_place_1st()));
			form.setDay6Point_100(String.valueOf(dto.getPoint_place_100th()));
			form.setDay6Point_200(String.valueOf(dto.getPoint_place_200th()));
			form.setDay6Point_1000(String.valueOf(dto.getPoint_place_1000th()));
			form.setDay6Point_1500(String.valueOf(dto.getPoint_place_1500th()));
			form.setDay6Point_2000(String.valueOf(dto.getPoint_place_2000th()));

			dto = calPoint(conn, pastEventId1, pastEventId2, pastEventId3, 7);
			form.setDay7Point_1(String.valueOf(dto.getPoint_place_1st()));
			form.setDay7Point_100(String.valueOf(dto.getPoint_place_100th()));
			form.setDay7Point_200(String.valueOf(dto.getPoint_place_200th()));
			form.setDay7Point_1000(String.valueOf(dto.getPoint_place_1000th()));
			form.setDay7Point_1500(String.valueOf(dto.getPoint_place_1500th()));
			form.setDay7Point_2000(String.valueOf(dto.getPoint_place_2000th()));

			dto = calPoint(conn, pastEventId1, pastEventId2, pastEventId3, 8);
			form.setDay8Point_1(String.valueOf(dto.getPoint_place_1st()));
			form.setDay8Point_100(String.valueOf(dto.getPoint_place_100th()));
			form.setDay8Point_200(String.valueOf(dto.getPoint_place_200th()));
			form.setDay8Point_1000(String.valueOf(dto.getPoint_place_1000th()));
			form.setDay8Point_1500(String.valueOf(dto.getPoint_place_1500th()));
			form.setDay8Point_2000(String.valueOf(dto.getPoint_place_2000th()));

			dto = calPoint(conn, pastEventId1, pastEventId2, pastEventId3, 9);
			form.setDay9Point_1(String.valueOf(dto.getPoint_place_1st()));
			form.setDay9Point_100(String.valueOf(dto.getPoint_place_100th()));
			form.setDay9Point_200(String.valueOf(dto.getPoint_place_200th()));
			form.setDay9Point_1000(String.valueOf(dto.getPoint_place_1000th()));
			form.setDay9Point_1500(String.valueOf(dto.getPoint_place_1500th()));
			form.setDay9Point_2000(String.valueOf(dto.getPoint_place_2000th()));
		} catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.disconnect(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
