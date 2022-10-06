package telran.structure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConnectionsPollImplTest {
	ConnectionsPoollImpl connection = new ConnectionsPoollImpl(5);

	@BeforeEach
	void setUp() {
		Connection con1 = new Connection(11, "aaa", 1);
		connection.addConnection(con1);
		Connection con2 = new Connection(22, "bbb", 2);
		connection.addConnection(con2);
		Connection con3 = new Connection(33, "ccc", 3);
		connection.addConnection(con3);
		Connection con4 = new Connection(44, "ddd", 4);
		connection.addConnection(con4);
		Connection con5 = new Connection(55, "eee", 5);
		connection.addConnection(con5);

	}

	@Test
	void addConnection() {
		Connection con1 = new Connection(66, "fff", 6);
	//	 assertTrue(connection.addConnection( con1));
		Connection con3 = new Connection(33, "ccc", 3);
		assertFalse(connection.addConnection(con3));
	}

	@Test
	void getConnection() {
		Connection expected = new Connection(22, "bbb", 2);
	//	assertEquals(expected, connection.getConnection(22));
		System.out.println(connection.getConnection(22));
		assertEquals(null, connection.getConnection(99));

	}

}
