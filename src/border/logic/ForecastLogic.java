package border.logic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import border.form.MobamasuForm;
import database.DAO;
import database.DAOFactory;
import database.DBConnection;
import database.DayPointDTO;
import database.Factory;

public class ForecastLogic {

	//過去のイベントIDを取得するメソッド
	//引数は現在のイベントID
	//戻り値は過去のイベント
	private List<Integer> getPastEventId(int evetnId){
		List<Integer> eventList = null;

		return eventList;
	}

	//過去ポイントを取得するメソッド
	//引数はイベントID
	//戻り値はDTO
	//private
	private DayPointDTO getPastPoint(int eventId,int day) {

		  Connection conn = null;
		  try {
	            // データベースへ接続
	            conn = DBConnection.connect();
	            Factory factory = new DAOFactory();
	          switch(day) {

	          case 1:
	            // Day1point
	            DAO<DayPointDTO> dao_day1_point = automaticCast(factory.create("Day1Point"));
	            return dao_day1_point.select(conn, eventId);
	          case 2:
	        	// Day2point
		            DAO<DayPointDTO> dao_day2_point = automaticCast(factory.create("Day2Point"));
		            return dao_day2_point.select(conn, eventId);
	          case 3:
	            // Day3point
		            DAO<DayPointDTO> dao_day3_point = automaticCast(factory.create("Day3Point"));
		            return dao_day3_point.select(conn, eventId);
	          case 4:
	        	// Day4point
		            DAO<DayPointDTO> dao_day4_point = automaticCast(factory.create("Day4Point"));
		            return dao_day4_point.select(conn, eventId);
	          case 5:
	            // Day5point
		            DAO<DayPointDTO> dao_day5_point = automaticCast(factory.create("Day5Point"));
		            return dao_day5_point.select(conn, eventId);
	          case 6:
	        	// Day6point
		            DAO<DayPointDTO> dao_day6_point = automaticCast(factory.create("Day6Point"));
		            return dao_day6_point.select(conn, eventId);
	          case 7:
	            // Day7point
		            DAO<DayPointDTO> dao_day7_point = automaticCast(factory.create("Day7Point"));
		            return dao_day7_point.select(conn, eventId);
		     case 8:
	        	// Day8point
		            DAO<DayPointDTO> dao_day8_point = automaticCast(factory.create("Day8Point"));
		            return dao_day8_point.select(conn, eventId);
		     case 9:
	        	// Day9point
			        DAO<DayPointDTO> dao_day9_point = automaticCast(factory.create("Day9Point"));
		            return dao_day9_point.select(conn, eventId);
	          default :
	        	  return null;
	          }
		  }
		  catch(IOException e) {
			  e.printStackTrace();
		  }
		  catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	                try {
						DBConnection.disconnect(conn);
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
	            }
		return null;

	}

