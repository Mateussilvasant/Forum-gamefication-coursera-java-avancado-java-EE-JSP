package test;

import java.sql.SQLException;
import java.sql.Statement;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;

/**
 * @author mateussilva
 *
 */
public class ResetSequenceOperation extends DatabaseOperation
{

    private DatabaseOperation decoree;

    public ResetSequenceOperation(DatabaseOperation decoree)
    {
	this.decoree = decoree;
    }

    @Override
    public void execute(IDatabaseConnection connection, IDataSet dataSet) throws DatabaseUnitException, SQLException
    {
	decoree.execute(connection, dataSet);

	String[] tables = dataSet.getTableNames();
	Statement statement = connection.getConnection().createStatement();
	for (String table : tables)
	{
	    try
	    {
		statement.execute("ALTER TABLE " + table + " AUTO_INCREMENT = 0");

	    } catch (SQLException ex)
	    {
		ex.printStackTrace();
	    }
	}
    }
}