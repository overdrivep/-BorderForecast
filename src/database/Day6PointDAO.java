package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Day6PointDAO implements DayPointImpl {
	private static final String SELECT = "select * from day6_point where event_id = ?";

	private static Day6PointDAO instance;

	private Day6PointDAO(){}

	public static Day6PointDAO getInstance() {
		if(null == instance) {
			instance = new Day6PointDAO();
		}
		return instance;
	}

	public DayPointDTO select(Connection conn,int event_id) throws SQLException,IOException {
		PreparedStatement ps = conn.prepareStatement(SELECT);
		ps.setInt(1,event_id);
		ResultSet rs = ps.executeQuery();
		return createDayPointDTO(rs);
	}

	public DayPointDTO createDayPointDTO(ResultSet rs) throws SQLException,IOException {
		try{
			DayPointDTO day_point_dto = new DayPointDTO();
			while(rs.next()) {
				day_point_dto.setEvent_id(rs.getInt("event_id"));
				day_point_dto.setPoint_place_1st(rs.getLong("1st_place_point"));
				day_point_dto.setPoint_place_100th(rs.getLong("100th_place_point"));
				day_point_dto.setPoint_place_200th(rs.getLong("200th_place_point"));
				day_point_dto.setPoint_place_1000th(rs.getLong("1000th_place_point"));
				day_point_dto.setPoint_place_1500th(rs.getLong("1500th_place_point"));
				day_point_dto.setPoint_place_2000th(rs.getLong("2000th_place_point"));
			}
			return day_point_dto;
		}catch(Exception e) {
			throw new SQLException(e);
		}
	}
}
