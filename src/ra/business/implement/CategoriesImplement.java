package ra.business.implement;

import ra.business.config.InputMethods;
import ra.business.design.ICategories;
import ra.business.entity.Categories;
import ra.business.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoriesImplement implements ICategories
{
    public static List<Categories> categoriesList = new ArrayList<>();
    public static int indexCategories= 0;



    @Override
    public void statusUpdate()
    {
        System.out.println("Nhập vào mã danh mục cần cập nhật trạng thái:");
        int catalogId = InputMethods.getInteger();
        int idUpdateStatus = findById(catalogId).getCatalogId();
        if (idUpdateStatus>=0){
            System.out.println("Nhap trang thai muon cap nhat");
            boolean input = InputMethods.getBoolean();
           findById(catalogId).setCatalogStatus(input);
        }else{
            System.err.println("Mã danh mục không tồn tại");
        }

    }

    @Override
    public void read()
    {
        //Hien thi tat ca danh muc hien co
        System.out.println("================Danh muc hien tai ================");
        for (Categories categories : categoriesList)
        {
            categories.displayData();
        }
        System.out.println("====================================================");
    }

    @Override
    public void creat()
    {
        //Nhap theo so danh muc nguoi dung muon nhap tu ban phim
        System.out.println("Mời bạn nhập vào số san pham muốn thêm");
        byte quantity = InputMethods.getByte();
        for (int i = 0; i < quantity; i++) {
            Categories categories = new Categories();
            categories.inputDataCategories(categoriesList);
            categoriesList.add(categories);
        }
    }

    @Override
    public void delete()
    {
        System.out.println("Nhập vào mã danh mục cần xóa:");
        int catalogId = InputMethods.getInteger();
        int idDelete = findById(catalogId).getCatalogId();
        if (idDelete >= 0) {
            boolean isExistProduct = false;
            // Check xem danh muc co san pham khong
            for (int i = 0; i < ProductImplement.productList.size(); i++) {
                if (ProductImplement.productList.get(i).getCatalogId() == catalogId) {
                    isExistProduct = true;
                    break;
                }
            }
            if (isExistProduct) {
                System.err.println("Danh mục đang chứa sản phẩm, không thể xóa");
            } else {
                categoriesList.remove(findById(catalogId));
                //Thực hiện xóa
                indexCategories--;
            }
        } else {
            System.err.println("Mã danh mục không tồn tại");
        }

    }

    @Override
    public void update()
    {
        System.out.println("Nhập vào mã danh mục cần cập nhật:");
        int categoriesId = InputMethods.getInteger();
        int idUpdate = findById(categoriesId).getCatalogId();
        if (idUpdate >= 0) {
            boolean isExit = true;
            do {
                System.out.println("1. Cập nhật tên danh mục");
                System.out.println("2. Cập nhật mô tả");
                System.out.println("3. Cập nhật trạng thái");
                System.out.println("4. Thoát");
                System.out.println("Lựa chọn của bạn:");
                byte choice = InputMethods.getByte();
                switch (choice) {
                    case 1:
                        System.out.println("Mời nhập tên muốn cập nhật");
                        findById(categoriesId).setCatalogName(InputMethods.getString());
                        break;
                    case 2:
                        System.out.println("Mời nhập Mô tả muốn cập nhật");
                        findById(categoriesId).setDescription(InputMethods.getString());
                        break;
                    case 3:
                        System.out.println("Moi nhập trang thái muốn cập nhật");
                        findById(categoriesId).setCatalogStatus(InputMethods.getBoolean());
                        break;
                    case 4:
                        isExit = false;
                        break;
                    default:
                        System.err.println("Vui lòng chọn từ 1-4");
                }
            } while (isExit);
        } else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }
    @Override
    public Categories findById(Integer inputId)
    {
        for (Categories categories: categoriesList) {
            if (categories.getCatalogId()==inputId) {
                return categories;
            }
        }
        return null;
    }
}
