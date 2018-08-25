package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventTypeDAO {
	private static final String SELECT = "select * from event_type where event_type_id = ?";

	private static EventTypeDAO instance;

	private EventTypeDAO(){}

	public static EventTypeDAO getInstance() {
		if(null == instance) {
			instance = new EventTypeDAO();
		}
		return instance;
	}

	public EventTypeDTO select(Connection conn,int event_type_id) throws SQLException,IOException {
		PreparedStatement ps = conn.prepareStatement(SELECT);
		ps.setInt(1,event_type_id);
		ResultSet rs = ps.executeQuery();
		return createEventTypeDTO(rs);
	}

	private EventTypeDTO createEventTypeDTO(ResultSet rs) throws SQLException,IOException {
		try{
			EventTypeDTO event_type_dto = new EventTypeDTO();
			while(rs.next()) {
				event_type_dto.setEvent_type_id(rs.getInt("event_type_id"));
				event_type_dto.setEvent_type_name(rs.getString("event_type_name"));
			}
			return event_type_dto;
		}catch(Exception e) {
			throw new SQLException(e);
		}
	}
}
