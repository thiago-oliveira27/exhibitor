package com.poo.exhibitor.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.poo.exhibitor.builder.MessageData;
import com.poo.exhibitor.connection.facade.DataBaseFacade;
import com.poo.exhibitor.model.ProductModel;
import com.poo.exhibitor.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public List<ProductModel> getProductList(){
		Iterable<ProductModel> productIterable = this.productRepository.findAll();
		return Streamable.of(productIterable).toList();
	}
	
	public void save(ProductModel product) {
		this.productRepository.save(product);
	}

	
	//Using JDBC to get this data, not the repository
	public MessageData getMessageData(Long id) {
		
		String userName="", adName="", phoneNumber="";
		
		DataBaseFacade dbfacade = new DataBaseFacade();
		dbfacade.connect();
		
		String query = "SELECT u.username, p.nome, u.phone_number  \r\n"
				+ "FROM produto p left join user_tb u \r\n"
				+ "on p.user_id = u.user_id\r\n"
				+ "where p.id = ?";
		
		ResultSet rs = dbfacade.executeQuery(query, id);
		try {
			if (rs.next()) {
		        userName = rs.getString("username");
		        adName = rs.getString("nome");
		        phoneNumber = rs.getString("phone_number");
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new MessageData.Builder()
							  .setUsername(userName)
							  .setAdName(adName)
							  .setPhoneNumber(phoneNumber)
							  .build();
			
	}
	
	public List<ProductModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
