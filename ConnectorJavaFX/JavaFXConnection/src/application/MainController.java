/**
 * 
 */
package application;

import java.sql.Connection;

import java.sql.SQLException;
import org.postgresql.ds.PGSimpleDataSource;
import org.postgresql.util.PSQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Funktionen
 * @author Antonio
 * @version 1.0
 */
public class MainController {

	//Attribute
	private Connection connection;
	private PGSimpleDataSource ds;

	@FXML
	private TextField dbtn, dbtu, dbtp, dbtip, dbtport;
	
	@FXML
	private Label lbc;

	/**
	 * Connection aufbauen und Inhalten aus den Textfeldern herauslesen
	 * @param event
	 */
	@FXML
	public void Connect(ActionEvent event) {

		
		try {
			// DB Connection
			ds = new PGSimpleDataSource();
			ds.setServerName(dbtip.getText());
			ds.setDatabaseName(dbtn.getText());
			ds.setUser(dbtu.getText());
			ds.setPassword(dbtp.getText());
			ds.setPortNumber(5432);

		
		
			connection = ds.getConnection();
			lbc.setText("Connected");
		} catch (Exception e) {
			System.err.println("Connection failed!");
			e.printStackTrace(System.err);
		}

	}
	
	
	
	/**
	 * Trennt die bestehende Verbindung
	 * @param event
	 */
	@FXML
	public void closeConnection(ActionEvent event) {
		try {
			connection.close();
			lbc.setText("Connection Closed");
		} catch (SQLException e) {
			System.err.println("Closing Connection failed!");
			e.printStackTrace(System.err);
		}
	}

}
