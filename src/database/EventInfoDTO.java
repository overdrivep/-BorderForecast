package database;

public class EventInfoDTO {
	private int event_id;
	private int event_type_id;
	private String begin_day;
	private String end_day;
	private String event_name;
	private String reward_idle;
	private int idol_id;

	public int getEvent_id() {
		return event_id;
	}
	public int getEvent_type_id() {
		return event_type_id;
	}
	public String getBegin_day() {
		return begin_day;
	}
	public String getEnd_day() {
		return end_day;
	}
	public String getEvent_name() {
		return event_name;
	}
	public String getReward_idle() {
		return reward_idle;
	}
	public int getIdol_id() {
		return idol_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public void setEvent_type_id(int event_type_id) {
		this.event_type_id = event_type_id;
	}
	public void setBegin_day(String begin_day) {
		this.begin_day = begin_day;
	}
	public void setEnd_day(String end_day) {
		this.end_day = end_day;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public void setReward_idle(String reward_idle) {
		this.reward_idle = reward_idle;
	}
	public void setIdol_id(int idol_id) {
		this.idol_id = idol_id;
	}
}
