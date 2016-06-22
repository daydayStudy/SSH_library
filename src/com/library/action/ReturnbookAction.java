package com.library.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.library.bean.Borrow;
import com.library.bean.BorrowRecordBean;
import com.library.bean.ReturnBookBean;
import com.library.bean.Stock;
import com.library.dao.BorrowDao;
import com.library.dao.StockDao;
import com.library.impl.BookInfoImpl;
import com.library.impl.BookTypeImpl;
import com.library.impl.BorrowImpl;
import com.library.impl.StockImpl;
import com.library.util.JUtils;
import com.opensymphony.xwork2.ActionSupport;


public class ReturnbookAction extends ActionSupport  implements ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String method;
	private String id;
	private Borrow borrow;
	private String borrowid;
	private Stock stock;
	private String bookname;
	private String readid;
	private String backdate;
	private String amount;
	private BorrowDao bordao =new BorrowImpl();
	private StockDao stcdao = new StockImpl();
	private HttpServletResponse response;

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getBorrowid() {
		return borrowid;
	}

	public void setBorrowid(String borrowid) {
		this.borrowid = borrowid;
	}

	public Borrow getBorrow() {
		return borrow;
	}

	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getReadid() {
		return readid;
	}

	public void setReadid(String readid) {
		this.readid = readid;
	}

	public String execute() throws Exception{
		String result ="";
		
		if("select".equals(method)) { 
			System.out.println("id="+id);
			System.out.println("method="+method);
			String isbn = id;   
			int bid = Integer.parseInt(borrowid);
			borrow=bordao.getBorrow(isbn,bid);

			//当前日期
			int days = calDays();
			System.out.println("backdate="+borrow.getBackdate());
			System.out.println("borrowdate="+borrow.getBorrowdate());
			System.out.println("days="+days);

			if(days>=0){
				stock=stcdao.getStock(isbn);
				stock.setAmount(stock.getAmount()+1);
				stcdao.updateStock(stock);       		
				borrow.setIsback(1);
				bordao.updateBorrow(borrow);

				result="success";
			}else {
				ReturnBookBean bean = new ReturnBookBean();
				bean.setRederid(readid);
				bean.setBookname(bookname);
				bean.setAmount(Integer.parseInt(amount));
				bean.setBorrowid(borrowid);
				bean.setBackdate(backdate);
				bean.setIsbn(id);

				HttpServletRequest request = ServletActionContext.getRequest();
				request.setAttribute("bean", bean);

				float fine = getFinemoney();
				request.setAttribute("fine", fine);
				result="ticket";			
			}
		}
		
		return result;
	}




	public String  borrow()  throws IOException, ParseException{
		if("select".equals(method)) { 

			if(JUtils.changeToNum(id)) {
				System.out.println("id="+id);
				System.out.println("method="+method);
				String isbn = id;   
				int bid = Integer.parseInt(borrowid);
				borrow=bordao.getBorrow(isbn,bid);

				//当前日期
				int days = calDays();
				System.out.println("backdate="+borrow.getBackdate());
				System.out.println("borrowdate="+borrow.getBorrowdate());
				System.out.println("days="+days);

				if(days>=0){
					stock=stcdao.getStock(isbn);
					stock.setAmount(stock.getAmount()+1);
					stcdao.updateStock(stock);       		
					borrow.setIsback(1);
					bordao.updateBorrow(borrow);

					return SUCCESS;
				}else {
					ReturnBookBean bean = new ReturnBookBean();
					bean.setRederid(readid);
					bean.setBookname(bookname);
					bean.setBackdate(backdate);
					bean.setBorrowid(borrowid);
					bean.setAmount(Integer.parseInt(amount));
					bean.setIsbn(id);

					HttpServletRequest request = ServletActionContext.getRequest();
					request.setAttribute("bean", bean);

					float fine = getFinemoney();
					request.setAttribute("fine", fine);
					return "ticket";			
				}
			}
		}

		return null;
	}

	private int calDays() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = format.format(new Date());
		Date now = format.parse(currentDate);
		String bd = format.format(borrow.getBackdate());
		Date backDate = format.parse(bd);
		int days = (int) ((backDate.getTime()-now.getTime())/86400000);
		return days;
	}


	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * 求罚款金额
	 * @return
	 * @throws ParseException
	 */
	public float getFinemoney() throws ParseException {
		BookTypeImpl bookTypeImpl = new BookTypeImpl();
		BookInfoImpl bookInfoImpl = new BookInfoImpl();
		int typeid = bookInfoImpl.selectFines(id);
		float fines = bookTypeImpl.selectFines(typeid);

		//获取当前日期
		int d = calDays();
		int days = Math.abs(d);


		return days*fines;
	}

}

