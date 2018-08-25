package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAO<V extends VO> {
	public abstract V select(Connection conn,int event_id) throws SQLException,IOException;
}
