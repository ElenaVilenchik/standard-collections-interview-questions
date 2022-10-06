package telran.structure;

public interface ConnectionsPool {
	/**
	 * adds connection into Connections Pool
	 * 
	 * @param connection
	 * @return true if added otherwise false if a connection already exists in the
	 *         case the Connection Pool is full the last connection will be removed
	 */
	boolean addConnection(Connection connection);

	/**
	 * 
	 * @param id
	 * @return
	 */
	Connection getConnection(int id);
	
	
}
