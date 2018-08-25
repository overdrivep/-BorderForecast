package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventInfoDAO {
	private static final String SELECT = "select * from event_info where event_id = ?";
	private static final String GET_EVENT_ID = "select event_id from event_info where STR_TO_DATE( begin_day, '%Y年%m月%d日' ) < CURRENT_DATE() AND CURRENT_DATE() < STR_TO_DATE( end_day, '%Y年%m月%d日' )";
	private static final String GET_EVENT_ID_PAST_THREE_EVENTS = "select event_id from event_info where event_type_id = ( select event_type_id from event_info where event_id = ? ) order by end_day desc";

	private static EventInfoDAO instance;

	private EventInfoDAO(){}

	public static EventInfoDAO getInstance() {
		if(null == instance) {
			instance = new EventInfoDAO();
		}
		return instance;
	}

	public EventInfoDTO select(Connection conn,int event_id) throws SQLException,IOException {
		PreparedStatement ps = conn.prepareStatement(SELECT);
		ps.setInt(1,event_id);
		ResultSet rs = ps.executeQuery();
		return createEventInfoDTO(rs);
	}

	private EventInfoDTO createEventInfoDTO(ResultSet rs) throws SQLException,IOException {
		try{
			EventInfoDTO event_info_dto = new EventInfoDTO();
			while(rs.next()) {
				event_info_dto.setEvent_id(rs.getInt("event_id"));
				event_info_dto.setEvent_type_id(rs.getInt("event_type_id"));
				event_info_dto.setBegin_day(rs.getString("begin_day"));
				event_info_dto.setEnd_day(rs.getString("end_day"));
				event_info_dto.setEvent_name(rs.getString("event_name"));
				event_info_dto.setReward_idle(rs.getString("reward_idle"));
				event_info_dto.setIdol_id(rs.getInt("idol_id"));
			}
			return event_info_dto;
		}catch(Exception e) {
			throw new SQLException(e);
		}
	}

	public int getEventId(Connection conn) throws SQLException,IOException {
		int ret_val = 0;
		PreparedStatement ps = conn.prepareStatement(GET_EVENT_ID);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			ret_val =  rs.getInt("event_id");
		}
		return ret_val;
	}

	public List<Integer> getEventIdListPastThreeEvents(Connection conn,int event_id) throws SQLException,IOException {
		List<Integer> event_id_list = new ArrayList<>();
		PreparedStatement ps = conn.prepareStatement(GET_EVENT_ID_PAST_THREE_EVENTS);
		ps.setInt(1,event_id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			event_id_list.add(rs.getInt("event_id"));
		}
		return event_id_list;
	}
}
