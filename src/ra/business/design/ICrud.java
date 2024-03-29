package ra.business.design;

import java.util.List;

public interface ICrud <E, T>
{
    void read();
    void creat() ;
    void delete();
    void update();


    E findById(T t);


}
