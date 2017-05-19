package com.it.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.it.util.UtilApp;




/**
 * A data access object (DAO) providing persistence and search support for
 * Borrow entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.it.entity.Borrow
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class BorrowDAO {
	private static final Logger log = LoggerFactory.getLogger(BorrowDAO.class);
	// property constants

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Borrow transientInstance) {
		log.debug("saving Borrow instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Borrow persistentInstance) {
		log.debug("deleting Borrow instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Borrow findById(java.lang.Integer id) {
		log.debug("getting Borrow instance with id: " + id);
		try {
			Borrow instance = (Borrow) getCurrentSession().get("com.it.entity.Borrow", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	
	public List<MyBorrow> getCurrentUserBorrow(Integer id){
		String hql = "from Borrow borrow where borrow.user.id = ?";
		Query queryObject = getCurrentSession().createQuery(hql);
		queryObject.setInteger(0, id);
		List<Borrow> borrows=queryObject.list();
		List<MyBorrow> myborrows=new ArrayList<MyBorrow>();
		List<Press> presses;
		Borrow borrow;
		Books book;
		if(borrows.size()!=0){
			for(int n=0;n<borrows.size();n++){
				borrow=borrows.get(n);
				MyBorrow myborrow=new MyBorrow();
				myborrow.setBooks(borrow.getBooks());
				myborrow.setUser(borrow.getUser());
				myborrow.setBorrowDate(borrow.getBorrowDate());
				myborrow.setReturnDate(borrow.getReturnDate());
				book=borrow.getBooks();
				String hql2 = "from Press";
				Query queryObject2 = getCurrentSession().createQuery(hql2);
				presses=queryObject2.list();
				for(int i=0;i<presses.size();i++){
					if(book.getPress()==presses.get(i)){
						myborrow.setPress(presses.get(i));
					}
				}
				myborrows.add(myborrow);
			}
			return myborrows;
		}
		return null;
	}
	public List<MyBorrow> findAllDetail(){
		String hql = "from Borrow";
		Query queryObject = getCurrentSession().createQuery(hql);
		List<Borrow> borrows=queryObject.list();
		List<MyBorrow> myborrows=new ArrayList<MyBorrow>();
		List<Press> presses;
		Borrow borrow;
		Books book;
		if(borrows.size()!=0){
			for(int n=0;n<borrows.size();n++){
				borrow=borrows.get(n);
				MyBorrow myborrow=new MyBorrow();
				myborrow.setBooks(borrow.getBooks());
				myborrow.setUser(borrow.getUser());
				myborrow.setBorrowDate(borrow.getBorrowDate());
				myborrow.setReturnDate(borrow.getReturnDate());
				book=borrow.getBooks();
				myborrow.setPress(book.getPress());
				myborrows.add(myborrow);
			}
			return myborrows;
		}
		return null;
	}
	public List<MyBorrow> searchAllBorrow(String key,String exact){
		try {
			if(exact==null){
				key = "%" + key + "%";// 模糊查询 
			}
			String hql = "from Books books where books.bookName like \'" + key + "\' ";
			Query queryObject = getCurrentSession().createQuery(hql);
			List<Books> books=queryObject.list();
			List<MyBorrow> myborrows=new ArrayList<MyBorrow>();
			String hql2 = "from Borrow";
			Query queryObject2 = getCurrentSession().createQuery(hql2);
			List<Borrow> borrows=queryObject2.list();
			for(int n=0;n<borrows.size();n++){
				for(int i=0;i<books.size();i++){
					if(borrows.get(n).getBooks()==books.get(i)){
						MyBorrow myborrow=new MyBorrow();
						myborrow.setBooks(books.get(i));
						myborrow.setUser(borrows.get(n).getUser());
						myborrow.setPress(books.get(i).getPress());
						myborrow.setBorrowDate(borrows.get(n).getBorrowDate());
						myborrow.setReturnDate(borrows.get(n).getReturnDate());
						myborrows.add(myborrow);
					}
				}
			}
			return myborrows;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
		
	}
	
	
	public List<MyBorrow> searchCurrentBorrow(String key,String exact){
		try {
			if(exact==null){
				key = "%" + key + "%";// 模糊查询 
			}
			//奇怪了，模糊查询不起作业
			String hql = "from Borrow borrow where borrow.user.id= ? and borrow.books.bookName like \'" + key + "\' ";
			Query queryObject = getCurrentSession().createQuery(hql);
			queryObject.setInteger(0, UtilApp.getInstance().getUser().getId());
			List<Borrow> borrows=queryObject.list();
			List<MyBorrow> myborrows=new ArrayList<MyBorrow>();
			Books book;
			for(int n=0;n<borrows.size();n++){
				book=borrows.get(n).getBooks();
				MyBorrow myborrow=new MyBorrow();
				myborrow.setBooks(book);
				myborrow.setPress(book.getPress());
				myborrow.setUser(borrows.get(n).getUser());
				myborrow.setBorrowDate(borrows.get(n).getBorrowDate());
				myborrow.setReturnDate(borrows.get(n).getReturnDate());
				myborrows.add(myborrow);
			}
			return myborrows;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
		
	}
	public List<Borrow> findByUserandBook(User user,Books book){
		String hql = "from Borrow borrow where borrow.user.id=? and borrow.books.id=?";
		Query queryObject = getCurrentSession().createQuery(hql);
		queryObject.setInteger(0, user.getId());
		queryObject.setInteger(1, book.getId());
		return queryObject.list();
	}
	
	
	public List findByExample(Borrow instance) {
		log.debug("finding Borrow instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.it.entity.Borrow").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Borrow instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Borrow as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Borrow instances");
		try {
			String queryString = "from Borrow";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Borrow merge(Borrow detachedInstance) {
		log.debug("merging Borrow instance");
		try {
			Borrow result = (Borrow) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Borrow instance) {
		log.debug("attaching dirty Borrow instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Borrow instance) {
		log.debug("attaching clean Borrow instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BorrowDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BorrowDAO) ctx.getBean("BorrowDAO");
	}
}