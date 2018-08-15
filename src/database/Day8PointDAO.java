package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Day8PointDAO extends DAO<DayPointDTO> {
	private static final String SELECT = "select * from day8_point where event_id = ?";

	private static Day8PointDAO instance;

	private Day8PointDAO(){}

	public static Day8PointDAO getInstance() {
		if(null == instance) {
			instance = new Day8PointDAO();
		}
		return instance;
	}

	@Override
	public ArrayList<DayPointDTO> select(Connection conn,int event_id)throws SQLException,IOException {
		PreparedStatement ps = conn.prepareStatement(SELECT);
		ps.setInt(1,event_id);
		ResultSet rs = ps.executeQuery();
		return createDay1PointList(rs);
	}

	private ArrayList<DayPointDTO> createDay1PointList(ResultSet rs)throws SQLException,IOException {
		ArrayList<DayPointDTO> al = new ArrayList<>();
		try{
			while(rs.next()) {
				DayPointDTO day_point_dto = new DayPointDTO();

				day_point_dto.setEvent_id(rs.getInt("event_id"));
				day_point_dto.setTerm(rs.getString("term"));
				day_point_dto.setPoint_place_1st(rs.getLong("1st_place_point"));
				day_point_dto.setPoint_place_100th(rs.getLong("100th_place_point"));
				day_point_dto.setPoint_place_200th(rs.getLong("200th_place_point"));
				day_point_dto.setPoint_place_1000th(rs.getLong("1000th_place_point"));
				day_point_dto.setPoint_place_1500th(rs.getLong("1500th_place_point"));
				day_point_dto.setPoint_place_2000th(rs.getLong("2000th_place_point"));

				al.add(day_point_dto);
			}
		}catch(Exception e) {
			throw new SQLException(e);
		}
		return al;
	}
}
