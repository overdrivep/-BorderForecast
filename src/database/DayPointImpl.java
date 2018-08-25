package database;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DayPointImpl {
	DayPointDTO createDayPointDTO(ResultSet rs) throws SQLException,IOException;
}
