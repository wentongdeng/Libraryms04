package com.it.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.it.entity.Books;
import com.it.entity.BooksDAO;
import com.it.entity.Borrow;
import com.it.entity.BorrowDAO;
import com.it.entity.MyBorrow;
import com.it.util.UtilApp;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class BorrowAction extends ActionSupport {
	private List<Borrow> borrows;
	private Integer bookId;
	private List<MyBorrow> myborrows;
	//搜索相关
	private String exactFlag;
	private String searchKey;
	BorrowDAO borrowDAO;
	BooksDAO booksDAO;
	/**
	 * 获取我的所有的借书记录
	 * 
	 * @return
	 */
	public String getMyBorrow() throws Exception {
		
		myborrows = borrowDAO.getCurrentUserBorrow(UtilApp.getInstance().getUser().getId());
		return "success";
	}

	public BorrowDAO getBorrowDAO() {
		return borrowDAO;
	}

	public void setBorrowDAO(BorrowDAO borrowDAO) {
		this.borrowDAO = borrowDAO;
	}

	public BooksDAO getBooksDAO() {
		return booksDAO;
	}

	public void setBooksDAO(BooksDAO booksDAO) {
		this.booksDAO = booksDAO;
	}

	/**
	 * 获取所有借书记录
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getAll() throws Exception {
		setMyborrows(borrowDAO.findAllDetail());
		return "success";
	}
	
	/**
	 * 搜索我的借书记录
	 * @return
	 */
	public String searchMyBorrow(){
		
		myborrows = borrowDAO.searchCurrentBorrow(searchKey, exactFlag);
		return "success";
	}
	
	/**
	 * 搜索某本书的借书记录
	 * @return
	 */
	public String searchAllBorrow(){
		myborrows = borrowDAO.searchAllBorrow(searchKey, exactFlag);
		return "success";
	}

	/**
	 * 借书的方法 添加借书记录，相应书的书的数目减一
	 * 
	 * @return
	 */
	public String borrowBook() {
		// 添加借书记录
		
		
		Books book = booksDAO.findById(bookId);
		
		Borrow borrow = null;
		
		borrow = new Borrow();
		Date date = new Date();       
		Timestamp nousedate = new Timestamp(date.getTime());
		borrow.setBorrowDate(nousedate);
		borrow.setBooks(book);
		borrow.setUser(UtilApp.getInstance().getUser());
		borrowDAO.save(borrow);
		// 将相应的书的数目减少1
		int bookNum = book.getBookCount();
		if(bookNum>0){
			book.setBookCount(--bookNum);
			booksDAO.attachDirty(book);
			System.out.println("借书了");
			return "success";
		}else{
			return "borrowerror";
		}
		
	}

	/**
	 * 还书 添加还书时间 将相应的书的数目加1
	 * 
	 * @return
	 * @throws Exception
	 */
	public String returnBook() throws Exception {
		// 更新借书记录
		
		Books book = booksDAO.findById(bookId);
		book.setId(bookId);
		
		Borrow borrow = borrowDAO.findByUserandBook(UtilApp.getInstance().getUser(), book).get(0);
		if(borrow!=null){
			Date date = new Date();   
			Timestamp nousedate = new Timestamp(date.getTime());
			borrow.setReturnDate(nousedate);
			borrowDAO.attachDirty(borrow);
			// 将相应的书的数目加1
			int bookNum = book.getBookCount();
			book.setBookCount(++bookNum);
			booksDAO.attachDirty(book);
			//刷新界面
			//getAll();
			return "success";
		}else{
			//增加处理事务。。。。。。
			return "error";
		}
		
	}

	public List<Borrow> getBorrows() {
		return borrows;
	}

	public void setBorrows(List<Borrow> borrows) {
		this.borrows = borrows;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public List<MyBorrow> getMyborrows() {
		return myborrows;
	}

	public void setMyborrows(List<MyBorrow> myborrows) {
		this.myborrows = myborrows;
	}

	public String getExactFlag() {
		return exactFlag;
	}

	public void setExactFlag(String exactFlag) {
		this.exactFlag = exactFlag;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	
}
