package database;

public class DAOFactory extends Factory {
	protected DAO<? extends VO> createDAO(String dao_name) {
		switch(dao_name) {
		case "EventType":
			return EventTypeDAO.getInstance();
		case "EventInfo":
			return EventInfoDAO.getInstance();
		case "Day1Point":
			return Day1PointDAO.getInstance();
		case "Day2Point":
			return Day2PointDAO.getInstance();
		case "Day3Point":
			return Day3PointDAO.getInstance();
		case "Day4Point":
			return Day4PointDAO.getInstance();
		case "Day5Point":
			return Day5PointDAO.getInstance();
		case "Day6Point":
			return Day6PointDAO.getInstance();
		case "Day7Point":
			return Day7PointDAO.getInstance();
		case "Day8Point":
			return Day8PointDAO.getInstance();
		case "Day9Point":
			return Day9PointDAO.getInstance();
		default:
			System.err.println(dao_name + " does not exist");
			return null;
		}
	}
}