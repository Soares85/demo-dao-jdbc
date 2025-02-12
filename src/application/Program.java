package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("===== TEST 1: seller findById =====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n===== TEST 2: seller findByDepartment =====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n===== TEST 3: seller findAll =====");
        list = sellerDao.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n===== TEST 4: seller insert =====");
        Seller seller1 = new Seller(null, "Greg", "greg@email.com", new Date(), 4000.00, department);
        sellerDao.insert(seller1);
        System.out.println("Inserted! New id = " + seller1.getId());

        System.out.println("\n===== TEST 5: seller update =====");
        seller = sellerDao.findById(1);
        seller.setName("Maria Lady");
        sellerDao.update(seller);
        System.out.println("Update complete!");

        System.out.println("\n===== TEST 5: seller delete =====");
        System.out.print("Enter id for delete test: ");
        int id = in.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");

    }
}
