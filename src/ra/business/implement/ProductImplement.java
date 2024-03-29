package ra.business.implement;

import ra.business.config.InputMethods;
import ra.business.design.IProduct;
import ra.business.entity.Categories;
import ra.business.entity.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;

public class ProductImplement implements IProduct
{
    public static List<Product> productList = new ArrayList<>();

    @Override
    public void read()
    {
        System.out.println("==================DANH SACH SAN PHAM HIEN CO=========================== ");
        for (Product product : productList)
        {
           product.displayData(CategoriesImplement.categoriesList);
        }
        System.out.println("========================================================================");
    }

    @Override
    public void creat()
    {
        System.out.println("Mời bạn nhập vào số san pham muốn thêm");
        byte quantity = InputMethods.getByte();
        for (int i = 0; i < quantity; i++) {
            Product product = new Product();
            product.inputDataProduct(productList,CategoriesImplement.categoriesList);
            productList.add(product);
        }

    }

    @Override
    public void delete()
    {
        System.out.println("Moi ban nhap vao ID muon xoa");
        String inputID = InputMethods.getString();
        for (Product product : productList)
        {
            if (product.getProductId().equals(inputID)){
                productList.remove(product);
                System.out.println("Da xoa Thanh cong");
            }
            else {
                System.out.println("Khong ton tai ID muon xoa");
            }
        }

    }

    @Override
    public void update()
    {
        System.out.println("Nhập vào mã danh mục cần cập nhật:");
        String updateID = InputMethods.getString();
        for (Product product : productList)
        {
            if (product.getProductId().equals(updateID))
            {
                boolean isExit = true;
                do
                {
                    System.out.println("1. Cập nhật ID san pham");
                    System.out.println("2. Cập nhật tên San pham");
                    System.out.println("3. Cập nhật Ngay thang");
                    System.out.println("4. Cập nhật Gia");
                    System.out.println("5. Cập nhật mô tả");
                    System.out.println("6. Thoát");
                    System.out.println("Lựa chọn của bạn:");
                    byte choice = InputMethods.getByte();
                    switch (choice)
                    {
                        case 1:
                            System.out.println("Mời nhập ID muốn cật nhật");
                            product.setProductId(InputMethods.getString());
                            break;
                        case 2:
                            System.out.println("Mời nhập tên muốn cật nhật");
                            product.setProductName(InputMethods.getString());
                            break;
                        case 3:
                            System.out.println("Mời nhập Ngay thang muốn cật nhật");
                            product.setCreated(InputMethods.getDate());
                            break;
                        case 4:
                            System.out.println("Mời nhập Gia muốn cật nhật");
                            product.setPrice(InputMethods.getFloat());
                            break;
                        case 5:
                            System.out.println("Mời nhập Mô tả muốn cật nhật");
                            product.setDescription(InputMethods.getString());
                            break;
                        case 6:
                            isExit = false;
                            break;
                        default:
                            System.err.println("Vui lòng chọn từ 1-6");
                    }
                } while (isExit);
            } else
            {
                System.err.println("Mã danh mục không tồn tại");

            }
        }
    }

    @Override
    public Product findById(String inputID)
    {
        for (Product product : productList) {
            if (product.getProductId().equals(inputID)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void sortByPrice()
    {
        productList.stream().sorted(Comparator.comparing(Product::getPrice));
        System.out.println(productList);
        System.out.println("Sap xep san pham thanh cong");

    }

    @Override
    public void searchByNameProduct()
    {
        System.out.println("Nhap ten Product muon tim");
        String findName = InputMethods.getString();
        for (Product product : productList)
        {
            if (product.getProductName().equals(findName)){
                System.out.println(product);
            }
            else {
                System.out.println("San pham khong ton tai");
            }
        }
    }
    @Override
    public void searchByPriceProduct()
    {
        System.out.println("Moi ban nhap gia san pham muon tim");
        System.out.println("Start price");
        float startPrice = InputMethods.getFloat();
        System.out.println("End price");
        float endprice = InputMethods.getFloat();
        for (int i = 0; i < productList.size(); i++)
        {
            System.out.println("San pham trong khoang gia la:");
            if (productList.get(i).getPrice()>startPrice&&productList.get(i).getPrice()<endprice){
                System.out.println(productList.get(i));
            }
            else {
                System.out.println("Moi nhap lai gia san pham");
            }
        }
    }
}
