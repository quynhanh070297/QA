package ra.business.entity;

import ra.business.config.InputMethods;
import ra.business.implement.CategoriesImplement;

import java.util.List;

public class Categories
{
    private int catalogId;
    private String catalogName;
    private String description;
    private boolean catalogStatus;

    public Categories()
    {
    }

    public Categories(int catalogId, String catalogName, String description, boolean catalogStatus)
    {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.description = description;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId()
    {
        return catalogId;
    }


    public void setCatalogId(int catalogId)
    {
        this.catalogId = catalogId;
    }

    public String getCatalogName()
    {
        return catalogName;
    }

    public void setCatalogName(String catalogName)
    {
        this.catalogName = catalogName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isCatalogStatus()
    {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus)
    {
        this.catalogStatus = catalogStatus;
    }

    public void inputDataCategories(List<Categories> categoriesList){
        this.catalogId = getInputCatalogId(categoriesList);
        this.catalogName = getInputCatalogName(categoriesList);
        this.catalogStatus = getInputCatalogStatus();
        this.description = getInputDescription();

    }

    private int getInputCatalogId(List<Categories> categoriesList)
    {
        //Nếu list chưa có phần tử nào thì đây chính là phần tử đầu tiên
        if (categoriesList.isEmpty())
        {
            return this.catalogId = 1;
        } else
        {
            int maxId = categoriesList.get(0).getCatalogId();
            for (Categories categories : categoriesList)
            {
                //Tìm ra id lớn nhất hiện có trong list employee
                if (categories.getCatalogId() > maxId)
                    maxId = categories.getCatalogId();
            }
           return this.catalogId = ++maxId;
        }
    }

    private String getInputDescription()
    {
        System.out.println("Moi ban nhap mo ta");
        return InputMethods.getString();
    }

    private boolean getInputCatalogStatus()
    {
        System.out.println("Nhap Vao trang thai danh muc :");

        do {
            String status = InputMethods.getString();
            if (status.equals("true") || status.equals("false")) {
                return Boolean.parseBoolean(status);
            } else {
                System.err.println("Trạng thái danh mục chỉ nhận true hoặc false, vui lòng nhập lại");
            }
        } while (true);
    }

    private String getInputCatalogName(List<Categories> categoriesList)
    {
        System.out.println("Nhap vao ten danh muc");
        do
        {
            String catalogName = InputMethods.getString();
            //1.Do dai toi da 50 ky tu
            if (catalogName.length() <= 50) {
                //2. Kiểm tra trùng lặp
                boolean isExist = false;
                for (int i = 0; i < categoriesList.size(); i++) {
                    if (categoriesList.get(i).getCatalogName().equals(catalogName)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.err.println("Tên danh mục đã tồn tại, vui lòng nhập lại");
                } else {
                    return catalogName;
                }
            } else {
                System.err.println("Tên danh mục tối đa 50 ký tự, vui lòng nhập lại");
            }
        }while (true);
    }

    public void displayData()
    {
        System.out.printf("Mã danh mục: %d | Tên danh mục: %s | Mô tả danh mục: %s | Trạng thái danh mục: %s\n",
                this.catalogId, this.catalogName, this.description, this.catalogStatus ? "Hoạt động" : "Không hoạt động");
    }
}
