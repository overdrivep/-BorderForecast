package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdolInfoDAO {
	private static final String SELECT = "select * from event_info where event_id = ?";

	private static IdolInfoDAO instance;

	private IdolInfoDAO(){}

	public static IdolInfoDAO getInstance() {
		if(null == instance) {
			instance = new IdolInfoDAO();
		}
		return instance;
	}

	public IdolInfoDTO select(Connection conn,int idol_id) throws SQLException,IOException {
		PreparedStatement ps = conn.prepareStatement(SELECT);
		ps.setInt(1,idol_id);
		ResultSet rs = ps.executeQuery();
		return createIdolInfoDTO(rs);
	}

	private IdolInfoDTO createIdolInfoDTO(ResultSet rs) throws SQLException,IOException {
		try{
			IdolInfoDTO idol_info_dto = new IdolInfoDTO();
			while(rs.next()) {
				idol_info_dto.setIdol_id(rs.getInt("idol_id"));
				idol_info_dto.setIdol_name(rs.getString("idol_name"));
				idol_info_dto.setPopularity(rs.getInt("popularity"));
			}
			return idol_info_dto;
		}catch(Exception e) {
			throw new SQLException(e);
		}
	}
}
