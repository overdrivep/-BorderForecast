package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventTypeDAO extends DAO<EventTypeDTO> {
	private static final String SELECT = "select * from event_type where event_id = ?";

	private static EventTypeDAO instance;

	private EventTypeDAO(){}

	public static EventTypeDAO getInstance() {
		if(null == instance) {
			instance = new EventTypeDAO();
		}
		return instance;
	}

	@Override
	public ArrayList<EventTypeDTO> select(Connection conn,int event_id)throws SQLException,IOException {
		PreparedStatement ps = conn.prepareStatement(SELECT);
		ps.setInt(1,event_id);
		ResultSet rs = ps.executeQuery();
		return createEventTypeList(rs);
	}

	private ArrayList<EventTypeDTO> createEventTypeList(ResultSet rs)throws SQLException,IOException {
		ArrayList<EventTypeDTO> al = new ArrayList<>();
		try{
			while(rs.next()) {
				EventTypeDTO event_type_dto = new EventTypeDTO();

				event_type_dto.setEvent_id(rs.getInt("event_id"));
				event_type_dto.setEvent_name(rs.getString("event_name"));

				al.add(event_type_dto);
			}
		}catch(Exception e) {
			throw new SQLException(e);
		}
		return al;
	}
}
