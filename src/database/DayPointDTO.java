package database;

public class DayPointDTO extends VO {
	private int event_id;
	private Long point_place_1st;
	private Long point_place_100th;
	private Long point_place_200th;
	private Long point_place_1000th;
	private Long point_place_1500th;
	private Long point_place_2000th;

	public int getEvent_id() {
		return event_id;
	}

	public Long getPoint_place_1st() {
		return point_place_1st;
	}

	public Long getPoint_place_100th() {
		return point_place_100th;
	}

	public Long getPoint_place_200th() {
		return point_place_200th;
	}

	public Long getPoint_place_1000th() {
		return point_place_1000th;
	}

	public Long getPoint_place_1500th() {
		return point_place_1500th;
	}

	public Long getPoint_place_2000th() {
		return point_place_2000th;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public void setPoint_place_1st(Long point_place_1st) {
		this.point_place_1st = point_place_1st;
	}

	public void setPoint_place_100th(Long point_place_100th) {
		this.point_place_100th = point_place_100th;
	}

	public void setPoint_place_200th(Long point_place_200th) {
		this.point_place_200th = point_place_200th;
	}

	public void setPoint_place_1000th(Long point_place_1000th) {
		this.point_place_1000th = point_place_1000th;
	}

	public void setPoint_place_1500th(Long point_place_1500th) {
		this.point_place_1500th = point_place_1500th;
	}

	public void setPoint_place_2000th(Long point_place_2000th) {
		this.point_place_2000th = point_place_2000th;
	}

}
