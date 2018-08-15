package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventInfoDAO extends DAO<EventInfoDTO> {
	private static final String SELECT = "select * from event_info where event_id = ?";

	private static EventInfoDAO instance;

	private EventInfoDAO(){}

	public static EventInfoDAO getInstance() {
		if(null == instance) {
			instance = new EventInfoDAO();
		}
		return instance;
	}

	@Override
	public ArrayList<EventInfoDTO> select(Connection conn,int event_id)throws SQLException,IOException {
		PreparedStatement ps = conn.prepareStatement(SELECT);
		ps.setInt(1,event_id);
		ResultSet rs = ps.executeQuery();
		return createEventInfoList(rs);
	}

	private ArrayList<EventInfoDTO> createEventInfoList(ResultSet rs)throws SQLException,IOException {
		ArrayList<EventInfoDTO> al = new ArrayList<>();
		try{
			while(rs.next()) {
				EventInfoDTO event_info_dto = new EventInfoDTO();

				event_info_dto.setEvent_id(rs.getInt("event_id"));
				event_info_dto.setTerm(rs.getString("term"));
				event_info_dto.setBegin_day(rs.getString("begin_day"));
				event_info_dto.setEnd_day(rs.getString("end_day"));
				event_info_dto.setReward_idle(rs.getString("reward_idle"));

				al.add(event_info_dto);
			}
		}catch(Exception e) {
			throw new SQLException(e);
		}
		return al;
	}
}
