package com.pretzel.pretzelEShop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

	@Autowired
	public OrdersRepository ordersRepository;
	@Autowired
	public PretzelRepository pretzelRepository;
	@Autowired
	public CustomerRepository customerRepository;
	
	public void orderPretzel(Customer c, Pretzel p, int amount)
	{
	
		
//		Customer c = customerRepository.findById(cid).get();
////		Pretzel p = pretzelRepository.findById(pid).get();
//		Pretzel p = pretzelRepository.findById(pid).get();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		Orders o = new Orders();
		o.setAmount(amount);
		o.setCustomer(c);
		o.setPretzel(p);
		o.setStatus("ordered");
		o.setTotalCost(p.getPrice()* o.getAmount());
		o.setOrderDate(dateFormat.format(date));
		ordersRepository.save(o);

		p.setStockAmount(p.getStockAmount() - o.getAmount());
		pretzelRepository.save(p);
		
		int intCost = (int) o.getTotalCost();
		c.setLoyalityPoints(c.getLoyalityPoints() + intCost/10);
		customerRepository.save(c);
	}

}
