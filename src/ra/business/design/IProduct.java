package ra.business.design;

import ra.business.entity.Product;

public interface IProduct extends ICrud<Product,String>
{
    void sortByPrice();
    void searchByNameProduct();
    void searchByPriceProduct();


}
