package com.library.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.library.bean.Borrow;
import com.library.bean.Reader;
import com.library.bean.Stock;
import com.library.bean.Ticket;
import com.library.dao.BorrowDao;
import com.library.dao.StockDao;
import com.library.impl.BorrowImpl;
import com.library.impl.StockImpl;
import com.library.impl.TicketImpl;
import com.opensymphony.xwork2.ActionSupport;

public class FineMoneyAct extends ActionSupport {

	private String readerID;
	private String borrowdate;
	private float fines;
	private String amount;
	private String isbn;
	private String borrowid;
	
	private BorrowDao bordao =new BorrowImpl();
	private StockDao stcdao = new StockImpl();
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBorrowid() {
		return borrowid;
	}

	public void setBorrowid(String borrowid) {
		this.borrowid = borrowid;
	}

	public String getReaderID() {
		return readerID;
	}

	public void setReaderID(String readerID) {
		this.readerID = readerID;
	}

	public String getBorrowdate() {
		return borrowdate;
	}

	public void setBorrowdate(String borrowdate) {
		this.borrowdate = borrowdate;
	}

	public float getFines() {
		return fines;
	}

	public void setFines(float fines) {
		this.fines = fines;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String doFineMoney() throws ParseException {
		TicketImpl impl = new TicketImpl();
		Ticket ticket = new Ticket();
		ticket.setMoney(fines);
		
		Reader reader = new Reader();
		reader.setReaderid(Integer.parseInt(readerID));
		ticket.setReader(reader);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(borrowdate);
		ticket.setTicketdate(date);
		boolean result = impl.addTicket(ticket);
		if(result) {
			Stock stock=stcdao.getStock(isbn);
			stock.setAmount(stock.getAmount()+1);
			stcdao.updateStock(stock);   
			
			int bid = Integer.parseInt(borrowid);
			Borrow borrow = bordao.getBorrow(isbn,bid);
			borrow.setBorrowid(Integer.parseInt(borrowid));
			borrow.setIsback(1);
			bordao.updateBorrow(borrow);
		}
		
		return SUCCESS;
	}

}
