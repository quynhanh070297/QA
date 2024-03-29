package ra.run;

import ra.business.config.InputMethods;
import ra.business.entity.Categories;
import ra.business.implement.CategoriesImplement;
import ra.business.implement.ProductImplement;

import java.util.Scanner;

public class ShopManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShopManagement shopManagement = new ShopManagement();
        do {
            System.out.println("************SHOP MENU************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayCategoriesMenu();
                    break;
                case 2:
                    displayProductMenu();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-3");
            }
        } while (true);
    }
    public static void displayProductMenu() {
        ProductImplement productImplement = new ProductImplement();
        boolean isExit = true;
        do {
            System.out.println("*************PRODUCT MENU************");
            System.out.println("1. Nhập thông tin các sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp các sản phẩm theo giá");
            System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
            System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)");
            System.out.println("8. Thoat");
            System.out.print("Lựa chọn của bạn:");
            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    productImplement.creat();
                    break;
                case 2:
                    productImplement.read();
                    break;
                case 3:
                    productImplement.sortByPrice();
                      break;
                case 4:
                    productImplement.update();
                    break;
                case 5:
                    productImplement.delete();
                    break;
                case 6:
                    productImplement.searchByNameProduct();
                    break;
                case 7:
                    productImplement.searchByPriceProduct();
                    break;
                case 8:
                    isExit = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-6");
            }
        } while (isExit);
    }
    public static void displayCategoriesMenu() {
        CategoriesImplement categoriesImplement = new CategoriesImplement();
        boolean isExit = true;
        do {
            System.out.println("*************CATEGORIES MENU************");
            System.out.println("1. Nhập thông tin các danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật thông tin các danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Cập nhật trạng thái danh mục");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    categoriesImplement.creat();
                    break;
                case 2:
                    categoriesImplement.read();
                    break;
                case 3:
                    categoriesImplement.update();
                    break;
                case 4:
                    categoriesImplement.delete();
                    break;
                case 5:
                    categoriesImplement.statusUpdate();
                    break;
                case 6:
                    isExit = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-6");
            }
        } while (isExit);
    }
}