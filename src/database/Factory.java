package database;

public abstract class Factory {
	public final DAO<? extends VO> create(String dao_name) {
		DAO<? extends VO> dao = createDAO(dao_name);
		return dao;
	}

	protected abstract DAO<? extends VO> createDAO(String dao_name);
}
