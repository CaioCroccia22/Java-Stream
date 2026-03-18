package dao;

import java.util.List;

public interface IObjectDAO<T> {
	public void addObjectList(T object);
	public T createObject(T object) throws Exception;
	public List<T> getAll();
	
}
