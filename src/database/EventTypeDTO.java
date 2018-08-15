package database;

public class EventTypeDTO extends VO {
	private int event_id;
	private String event_nmae;

	public int getEvent_id() {
		return event_id;
	}

	public String getEvent_name() {
		return event_nmae;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public void setEvent_name(String event_nmae) {
		this.event_nmae = event_nmae;
	}

}