	//過去ポイントから直近イベントの平均を算出
	//引数は上記メソッドDTO
	//戻り値はDTO
	//private
	private DayPointDTO calPoint(int eventId1, int eventId2, int eventId3, int day) {
		DayPointDTO past1 = new DayPointDTO();
		past1 = getPastPoint(eventId1,day);
		DayPointDTO past2 = new DayPointDTO();
		past2 = getPastPoint(eventId2,day);
		DayPointDTO past3 = new DayPointDTO();
		past3 = getPastPoint(eventId3,day);

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
		List<Integer> eventList = getPastEventId(eventId);

		int pastEventId1 = eventList.get(0);
		int pastEventId2 = eventList.get(1);
		int pastEventId3 = eventList.get(2);


		DayPointDTO dto = calPoint(pastEventId1, pastEventId2, pastEventId3, 1);
		form.setDay1Point_1(String.valueOf(dto.getPoint_place_1st()));
		form.setDay1Point_100(String.valueOf(dto.getPoint_place_100th()));
		form.setDay1Point_200(String.valueOf(dto.getPoint_place_200th()));
		form.setDay1Point_1000(String.valueOf(dto.getPoint_place_1000th()));
		form.setDay1Point_1500(String.valueOf(dto.getPoint_place_1500th()));
		form.setDay1Point_2000(String.valueOf(dto.getPoint_place_2000th()));
		dto = calPoint(pastEventId1, pastEventId2, pastEventId3, 2);
		form.setDay2Point_1(String.valueOf(dto.getPoint_place_1st()));
		form.setDay2Point_100(String.valueOf(dto.getPoint_place_100th()));
		form.setDay2Point_200(String.valueOf(dto.getPoint_place_200th()));
		form.setDay2Point_1000(String.valueOf(dto.getPoint_place_1000th()));
		form.setDay2Point_1500(String.valueOf(dto.getPoint_place_1500th()));
		form.setDay2Point_2000(String.valueOf(dto.getPoint_place_2000th()));
		dto = calPoint(pastEventId1, pastEventId2, pastEventId3, 3);
		form.setDay3Point_1(String.valueOf(dto.getPoint_place_1st()));
		form.setDay3Point_100(String.valueOf(dto.getPoint_place_100th()));
		form.setDay3Point_200(String.valueOf(dto.getPoint_place_200th()));
		form.setDay3Point_1000(String.valueOf(dto.getPoint_place_1000th()));
		form.setDay3Point_1500(String.valueOf(dto.getPoint_place_1500th()));
		form.setDay3Point_2000(String.valueOf(dto.getPoint_place_2000th()));
		dto = calPoint(pastEventId1, pastEventId2, pastEventId3, 4);
		form.setDay4Point_1(String.valueOf(dto.getPoint_place_1st()));
		form.setDay4Point_100(String.valueOf(dto.getPoint_place_100th()));
		form.setDay4Point_200(String.valueOf(dto.getPoint_place_200th()));
		form.setDay4Point_1000(String.valueOf(dto.getPoint_place_1000th()));
		form.setDay4Point_1500(String.valueOf(dto.getPoint_place_1500th()));
		form.setDay4Point_2000(String.valueOf(dto.getPoint_place_2000th()));
		dto = calPoint(pastEventId1, pastEventId2, pastEventId3, 5);
		form.setDay5Point_1(String.valueOf(dto.getPoint_place_1st()));
		form.setDay5Point_100(String.valueOf(dto.getPoint_place_100th()));
		form.setDay5Point_200(String.valueOf(dto.getPoint_place_200th()));
		form.setDay5Point_1000(String.valueOf(dto.getPoint_place_1000th()));
		form.setDay5Point_1500(String.valueOf(dto.getPoint_place_1500th()));
		form.setDay5Point_2000(String.valueOf(dto.getPoint_place_2000th()));
		dto = calPoint(pastEventId1, pastEventId2, pastEventId3, 6);
		form.setDay6Point_1(String.valueOf(dto.getPoint_place_1st()));
		form.setDay6Point_100(String.valueOf(dto.getPoint_place_100th()));
		form.setDay6Point_200(String.valueOf(dto.getPoint_place_200th()));
		form.setDay6Point_1000(String.valueOf(dto.getPoint_place_1000th()));
		form.setDay6Point_1500(String.valueOf(dto.getPoint_place_1500th()));
		form.setDay6Point_2000(String.valueOf(dto.getPoint_place_2000th()));
		dto = calPoint(pastEventId1, pastEventId2, pastEventId3, 7);
		form.setDay7Point_1(String.valueOf(dto.getPoint_place_1st()));
		form.setDay7Point_100(String.valueOf(dto.getPoint_place_100th()));
		form.setDay7Point_200(String.valueOf(dto.getPoint_place_200th()));
		form.setDay7Point_1000(String.valueOf(dto.getPoint_place_1000th()));
		form.setDay7Point_1500(String.valueOf(dto.getPoint_place_1500th()));
		form.setDay7Point_2000(String.valueOf(dto.getPoint_place_2000th()));
		dto = calPoint(pastEventId1, pastEventId2, pastEventId3, 8);
		form.setDay8Point_1(String.valueOf(dto.getPoint_place_1st()));
		form.setDay8Point_100(String.valueOf(dto.getPoint_place_100th()));
		form.setDay8Point_200(String.valueOf(dto.getPoint_place_200th()));
		form.setDay8Point_1000(String.valueOf(dto.getPoint_place_1000th()));
		form.setDay8Point_1500(String.valueOf(dto.getPoint_place_1500th()));
		form.setDay8Point_2000(String.valueOf(dto.getPoint_place_2000th()));
		dto = calPoint(pastEventId1, pastEventId2, pastEventId3, 9);
		form.setDay9Point_1(String.valueOf(dto.getPoint_place_1st()));
		form.setDay9Point_100(String.valueOf(dto.getPoint_place_100th()));
		form.setDay9Point_200(String.valueOf(dto.getPoint_place_200th()));
		form.setDay9Point_1000(String.valueOf(dto.getPoint_place_1000th()));
		form.setDay9Point_1500(String.valueOf(dto.getPoint_place_1500th()));
		form.setDay9Point_2000(String.valueOf(dto.getPoint_place_2000th()));
	}

	  @SuppressWarnings("unchecked")
	    private static <T> T automaticCast(Object src) {
	        T castedObject = (T) src;
	        return castedObject;
	    }

}
