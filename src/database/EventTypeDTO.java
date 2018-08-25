package database;

public class EventTypeDTO extends VO {
	private int event_type_id;
	private String event_type_name;

	public int getEvent_type_id() {
		return event_type_id;
	}
	public String getEvent_type_name() {
		return event_type_name;
	}
	public void setEvent_type_id(int event_type_id) {
		this.event_type_id = event_type_id;
	}
	public void setEvent_type_name(String event_type_name) {
		this.event_type_name = event_type_name;
	}
}
