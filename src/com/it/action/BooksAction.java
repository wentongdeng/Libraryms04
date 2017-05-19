package com.it.action;

import java.util.List;

import com.it.entity.Bigtype;
import com.it.entity.BigtypeDAO;
import com.it.entity.Books;
import com.it.entity.BooksDAO;
import com.it.entity.Press;
import com.it.entity.PressDAO;
import com.it.entity.Smalltype;
import com.it.entity.SmalltypeDAO;
import com.it.entity.User;
import com.it.entity.UserDAO;
import com.it.util.UtilApp;
import com.opensymphony.xwork2.ActionSupport;

public class BooksAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5561500855123930769L;
	private BooksDAO bookDao;
	private PressDAO pressDao;
	private SmalltypeDAO smalltypeDao;
	private BigtypeDAO bigtypeDao;
	private UserDAO userDao;
	private User user;
	private Books book;
	private String pressName;
	private Integer bookId;
	private List<Books> books;
	private List<Press> presses;
	private String searchKey;
	private String exactFlag;
	
	
	public String getBookByKey() throws Exception {
		
		books = bookDao.searchByKey(searchKey, exactFlag);
		presses = pressDao.findAll();
		Short isAdmin = UtilApp.getInstance().getUser().getAdmin();
		setUser(UtilApp.getInstance().getUser());
		if(isAdmin>0){
			return "admin_main";
		}else{
			return "main";
		}
	}
	
	public String addBook() throws Exception{
		Press press = new Press();
		press.setName(pressName);
		book.setPress(press);
		Smalltype smalltype=new Smalltype();
		smalltype.setTypename("软件工程");
		Bigtype bigtype=new Bigtype();
		bigtype.setTypename("计算机科学");
		smalltype.setBigtype(bigtype);
//		bigtypeDao.save(bigtype);
//		smalltypeDao.save(smalltype);
		book.setSmalltype(smalltype);
		bookDao.save(book);
		return "success";
	}
	
	public String getAll(){
		
		books = bookDao.findAll();
		
		presses = pressDao.findAll();
		Short isAdmin = UtilApp.getInstance().getUser().getAdmin();
		setUser(UtilApp.getInstance().getUser());
		if(isAdmin>0){
			return "admin_main";
		}else{
			return "main";
		}
	}
	public String goEditBook(){
		
		presses = pressDao.findAll();
		book = bookDao.findById(bookId);
		return "success";
	}
	public String editBook(){
		Press press = new Press();
		press.setName(pressName);
		book.setPress(press);
		
		bookDao.attachDirty(book);
		return "success";
	}
	
	
	public List<Books> getBooks() {
		return books;
	}
	public void setBooks(List<Books> books) {
		this.books = books;
	}
	public List<Press> getPresses() {
		return presses;
	}
	public void setPresses(List<Press> presses) {
		this.presses = presses;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getExactFlag() {
		return exactFlag;
	}
	public void setExactFlag(String exactFlag) {
		this.exactFlag = exactFlag;
	}
	public BooksDAO getBookDao() {
		return bookDao;
	}
	public void setBookDao(BooksDAO bookDao) {
		this.bookDao = bookDao;
	}
	public PressDAO getPressDao() {
		return pressDao;
	}
	public void setPressDao(PressDAO pressDao) {
		this.pressDao = pressDao;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Books getBook() {
		return book;
	}
	public void setBook(Books book) {
		this.book = book;
	}
	public String getPressName() {
		return pressName;
	}
	public void setPressName(String pressName) {
		this.pressName = pressName;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public SmalltypeDAO getSmalltypeDao() {
		return smalltypeDao;
	}

	public void setSmalltypeDao(SmalltypeDAO smalltypeDao) {
		this.smalltypeDao = smalltypeDao;
	}

	public BigtypeDAO getBigtypeDao() {
		return bigtypeDao;
	}

	public void setBigtypeDao(BigtypeDAO bigtypeDao) {
		this.bigtypeDao = bigtypeDao;
	}
	
	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

}
