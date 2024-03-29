package ra.business.design;

import ra.business.entity.Categories;

import java.util.List;

public interface ICategories extends ICrud <Categories,Integer > {

   void statusUpdate();


}
