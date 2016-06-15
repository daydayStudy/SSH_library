package com.library.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.library.bean.BookInfo;
import com.library.bean.Borrow;
import com.library.bean.BorrowBookBean;
import com.library.bean.Reader;
import com.library.bean.Stock;
import com.library.impl.BookInfoImpl;
import com.library.impl.BorrowImpl;
import com.library.impl.ReaderImpl;
import com.library.impl.StockImpl;
import com.library.util.JUtils;
import com.opensymphony.xwork2.ActionSupport;

public class BorrowAction extends ActionSupport implements ServletResponseAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletResponse response ;
	@Resource
	private ReaderImpl readerImpl;
	@Resource
	private BookInfoImpl bookInfoImpl;
	@Resource
	private BorrowImpl borrowImpl;
	@Resource
	private StockImpl stockImpl;
	private int page;
	private String readerID;
	private String bookISBN;
	private String borrowdate;
	private String backdate;

	public String getBorrowdate() {
		return borrowdate;
	}

	public void setBorrowdate(String borrowdate) {
		this.borrowdate = borrowdate;
	}

	public String getBackdate() {
		return backdate;
	}

	public void setBackdate(String backdate) {
		this.backdate = backdate;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getReaderID() {
		return readerID;
	}

	public void setReaderID(String readerID) {
		this.readerID = readerID;
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
	
	/**
	 * 查询用户id
	 * @return
	 */
	public String selectReaderID() {
		List<Reader> readers = null;
		if(readerID !=null) {
			if(JUtils.changeToNum(readerID)) {
				String hql = "from Reader as r where r.isdelete=0 and r.readerid like '%"+readerID+"%'";
				readers = readerImpl.selectReaders(hql);
				HttpServletRequest request = ServletActionContext.getRequest();
				request.setAttribute("borrow_reader", readers);
			}
		}
		
		return SUCCESS;
	}

	
	/**
	 * 查询图书
	 * @return
	 */
	public String selectBook() {
		List<BorrowBookBean> infos = null;
		if(bookISBN!=null) {
			infos = bookInfoImpl.selectBook(bookISBN);
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("borrow_bookinfo", infos);
		}
		
		return SUCCESS;
	}
	
	/**
	 * 添加借阅记录
	 * @return
	 */
	public String addRecord() {
		if(JUtils.changeToNum(readerID)) {
			try {
				Borrow borrow = new Borrow();
				Reader reader = new Reader();
				reader.setReaderid(Integer.parseInt(readerID));
				BookInfo bookInfo = new BookInfo();
				bookInfo.setIsbn(bookISBN);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
				borrow.setReader(reader);
				borrow.setIsback(0);
				borrow.setBookInfo(bookInfo);
				Date date = format.parse(backdate);
				borrow.setBackdate(date);
				date = format.parse(borrowdate);
				borrow.setBorrowdate(date);
				
				boolean result = borrowImpl.addBorrow(borrow);
				if(result) {
					try {
						//更新库存
						String hql = "from Stock as o where o.bookInfo.isbn="+bookISBN;
						List<Stock> list = stockImpl.selectStocks(hql);
						if(list.size()>0) {
							Stock stock = list.get(0);
							int amount = stock.getAmount();
							stock.setAmount(amount-1);
							stockImpl.updateStock(stock);
						}
						
						response.setContentType("text/html;charset=UTF-8");
						response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码 
						PrintWriter out = response.getWriter();
						out.print("<script>alert('借阅成功!')</script>");
						out.print("<script>window.location.href='" + "borrow_book.jsp" + "'</script>");   
						out.flush();   
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					System.out.println("借阅成功");
				}
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		
		return SUCCESS;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
}
