package practice.codejava.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import practice.codejava.contact.modal.Contact;

public class ContactDAOImpl implements ContactDAO {

	private JdbcTemplate jdbctemplate;
	
	public ContactDAOImpl(DataSource datasource)
	{
		this.jdbctemplate = new JdbcTemplate(datasource);
	}
	@Override
	public int save(Contact c) {
		// TODO Auto-generated method stub
		String sql= "INSERT INTO Contact(name, email, address, phone) VALUES (?, ?, ?, ?)";
		 return jdbctemplate.update(sql,c.getName(),c.getEmail(),c.getAddress(),c.getPhone());
		
	}

	@Override
	public int update(Contact c) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Contact SET name=?, email=?, address=?, phone=? WHERE contact_id=?";
		return jdbctemplate.update(sql,c.getName(),c.getEmail(),c.getAddress(),c.getPhone(), c.getId() );
	}

	@Override
	public Contact get(Integer id) {
		// TODO Auto-generated method stub
		String sql ="SELECT * FROM Contact WHERE contact_id="+id;
		ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>(){

			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				if(rs.next())
				{
					String name = rs.getString("name");
					String email = rs.getString("email");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					
					return new Contact(id, name, email, address, phone);
				}
				return null;
			}
			
		};
		return jdbctemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		String sql ="DELETE FROM Contact WHERE contact_id="+id;
		return jdbctemplate.update(sql);
	}

	@Override
	public List<Contact> listContacts() {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM Contact";
		RowMapper <Contact> rowMapper = new RowMapper<Contact>(){

			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Integer id = rs.getInt("contact_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				
				return new Contact(id, name, email, address, phone);
			}
			
		};
		
		return jdbctemplate.query(sql, rowMapper);
	}

}
