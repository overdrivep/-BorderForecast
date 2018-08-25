package database;

public class IdolInfoDTO {
	private int idol_id;
	private String idol_name;
	private int popularity;

	public int getIdol_id() {
		return idol_id;
	}
	public String getIdol_name() {
		return idol_name;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setIdol_id(int idol_id) {
		this.idol_id = idol_id;
	}
	public void setIdol_name(String idol_name) {
		this.idol_name = idol_name;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
}