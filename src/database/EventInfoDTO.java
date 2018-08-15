package database;

public class EventInfoDTO extends VO {
	private int event_id;
	private String term;
	private String begin_day;
	private String end_day;
	private String reward_idle;

	public int getEvent_id() {
		return event_id;
	}

	public String getTerm() {
		return term;
	}

	public String getBegin_day() {
		return begin_day;
	}

	public String getEnd_day() {
		return end_day;
	}

	public String getReward_idle() {
		return reward_idle;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public void setBegin_day(String begin_day) {
		this.begin_day = begin_day;
	}

	public void setEnd_day(String end_day) {
		this.end_day = end_day;
	}

	public void setReward_idle(String reward_idle) {
		this.reward_idle = reward_idle;
	}
}
