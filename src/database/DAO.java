package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class DAO<V extends VO> {
	public abstract ArrayList<V> select(Connection conn,int event_id)throws SQLException,IOException;
}
