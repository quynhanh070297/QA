package ra.business.entity;

import ra.business.config.InputMethods;

import java.util.Date;
import java.util.List;

public class Product
{
    private String productId;
    private String productName;
    private float price;
    private String description;
    private Date created;
    private int catalogId;
    private int productStatus;

    public Product()
    {
    }
    public Product(String productId, String productName, float price, String description, Date created, int catalogId, int productStatus)
    {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    public String getProductId()
    {
        return productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getCreated()
    {
        return created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    public int getCatalogId()
    {
        return catalogId;
    }

    public void setCatalogId(int catalogId)
    {
        this.catalogId = catalogId;
    }

    public int getProductStatus()
    {
        return productStatus;
    }

    public void setProductStatus(int productStatus)
    {
        this.productStatus = productStatus;
    }

    public void inputDataProduct(List<Product> productList, List<Categories> categoriesList)
    {

        this.productId = getInputProductId(productList);
        this.productName = getInputProductName(productList);
        this.price = getInputPrice();
        this.description = getInputDescription();
        this.created = getInputCreated();
        this.catalogId = getInputCatalogId(productList,categoriesList);
        this.productStatus = getInputProductStatus();
    }

    private int getInputProductStatus()
    {
        System.out.println("Nhập vào trạng thái sản phẩm:");
        System.out.println("1. Hoạt động " +
                "2. Không hoạt động ");
        do
        {
            int status = InputMethods.getInteger();
            if (status == 0 || status == 1 || status == 2)
            {
                return status;
            } else
            {
                System.err.println("Trạng thái chỉ nhận giá trị 0,1,2, vui lòng nhập lại");
            }
        } while (true);
    }

    private int getInputCatalogId(List<Product> productList, List<Categories> categoriesList)
    {
        System.out.println("Chọn danh mục của sản phẩm:");
        if (categoriesList.size() != 0){
            for (int i = 0; i < categoriesList.size(); i++)
            {
                if (categoriesList.get(i).isCatalogStatus())
                {
                    System.out.printf("%d.%s\n", i + 1,categoriesList.get(i).getCatalogName());
                }

            }
            System.out.print("Chon san pham ");
            int choice = InputMethods.getInteger();
            return categoriesList.get(choice-1).getCatalogId();}
        else {
            System.out.println("Danh muc trong");
            return 0;
        }
    }

    private Date getInputCreated()
    {
        System.out.println("Moi ban nhap vao ngay them san pham");
        return InputMethods.getDate();
    }

    private String getInputDescription()
    {
        System.out.println("Nhap vao mo ta san pham");
        return InputMethods.getString();
    }

    private float getInputPrice()
    {
        System.out.println("Nhap vap gia san pham");
        do
        {
            float price = InputMethods.getFloat();
            if (price > 0)
            {
                return price;
            } else
            {
                System.err.println("Giá sản phẩm phải lớn hơn 0, vui lòng nhập lại");
            }
        } while (true);
    }

    private String getInputProductName(List<Product> productList)
    {
        System.out.println("Moi ban nhap ten san pham");
        do{
            String productName = InputMethods.getString();
            if (productName.length() >= 10 && productName.length() <= 50)
            {
                boolean isExist = false;
                for (int i = 0; i < productList.size(); i++)
                {
                    if (productList.get(i).getProductName().equals(productName))
                    {
                        isExist = true;
                        break;
                    }
                }
                if (isExist)
                {
                    System.err.println("Tên sản phẩm đã tồn tại, vui lòng nhập lại");
                } else
                {
                    return productName;
                }
            } else
            {
                System.err.println("Tên sản phẩm có từ 10-50 ký tự, vui lòng nhập lại");
            }
        } while (true);
    }

    private String getInputProductId(List<Product> productList)
    {
        System.out.println("Nhập vào mã sản phẩm:");
        final String regex = "^[A|S|C]\\w{3}$";
        while (true)
        {
            String productId = InputMethods.getString();
            if (productId.matches(regex))
            {
                // đúng định dạng -> kiểm tra trùng lặp
                if (productList.stream().noneMatch(t -> t.getProductId().equals(productId)))
                {
                    // trùng lặp
                    return productId;
                }
                System.err.println("Id đã tồn tại, vui long nhập giá trị khác");
            } else
            {
                System.err.println("Không đúng định dạng (C|S|A____)");
            }
        }
    }
    public void displayData (List <Categories> categoriesList){
        System.out.println("===================================================================");
        System.out.printf("Mã sản phẩm: %s - Tên sản phẩm: %s - Giá: %f\n", this.productId, this.productName, this.price);
        System.out.printf("Mô tả: %s - Ngày nhập: %s\n", this.description, this.created.toString());
        String catalogName = "";
        for (int i = 0; i < categoriesList.size(); i++)
        {
            if (categoriesList.get(i).getCatalogId() == this.catalogId)
            {
                catalogName = categoriesList.get(i).getCatalogName();
                break;
            }
        }
        System.out.printf("Danh mục: %-3s - Trạng thái: %s\n", catalogName,
                this.productStatus == 0 ? "Đang bán" : (this.productStatus == 1 ? "Hết hàng" : "Không bán"));
    }
    }

