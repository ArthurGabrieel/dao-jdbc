package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("==== Test 1: seller findById ====");
        Seller seller = sellerDao.findById(7);

        System.out.println(seller);

        System.out.println("\n==== Test 2: seller findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n==== Test 3: seller findAll ====");
        list = sellerDao.findAll();

        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n==== Test 4: seller insert ====");
        Seller newSeller = new Seller(null, "Messi", "messi@gmail.com", new Date(), 3000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id: " + newSeller.getId());

        System.out.println("\n==== Test 4: seller update ====");
        seller = sellerDao.findById(1);
        seller.setName("Cristiano Ronaldo");
        sellerDao.update(seller);
        System.out.println("Updade complete!");
    }
}
