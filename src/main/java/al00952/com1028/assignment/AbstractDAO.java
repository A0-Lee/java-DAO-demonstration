package al00952.com1028.assignment;

import java.util.ArrayList;


/**
 * An Abstract Class to be inherited by a generic Data Access Object Class.
 * 
 * @author Andy Lee
 *
 * @param <T>
 */
abstract class AbstractDAO<T> {
	protected BaseQuery baseQuery;
	
	protected AbstractDAO() {
		this.baseQuery = new BaseQuery();
	}
	
	protected abstract ArrayList<T> findAllObjectData();
}
